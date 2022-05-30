package com.t.zero.yg.crm.bu.model.auto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BussDef implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_buss_def.id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_buss_def.tenant_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private Integer tenantId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_buss_def.pv_code
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String pvCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_buss_def.buss_name
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String bussName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_buss_def.pv_status
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String pvStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_buss_def.created_user_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String createdUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_buss_def.created_time
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private LocalDateTime createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_buss_def.updated_user_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String updatedUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_buss_def.updated_time
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private LocalDateTime updatedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_buss_def.is_deleted
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String deletedFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_buss_def.pv_desc
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String pvDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_buss_def.id
     *
     * @return the value of yg_buss_def.id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_buss_def.id
     *
     * @param id the value for yg_buss_def.id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_buss_def.tenant_id
     *
     * @return the value of yg_buss_def.tenant_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public Integer getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_buss_def.tenant_id
     *
     * @param tenantId the value for yg_buss_def.tenant_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_buss_def.pv_code
     *
     * @return the value of yg_buss_def.pv_code
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getPvCode() {
        return pvCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_buss_def.pv_code
     *
     * @param pvCode the value for yg_buss_def.pv_code
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setPvCode(String pvCode) {
        this.pvCode = pvCode == null ? null : pvCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_buss_def.buss_name
     *
     * @return the value of yg_buss_def.buss_name
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getBussName() {
        return bussName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_buss_def.buss_name
     *
     * @param bussName the value for yg_buss_def.buss_name
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setBussName(String bussName) {
        this.bussName = bussName == null ? null : bussName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_buss_def.pv_status
     *
     * @return the value of yg_buss_def.pv_status
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getPvStatus() {
        return pvStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_buss_def.pv_status
     *
     * @param pvStatus the value for yg_buss_def.pv_status
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setPvStatus(String pvStatus) {
        this.pvStatus = pvStatus == null ? null : pvStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_buss_def.created_user_id
     *
     * @return the value of yg_buss_def.created_user_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getCreatedUserId() {
        return createdUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_buss_def.created_user_id
     *
     * @param createdUserId the value for yg_buss_def.created_user_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId == null ? null : createdUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_buss_def.created_time
     *
     * @return the value of yg_buss_def.created_time
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_buss_def.created_time
     *
     * @param createdTime the value for yg_buss_def.created_time
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_buss_def.updated_user_id
     *
     * @return the value of yg_buss_def.updated_user_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getUpdatedUserId() {
        return updatedUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_buss_def.updated_user_id
     *
     * @param updatedUserId the value for yg_buss_def.updated_user_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId == null ? null : updatedUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_buss_def.updated_time
     *
     * @return the value of yg_buss_def.updated_time
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_buss_def.updated_time
     *
     * @param updatedTime the value for yg_buss_def.updated_time
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_buss_def.is_deleted
     *
     * @return the value of yg_buss_def.is_deleted
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getDeletedFlag() {
        return deletedFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_buss_def.is_deleted
     *
     * @param deletedFlag the value for yg_buss_def.is_deleted
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag == null ? null : deletedFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_buss_def.pv_desc
     *
     * @return the value of yg_buss_def.pv_desc
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getPvDesc() {
        return pvDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_buss_def.pv_desc
     *
     * @param pvDesc the value for yg_buss_def.pv_desc
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setPvDesc(String pvDesc) {
        this.pvDesc = pvDesc == null ? null : pvDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_buss_def
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
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
        sb.append(", bussName=").append(bussName);
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