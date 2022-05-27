package com.t.zero.yg.crm.bu.dao.auto;

import com.t.zero.yg.crm.bu.model.auto.CorpAccount;
import com.t.zero.yg.crm.bu.model.auto.CorpAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CorpAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    long countByExample(CorpAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int deleteByExample(CorpAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int insert(CorpAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int insertSelective(CorpAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    List<CorpAccount> selectByExampleWithBLOBs(CorpAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    List<CorpAccount> selectByExample(CorpAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    CorpAccount selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int updateByExampleSelective(@Param("record") CorpAccount record, @Param("example") CorpAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") CorpAccount record, @Param("example") CorpAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int updateByExample(@Param("record") CorpAccount record, @Param("example") CorpAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int updateByPrimaryKeySelective(CorpAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(CorpAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_corp_account
     *
     * @mbg.generated Fri May 27 14:14:07 CST 2022
     */
    int updateByPrimaryKey(CorpAccount record);
}