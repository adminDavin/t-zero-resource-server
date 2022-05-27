package com.t.zero.yg.crm.bu.dao.auto;

import com.t.zero.yg.crm.bu.model.auto.FieldDef;
import com.t.zero.yg.crm.bu.model.auto.FieldDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FieldDefMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    long countByExample(FieldDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int deleteByExample(FieldDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int insert(FieldDef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int insertSelective(FieldDef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    List<FieldDef> selectByExampleWithBLOBs(FieldDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    List<FieldDef> selectByExample(FieldDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    FieldDef selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int updateByExampleSelective(@Param("record") FieldDef record, @Param("example") FieldDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") FieldDef record, @Param("example") FieldDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int updateByExample(@Param("record") FieldDef record, @Param("example") FieldDefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int updateByPrimaryKeySelective(FieldDef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(FieldDef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_field_def
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int updateByPrimaryKey(FieldDef record);
}