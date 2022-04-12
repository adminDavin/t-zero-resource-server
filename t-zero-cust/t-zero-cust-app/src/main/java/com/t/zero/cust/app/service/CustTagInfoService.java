package com.t.zero.cust.app.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;
import com.t.zero.cust.app.bu.dao.auto.CustTagInfoMapper;
import com.t.zero.cust.app.bu.model.auto.CustTagInfo;
import com.t.zero.cust.app.bu.model.auto.CustTagInfoExample;

@Service
public class CustTagInfoService {

	@Autowired
	public CustTagInfoMapper custTagInfoMapper;

	public Object list(CommonParams params, ObjectNode content) {
		var example = new CustTagInfoExample();
		example.createCriteria().andTenantIdEqualTo(params.getTenantId());
		return custTagInfoMapper.selectByExample(example);
	}

	public Object create(CommonParams params, ObjectNode content) {
		var r = new CustTagInfo();
		r.setCreatedTime(LocalDateTime.now());
		r.setUpdatedTime(LocalDateTime.now());
		r.setUpdatedUserId(params.getUserId());
		r.setCreatedUserId(params.getUserId());
		r.setTenantId(params.getTenantId());
		r.setDeletedFlag(TZeroConstants.NORMAL);
		r.setTagInfoAttrs(content.get("tagInfoAttrs").toString());
		r.setTagInfoCode(UUIDUtils.getUUID());
		r.setTagInfoColor(content.get("tagInfoColor").asText());
		r.setTagInfoName(content.get("tagInfoName").asText());
		r.setTagInfoType(content.get("tagInfoType").asText());
		custTagInfoMapper.insert(r);
		return r;
	}

	public Object modify(CommonParams params, ObjectNode content) {
		var r = custTagInfoMapper.selectByPrimaryKey(content.get("id").asInt());
		if (ObjectUtils.isEmpty(r)) {
			throw new RuntimeException("标签不存在");
		}
		r.setUpdatedTime(LocalDateTime.now());
		r.setUpdatedUserId(params.getUserId());
		r.setTagInfoAttrs(content.get("tagInfoAttrs").toString());
		r.setTagInfoColor(content.get("tagInfoColor").asText());
		r.setTagInfoName(content.get("tagInfoName").asText());
		r.setTagInfoType(content.get("tagInfoType").asText());
		custTagInfoMapper.updateByPrimaryKeySelective(r);
		return r;
	}

	public Object delete(CommonParams params, ObjectNode content) {
		return custTagInfoMapper.deleteByPrimaryKey(content.get("id").asInt());
	}

	public Object get(CommonParams params, ObjectNode content) {
		return custTagInfoMapper.selectByPrimaryKey(content.get("id").asInt());
	}

	

}
