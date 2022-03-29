package com.t.zero.common.base.Enum;

/**
 * @author shihao
 * @Title: ModelNameEnum
 * @ProjectName com.t.zero.common.base.Enum
 * @Description: 模块的名称 key
 * @date Created in 2021/7/3 18:37
 * @Version: 1$
 */
public enum ModelNameEnum {
    //todo 小柱网模块key
    /**
     * 模块1
     */
    SMALLCOLUMNGRIDMODEL_MODEL1("SmallColumnGridModel_model1"),
    /**
     * 模块2
     */
    SMALLCOLUMNGRIDMODEL_MODEL2("SmallColumnGridModel_model2"),
    /**
     * 模块3
     */
    SMALLCOLUMNGRIDMODEL_MODEL3("SmallColumnGridModel_model3"),
    /**
     * 模块4
     */
    SMALLCOLUMNGRIDMODEL_MODEL4("SmallColumnGridModel_model4"),
    //todo 大柱网
    /**
     * 模块1
     */
    BIGCOLUMNGRIDMODEL_MODEL1("BigColumnGridModel_model1"),
    /**
     * 模块2
     */
    BIGCOLUMNGRIDMODEL_MODEL2("BigColumnGridModel_model2"),
    /**
     * 模块3
     */
    BIGCOLUMNGRIDMODEL_MODEL3("BigColumnGridModel_model3"),
    /**
     * 模块4
     */
    BIGCOLUMNGRIDMODEL_MODEL4("BigColumnGridModel_model4"),
    /**
     * 模块5
     */
    BIGCOLUMNGRIDMODEL_MODEL5("BigColumnGridModel_model5"),
    /**
     * 模块6
     */
    BIGCOLUMNGRIDMODEL_MODEL6("BigColumnGridModel_model6"),
    /**
     * 模块7
     */
    BIGCOLUMNGRIDMODEL_MODEL7("BigColumnGridModel_model7"),
    /**
     * 模块8
     */
    BIGCOLUMNGRIDMODEL_MODEL8("BigColumnGridModel_model8"),
    /**
     * 模块9
     */
    BIGCOLUMNGRIDMODEL_MODEL9("BigColumnGridModel_model9"),
    /**
     * 模块10
     */
    BIGCOLUMNGRIDMODEL_MODEL10("BigColumnGridModel_model10"),
    /**
     * 模块11
     */
    BIGCOLUMNGRIDMODEL_MODEL11("BigColumnGridModel_model11"),
    //todo 大小柱网
    /**
     * 模块1
     */
    BIGSMALLCOLUMNGRIDMODEL_MODEL1("BigSmallColumnGridModel_model1"),
    /**
     * 模块2
     */
    BIGSMALLCOLUMNGRIDMODEL_MODEL2("BigSmallColumnGridModel_model2"),
    /**
     * 模块3
     */
    BIGSMALLCOLUMNGRIDMODEL_MODEL3("BigSmallColumnGridModel_model3"),
    /**
     * 模块4
     */
    BIGSMALLCOLUMNGRIDMODEL_MODEL4("BigSmallColumnGridModel_model4"),
    /**
     * 模块5
     */
    BIGSMALLCOLUMNGRIDMODEL_MODEL5("BigSmallColumnGridModel_model5"),
    /**
     * 模块6
     */
    BIGSMALLCOLUMNGRIDMODEL_MODEL6("BigSmallColumnGridModel_model6"),
    /**
     * 模块7
     */
    BIGSMALLCOLUMNGRIDMODEL_MODEL7("BigSmallColumnGridModel_model7"),
    /**
     * 模块8
     */
    BIGSMALLCOLUMNGRIDMODEL_MODEL8("BigSmallColumnGridModel_model8"),
    /**
     * 模块9
     */
    BIGSMALLCOLUMNGRIDMODEL_MODEL9("BigSmallColumnGridModel_model9"),
    /**
     * 模块10
     */
    BIGSMALLCOLUMNGRIDMODEL_MODEL10("BigSmallColumnGridModel_model10"),
    /**
     * 模块11
     */
    BIGSMALLCOLUMNGRIDMODEL_MODEL11("BigSmallColumnGridModel_model11");
    private String key;

    ModelNameEnum(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
