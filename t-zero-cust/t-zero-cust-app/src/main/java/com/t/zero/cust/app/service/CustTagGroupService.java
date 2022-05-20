package com.t.zero.cust.app.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;
import com.t.zero.cust.app.bu.dao.auto.CustTagGroupMapper;
import com.t.zero.cust.app.bu.model.auto.CustTagGroup;
import com.t.zero.cust.app.bu.model.auto.CustTagGroupExample;
import com.t.zero.cust.app.bu.vo.response.CustTagGroupVo;
import com.t.zero.cust.app.helper.CustRelTagGroupHelper;

@Service
public class CustTagGroupService {

	@Autowired
	public CustTagGroupMapper custTagGroupMapper;

	@Autowired
	public ObjectMapper mapper;
	
	@Autowired
	public CustRelTagGroupHelper custRelTagGroupHelper;
	
	public Object list(CommonParams params, ObjectNode content) {
			var example = new CustTagGroupExample();
			example.createCriteria().andTenantIdEqualTo(params.getTenantId());
			example.setOrderByClause(" updated_time desc");
			var list = custTagGroupMapper.selectByExample(example);
			var codes = list.stream().map(i -> i.getTagGroupCode()).collect(Collectors.toList());
			var t1 = custRelTagGroupHelper.getTagInfosByTagGroups(codes);
			return list.stream().map(i -> CustTagGroupVo.build(i, t1.get(i.getTagGroupCode()))).collect(Collectors.toList());
		}
	
		public Object create(CommonParams params, ObjectNode content) {
			var r = new CustTagGroup();
			r.setCreatedTime(LocalDateTime.now());
			r.setUpdatedTime(LocalDateTime.now());
			r.setUpdatedUserId(params.getUserId());
			r.setCreatedUserId(params.getUserId());
			r.setTenantId(params.getTenantId());
			r.setDeletedFlag(TZeroConstants.NORMAL);
			r.setTagGroupCode(UUIDUtils.getUUID());
			r.setTagGroupName(content.get("tagGroupName").asText());
			custTagGroupMapper.insert(r);
			return r;
		}
	
		public Object modify(CommonParams params, ObjectNode content) {
			var r = custTagGroupMapper.selectByPrimaryKey(content.get("id").asInt());
			if (ObjectUtils.isEmpty(r)) {
				throw new RuntimeException("标签不存在");
			}
			r.setUpdatedTime(LocalDateTime.now());
			r.setUpdatedUserId(params.getUserId());
			r.setTagGroupName(content.get("tagGroupName").asText());
			custTagGroupMapper.updateByPrimaryKeySelective(r);
			return r;
		}
	
		public Object delete(CommonParams params, ObjectNode content) {
			return custTagGroupMapper.deleteByPrimaryKey(content.get("id").asInt());
		}
	
		public Object get(CommonParams params, ObjectNode content) {
			return custTagGroupMapper.selectByPrimaryKey(content.get("id").asInt());
		}
		
		public Object addTag(CommonParams params, ObjectNode content) {
			var item = custTagGroupMapper.selectByPrimaryKey(content.get("id").asInt());
			custRelTagGroupHelper.addTag(params.getUserId(), item, Arrays.asList(mapper.convertValue(content.get("tagInfoCodes"), String[].class)));
			return 200;
		}

		public Object deleteTag(CommonParams params, ObjectNode content) {
			var item = custTagGroupMapper.selectByPrimaryKey(content.get("id").asInt());
			custRelTagGroupHelper.addTag(params.getUserId(), item, Arrays.asList(mapper.convertValue(content.get("tagInfoCodes"), String[].class)));
			return 200;
		}

}
