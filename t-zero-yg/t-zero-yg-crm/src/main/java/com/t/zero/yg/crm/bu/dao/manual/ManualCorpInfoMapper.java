package com.t.zero.yg.crm.bu.dao.manual;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.t.zero.yg.crm.bu.model.auto.CorpInfo;

public interface ManualCorpInfoMapper {
	public List<CorpInfo> listCorps(@Param("conditions") String c, @Param("sorted") String s, @Param("cPage") int i, @Param("pSize") int j);
	
	public List<CorpInfo> listSimpleCorps(@Param("conditions") String c, @Param("sorted") String s);

	public Integer countCorps(@Param("conditions") String c, @Param("sorted") String s);
}
