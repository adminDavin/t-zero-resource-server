package com.t.zero.yg.crm.bu.vo;

import com.fasterxml.jackson.databind.JsonNode;
import com.t.zero.yg.crm.bu.model.auto.CorpContact;
import com.t.zero.yg.crm.bu.vo.base.BuBaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CorpContactVo extends CorpContact implements BuBaseModel {
	private static final long serialVersionUID = 2756869143488715298L;
	private JsonNode pvJson;

	@Override
	public String getPvDesc() {
		return null;
	}
}