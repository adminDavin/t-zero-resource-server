package com.t.zero.res.c.manager.helper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.check.CheckUtils;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.res.c.manager.bu.dao.auto.ResInfoDefMapper;
import com.t.zero.res.c.manager.bu.model.auto.ResInfoDef;
import com.t.zero.res.c.manager.bu.model.auto.ResInfoDefExample;
import com.t.zero.res.c.manager.co.file.MinIoUtil;

/**
 * @author davinzhang
 * 
 * @date 2022/02/04
 * 
 * @desc TODO
 */
@Component
public class RenameResourceHelper {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MinIoUtil minIoUtil;

    @Autowired
    private ResInfoDefMapper resInfoDefMapper;

    public List<ResInfoDef> rename(CommonParams params, ResInfoDef resInfo, String resInfoName) {
        var r = new ResInfoDef();
        r.setResInfoName(resInfoName);
        r.setUpdatedTime(LocalDateTime.now());
        r.setUpdatedUserId(params.getUserId());
        r.setId(resInfo.getId());
        resInfoDefMapper.updateByPrimaryKeySelective(r);
        return List.of(resInfo);

    }

    public void delete(CommonParams params, ResInfoDef resInfo) throws Exception {
        if (!UploadResourceHelper.RES_INFO_TYPE_FILE.equals(resInfo.getResInfoType())) {
            var children = getAllChild(resInfo.getResInfoCode());
            var nChildren = children
                .stream().filter(i -> UploadResourceHelper.RES_INFO_TYPE_FILE.equals(i.getResInfoType())).map(i -> i.getResInfoStore())
                .collect(Collectors.toList());
            minIoUtil.deleteFiles(nChildren);
            for (var i : children) {
                resInfoDefMapper.deleteByPrimaryKey(i.getId());
            }
        } else {
            minIoUtil.deleteFile(resInfo.getResInfoStore());
        }
        resInfoDefMapper.deleteByPrimaryKey(resInfo.getId());
    }

    public void move(CommonParams params, List<ResInfoDef> sResInfos, ResInfoDef tResInfo) throws Exception {
        for (var sResInfo : sResInfos) {
            var r = new ResInfoDef();
            r.setUpdatedTime(LocalDateTime.now());
            r.setUpdatedUserId(params.getUserId());
            r.setId(sResInfo.getId());
            r.setResInfoParentCode(tResInfo.getResInfoCode());
            resInfoDefMapper.updateByPrimaryKeySelective(r);
        }
    }

    public List<ResInfoDef> getAllChild(String resInfoCode) {
        var example = new ResInfoDefExample();
        example.createCriteria().andResInfoParentCodeEqualTo(resInfoCode).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
        List<ResInfoDef> children = resInfoDefMapper.selectByExample(example);
        var childrenFolders = children
            .stream().filter(i -> !UploadResourceHelper.RES_INFO_TYPE_FILE.equals(i.getResInfoType())).map(i -> i.getResInfoCode())
            .collect(Collectors.toList());
        children.addAll(getAllChild(childrenFolders));
        return children;
    }

    public List<ResInfoDef> getAllChild(List<String> resInfoCode) {
        if (CollectionUtils.isEmpty(resInfoCode)) {
            return List.of();
        }
        var example = new ResInfoDefExample();
        example.createCriteria().andResInfoParentCodeIn(resInfoCode).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
        List<ResInfoDef> children = resInfoDefMapper.selectByExample(example);
        var childrenFolders = children
            .stream().filter(i -> !UploadResourceHelper.RES_INFO_TYPE_FILE.equals(i.getResInfoType())).map(i -> i.getResInfoCode())
            .collect(Collectors.toList());
        children.addAll(getAllChild(childrenFolders));
        return children;
    }

    public ObjectNode getChildTree(String resInfoCode) {
        var example = new ResInfoDefExample();
        example.createCriteria().andResInfoParentCodeEqualTo(resInfoCode).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
        List<ResInfoDef> children = resInfoDefMapper.selectByExample(example);
        var result = mapper.createObjectNode();
        for (var i : children) {
            if (!UploadResourceHelper.RES_INFO_TYPE_FILE.equals(i.getResInfoType())) {
                var temp = mapper.createObjectNode();
                temp.set("children", getChildTree(i.getResInfoCode()));
                result.set(i.getResInfoCode(), temp);
            }
        }
        return result;
    }

    public List<ResInfoDef> getAllParent(String resInfoCode) {
        var example = new ResInfoDefExample();
        example.createCriteria().andResInfoCodeEqualTo(resInfoCode).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
        List<ResInfoDef> results = resInfoDefMapper.selectByExample(example);
        CheckUtils.throwException(CollectionUtils.isEmpty(results), "资源%s不存在", resInfoCode);
        var resInfo = results.get(0);
        if (StringUtils.isNotEmpty(resInfo.getResInfoParentCode())) {
            var result = getAllParent(resInfo.getResInfoParentCode());
            result.add(resInfo);
            return result;
        } else {
            List<ResInfoDef> result = new ArrayList<>();
            result.add(resInfo);
            return result;
        }
    }

}
