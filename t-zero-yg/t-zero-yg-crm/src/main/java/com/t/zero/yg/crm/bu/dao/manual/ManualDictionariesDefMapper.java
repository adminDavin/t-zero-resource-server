package com.t.zero.yg.crm.bu.dao.manual;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.t.zero.yg.crm.bu.model.auto.DictionariesDef;

public interface ManualDictionariesDefMapper {

	public List<DictionariesDef> listDictionariesDef(@Param("conditions") String c, @Param("sorted") String s,
			@Param("cPage") int i, @Param("pSize") int j);

	public List<DictionariesDef> listSimpleDictionariesDef(@Param("conditions") String c, @Param("sorted") String s);

	public Integer countDictionariesDef(@Param("conditions") String c, @Param("sorted") String s);
}
