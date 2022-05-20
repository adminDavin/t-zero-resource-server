package com.t.zero.cust.app.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;
import com.t.zero.cust.app.bu.dao.auto.CustAppInfoMapper;
import com.t.zero.cust.app.bu.model.auto.CustAppInfo;
import com.t.zero.cust.app.bu.model.auto.CustAppInfoExample;
import com.t.zero.cust.app.bu.model.auto.CustTagInfo;
import com.t.zero.cust.app.bu.vo.response.CustAppInfoVo;
import com.t.zero.cust.app.helper.CustAppInfoHelper;

@Service
public class CustAppInfoService {

	@Autowired
	public CustAppInfoMapper custAppInfoMapper;

	@Autowired
	public CustAppInfoHelper custAppInfoHelper;

	@Autowired
	public ObjectMapper mapper;

	public Object list(CommonParams params, ObjectNode content) {
		var example = new CustAppInfoExample();
		example.createCriteria().andTenantIdEqualTo(params.getTenantId());
		example.setOrderByClause(" updated_time desc");
		var list = custAppInfoMapper.selectByExample(example);
		var code = list.stream().map(i -> i.getAppInfoCode()).collect(Collectors.toList());
		Map<String, List<CustTagInfo>> t1 = custAppInfoHelper.getTagInfosByAppInfos(code);
		return list.stream().map(i -> CustAppInfoVo.build(i, t1.get(i.getAppInfoCode()))).collect(Collectors.toList());
	}
	
	

	public Object create(CommonParams params, ObjectNode content) {
		var r = new CustAppInfo();
		r.setCreatedTime(LocalDateTime.now());
		r.setUpdatedTime(LocalDateTime.now());
		r.setUpdatedUserId(params.getUserId());
		r.setCreatedUserId(params.getUserId());
		r.setTenantId(params.getTenantId());
		r.setDeletedFlag(TZeroConstants.NORMAL);
		r.setAppInfoCode(UUIDUtils.getUUID());
		r.setAppInfoAttrs(content.get("appInfoAttrs").toString());
		r.setAppInfoLink(content.get("appInfoLink").asText());
		r.setAppInfoLogo(content.get("appInfoLogo").asText());
		r.setAppInfoName(content.get("appInfoName").asText());
		r.setAppInfoType(content.get("appInfoType").asText());
		r.setOwnerId(content.get("ownerId").asText());
		custAppInfoMapper.insert(r);
		return r;
	}

	public Object modify(CommonParams params, ObjectNode content) {
		var r = custAppInfoMapper.selectByPrimaryKey(content.get("id").asInt());
		if (ObjectUtils.isEmpty(r)) {
			throw new RuntimeException("标签不存在");
		}
		r.setUpdatedTime(LocalDateTime.now());
		r.setUpdatedUserId(params.getUserId());
		r.setAppInfoAttrs(content.get("appInfoAttrs").toString());
		r.setAppInfoLink(content.get("appInfoLink").asText());
		r.setAppInfoLogo(content.get("appInfoLogo").asText());
		r.setAppInfoName(content.get("appInfoName").asText());
		r.setAppInfoType(content.get("appInfoType").asText());
		custAppInfoMapper.updateByPrimaryKeySelective(r);
		return r;
	}

	public Object delete(CommonParams params, ObjectNode content) {
		return custAppInfoMapper.deleteByPrimaryKey(content.get("id").asInt());
	}

	public Object get(CommonParams params, ObjectNode content) {
		return custAppInfoMapper.selectByPrimaryKey(content.get("id").asInt());
	}

	public Object addTag(CommonParams params, ObjectNode content) {
		var item = custAppInfoMapper.selectByPrimaryKey(content.get("id").asInt());
		custAppInfoHelper.addTag(params.getUserId(), item,
				Arrays.asList(mapper.convertValue(content.get("tagInfoCodes"), String[].class)));
		return 200;
	}

	public Object deleteTag(CommonParams params, ObjectNode content) {
		var item = custAppInfoMapper.selectByPrimaryKey(content.get("id").asInt());
		custAppInfoHelper.addTag(params.getUserId(), item,
				Arrays.asList(mapper.convertValue(content.get("tagInfoCodes"), String[].class)));
		return 200;
	}
}
