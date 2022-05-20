package com.t.zero.res.c.manager.bu.dao.auto;

import com.t.zero.res.c.manager.bu.model.auto.ResAuthRel;
import com.t.zero.res.c.manager.bu.model.auto.ResAuthRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResAuthRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    long countByExample(ResAuthRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    int deleteByExample(ResAuthRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    int insert(ResAuthRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    int insertSelective(ResAuthRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    List<ResAuthRel> selectByExample(ResAuthRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    ResAuthRel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    int updateByExampleSelective(@Param("record") ResAuthRel record, @Param("example") ResAuthRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    int updateByExample(@Param("record") ResAuthRel record, @Param("example") ResAuthRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    int updateByPrimaryKeySelective(ResAuthRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_auth_rel
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    int updateByPrimaryKey(ResAuthRel record);
}