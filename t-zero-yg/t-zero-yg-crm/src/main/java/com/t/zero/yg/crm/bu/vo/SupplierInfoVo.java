package com.t.zero.yg.crm.bu.vo;

import com.fasterxml.jackson.databind.JsonNode;
import com.t.zero.yg.crm.bu.model.auto.SupplierInfo;
import com.t.zero.yg.crm.bu.vo.base.BuBaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class SupplierInfoVo extends SupplierInfo implements BuBaseModel {
	private static final long serialVersionUID = -6722313365786975923L;
	private JsonNode pvJson;

	@Override
	public String getPvDesc() {
		return null;
	}
}