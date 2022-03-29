package com.t.zero.res.c.manager.bu.dao.manual;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.t.zero.res.c.manager.bu.model.auto.ResInfoDef;
import com.t.zero.res.c.manager.bu.vo.filters.ResInfoDefFilters;

/**
 * @author davinzhang
 * 
 * @date 2022/02/05
 * 
 * @desc TODO
 */

@Mapper
public interface ManualResInfoDefMapper {

    public List<ResInfoDef> selectListByPage(
        @Param("tenantId") Integer tenantId,
        @Param("userId") Integer userId,
        @Param("filters") ResInfoDefFilters filters,
        @Param("currentPage") int currentPage,
        @Param("pageSize") int pageSize);

    public Integer selectCount(@Param("tenantId") Integer tenantId, @Param("userId") Integer userId, @Param("filters") ResInfoDefFilters filters);

    public List<ResInfoDef> selectListNoTagByPage(
        @Param("tenantId") Integer tenantId,
        @Param("userId") Integer userId,
        @Param("filters") ResInfoDefFilters filters,
        @Param("currentPage") int currentPage,
        @Param("pageSize") int pageSize);

    public Integer selectNoTagCount(
        @Param("tenantId") Integer tenantId,
        @Param("userId") Integer userId,
        @Param("filters") ResInfoDefFilters filters);

}
