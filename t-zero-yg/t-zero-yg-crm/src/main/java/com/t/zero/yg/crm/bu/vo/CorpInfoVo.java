package com.t.zero.yg.crm.bu.vo;

import com.fasterxml.jackson.databind.JsonNode;
import com.t.zero.yg.crm.bu.model.auto.CorpInfo;
import com.t.zero.yg.crm.bu.vo.base.BuBaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CorpInfoVo extends CorpInfo implements BuBaseModel {
	private static final long serialVersionUID = -6057710564303453602L;
	private JsonNode pvJson;

	@Override
	public String getPvDesc() {
		return null;
	}
}