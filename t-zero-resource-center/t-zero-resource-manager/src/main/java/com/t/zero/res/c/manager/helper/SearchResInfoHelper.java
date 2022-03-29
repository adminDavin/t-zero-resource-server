package com.t.zero.res.c.manager.helper;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.page.Page;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.res.c.manager.bu.dao.auto.ResTagDefMapper;
import com.t.zero.res.c.manager.bu.dao.auto.ResTagRelMapper;
import com.t.zero.res.c.manager.bu.dao.manual.ManualResInfoDefMapper;
import com.t.zero.res.c.manager.bu.model.auto.ResTagDef;
import com.t.zero.res.c.manager.bu.model.auto.ResTagDefExample;
import com.t.zero.res.c.manager.bu.model.auto.ResTagRelExample;
import com.t.zero.res.c.manager.bu.vo.filters.ResInfoDefFilters;
import com.t.zero.res.c.manager.bu.vo.response.ResInfoDefWithTag;

/**
 * @author davinzhang
 * 
 * @date 2022/02/05
 * 
 * @desc TODO
 */

@Component
public class SearchResInfoHelper {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ResTagDefMapper resTagDefMapper;

    @Autowired
    private ResTagRelMapper resTagRelMapper;

    @Autowired
    private ManualResInfoDefMapper manualResInfoDefMapper;

    private final static String SQL_LIKE = "%";
    
    
    private ResInfoDefFilters getSearchParams(CommonParams params, ObjectNode content) {
        var searchKey = content.get("searchKey").asText();
        var resContentTypes = Arrays.asList(mapper.convertValue(content.get("resContentTypes"), String[].class));
        var resInfoType = content.get("resInfoType").asText();
        
        var resTagCodes = Arrays.asList(mapper.convertValue(content.get("resTagCodes"), String[].class));

        var searchType = content.has("searchType") ? content.get("searchType").asText() : StringUtils.EMPTY;
        if (searchType == "resTag") {
            resTagCodes = getSearchedResTag(searchKey);
            searchKey = StringUtils.EMPTY;
        }

        var filters = new ResInfoDefFilters();
        filters
            .setOwnerId(UploadResourceHelper.RES_INFO_OWNER_TYPE_MINE.equals(content.get("ownerType").asText())
                ? params.getUserIdInt()
                : content.get("ownerId").asInt());
        
        filters.setResTagCodes(resTagCodes);
        filters.setResContentTypes(resContentTypes);
        filters.setResInfoName(searchKey);
        filters.setResInfoType(resInfoType);
        filters.setUpdatedTimes(content.has("updatedTimes") ? mapper.convertValue(content.get("updatedTimes"), LocalDateTime[].class) : null);
        return filters;
    }


    public Object search(CommonParams params, ObjectNode content) {
        var currentPage = content.has("currentPage") ? content.get("currentPage").asInt() : 0;
        var pageSize = content.has("pageSize") ? content.get("pageSize").asInt() : 20;
        Page<ResInfoDefWithTag> page = Page.build(currentPage, pageSize);
        var filters = getSearchParams(params, content);
        if (CollectionUtils.isNotEmpty(filters.getResContentTypes()) && "folder".equals(filters.getResInfoType())) {
            page.setList(List.of());
            return page;
        }
        filters.setNotInResContentType(content.has("notInResContentTypeFlag")? content.get("notInResContentTypeFlag").asBoolean(): Boolean.FALSE);
        if (CollectionUtils.isEmpty(filters.getResTagCodes())) {
            var result = manualResInfoDefMapper
                .selectListNoTagByPage(params.getTenantId(), params.getUserIdInt(), filters, page.getOffset(), page.getPageSize());
            var tagMaps = getResTagDefsByResId(result.stream().map(i -> i.getId()).collect(Collectors.toList()));
            var tempResult = result.stream().map(i -> ResInfoDefWithTag.init(i, tagMaps.get(i.getId()))).collect(Collectors.toList());
            page.setList(tempResult);
            if (result.size() < 20) {
                page.setTotalCount(result.size());
            } else {
                var totalSize = manualResInfoDefMapper.selectNoTagCount(params.getTenantId(), params.getUserIdInt(), filters);
                page.setTotalCount(totalSize);
            }
        } else {
            var result = manualResInfoDefMapper
                .selectListByPage(params.getTenantId(), params.getUserIdInt(), filters, page.getOffset(), page.getPageSize());
            var tagMaps = getResTagDefsByResId(result.stream().map(i -> i.getId()).collect(Collectors.toList()));
            var tempResult = result.stream().map(i -> ResInfoDefWithTag.init(i, tagMaps.get(i.getId()))).collect(Collectors.toList());
            page.setList(tempResult);
            if (result.size() < 20) {
                page.setTotalCount(result.size());
            } else {
                var totalSize = manualResInfoDefMapper.selectCount(params.getTenantId(), params.getUserIdInt(), filters);
                page.setTotalCount(totalSize);
            }

        }
        return page;
    }

    public Map<Integer, List<ResTagDef>> getResTagDefsByResId(List<Integer> resIds) {
        if (CollectionUtils.isEmpty(resIds)) {
            return Map.of();
        }
        var relExample = new ResTagRelExample();
        relExample.createCriteria().andResInfoIdIn(resIds);
        var rels = resTagRelMapper.selectByExample(relExample);
        if (CollectionUtils.isEmpty(rels)) {
            return Map.of();
        }
        var tagIds = rels.stream().map(i -> i.getId()).distinct().collect(Collectors.toList());
        var tagExample = new ResTagDefExample();
        tagExample.createCriteria().andIdIn(tagIds);
        var tags = resTagDefMapper.selectByExample(tagExample);
        var tagMaps = tags.stream().collect(Collectors.toMap(i -> i.getId(), i -> i));
        for (var i : rels) {
            System.out.println(String.valueOf(i.getResInfoId()) + tagMaps.containsKey(i.getResTagId()));
        }
        return rels
            .stream()
            .collect(Collectors
                .toMap(i -> i.getResInfoId(), i -> tagMaps.containsKey(i.getResTagId())
                    ? Arrays.asList(tagMaps.get(i.getResTagId()))
                    : List.of(), (List<ResTagDef> oldList, List<ResTagDef> newList) -> {
                        if (CollectionUtils.isEmpty(oldList)) {
                            return newList;
                        }
                        var temp = oldList.stream().collect(Collectors.toList());
                        temp.addAll(newList);
                        return temp;
                    }));
    }

    public List<String> getSearchedResTag(String resTagName) {
        var example = new ResTagDefExample();
        example.createCriteria().andResTagNameLike(SQL_LIKE + resTagName + SQL_LIKE).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
        var result = resTagDefMapper.selectByExample(example);
        return result.stream().map(i -> i.getResTagCode()).collect(Collectors.toList());
    }
}
