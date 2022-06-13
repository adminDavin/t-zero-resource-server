package com.t.zero.yg.crm.module.buss.config.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.yg.crm.bu.service.config.CustomerDefBussService;
import com.t.zero.yg.crm.bu.service.config.FieldDefService;
import com.t.zero.yg.crm.bu.vo.config.CustomerDefBussVo;
import com.t.zero.yg.crm.module.buss.config.vo.FieldColumnVo;

@Service
public class CustomDefService {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private FieldDefService fieldDefService;

	@Autowired
	public CustomerDefBussService customerDefBussService;
	private static List<String> defaultHindFieldKeys = List.of("pvCode", "createdTime", "updatedTime", "createdUsername", "updatedUsername");
	private static List<String> defaultIgonreFieldKeys = List.of("IMAGE_FILE", "OTHER_FILE");

	public ObjectNode updateCustomDefBuss(CommonParams params, ObjectNode content) {
		var cBuss = mapper.convertValue(content, CustomerDefBussVo.class);
		cBuss.setTenantId(params.getTenantId());
		cBuss.setUserId(params.getUserId());
		var oldPvJson = Arrays.asList(mapper.convertValue(cBuss.getPvJson(), FieldColumnVo[].class));
		var i = 0;
		for (var j : oldPvJson) {
			i++;
			j.setLvOrder(i);
		}
		var tempCBuss = customerDefBussService.getByUserAndBussCode(params.getTenantId(), params.getUserId(), cBuss.getBussCode());
		tempCBuss.setPvJson(mapper.convertValue(oldPvJson, ArrayNode.class));
		tempCBuss.setBussCode(cBuss.getBussCode());
		tempCBuss.setUserId(params.getUserId());
		tempCBuss.setPvStatus(TZeroConstants.NORMAL);
		customerDefBussService.insert(params, tempCBuss);
		return getCustomDefBuss(params, cBuss.getBussCode());
	}

	public ObjectNode getCustomDefBuss(CommonParams params, String bussCode) {
		var fields = fieldDefService.getByBussCode(params, bussCode);
		var cFields = fields.stream().filter(i -> !defaultIgonreFieldKeys.contains(i.getFieldType())).map(i -> FieldColumnVo.init(i, defaultHindFieldKeys)).collect(Collectors.toList());
		
		var cBuss = customerDefBussService.getByUserAndBussCode(params.getTenantId(), params.getUserId(), bussCode);
		cBuss = customerDefBussService.clearUnused(cBuss);
		if (StringUtils.isNotBlank(cBuss.getPvCode())) {
			var oldPvJson = Arrays.asList(mapper.convertValue(cBuss.getPvJson(), FieldColumnVo[].class));
			var oldCFields = oldPvJson.stream().collect(Collectors.toMap(i -> i.getFieldKey(), i -> i));
			for (var i : cFields) {
				if (oldCFields.containsKey(i.getFieldKey())) {
					var f = oldCFields.get(i.getFieldKey());
					i.setFieldShow(f.getFieldShow());
					i.setLvOrder(f.getLvOrder());
				}
			}
			cBuss.setPvJson(mapper.convertValue(
					cFields.stream().sorted(Comparator.comparing(FieldColumnVo::getLvOrder)), ArrayNode.class));
		} else {
			cBuss.setBussCode(bussCode);
			cBuss.setUserId(params.getUserId());
			cBuss.setTenantId(params.getTenantId());
			cBuss.setPvJson(mapper.convertValue(cFields, ArrayNode.class));
		}
		return mapper.convertValue(cBuss, ObjectNode.class);
	}

}
