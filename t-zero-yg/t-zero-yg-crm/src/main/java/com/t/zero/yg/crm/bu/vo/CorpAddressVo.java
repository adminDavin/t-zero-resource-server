package com.t.zero.yg.crm.bu.vo;

import com.fasterxml.jackson.databind.JsonNode;
import com.t.zero.yg.crm.bu.model.auto.CorpAddress;
import com.t.zero.yg.crm.bu.vo.base.BuBaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CorpAddressVo extends CorpAddress implements BuBaseModel {

	private static final long serialVersionUID = 822674007572454824L;
	private JsonNode pvJson;

	@Override
	public String getPvDesc() {
		return null;
	}

}