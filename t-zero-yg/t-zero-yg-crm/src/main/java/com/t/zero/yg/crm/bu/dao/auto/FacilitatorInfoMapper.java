package com.t.zero.yg.crm.bu.dao.auto;

import com.t.zero.yg.crm.bu.model.auto.FacilitatorInfo;
import com.t.zero.yg.crm.bu.model.auto.FacilitatorInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FacilitatorInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    long countByExample(FacilitatorInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int deleteByExample(FacilitatorInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int insert(FacilitatorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int insertSelective(FacilitatorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    List<FacilitatorInfo> selectByExampleWithBLOBs(FacilitatorInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    List<FacilitatorInfo> selectByExample(FacilitatorInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    FacilitatorInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int updateByExampleSelective(@Param("record") FacilitatorInfo record, @Param("example") FacilitatorInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") FacilitatorInfo record, @Param("example") FacilitatorInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int updateByExample(@Param("record") FacilitatorInfo record, @Param("example") FacilitatorInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int updateByPrimaryKeySelective(FacilitatorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(FacilitatorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_facilitator_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    int updateByPrimaryKey(FacilitatorInfo record);
}