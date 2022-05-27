package com.t.zero.yg.crm.bu.vo;

import com.fasterxml.jackson.databind.JsonNode;
import com.t.zero.yg.crm.bu.model.auto.FacilitatorInfo;
import com.t.zero.yg.crm.bu.vo.base.BuBaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class FacilitatorInfoVo extends FacilitatorInfo implements BuBaseModel {
	private static final long serialVersionUID = -6317251433374929609L;
	private JsonNode pvJson;

	@Override
	public String getPvDesc() {
		return null;
	}
}