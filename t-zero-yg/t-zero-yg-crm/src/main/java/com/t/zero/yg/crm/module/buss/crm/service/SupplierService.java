package com.t.zero.yg.crm.module.buss.crm.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.page.Page;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.yg.crm.bu.service.SupplierInfoService;
import com.t.zero.yg.crm.bu.vo.CorpInfoVo;
import com.t.zero.yg.crm.bu.vo.SupplierInfoVo;
import com.t.zero.yg.crm.module.components.SqlCreatorComponent;

/**
 * 供应商
 * 
 * @author davinzhang
 *
 */
@Service
public class SupplierService {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private SqlCreatorComponent sqlCreatorComponent;

	@Autowired
	private SupplierInfoService supplierInfoService;

	@Autowired
	private CorpService corpService;

	public Object list(CommonParams params, ObjectNode content) {
		var curentPage = content.has("currentPage") ? content.get("currentPage").asInt() : 1;
		var pageSize = content.has("pageSize") ? content.get("pageSize").asInt() : 30;
		Page<SupplierInfoVo> page = new Page<>(curentPage, pageSize);
		var c = sqlCreatorComponent.getConditions(content);
		c = c + "and tenant_id=" + params.getTenantId();
		var sorted = sqlCreatorComponent.getSorted(content);
		return supplierInfoService.listCorps(c, sorted, page);
	}

	public Object getSimpleList(CommonParams params, ObjectNode content) {
		var c = sqlCreatorComponent.getConditions(content);
		c = c + "and tenant_id=" + params.getTenantId();
		var sorted = sqlCreatorComponent.getSorted(content);
		return supplierInfoService.listSimpleCorps(c, sorted);
	}

	public Object insert(CommonParams params, ObjectNode content) {
		var customerInfo = mapper.convertValue(content.get("supplierInfo"), SupplierInfoVo.class);
		var corp = corpService.insertCorp(params, content, customerInfo.getSupplierName());
		var corpInfo = mapper.convertValue(corp.get("corpInfo"), CorpInfoVo.class);
		customerInfo.setCorpCode(corpInfo.getPvCode());
		customerInfo.setCorpId(corpInfo.getId());
		customerInfo.setSupplierName(corpInfo.getCorpBrief());
		customerInfo = supplierInfoService.insert(params, customerInfo);
		corp.set("supplierInfo", mapper.convertValue(customerInfo, ObjectNode.class));
		return corp;
	}

	public Object delete(CommonParams params, ObjectNode content) {
		var ids = Arrays.asList(mapper.convertValue(content.get("ids"), Integer[].class));
		for (var id : ids) {
			var corpInfo = new SupplierInfoVo();
			corpInfo.setId(id);
			 supplierInfoService.delete(params, corpInfo);
		}
		return ids.size();
	}

	public Object get(CommonParams build, Integer id) {
		var item = supplierInfoService.getById(id);
		var corp = corpService.getCorp(build, item.getCorpId());
		corp.set("supplierInfo", mapper.convertValue(item, ObjectNode.class));
		return corp;
	}


}