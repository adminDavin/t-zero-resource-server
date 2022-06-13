package com.t.zero.yg.crm.module.buss.crm.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.page.Page;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.yg.crm.bu.service.CustomerInfoService;
import com.t.zero.yg.crm.bu.vo.CorpInfoVo;
import com.t.zero.yg.crm.bu.vo.CustomerInfoVo;
import com.t.zero.yg.crm.module.components.SqlCreatorComponent;

/**
 * 客户信息
 * 
 * @author davinzhang
 *
 */
@Service
public class CustomerService {
	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private SqlCreatorComponent sqlCreatorComponent;

	@Autowired
	private CustomerInfoService customerInfoService;

	@Autowired
	private CorpService corpService;

	public Object list(CommonParams params, ObjectNode content) {
		var curentPage = content.has("currentPage") ? content.get("currentPage").asInt() : 1;
		var pageSize = content.has("pageSize") ? content.get("pageSize").asInt() : 30;
		Page<CustomerInfoVo> page = new Page<>(curentPage, pageSize);
		var c = sqlCreatorComponent.getConditions(content);
		c = c + "and tenant_id=" + params.getTenantId();
		var sorted = sqlCreatorComponent.getSorted(content);
		return customerInfoService.listCorps(c, sorted, page);
	}

	public Object getSimpleList(CommonParams params, ObjectNode content) {
		var c = sqlCreatorComponent.getConditions(content);
		c = c + "and tenant_id=" + params.getTenantId();
		var sorted = sqlCreatorComponent.getSorted(content);
		return customerInfoService.listSimpleCorps(c, sorted);
	}

	public Object insert(CommonParams params, ObjectNode content) {
		var customerInfo = mapper.convertValue(content.get("customerInfo"), CustomerInfoVo.class);
		var corp = corpService.insertCorp(params, content, customerInfo.getCustomerName());
		var corpInfo = mapper.convertValue(corp.get("corpInfo"), CorpInfoVo.class);
		customerInfo.setCorpCode(corpInfo.getPvCode());
		customerInfo.setCorpId(corpInfo.getId());
		customerInfo.setCustomerName(corpInfo.getCorpBrief());
		customerInfo = customerInfoService.insert(params, customerInfo);
		corp.set("customerInfo", mapper.convertValue(customerInfo, ObjectNode.class));
		return corp;
	}

	public Object delete(CommonParams params, ObjectNode content) {
		var corpInfo = new CustomerInfoVo();
		var ids = Arrays.asList(mapper.convertValue(content.get("ids"), Integer[].class));
		for (var id : ids) {
			corpInfo.setId(id);
			customerInfoService.delete(params, corpInfo);
		}
		return ids.size();
	}

	public Object get(CommonParams build, Integer id) {
		var item = customerInfoService.getById(id);
		var corp = corpService.getCorp(build, item.getCorpId());
		corp.set("customerInfo", mapper.convertValue(item, ObjectNode.class));
		return corp;
	}
}