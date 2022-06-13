package com.t.zero.yg.crm.bu.dao.manual;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.t.zero.yg.crm.bu.model.auto.SupplierInfo;

public interface ManualSupplierInfoMapper {
	public List<SupplierInfo> listCorps(@Param("conditions") String c, @Param("sorted") String s, @Param("cPage") int i, @Param("pSize") int j);
	
	public List<SupplierInfo> listSimpleCorps(@Param("conditions") String c, @Param("sorted") String s);

	public Integer countCorps(@Param("conditions") String c, @Param("sorted") String s);
}
