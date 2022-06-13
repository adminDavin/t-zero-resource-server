package com.t.zero.yg.crm.bu.model.auto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CustomerDefBuss implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_def_buss.id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_def_buss.tenant_id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private Integer tenantId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_def_buss.pv_code
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private String pvCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_def_buss.user_id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_def_buss.buss_code
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private String bussCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_def_buss.pv_status
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private String pvStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_def_buss.created_user_id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private String createdUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_def_buss.created_time
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private LocalDateTime createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_def_buss.updated_user_id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private String updatedUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_def_buss.updated_time
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private LocalDateTime updatedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_def_buss.is_deleted
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private String deletedFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_def_buss.pv_desc
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private String pvDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table yg_customer_def_buss
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_def_buss.id
     *
     * @return the value of yg_customer_def_buss.id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_def_buss.id
     *
     * @param id the value for yg_customer_def_buss.id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_def_buss.tenant_id
     *
     * @return the value of yg_customer_def_buss.tenant_id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public Integer getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_def_buss.tenant_id
     *
     * @param tenantId the value for yg_customer_def_buss.tenant_id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_def_buss.pv_code
     *
     * @return the value of yg_customer_def_buss.pv_code
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public String getPvCode() {
        return pvCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_def_buss.pv_code
     *
     * @param pvCode the value for yg_customer_def_buss.pv_code
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public void setPvCode(String pvCode) {
        this.pvCode = pvCode == null ? null : pvCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_def_buss.user_id
     *
     * @return the value of yg_customer_def_buss.user_id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_def_buss.user_id
     *
     * @param userId the value for yg_customer_def_buss.user_id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_def_buss.buss_code
     *
     * @return the value of yg_customer_def_buss.buss_code
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public String getBussCode() {
        return bussCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_def_buss.buss_code
     *
     * @param bussCode the value for yg_customer_def_buss.buss_code
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public void setBussCode(String bussCode) {
        this.bussCode = bussCode == null ? null : bussCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_def_buss.pv_status
     *
     * @return the value of yg_customer_def_buss.pv_status
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public String getPvStatus() {
        return pvStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_def_buss.pv_status
     *
     * @param pvStatus the value for yg_customer_def_buss.pv_status
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public void setPvStatus(String pvStatus) {
        this.pvStatus = pvStatus == null ? null : pvStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_def_buss.created_user_id
     *
     * @return the value of yg_customer_def_buss.created_user_id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public String getCreatedUserId() {
        return createdUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_def_buss.created_user_id
     *
     * @param createdUserId the value for yg_customer_def_buss.created_user_id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId == null ? null : createdUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_def_buss.created_time
     *
     * @return the value of yg_customer_def_buss.created_time
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_def_buss.created_time
     *
     * @param createdTime the value for yg_customer_def_buss.created_time
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_def_buss.updated_user_id
     *
     * @return the value of yg_customer_def_buss.updated_user_id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public String getUpdatedUserId() {
        return updatedUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_def_buss.updated_user_id
     *
     * @param updatedUserId the value for yg_customer_def_buss.updated_user_id
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId == null ? null : updatedUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_def_buss.updated_time
     *
     * @return the value of yg_customer_def_buss.updated_time
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_def_buss.updated_time
     *
     * @param updatedTime the value for yg_customer_def_buss.updated_time
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_def_buss.is_deleted
     *
     * @return the value of yg_customer_def_buss.is_deleted
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public String getDeletedFlag() {
        return deletedFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_def_buss.is_deleted
     *
     * @param deletedFlag the value for yg_customer_def_buss.is_deleted
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag == null ? null : deletedFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_def_buss.pv_desc
     *
     * @return the value of yg_customer_def_buss.pv_desc
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public String getPvDesc() {
        return pvDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_def_buss.pv_desc
     *
     * @param pvDesc the value for yg_customer_def_buss.pv_desc
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    public void setPvDesc(String pvDesc) {
        this.pvDesc = pvDesc == null ? null : pvDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_def_buss
     *
     * @mbg.generated Sun Jun 05 16:40:02 CST 2022
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", pvCode=").append(pvCode);
        sb.append(", userId=").append(userId);
        sb.append(", bussCode=").append(bussCode);
        sb.append(", pvStatus=").append(pvStatus);
        sb.append(", createdUserId=").append(createdUserId);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedUserId=").append(updatedUserId);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", deletedFlag=").append(deletedFlag);
        sb.append(", pvDesc=").append(pvDesc);
        sb.append("]");
        return sb.toString();
    }
}