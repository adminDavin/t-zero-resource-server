package com.t.zero.yg.crm.bu.dao.auto;

import com.t.zero.yg.crm.bu.model.auto.BussDef;
import com.t.zero.yg.crm.bu.model.auto.BussDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BussDefMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    long countByExample(BussDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int deleteByExample(BussDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int insert(BussDef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int insertSelective(BussDef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    List<BussDef> selectByExampleWithBLOBs(BussDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    List<BussDef> selectByExample(BussDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    BussDef selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int updateByExampleSelective(@Param("record") BussDef record, @Param("example") BussDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") BussDef record, @Param("example") BussDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int updateByExample(@Param("record") BussDef record, @Param("example") BussDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int updateByPrimaryKeySelective(BussDef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(BussDef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int updateByPrimaryKey(BussDef record);
}