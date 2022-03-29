package com.t.zero.res.c.manager.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.check.CheckUtils;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;
import com.t.zero.res.c.manager.bu.dao.auto.ResTagDefMapper;
import com.t.zero.res.c.manager.bu.model.auto.ResTagDef;
import com.t.zero.res.c.manager.bu.model.auto.ResTagDefExample;
import com.t.zero.res.c.manager.helper.ResTagRelManager;
import com.t.zero.res.c.manager.helper.UploadResourceHelper;

/**
 * @author davinzhang
 * 
 * @date 2022/02/04
 * 
 * @desc TODO
 */

@Service
public class ResTagDefService {
    @Autowired
    private ResTagDefMapper resTagDefMapper;

    @Autowired
    private ResTagRelManager resTagRelManager;

    public static String DEFAULT_RES_TAG_TYPE = "CUSTOM";

    public Object list(CommonParams params, ObjectNode content) {
        var ownerType = content.get("ownerType").asText();
        var ownerId = UploadResourceHelper.RES_INFO_OWNER_TYPE_MINE.equals(ownerType) ? params.getUserIdInt() : content.get("ownerId").asInt();
        var example = new ResTagDefExample();
        example.createCriteria().andResOwnerIdEqualTo(ownerId).andResOwnerTypeEqualTo(ownerType).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
        return resTagDefMapper
            .selectByExample(example).stream().sorted(Comparator.comparing(ResTagDef::getCreatedTime).reversed()).collect(Collectors.toList());
    }

    public Object save(CommonParams params, ObjectNode content) {
        var ownerType = content.get("ownerType").asText();
        var resTagName = content.get("resTagName").asText();
        var ownerId = UploadResourceHelper.RES_INFO_OWNER_TYPE_MINE.equals(ownerType) ? params.getUserIdInt() : content.get("ownerId").asInt();
        var r = new ResTagDef();
        var operateTime = LocalDateTime.now();
        var example = new ResTagDefExample();
        example
            .createCriteria().andResTagNameEqualTo(resTagName).andResOwnerIdEqualTo(ownerId).andResOwnerTypeEqualTo(ownerType)
            .andDeletedFlagEqualTo(TZeroConstants.NORMAL);
        var result = resTagDefMapper.selectByExample(example);
        CheckUtils.throwException(CollectionUtils.isNotEmpty(result), "资源标签%s已存在", resTagName);
        r.setCreatedTime(operateTime);
        r.setCreatedUserId(params.getUserId());
        r.setUpdatedTime(operateTime);
        r.setUpdatedUserId(params.getUserId());
        r.setDeletedFlag(TZeroConstants.NORMAL);
        r.setTenantId(params.getTenantId());

        r.setResOwnerId(ownerId);
        r.setResOwnerType(ownerType);
        r.setResTagCode(UUIDUtils.getUUID());
        r.setResTagName(resTagName);
        r.setResTagType(DEFAULT_RES_TAG_TYPE);
        resTagDefMapper.insert(r);
        return r;
    }

    public Object delete(CommonParams params, ObjectNode content) {
        var resTagCode = content.get("resTagCode").asText();
        resTagRelManager.deleteTag(params, resTagCode);
        var example = new ResTagDefExample();
        example.createCriteria().andResTagCodeEqualTo(resTagCode);
        var r = new ResTagDef();
        r.setUpdatedTime(LocalDateTime.now());
        r.setUpdatedUserId(params.getUserId());
        r.setDeletedFlag(TZeroConstants.ABNORMAL);
        return resTagDefMapper.updateByExampleSelective(r, example);
    }

}
