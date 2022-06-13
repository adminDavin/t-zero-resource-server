package com.t.zero.yg.crm.bu.dao.auto;

import com.t.zero.yg.crm.bu.model.auto.CustomerInfo;
import com.t.zero.yg.crm.bu.model.auto.CustomerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    long countByExample(CustomerInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int deleteByExample(CustomerInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int insert(CustomerInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int insertSelective(CustomerInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    List<CustomerInfo> selectByExampleWithBLOBs(CustomerInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    List<CustomerInfo> selectByExample(CustomerInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    CustomerInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int updateByExampleSelective(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int updateByExample(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int updateByPrimaryKeySelective(CustomerInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(CustomerInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    int updateByPrimaryKey(CustomerInfo record);
}