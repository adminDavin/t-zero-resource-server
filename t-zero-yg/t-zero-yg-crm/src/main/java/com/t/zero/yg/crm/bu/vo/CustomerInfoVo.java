package com.t.zero.yg.crm.bu.vo;

import com.fasterxml.jackson.databind.JsonNode;
import com.t.zero.yg.crm.bu.model.auto.CustomerInfo;
import com.t.zero.yg.crm.bu.vo.base.BuBaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CustomerInfoVo extends  CustomerInfo implements BuBaseModel  {
	private static final long serialVersionUID = -1964879765975761419L;
	private JsonNode pvJson;

	@Override
	public String getPvDesc() {
		return null;
	}
}