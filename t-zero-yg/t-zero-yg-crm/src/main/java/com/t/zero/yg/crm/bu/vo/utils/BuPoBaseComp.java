package com.t.zero.yg.crm.bu.vo.utils;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;
import com.t.zero.yg.crm.bu.vo.base.BuBaseModel;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class BuPoBaseComp<T extends BuBaseModel> {

	@Autowired
	private ObjectMapper mapper;

	public T init(T i, CommonParams p, String uuid) {
		var operateTime = LocalDateTime.now();
		i.setPvCode(uuid);
		i.setCreatedTime(operateTime);
		i.setCreatedUserId(p.getUserId());
		i.setUpdatedTime(operateTime);
		i.setUpdatedUserId(p.getUserId());
		i.setTenantId(p.getTenantId());
		i.setDeletedFlag(TZeroConstants.NORMAL);
		return i;
	}

	public T init(T i, CommonParams p) {
		i.setPvCode(UUIDUtils.getUUID());
		return init(i, p, UUIDUtils.getUUID());
	}

	public T modify(T i, CommonParams p) {
		var operateTime = LocalDateTime.now();
		i.setCreatedTime(null);
		i.setUpdatedUserId(null);
		i.setUpdatedTime(operateTime);
		i.setUpdatedUserId(p.getUserId());
		i.setTenantId(null);
		i.setPvCode(null);
		return i;
	}

	public JsonNode toJson(String pvDesc) {
		try {
			return StringUtils.isBlank(pvDesc) ? mapper.createObjectNode() : mapper.readTree(pvDesc);
		} catch (JsonProcessingException e) {
			log.warn("convert json failed", e);
			return mapper.createObjectNode();
		}
	}

	public void clear(T j) {
		j.setTenantId(null);
		j.setDeletedFlag(null);
		j.setCreatedTime(null);
		j.setCreatedUserId(null);
		j.setUpdatedTime(null);
		j.setUpdatedUserId(null);

	}
}
