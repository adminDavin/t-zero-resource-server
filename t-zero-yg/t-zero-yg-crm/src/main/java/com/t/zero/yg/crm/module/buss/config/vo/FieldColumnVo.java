package com.t.zero.yg.crm.module.buss.config.vo;

import java.util.List;

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
	private Integer showWidth;
	
	
	public static FieldColumnVo init(FieldDefVo i, List<String> defaultHindFieldKeys) {
		var a = new FieldColumnVo();
		a.fieldKey = i.getFieldKey();
		a.fieldName = i.getFieldName();
		a.fieldNameEn = i.getFieldNameEn();
		a.fieldType = i.getFieldType();
		a.valueType = i.getValueType();
		a.fieldShow = !defaultHindFieldKeys.contains(i.getFieldKey());
		a.lvOrder = i.getLvOrder();
		a.showWidth = i.getShowWidth();
		return a;
	}

}
