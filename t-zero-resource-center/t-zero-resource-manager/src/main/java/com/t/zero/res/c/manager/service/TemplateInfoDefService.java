package com.t.zero.res.c.manager.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;
import com.t.zero.res.c.manager.bu.convert.TemplateInfoConvertor;
import com.t.zero.res.c.manager.bu.dao.auto.TemplateInfoDefMapper;
import com.t.zero.res.c.manager.bu.dao.auto.TemplateTypeDefMapper;
import com.t.zero.res.c.manager.bu.model.auto.TemplateInfoDef;
import com.t.zero.res.c.manager.bu.model.auto.TemplateInfoDefExample;
import com.t.zero.res.c.manager.bu.model.auto.TemplateTypeDef;
import com.t.zero.res.c.manager.bu.model.auto.TemplateTypeDefExample;

@Service
public class TemplateInfoDefService {

	@Autowired
	private TemplateInfoConvertor templateInfoConvertor;

	@Autowired
	private TemplateInfoDefMapper templateInfoDefMapper;

	@Autowired
	private TemplateTypeDefMapper templateTypeDefMapper;

	public Object list(CommonParams params, ObjectNode content) {
		var typeExample = new TemplateTypeDefExample();
		if (content.has("templateTypeCode")) {
			typeExample.createCriteria().andTenantIdEqualTo(params.getTenantId())
					.andDeletedFlagEqualTo(TZeroConstants.NORMAL)
					.andTemplateTypeCodeEqualTo(content.get("templateTypeCode").asText());
		} else {
			typeExample.createCriteria().andTenantIdEqualTo(params.getTenantId())
					.andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		}
		var typeRecords = templateTypeDefMapper.selectByExample(typeExample);
		if (CollectionUtils.isEmpty(typeRecords)) {
			return List.of();
		}

		var typeCodes = typeRecords.stream().map(i -> i.getTemplateTypeCode()).collect(Collectors.toList());
		var typeMaps = typeRecords.stream()
				.collect(Collectors.toMap(TemplateTypeDef::getTemplateTypeCode, i -> i.getTemplateTypeName()));

		var infoExample = new TemplateInfoDefExample();
		infoExample.createCriteria().andTemplateTypeCodeIn(typeCodes);
		var infoRecords = templateInfoDefMapper.selectByExampleWithBLOBs(infoExample);
		var results = templateInfoConvertor.convert(infoRecords);

		return results.stream().map(i -> {
			i.setTemplateTypeName(typeMaps.get(i.getTemplateTypeCode()));
			return i;
		}).collect(Collectors.toList());
	}

	public Object update(CommonParams params, ObjectNode content) {
		var record = templateInfoDefMapper.selectByPrimaryKey(content.get("id").asInt());
		record.setUpdatedTime(LocalDateTime.now());
		record.setUpdatedUserId(params.getUserId());
		record.setTemplateFileAddress(content.get("templateFileAddress").asText());
		record.setTemplateFileName(content.get("templateFileName").asText());
		record.setTemplateFileStorage(content.get("templateFileStorage").asText());
		record.setTemplateInfoDesc(content.get("templateInfoDesc").toString());
		record.setTemplateInfoName(content.get("templateInfoName").asText());

		if (content.has("templateTypeId")) {
			var typeRecord = templateTypeDefMapper.selectByPrimaryKey(content.get("templateTypeId").asInt());
			record.setTemplateTypeCode(typeRecord.getTemplateTypeCode());
			record.setTemplateTypeId(typeRecord.getId());
		}
		templateInfoDefMapper.updateByPrimaryKey(record);
		return record;
	}

	public Object save(CommonParams params, ObjectNode content) {
		var record = new TemplateInfoDef();
		var operateTime = LocalDateTime.now();

		var typeRecord = templateTypeDefMapper.selectByPrimaryKey(content.get("templateTypeId").asInt());
		record.setTemplateTypeCode(typeRecord.getTemplateTypeCode());
		record.setTemplateTypeId(typeRecord.getId());

		record.setTemplateInfoCode(UUIDUtils.getUUID());
		record.setDeletedFlag(TZeroConstants.NORMAL);
		record.setCreatedTime(operateTime);
		record.setCreatedUserId(params.getUserId());
		record.setUpdatedTime(operateTime);
		record.setUpdatedUserId(params.getUserId());
		record.setTemplateFileAddress(content.get("templateFileAddress").asText());
		record.setTemplateFileName(content.get("templateFileName").asText());
		record.setTemplateFileStorage(content.get("templateFileStorage").asText());
		record.setTemplateInfoDesc(content.get("templateInfoDesc").toString());
		record.setTemplateInfoName(content.get("templateInfoName").asText());
		templateInfoDefMapper.insert(record);
		return record;
	}

	public Object delete(CommonParams params, ObjectNode content) {
		return templateInfoDefMapper.deleteByPrimaryKey(content.get("id").asInt());
	}
}
