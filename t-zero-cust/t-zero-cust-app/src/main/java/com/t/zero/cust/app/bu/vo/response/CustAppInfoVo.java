package com.t.zero.cust.app.bu.vo.response;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.t.zero.cust.app.bu.model.auto.CustAppInfo;
import com.t.zero.cust.app.bu.model.auto.CustTagGroup;
import com.t.zero.cust.app.bu.model.auto.CustTagInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class CustAppInfoVo extends CustAppInfo {
	
	private static final long serialVersionUID = 5619634554036930064L;
	List<CustTagInfo> custTagInfos;

	public static CustAppInfoVo build(CustAppInfo item, List<CustTagInfo> custTagInfos) {
		var t = new CustAppInfoVo();
		BeanUtils.copyProperties(item, t);
		t.setCustTagInfos(custTagInfos);
		return t;
	}
}
