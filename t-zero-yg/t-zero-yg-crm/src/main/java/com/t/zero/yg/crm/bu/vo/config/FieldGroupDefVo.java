package com.t.zero.yg.crm.bu.vo.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.t.zero.yg.crm.bu.model.auto.FieldGroupDef;
import com.t.zero.yg.crm.bu.vo.base.BuBaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class FieldGroupDefVo extends FieldGroupDef implements BuBaseModel {

	private static final long serialVersionUID = 841500360353730633L;

	private JsonNode pvJson;

	@Override
	public String getPvDesc() {
		return null;
	}

}
