package com.t.zero.yg.crm.module.buss.config.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;
import com.t.zero.yg.crm.bu.dao.auto.DictionariesDefMapper;
import com.t.zero.yg.crm.bu.dao.auto.FieldDefMapper;
import com.t.zero.yg.crm.bu.dao.auto.FieldGroupDefMapper;
import com.t.zero.yg.crm.bu.model.auto.DictionariesDef;
import com.t.zero.yg.crm.bu.model.auto.DictionariesDefExample;
import com.t.zero.yg.crm.bu.model.auto.FieldDef;
import com.t.zero.yg.crm.bu.model.auto.FieldDefExample;
import com.t.zero.yg.crm.bu.model.auto.FieldGroupDef;
import com.t.zero.yg.crm.bu.model.auto.FieldGroupDefExample;

@Service
public class EntityService {
	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private FieldDefMapper fieldDefMapper;

	@Autowired
	private FieldGroupDefMapper fieldGroupDefMapper;

	@Autowired
	private DictionariesDefMapper dictionariesDefMapper;

	public static List<String> arrayList = List.of("OTHER_FILE", "IMAGE_FILE", "DATERANGE", "SELECT_MULTI");

	public Object initEntity(CommonParams params, String bussCode, ObjectNode content)
			throws JsonMappingException, JsonProcessingException {
		clearFields(bussCode);
		var fieldGroup = initGroup(params, bussCode);
		int index = 0;
		var pvJson = (ObjectNode) content.get("pvJson");
		initId(params, bussCode, fieldGroup, index++, pvJson);
		initPv(params, bussCode, fieldGroup, index++, pvJson);
		index++;
		initCreate(params, bussCode, fieldGroup, index++, pvJson);
		index++;
		initUser(params, bussCode, fieldGroup, index++, pvJson);

		var textColumns = Arrays.asList(mapper.convertValue(content.get("textColumns"), ObjectNode[].class));
		var groups = textColumns.stream().filter(i -> i.get("group").asText().contains(":"))
				.collect(Collectors.groupingBy(i -> i.get("group").asText()));
//		initGroup();
		for (var columns : textColumns) {
			if (!columns.get("group").asText().contains(":")) {
				initColumn(params, bussCode, fieldGroup, index++, columns, pvJson);
			}
		}
		for (var i : groups.keySet()) {
			var g = initGroup(params, bussCode, i);
			var gField = groups.get(i);
			for (var columns : gField) {
				initColumn(params, bussCode, g, index++, columns, pvJson);
			}
		}
		return null;
	}

	private void initColumn(CommonParams params, String bussCode, FieldGroupDef fieldGroup, Integer index,
			ObjectNode content, ObjectNode pvJson) throws JsonMappingException, JsonProcessingException {
		var fieldDef = getInitFiedl(params, bussCode, fieldGroup);
		fieldDef.setFieldKey(content.get("key").asText());
		fieldDef.setAutoGenerate(TZeroConstants.NORMAL);
		fieldDef.setFieldName(content.get("label").asText());
		fieldDef.setFieldNameEn(content.get("label").asText());
		fieldDef.setFieldType(content.get("fieldType").asText());
		fieldDef.setValueSource("MUNUAL_INPUT");
		if (fieldDef.getFieldType().equals("SELECT_SINGLE") || "SELECT_MULTI".equals(fieldDef.getFieldType())) {
			var dict = initDect(params, bussCode, fieldDef, content.get("typeDict"));
			fieldDef.setValueSource("DICT");
			fieldDef.setValueSourceDef(dict.getPvCode());
		} else {
			fieldDef.setValueSourceDef("");
		}

		fieldDef.setValueType(arrayList.contains(fieldDef.getFieldType()) ? "ARRAY" : "TEXT");
		var width = (ObjectNode) pvJson.get("width");
		width.put("value", content.get("width").asInt());
		fieldDef.setLvOrder(content.get("lvOrder").asInt());
		fieldDef.setShowWidth(content.get("showWidth").asInt());
		fieldDef.setPvDesc(pvJson.toString());
		fieldDefMapper.insert(fieldDef);
	}

	private DictionariesDef initDect(CommonParams params, String bussCode, FieldDef field, JsonNode content) {
		var d = new DictionariesDef();
		d.setBussCode(bussCode);
		d.setCreatedTime(LocalDateTime.now());
		d.setCreatedUserId(params.getUserId());
		d.setDeletedFlag(TZeroConstants.NORMAL);
		d.setDictName(field.getFieldName());
		d.setDictType("PRIVATE");
		d.setPvCode(UUIDUtils.getUUID());
		d.setPvDesc(content.toString());
		d.setPvStatus(TZeroConstants.NORMAL);
		d.setRelatedCode(field.getPvCode());
		d.setRelatedType("RELATED_FIELD");
		d.setTenantId(params.getTenantId());
		d.setUpdatedTime(LocalDateTime.now());
		d.setUpdatedUserId(params.getUserId());
		dictionariesDefMapper.insert(d);
		return d;
	}

