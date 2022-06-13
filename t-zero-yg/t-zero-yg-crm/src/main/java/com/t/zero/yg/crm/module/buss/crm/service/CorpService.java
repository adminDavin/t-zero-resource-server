package com.t.zero.yg.crm.module.buss.crm.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.page.Page;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.yg.crm.bu.model.auto.CorpInfo;
import com.t.zero.yg.crm.bu.service.CorpAccountService;
import com.t.zero.yg.crm.bu.service.CorpAddressService;
import com.t.zero.yg.crm.bu.service.CorpContactService;
import com.t.zero.yg.crm.bu.service.CorpInfoService;
import com.t.zero.yg.crm.bu.service.CustomerInfoService;
import com.t.zero.yg.crm.bu.service.FacilitatorInfoService;
import com.t.zero.yg.crm.bu.service.SupplierInfoService;
import com.t.zero.yg.crm.bu.vo.CorpAccountVo;
import com.t.zero.yg.crm.bu.vo.CorpAddressVo;
import com.t.zero.yg.crm.bu.vo.CorpContactVo;
import com.t.zero.yg.crm.bu.vo.CorpInfoVo;
import com.t.zero.yg.crm.module.components.SqlCreatorComponent;

/**
 * 企业信息
 * 
 * @author davinzhang
 *
 */
@Service
public class CorpService {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private CorpInfoService corpInfoService;

	@Autowired
	private CorpAccountService corpAccountService;

	@Autowired
	private CorpAddressService corpAddressService;

	@Autowired
	private CorpContactService corpContactService;

	@Autowired
	private SqlCreatorComponent sqlCreatorComponent;

	@Autowired
	private CustomerInfoService customerInfoService;

	@Autowired
	private FacilitatorInfoService facilitatorInfoService;

	@Autowired
	private SupplierInfoService supplierInfoService;

	public ObjectNode insertCorp(CommonParams params, ObjectNode content, String customerName) {
		var tCorpInfo = mapper.convertValue(content.get("corpInfo"), CorpInfoVo.class);
		tCorpInfo.setCorpBrief(customerName);
		return insertCorp(params, tCorpInfo, content);
	}
	
	public ObjectNode insertCorp(CommonParams params, JsonNode content) {
		var tCorpInfo = mapper.convertValue(content.get("corpInfo"), CorpInfoVo.class);
		return insertCorp(params, tCorpInfo, content);
	}

	/**
	 * 插入或者更新通讯录
	 * 
	 * @param params
	 * @param content
	 * @return
	 */
	public ObjectNode insertCorp(CommonParams params, CorpInfoVo tCorpInfo, JsonNode content) {
		var tempCorp = corpInfoService.getByCorpBrief(tCorpInfo.getCorpBrief());
		if (!ObjectUtils.isEmpty(tempCorp) && StringUtils.isBlank(tCorpInfo.getPvCode())) {
			throw new RuntimeException("企业已存在, 不可以重复添加");
		}
		var corpInfo = corpInfoService.insert(params, tCorpInfo);
		if (content.has("corpAccountBases")) {
			var tempAccounts = mapper.convertValue(content.get("corpAccountBases"), CorpAccountVo[].class);
			for (var tempAccount : tempAccounts) {
				tempAccount.setCorpCode(corpInfo.getPvCode());
				tempAccount.setCorpId(corpInfo.getId());
				tempAccount.setAccountType("baseAccount");
				corpAccountService.insert(params, tempAccount);
			}
		}
		
		if (content.has("corpAccountOuters")) {
			var tempAccounts = mapper.convertValue(content.get("corpAccountOuters"), CorpAccountVo[].class);
			for (var tempAccount : tempAccounts) {
				tempAccount.setCorpCode(corpInfo.getPvCode());
				tempAccount.setCorpId(corpInfo.getId());
				tempAccount.setAccountType("outerAccount");
				corpAccountService.insert(params, tempAccount);
			}
		}

		if (content.has("corpAddresses")) {
			var tempAddresses = Arrays.asList(mapper.convertValue(content.get("corpAddresses"), CorpAddressVo[].class));
			for (var tempAddresse : tempAddresses) {
				tempAddresse.setCorpCode(corpInfo.getPvCode());
				tempAddresse.setCorpId(corpInfo.getId());
				corpAddressService.insert(params, tempAddresse);
			}
		}

		if (content.has("corpContacts")) {
			var tempAddresses = Arrays.asList(mapper.convertValue(content.get("corpContacts"), CorpContactVo[].class));
			for (var tempAddresse : tempAddresses) {
				tempAddresse.setCorpCode(corpInfo.getPvCode());
				tempAddresse.setCorpId(corpInfo.getId());
				corpContactService.insert(params, tempAddresse);
			}
		}
		return getCorp(params, corpInfo.getId());
	}

