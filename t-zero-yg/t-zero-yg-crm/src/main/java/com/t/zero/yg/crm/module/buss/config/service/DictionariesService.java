package com.t.zero.yg.crm.module.buss.config.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.yg.crm.bu.service.config.DictionariesDefService;
import com.t.zero.yg.crm.bu.vo.config.DictionariesDefVo;

/**
 * 企业信息
 * 
 * @author davinzhang
 *
 */
@Service
public class DictionariesService {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private DictionariesDefService dictionariesDefService;

	/**
	 * 插入或者更新通讯录
	 * 
	 * @param params
	 * @param content
	 * @return
	 */
	public ObjectNode insert(CommonParams params, JsonNode content) {
		var dict = mapper.convertValue(content, DictionariesDefVo.class);
		dict = dictionariesDefService.insert(params, dict);
		return getCorp(params, dict.getPvCode());
	}

	/**
	 * 获取通讯录根据通讯录ID
	 * 
	 * @param params
	 * @param corpId
	 * @return
	 */
	public ObjectNode getCorp(CommonParams params, String pvCode) {
		return mapper.convertValue(dictionariesDefService.getByCode(pvCode), ObjectNode.class);
	}

	/**
	 * 删除通讯录
	 * 
	 * @param params
	 * @param corpId
	 * @return
	 */
	public ObjectNode deleteCorp(CommonParams params, String pvCode) {
		var r = dictionariesDefService.getByCode(pvCode);
		dictionariesDefService.delete(params, r);
		return mapper.createObjectNode();
	}

	public Object getByCodes(CommonParams params, ObjectNode content) {
		List<String> pvCodes = Arrays.asList(mapper.convertValue(content.get("pvCodes"), String[].class));
		return dictionariesDefService.getByCodes(pvCodes);
	}
}
