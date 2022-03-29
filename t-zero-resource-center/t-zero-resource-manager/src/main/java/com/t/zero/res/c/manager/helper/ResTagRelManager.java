package com.t.zero.res.c.manager.helper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.t.zero.common.base.check.CheckUtils;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.res.c.manager.bu.dao.auto.ResInfoDefMapper;
import com.t.zero.res.c.manager.bu.dao.auto.ResTagDefMapper;
import com.t.zero.res.c.manager.bu.dao.auto.ResTagRelMapper;
import com.t.zero.res.c.manager.bu.model.auto.ResInfoDef;
import com.t.zero.res.c.manager.bu.model.auto.ResInfoDefExample;
import com.t.zero.res.c.manager.bu.model.auto.ResTagDef;
import com.t.zero.res.c.manager.bu.model.auto.ResTagDefExample;
import com.t.zero.res.c.manager.bu.model.auto.ResTagRel;
import com.t.zero.res.c.manager.bu.model.auto.ResTagRelExample;

/**
 * @author davinzhang
 * 
 * @date 2022/02/05
 * 
 * @desc TODO
 */

@Component
public class ResTagRelManager {

    @Autowired
    private ResTagRelMapper resTagRelMapper;

    @Autowired
    private ResTagDefMapper resTagDefMapper;

    @Autowired
    private ResInfoDefMapper resInfoDefMapper;

    public List<ResTagDef> getResInfoTags(String resInfoCode) {
        var rels = getResTagRels(resInfoCode);
        var tagCodes = rels.stream().map(i -> i.getResTagCode()).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(tagCodes)) {
            return List.of();
        }
        var example = new ResTagDefExample();
        example.createCriteria().andResTagCodeIn(tagCodes);
        return resTagDefMapper.selectByExample(example);

    }

    private List<ResTagRel> getResTagRels(String resInfoCode) {
        var example = new ResTagRelExample();
        example.createCriteria().andResInfoCodeEqualTo(resInfoCode);
        return resTagRelMapper.selectByExample(example);
    }

    private List<ResTagRel> getResTagRels(String resInfoCode, String resTagCode) {
        var example = new ResTagRelExample();
        example.createCriteria().andResInfoCodeEqualTo(resInfoCode).andResTagCodeEqualTo(resTagCode);
        return resTagRelMapper.selectByExample(example);
    }

    public ResTagRel addTag(CommonParams params, String resInfoCode, String resTagCode) {
        var rels = getResTagRels(resInfoCode, resTagCode);
        CheckUtils.throwException(CollectionUtils.isNotEmpty(rels), "资源标签已存在, 不可重复添加", resTagCode);
        var resInfo = getResInfoDef(resInfoCode);
        var resTag = getResTagDef(resTagCode);
        var r = new ResTagRel();
        r.setCreatedTime(LocalDateTime.now());
        r.setCreatedUserId(params.getUserId());
        r.setResInfoCode(resInfo.getResInfoCode());
        r.setResInfoId(resInfo.getId());
        r.setResTagCode(resTag.getResTagCode());
        r.setResTagId(resTag.getId());
        resTagRelMapper.insert(r);
        return r;
    }

    public Integer deleteTag(CommonParams params, String resInfoCode, String resTagCode) {
        var rels = getResTagRels(resInfoCode, resTagCode);
        CheckUtils.throwException(CollectionUtils.isEmpty(rels), "资源标签不存在, 没有执行删除操作", resTagCode);
        return resTagRelMapper.deleteByPrimaryKey(rels.get(0).getId());
    }

    public Integer deleteTag(CommonParams params, String resTagCode) {
        var example = new ResTagRelExample();
        example.createCriteria().andResTagCodeEqualTo(resTagCode);
        return resTagRelMapper.deleteByExample(example);
    }

    
    public ResInfoDef getResInfoDef(String resInfoCode) {
        var example = new ResInfoDefExample();
        example.createCriteria().andResInfoCodeEqualTo(resInfoCode);
        var res = resInfoDefMapper.selectByExample(example);
        CheckUtils.throwException(CollectionUtils.isEmpty(res), "资源不存在", resInfoCode);
        return res.get(0);
    }

    public ResTagDef getResTagDef(String resTagCode) {
        var example = new ResTagDefExample();
        example.createCriteria().andResTagCodeEqualTo(resTagCode);
        var res = resTagDefMapper.selectByExample(example);
        CheckUtils.throwException(CollectionUtils.isEmpty(res), "资源标签不存在", resTagCode);
        return res.get(0);
    }

}