	/**
	 * 获取通讯录根据通讯录ID
	 * 
	 * @param params
	 * @param corpId
	 * @return
	 */
	public ObjectNode getCorp(CommonParams params, Integer corpId) {
		var r = mapper.createObjectNode();
		var corpInfo = corpInfoService.getById(corpId);
		r.set("corpInfo", mapper.convertValue(corpInfo, ObjectNode.class));
		var corpAccount = corpAccountService.getByCorpCode(corpInfo.getPvCode());
		for (var i : corpAccount) {
			i.setCorpCode(null);
			i.setCorpId(null);
			i.setTenantId(null);
			i.setDeletedFlag(null);
		}
		var corpAccountMap = corpAccount.stream().collect(Collectors.groupingBy(CorpAccountVo::getAccountType));
		r.set("corpAccountOuters", mapper.convertValue(corpAccountMap.getOrDefault("outerAccount", List.of()), ArrayNode.class));
		r.set("corpAccountBases", mapper.convertValue(corpAccountMap.getOrDefault("baseAccount", List.of()), ArrayNode.class));
		var corpAddresses = corpAddressService.getByCorpCode(corpInfo.getPvCode());
		for (var i : corpAddresses) {
			i.setCorpCode(null);
			i.setCorpId(null);
			i.setTenantId(null);
			i.setDeletedFlag(null);
		}
		r.set("corpAddresses", mapper.convertValue(corpAddresses, ArrayNode.class));
		var corpContacts = corpContactService.getByCorpCode(corpInfo.getPvCode());
		for (var i : corpContacts) {
			i.setCorpCode(null);
			i.setCorpId(null);
			i.setTenantId(null);
			i.setDeletedFlag(null);
		}
		r.set("corpContacts", mapper.convertValue(corpContacts, ArrayNode.class));
		r.put("isCustomer", customerInfoService.isCustomer(params, corpId));
		r.put("isFacilitator", facilitatorInfoService.isFacilitator(params, corpId));
		r.put("isSupplier", supplierInfoService.isSupplier(params, corpId));
		return r;
	}

	/**
	 * 删除通讯录
	 * 
	 * @param params
	 * @param corpId
	 * @return
	 */
	public Object deleteCorp(CommonParams params, ObjectNode content) {
		var ids = Arrays.asList(mapper.convertValue(content.get("ids"), Integer[].class));
		for (var id : ids) {
			var corpInfo = new CorpInfoVo();
			corpInfo.setId(id);
			corpInfo = corpInfoService.delete(params, corpInfo);
			corpAccountService.deleteByCorpId(params, id);
			corpAddressService.deleteByCorpId(params, id);
			corpContactService.deleteByCorpId(params, id);
			facilitatorInfoService.deleteByCorpId(params, id);
			customerInfoService.deleteByCorpId(params, id);
			supplierInfoService.deleteByCorpId(params, id);
		}
		return ids.size();
	}

	/**
	 * 获取全部企业 缩减版
	 * 
	 * @param params
	 * @param content
	 * @return
	 */
	public List<CorpInfo> getSimpleCorps(CommonParams params, JsonNode content) {
		var c = sqlCreatorComponent.getConditions(content);
		c = c + "and tenant_id=" + params.getTenantId();
		var sorted = sqlCreatorComponent.getSorted(content);
		return corpInfoService.listSimpleCorps(c, sorted);
	}

	/**
	 * 获取全部企业 分页版
	 * 
	 * @param params
	 * @param content
	 * @return
	 */
	public Page<CorpInfoVo> getCorps(CommonParams params, JsonNode content) {
		var curentPage = content.has("currentPage") ? content.get("currentPage").asInt() : 1;
		var pageSize = content.has("pageSize") ? content.get("pageSize").asInt() : 30;
		Page<CorpInfoVo> page = new Page<>(curentPage, pageSize);
		var c = sqlCreatorComponent.getConditions(content);
		c = c + "and tenant_id=" + params.getTenantId();
		var sorted = sqlCreatorComponent.getSorted(content);
		return corpInfoService.listCorps(c, sorted, page);
	}

}