	private void initPv(CommonParams params, String bussCode, FieldGroupDef fieldGroup, Integer index,
			ObjectNode pvJson) throws JsonMappingException, JsonProcessingException {
		var fieldDef = getInitFiedl(params, bussCode, fieldGroup);
		fieldDef.setFieldKey("pvCode");
		fieldDef.setFieldName("记录编码");
		fieldDef.setFieldNameEn("code");
		fieldDef.setFieldType("TEXT");
		fieldDef.setValueSource("AUTO_GENERATE");
		fieldDef.setValueSourceDef("");
		fieldDef.setValueType("TEXT");
		var width = (ObjectNode) pvJson.get("width");
		width.put("value", 0);
		fieldDef.setLvOrder(index);
		fieldDef.setShowWidth(280);
		fieldDef.setPvDesc(pvJson.toString());
		fieldDefMapper.insert(fieldDef);
	}

	private void initUser(CommonParams params, String bussCode, FieldGroupDef fieldGroup, Integer index,
			ObjectNode pvJson) throws JsonMappingException, JsonProcessingException {
		var fieldDef = getInitFiedl(params, bussCode, fieldGroup);
		fieldDef.setFieldKey("createdUsername");
		fieldDef.setFieldName("创建人");
		fieldDef.setFieldNameEn("created username");
		fieldDef.setFieldType("TEXT");
		fieldDef.setValueSource("AUTO_GENERATE");
		fieldDef.setValueSourceDef("");
		fieldDef.setValueType("TEXT");
		var width = (ObjectNode) pvJson.get("width");
		width.put("value", 0);
		fieldDef.setLvOrder(index - 1);
		fieldDef.setShowWidth(100);
		fieldDef.setPvDesc(pvJson.toString());
		fieldDefMapper.insert(fieldDef);
		fieldDef = getInitFiedl(params, bussCode, fieldGroup);
		fieldDef.setFieldKey("updatedUsername");
		fieldDef.setFieldName("更新人");
		fieldDef.setFieldNameEn("update username");
		fieldDef.setFieldType("TEXT");
		fieldDef.setValueSource("AUTO_GENERATE");
		fieldDef.setValueSourceDef("");
		fieldDef.setValueType("TEXT");
		fieldDef.setLvOrder(index);
		fieldDef.setShowWidth(100);
		fieldDef.setPvDesc(pvJson.toString());
		fieldDefMapper.insert(fieldDef);
	}

	private void initCreate(CommonParams params, String bussCode, FieldGroupDef fieldGroup, Integer index,
			ObjectNode pvJson) throws JsonMappingException, JsonProcessingException {
		var fieldDef = getInitFiedl(params, bussCode, fieldGroup);
		fieldDef.setFieldKey("createdTime");
		fieldDef.setFieldName("创建时间");
		fieldDef.setFieldNameEn("created time");
		fieldDef.setFieldType("DATE");
		fieldDef.setValueSource("AUTO_GENERATE");
		fieldDef.setValueSourceDef("");
		fieldDef.setValueType("DATE");
		var width = (ObjectNode) pvJson.get("width");
		width.put("value", 0);
		fieldDef.setLvOrder(index - 1);
		fieldDef.setShowWidth(160);
		fieldDef.setPvDesc(pvJson.toString());
		fieldDefMapper.insert(fieldDef);
		fieldDef = getInitFiedl(params, bussCode, fieldGroup);
		fieldDef.setFieldKey("updatedTime");
		fieldDef.setFieldName("更新时间");
		fieldDef.setFieldNameEn("updated time");
		fieldDef.setFieldType("DATE");
		fieldDef.setValueSource("AUTO_GENERATE");
		fieldDef.setValueSourceDef("");
		fieldDef.setValueType("DATE");
		fieldDef.setLvOrder(index);
		fieldDef.setShowWidth(160);
		fieldDef.setPvDesc(pvJson.toString());
		fieldDefMapper.insert(fieldDef);
	}

