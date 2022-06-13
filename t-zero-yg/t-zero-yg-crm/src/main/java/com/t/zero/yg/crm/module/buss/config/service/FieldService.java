package com.t.zero.yg.crm.module.buss.config.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.yg.crm.bu.service.config.BussDefService;
import com.t.zero.yg.crm.bu.service.config.FieldDefService;
import com.t.zero.yg.crm.bu.service.config.FieldGroupDefService;
import com.t.zero.yg.crm.bu.vo.config.BussDefVo;
import com.t.zero.yg.crm.bu.vo.config.FieldDefVo;
import com.t.zero.yg.crm.bu.vo.config.FieldGroupDefVo;

/**
 * 企业信息
 * 
 * @author davinzhang
 *
 */
@Service
public class FieldService {

	@Autowired
	private ObjectMapper mapper;
	@Autowired
	BussDefService bussDefService;
	@Autowired
	private FieldGroupDefService fieldGroupDefService;
	@Autowired
	private FieldDefService fieldDefService;

	/**
	 * 插入或者更新字段配置
	 * 
	 * @param params
	 * @param content
	 * @return
	 */
	public ObjectNode insertFields(CommonParams params, JsonNode content) {
		BussDefVo bussDef = bussDefService.getByCode(content.get("pvCode").asText());
		var fieldGroups = Arrays.asList(mapper.convertValue(content.get("fieldGroups"), ObjectNode[].class));

		var existsGroupCode = fieldGroups.stream().filter(i -> i.has("pvCode")).map(i -> i.get("pvCode").asText())
				.collect(Collectors.toList());
		var oldGroups = fieldGroupDefService.getByBussCode(params, bussDef.getPvCode()).stream().map(i -> i.getPvCode())
				.collect(Collectors.toList());

		oldGroups = oldGroups.stream().filter(i -> !existsGroupCode.contains(i)).collect(Collectors.toList());
		fieldGroupDefService.deleteByPvCodes(oldGroups);
		fieldDefService.deleteByGroupCodes(params, oldGroups);
		var k = 1000;
		for (var j : fieldGroups) {
			k++;
			var i = mapper.convertValue(j, FieldGroupDefVo.class);
			i.setLvOrder(k);
			i.setBussCode(bussDef.getPvCode());
			FieldGroupDefVo group = fieldGroupDefService.insert(params, i);

			var oldFields = fieldDefService.getByGroupCode(params, group.getPvCode());
			if (j.has("fields")) {
				var fields = Arrays.asList(mapper.convertValue(j.get("fields"), FieldDefVo[].class));
				var existsFieldCode = fields.stream().filter(c -> StringUtils.isNotBlank(c.getPvCode()))
						.map(c -> c.getPvCode()).collect(Collectors.toList());
				oldFields = oldFields.stream().filter(c -> !existsFieldCode.contains(c.getPvCode()))
						.collect(Collectors.toList());
				var m = k * 10;
				for (var field : fields) {
					m++;
					field.setValueType(EntityService.arrayList.contains(field.getFieldType()) ? "ARRAY" : "TEXT");
					field.setBussCode(bussDef.getPvCode());
					field.setGroupCode(group.getPvCode());
					field.setLvOrder(m);
					fieldDefService.insert(params, field);
				}
			}
			fieldDefService.deleteByPvCodes(params, oldFields.stream().map(c -> c.getPvCode()).collect(Collectors.toList()));
		}
		return getByCode(params, bussDef.getPvCode());
	}

