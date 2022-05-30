package com.t.zero.yg.crm.bu.model.auto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CustomerInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.pv_code
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String pvCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.tenant_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private Integer tenantId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.corp_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private Integer corpId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.corp_code
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String corpCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.customer_name
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String customerName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.customer_quota
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String customerQuota;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.pv_status
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String pvStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.created_user_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String createdUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.created_time
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private LocalDateTime createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.updated_user_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String updatedUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.updated_time
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private LocalDateTime updatedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.is_deleted
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String deletedFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yg_customer_info.pv_desc
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private String pvDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table yg_customer_info
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.id
     *
     * @return the value of yg_customer_info.id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.id
     *
     * @param id the value for yg_customer_info.id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.pv_code
     *
     * @return the value of yg_customer_info.pv_code
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getPvCode() {
        return pvCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.pv_code
     *
     * @param pvCode the value for yg_customer_info.pv_code
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setPvCode(String pvCode) {
        this.pvCode = pvCode == null ? null : pvCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.tenant_id
     *
     * @return the value of yg_customer_info.tenant_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public Integer getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.tenant_id
     *
     * @param tenantId the value for yg_customer_info.tenant_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.corp_id
     *
     * @return the value of yg_customer_info.corp_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public Integer getCorpId() {
        return corpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.corp_id
     *
     * @param corpId the value for yg_customer_info.corp_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.corp_code
     *
     * @return the value of yg_customer_info.corp_code
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getCorpCode() {
        return corpCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.corp_code
     *
     * @param corpCode the value for yg_customer_info.corp_code
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.customer_name
     *
     * @return the value of yg_customer_info.customer_name
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.customer_name
     *
     * @param customerName the value for yg_customer_info.customer_name
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.customer_quota
     *
     * @return the value of yg_customer_info.customer_quota
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getCustomerQuota() {
        return customerQuota;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.customer_quota
     *
     * @param customerQuota the value for yg_customer_info.customer_quota
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setCustomerQuota(String customerQuota) {
        this.customerQuota = customerQuota == null ? null : customerQuota.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.pv_status
     *
     * @return the value of yg_customer_info.pv_status
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getPvStatus() {
        return pvStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.pv_status
     *
     * @param pvStatus the value for yg_customer_info.pv_status
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setPvStatus(String pvStatus) {
        this.pvStatus = pvStatus == null ? null : pvStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.created_user_id
     *
     * @return the value of yg_customer_info.created_user_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getCreatedUserId() {
        return createdUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.created_user_id
     *
     * @param createdUserId the value for yg_customer_info.created_user_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId == null ? null : createdUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.created_time
     *
     * @return the value of yg_customer_info.created_time
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.created_time
     *
     * @param createdTime the value for yg_customer_info.created_time
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.updated_user_id
     *
     * @return the value of yg_customer_info.updated_user_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getUpdatedUserId() {
        return updatedUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.updated_user_id
     *
     * @param updatedUserId the value for yg_customer_info.updated_user_id
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId == null ? null : updatedUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.updated_time
     *
     * @return the value of yg_customer_info.updated_time
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.updated_time
     *
     * @param updatedTime the value for yg_customer_info.updated_time
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.is_deleted
     *
     * @return the value of yg_customer_info.is_deleted
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getDeletedFlag() {
        return deletedFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.is_deleted
     *
     * @param deletedFlag the value for yg_customer_info.is_deleted
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag == null ? null : deletedFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yg_customer_info.pv_desc
     *
     * @return the value of yg_customer_info.pv_desc
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public String getPvDesc() {
        return pvDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yg_customer_info.pv_desc
     *
     * @param pvDesc the value for yg_customer_info.pv_desc
     *
     * @mbg.generated Mon May 30 09:12:20 CST 2022
     */
    public void setPvDesc(String pvDesc) {
        this.pvDesc = pvDesc == null ? null : pvDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yg_customer_info
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
        sb.append(", pvCode=").append(pvCode);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", corpId=").append(corpId);
        sb.append(", corpCode=").append(corpCode);
        sb.append(", customerName=").append(customerName);
        sb.append(", customerQuota=").append(customerQuota);
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