	private void initId(CommonParams params, String bussCode, FieldGroupDef fieldGroup, Integer index,
			ObjectNode pvJson) throws JsonMappingException, JsonProcessingException {
		var fieldDef = getInitFiedl(params, bussCode, fieldGroup);
		fieldDef.setFieldKey("id");
		fieldDef.setFieldName("序号");
		fieldDef.setFieldNameEn("Nu");
		fieldDef.setFieldType("NUMBER");
		fieldDef.setValueSource("AUTO_GENERATE");
		fieldDef.setValueSourceDef("");
		fieldDef.setValueType("NUMBER");
		var width = (ObjectNode) pvJson.get("width");
		width.put("value", 0);
		fieldDef.setLvOrder(index);
		fieldDef.setShowWidth(55);
		fieldDef.setPvDesc(pvJson.toString());
		fieldDefMapper.insert(fieldDef);
	}

	private FieldDef getInitFiedl(CommonParams params, String bussCode, FieldGroupDef fieldGroup) {
		var fieldDef = new FieldDef();
		fieldDef.setPvCode(UUIDUtils.getUUID());
		fieldDef.setBussCode(bussCode);
		fieldDef.setCreatedTime(LocalDateTime.now());
		fieldDef.setCreatedUserId(params.getUserId());
		fieldDef.setDeletedFlag(TZeroConstants.NORMAL);
		fieldDef.setPvStatus(TZeroConstants.NORMAL);
		fieldDef.setTenantId(params.getTenantId());
		fieldDef.setUpdatedTime(LocalDateTime.now());
		fieldDef.setUpdatedUserId(params.getUserId());
		fieldDef.setAutoGenerate(TZeroConstants.ABNORMAL);
		fieldDef.setFieldRequire(TZeroConstants.NORMAL);
		fieldDef.setGroupCode(fieldGroup.getPvCode());
		fieldDef.setFieldSource("System");
		return fieldDef;
	}

	private FieldGroupDef initGroup(CommonParams params, String bussCode) {
		var fieldGroup = new FieldGroupDef();
		fieldGroup.setPvCode(UUIDUtils.getUUID());
		fieldGroup.setBussCode(bussCode);
		fieldGroup.setCreatedTime(LocalDateTime.now());
		fieldGroup.setCreatedUserId(params.getUserId());
		fieldGroup.setDeletedFlag(TZeroConstants.NORMAL);
		fieldGroup.setFieldGroupName("");
		fieldGroup.setLvOrder(0);
		fieldGroup.setGroupSource("System");
		fieldGroup.setPvDesc(mapper.createObjectNode().toString());
		fieldGroup.setPvStatus(TZeroConstants.NORMAL);
		fieldGroup.setTenantId(params.getTenantId());
		fieldGroup.setUpdatedTime(LocalDateTime.now());
		fieldGroup.setUpdatedUserId(params.getUserId());
		fieldGroupDefMapper.insert(fieldGroup);
		return fieldGroup;
	}

	private FieldGroupDef initGroup(CommonParams params, String bussCode, String group) {
		var fieldGroup = new FieldGroupDef();
		fieldGroup.setPvCode(UUIDUtils.getUUID());
		fieldGroup.setBussCode(bussCode);
		fieldGroup.setCreatedTime(LocalDateTime.now());
		fieldGroup.setCreatedUserId(params.getUserId());
		fieldGroup.setDeletedFlag(TZeroConstants.NORMAL);
		fieldGroup.setFieldGroupName(group.split(":")[1]);
		fieldGroup.setLvOrder(Integer.valueOf(group.split(":")[0]));
		fieldGroup.setGroupSource("System");
		fieldGroup.setPvDesc(mapper.createObjectNode().toString());
		fieldGroup.setPvStatus(TZeroConstants.NORMAL);
		fieldGroup.setTenantId(params.getTenantId());
		fieldGroup.setUpdatedTime(LocalDateTime.now());
		fieldGroup.setUpdatedUserId(params.getUserId());
		fieldGroupDefMapper.insert(fieldGroup);
		return fieldGroup;
	}

	private void clearFields(String bussCode) {
		var fieldDefExample = new FieldDefExample();
		fieldDefExample.createCriteria().andBussCodeEqualTo(bussCode);
		var allfields = fieldDefMapper.selectByExample(fieldDefExample);
		fieldDefMapper.deleteByExample(fieldDefExample);
		var fieldGroupDefExample = new FieldGroupDefExample();
		fieldGroupDefExample.createCriteria().andBussCodeEqualTo(bussCode);
		fieldGroupDefMapper.deleteByExample(fieldGroupDefExample);
		var fictionariesDefExample = new DictionariesDefExample();

		var dictPvCodes = allfields.stream().map(i -> i.getValueSourceDef()).filter(i -> StringUtils.isNotBlank(i))
				.collect(Collectors.toList());

		if (CollectionUtils.isNotEmpty(dictPvCodes)) {
			fictionariesDefExample.createCriteria().andPvCodeIn(dictPvCodes);
			dictionariesDefMapper.deleteByExample(fictionariesDefExample);
		}
	}

}
