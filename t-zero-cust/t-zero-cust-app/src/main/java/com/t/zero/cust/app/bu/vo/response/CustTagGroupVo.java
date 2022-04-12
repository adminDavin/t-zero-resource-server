package com.t.zero.cust.app.bu.vo.response;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.t.zero.cust.app.bu.model.auto.CustTagGroup;
import com.t.zero.cust.app.bu.model.auto.CustTagInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class CustTagGroupVo extends CustTagGroup {
	
	private static final long serialVersionUID = 5619634554036930064L;
	List<CustTagInfo> custTagInfos;
	
	public static CustTagGroupVo build(CustTagGroup item, List<CustTagInfo> custTagInfos) {
		var t = new CustTagGroupVo();
		BeanUtils.copyProperties(item, t);
		t.setCustTagInfos(custTagInfos);
		return t;
	}

}