	/**
	 * 获取字段配置根据业务编码
	 * 
	 * @param params
	 * @param bussCode
	 * @return
	 */
	public ObjectNode getByCode(CommonParams params, String bussCode) {
		var groups = fieldGroupDefService.getByBussCode(params, bussCode).stream()
				.sorted(Comparator.comparing(FieldGroupDefVo::getLvOrder)).collect(Collectors.toList());

		var groupCodes = groups.stream().map(i -> i.getPvCode()).collect(Collectors.toList());
		if (CollectionUtils.isEmpty(groupCodes)) {
			BussDefVo bussDef = bussDefService.getByCode(bussCode);
			bussDef = bussDefService.clearUnused(bussDef);
			var r = mapper.convertValue(bussDef, ObjectNode.class);
			r.set("fieldGroups", mapper.createArrayNode());
			return r;
		}
		var fields = fieldDefService.getByGroupCodes(params, groupCodes);
		var fieldGroupMap = fields.stream().collect(Collectors.groupingBy(FieldDefVo::getGroupCode));
		var a = mapper.createArrayNode();
		for (var g : groups) {
			g = fieldGroupDefService.clearUnused(g);
			var i = mapper.convertValue(g, ObjectNode.class);
			var gFields = fieldGroupMap.get(g.getPvCode());
			if (CollectionUtils.isEmpty(gFields)) {
				i.set("fields", mapper.createArrayNode());
			} else {
				gFields = fieldDefService.clearUnused(gFields).stream()
						.sorted(Comparator.comparing(FieldDefVo::getLvOrder)).collect(Collectors.toList());
				i.set("fields", mapper.convertValue(gFields, ArrayNode.class));
			}
			a.add(i);
		}

		BussDefVo bussDef = bussDefService.getByCode(bussCode);
		bussDef = bussDefService.clearUnused(bussDef);
		var r = mapper.convertValue(bussDef, ObjectNode.class);
		r.set("fieldGroups", a);
		return r;
	}

	public ObjectNode getColumnsByCode(CommonParams params, String bussCode) {
		var fields = fieldDefService.getByBussCode(params, bussCode);
		fields = fields.stream().filter(i -> TZeroConstants.NORMAL.equals(i.getPvStatus()))
				.sorted(Comparator.comparing(FieldDefVo::getLvOrder)).collect(Collectors.toList());
		return null;
	}

	public Object getByFieldKey(CommonParams params, String bussCode, String fieldKey) {
		return fieldDefService.getByFieldKey(params, bussCode, fieldKey);
	}

	private static List<String> ignoreFields = List.of("id", "pvCode", "createdTime", "updatedTime", "createdUsername",
			"updatedUsername");

	public ObjectNode initInstanceData(CommonParams params, ObjectNode content) {
		var fields = fieldDefService.getByBussCode(params, content.get("bussCode").asText());
		var systemFields = Arrays.asList(mapper.convertValue(content.get("systemFields"), String[].class));
		var custumIgnoreFields = Arrays.asList(mapper.convertValue(content.get("custumIgnoreFields"), String[].class));
		var r = mapper.createObjectNode();
		var item = mapper.createObjectNode();
		for (var i : fields) {
			if (ignoreFields.contains(i.getFieldKey()) || custumIgnoreFields.contains(i.getFieldKey())) {
				continue;
			}
			JsonNode p = i.getPvJson();
			if (p.has("defualtValue") && p.get("defualtValue").has("value")) {
				var v = p.get("defualtValue").get("value").asText();
				if (systemFields.contains(i.getFieldKey())) {
					r.set(i.getFieldKey(), initFieldDefualtValue(i, v));
				} else {
					item.set(i.getFieldKey(), initFieldDefualtValue(i, v));
				}
			} else {
				if (systemFields.contains(i.getFieldKey())) {
					r.set(i.getFieldKey(), initFieldDefualtValue(i, StringUtils.EMPTY));
				} else {
					item.set(i.getFieldKey(), initFieldDefualtValue(i, StringUtils.EMPTY));
				}
			}
		}
		r.set("pvJson", item);
		return r;
	}

	public JsonNode initFieldDefualtValue(FieldDefVo field, String defaultValue) {
		if ("NUMBER".equals(field.getFieldType())) {
			return mapper.convertValue(StringUtils.isBlank(defaultValue) ? 0 : Integer.valueOf(defaultValue),
					JsonNode.class);
		} else if ("DATERANGE".equals(field.getFieldType())) {
			return mapper.convertValue(List.of(LocalDateTime.now(), LocalDateTime.now()), JsonNode.class);
		} else if ("DATE".equals(field.getFieldType())) {
			return mapper.convertValue(LocalDateTime.now(), JsonNode.class);
		} else if ("IMAGE_FILE".equals(field.getFieldType()) || "OTHER_FILE".equals(field.getFieldType())) {
			return mapper.convertValue(List.of(), JsonNode.class);
		}
		return mapper.convertValue(defaultValue, JsonNode.class);

	}
}
