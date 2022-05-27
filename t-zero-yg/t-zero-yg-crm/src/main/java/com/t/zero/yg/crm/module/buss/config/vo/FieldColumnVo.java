package com.t.zero.yg.crm.module.buss.config.vo;

import com.t.zero.yg.crm.bu.vo.config.FieldDefVo;

import lombok.Data;

@Data
public class FieldColumnVo {

	private String fieldKey;
	private String fieldName;
	private String fieldNameEn;
	private String fieldType;
	private String valueType;
	private Boolean fieldShow;
	private Integer lvOrder;

	public static FieldColumnVo init(FieldDefVo i) {
		var a = new FieldColumnVo();
		a.fieldKey = i.getFieldKey();
		a.fieldName = i.getFieldName();
		a.fieldNameEn = i.getFieldNameEn();
		a.fieldType = i.getFieldType();
		a.valueType = i.getValueType();
		a.fieldShow = Boolean.TRUE;
		a.lvOrder = i.getLvOrder();
		return a;
	}

}
