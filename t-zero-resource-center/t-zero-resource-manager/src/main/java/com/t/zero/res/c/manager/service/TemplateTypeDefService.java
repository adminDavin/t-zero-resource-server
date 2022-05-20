package com.t.zero.res.c.manager.service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;
import com.t.zero.res.c.manager.bu.dao.auto.TemplateInfoDefMapper;
import com.t.zero.res.c.manager.bu.dao.auto.TemplateTypeDefMapper;
import com.t.zero.res.c.manager.bu.model.auto.TemplateInfoDefExample;
import com.t.zero.res.c.manager.bu.model.auto.TemplateTypeDef;
import com.t.zero.res.c.manager.bu.model.auto.TemplateTypeDefExample;
import com.t.zero.res.c.manager.bu.model.manual.TemplateTypeDefVo;

@Service
public class TemplateTypeDefService {

	@Autowired
	private TemplateTypeDefMapper templateTypeDefMapper;

	@Autowired
	private TemplateInfoDefMapper templateInfoDefMapper;

	@Autowired
	private ObjectMapper mapper;

	public Object list(CommonParams params, ObjectNode content) {
		var typeExample = new TemplateTypeDefExample();
		typeExample.createCriteria().andTenantIdEqualTo(params.getTenantId())
				.andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		var records = templateTypeDefMapper.selectByExampleWithBLOBs(typeExample);
		return records.stream().map(i -> {
			var r = new TemplateTypeDefVo();
			r.setCreatedTime(i.getCreatedTime());
			r.setCreatedUserId(i.getCreatedUserId());
			r.setTemplateTypeCode(i.getTemplateTypeCode());
			try {
				r.setTemplateTypeDesc(mapper.readTree(i.getTemplateTypeDesc()));
			} catch (JsonProcessingException e) {

			}
			r.setId(i.getId());
			r.setTemplateTypeName(i.getTemplateTypeName());
			r.setTenantId(i.getTenantId());
			r.setUpdatedTime(i.getUpdatedTime());
			r.setUpdatedUserId(i.getUpdatedUserId());
			return r;
		}).collect(Collectors.toList());
	}

	public Object update(CommonParams params, ObjectNode content) {
		var record = templateTypeDefMapper.selectByPrimaryKey(content.get("id").asInt());
		record.setUpdatedTime(LocalDateTime.now());
		record.setUpdatedUserId(params.getUserId());
		record.setTemplateTypeDesc(content.get("templateTypeDesc").toString());
		record.setTemplateTypeName(content.get("templateTypeName").asText());
		return record;
	}

	public Object save(CommonParams params, ObjectNode content) {
		var record = new TemplateTypeDef();
		var operateTime = LocalDateTime.now();
		record.setTenantId(params.getTenantId());
		record.setTemplateTypeCode(UUIDUtils.getUUID());
		record.setDeletedFlag(TZeroConstants.NORMAL);
		record.setCreatedTime(operateTime);
		record.setCreatedUserId(params.getUserId());
		record.setUpdatedTime(operateTime);
		record.setUpdatedUserId(params.getUserId());

		record.setTemplateTypeDesc(content.get("templateTypeDesc").toString());
		record.setTemplateTypeName(content.get("templateTypeName").asText());
		templateTypeDefMapper.insert(record);
		return record;
	}

	public Object delete(CommonParams params, ObjectNode content) {
		var record = templateTypeDefMapper.selectByPrimaryKey(content.get("id").asInt());

		var infoExample = new TemplateInfoDefExample();
		infoExample.createCriteria().andTemplateInfoCodeEqualTo(record.getTemplateTypeCode());

		templateInfoDefMapper.deleteByExample(infoExample);
		templateTypeDefMapper.deleteByPrimaryKey(record.getId());
		return record;
	}

}
