package com.t.zero.yg.crm.bu.dao.manual;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.t.zero.yg.crm.bu.model.auto.CustomerInfo;

public interface ManualCustomerInfoMapper {
	public List<CustomerInfo> listCorps(@Param("conditions") String c, @Param("sorted") String s, @Param("cPage") int i, @Param("pSize") int j);
	
	public List<CustomerInfo> listSimpleCorps(@Param("conditions") String c, @Param("sorted") String s);

	public Integer countCorps(@Param("conditions") String c, @Param("sorted") String s);
}
