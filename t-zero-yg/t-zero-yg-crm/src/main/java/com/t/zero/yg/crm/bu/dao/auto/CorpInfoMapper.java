package com.t.zero.yg.crm.bu.dao.auto;

import com.t.zero.yg.crm.bu.model.auto.CorpInfo;
import com.t.zero.yg.crm.bu.model.auto.CorpInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CorpInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    long countByExample(CorpInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int deleteByExample(CorpInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int insert(CorpInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int insertSelective(CorpInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    List<CorpInfo> selectByExampleWithBLOBs(CorpInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    List<CorpInfo> selectByExample(CorpInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    CorpInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int updateByExampleSelective(@Param("record") CorpInfo record, @Param("example") CorpInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") CorpInfo record, @Param("example") CorpInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int updateByExample(@Param("record") CorpInfo record, @Param("example") CorpInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int updateByPrimaryKeySelective(CorpInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(CorpInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int updateByPrimaryKey(CorpInfo record);
}