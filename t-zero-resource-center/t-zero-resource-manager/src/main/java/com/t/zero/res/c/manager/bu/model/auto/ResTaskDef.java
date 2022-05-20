package com.t.zero.res.c.manager.bu.model.auto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ResTaskDef implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.id
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.tenant_id
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private Integer tenantId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.res_task_code
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private String resTaskCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.res_task_type
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private String resTaskType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.res_info_name
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private String resInfoName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.res_info_type
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private String resInfoType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.res_info_parent_code
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private String resInfoParentCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.res_info_path
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private String resInfoPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.res_info_owner_id
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private Integer resInfoOwnerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.res_info_owner_type
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private String resInfoOwnerType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.res_info_store
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private String resInfoStore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.res_info_region
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private String resInfoRegion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.res_info_size
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private Integer resInfoSize;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.part_count
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private Integer partCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.res_task_status
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private Integer resTaskStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.created_time
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private LocalDateTime createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_res_task_def.created_user_id
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private String createdUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_zero_res_task_def
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.id
     *
     * @return the value of t_zero_res_task_def.id
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.id
     *
     * @param id the value for t_zero_res_task_def.id
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.tenant_id
     *
     * @return the value of t_zero_res_task_def.tenant_id
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public Integer getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.tenant_id
     *
     * @param tenantId the value for t_zero_res_task_def.tenant_id
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.res_task_code
     *
     * @return the value of t_zero_res_task_def.res_task_code
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public String getResTaskCode() {
        return resTaskCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.res_task_code
     *
     * @param resTaskCode the value for t_zero_res_task_def.res_task_code
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setResTaskCode(String resTaskCode) {
        this.resTaskCode = resTaskCode == null ? null : resTaskCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.res_task_type
     *
     * @return the value of t_zero_res_task_def.res_task_type
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public String getResTaskType() {
        return resTaskType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.res_task_type
     *
     * @param resTaskType the value for t_zero_res_task_def.res_task_type
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setResTaskType(String resTaskType) {
        this.resTaskType = resTaskType == null ? null : resTaskType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.res_info_name
     *
     * @return the value of t_zero_res_task_def.res_info_name
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public String getResInfoName() {
        return resInfoName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.res_info_name
     *
     * @param resInfoName the value for t_zero_res_task_def.res_info_name
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setResInfoName(String resInfoName) {
        this.resInfoName = resInfoName == null ? null : resInfoName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.res_info_type
     *
     * @return the value of t_zero_res_task_def.res_info_type
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public String getResInfoType() {
        return resInfoType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.res_info_type
     *
     * @param resInfoType the value for t_zero_res_task_def.res_info_type
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setResInfoType(String resInfoType) {
        this.resInfoType = resInfoType == null ? null : resInfoType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.res_info_parent_code
     *
     * @return the value of t_zero_res_task_def.res_info_parent_code
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public String getResInfoParentCode() {
        return resInfoParentCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.res_info_parent_code
     *
     * @param resInfoParentCode the value for t_zero_res_task_def.res_info_parent_code
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setResInfoParentCode(String resInfoParentCode) {
        this.resInfoParentCode = resInfoParentCode == null ? null : resInfoParentCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.res_info_path
     *
     * @return the value of t_zero_res_task_def.res_info_path
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public String getResInfoPath() {
        return resInfoPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.res_info_path
     *
     * @param resInfoPath the value for t_zero_res_task_def.res_info_path
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setResInfoPath(String resInfoPath) {
        this.resInfoPath = resInfoPath == null ? null : resInfoPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.res_info_owner_id
     *
     * @return the value of t_zero_res_task_def.res_info_owner_id
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public Integer getResInfoOwnerId() {
        return resInfoOwnerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.res_info_owner_id
     *
     * @param resInfoOwnerId the value for t_zero_res_task_def.res_info_owner_id
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setResInfoOwnerId(Integer resInfoOwnerId) {
        this.resInfoOwnerId = resInfoOwnerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.res_info_owner_type
     *
     * @return the value of t_zero_res_task_def.res_info_owner_type
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public String getResInfoOwnerType() {
        return resInfoOwnerType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.res_info_owner_type
     *
     * @param resInfoOwnerType the value for t_zero_res_task_def.res_info_owner_type
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setResInfoOwnerType(String resInfoOwnerType) {
        this.resInfoOwnerType = resInfoOwnerType == null ? null : resInfoOwnerType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.res_info_store
     *
     * @return the value of t_zero_res_task_def.res_info_store
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public String getResInfoStore() {
        return resInfoStore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.res_info_store
     *
     * @param resInfoStore the value for t_zero_res_task_def.res_info_store
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setResInfoStore(String resInfoStore) {
        this.resInfoStore = resInfoStore == null ? null : resInfoStore.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.res_info_region
     *
     * @return the value of t_zero_res_task_def.res_info_region
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public String getResInfoRegion() {
        return resInfoRegion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.res_info_region
     *
     * @param resInfoRegion the value for t_zero_res_task_def.res_info_region
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setResInfoRegion(String resInfoRegion) {
        this.resInfoRegion = resInfoRegion == null ? null : resInfoRegion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.res_info_size
     *
     * @return the value of t_zero_res_task_def.res_info_size
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public Integer getResInfoSize() {
        return resInfoSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.res_info_size
     *
     * @param resInfoSize the value for t_zero_res_task_def.res_info_size
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setResInfoSize(Integer resInfoSize) {
        this.resInfoSize = resInfoSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.part_count
     *
     * @return the value of t_zero_res_task_def.part_count
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public Integer getPartCount() {
        return partCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.part_count
     *
     * @param partCount the value for t_zero_res_task_def.part_count
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setPartCount(Integer partCount) {
        this.partCount = partCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.res_task_status
     *
     * @return the value of t_zero_res_task_def.res_task_status
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public Integer getResTaskStatus() {
        return resTaskStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.res_task_status
     *
     * @param resTaskStatus the value for t_zero_res_task_def.res_task_status
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setResTaskStatus(Integer resTaskStatus) {
        this.resTaskStatus = resTaskStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.created_time
     *
     * @return the value of t_zero_res_task_def.created_time
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.created_time
     *
     * @param createdTime the value for t_zero_res_task_def.created_time
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_res_task_def.created_user_id
     *
     * @return the value of t_zero_res_task_def.created_user_id
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public String getCreatedUserId() {
        return createdUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_res_task_def.created_user_id
     *
     * @param createdUserId the value for t_zero_res_task_def.created_user_id
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId == null ? null : createdUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_res_task_def
     *
     * @mbg.generated Tue May 17 13:12:23 CST 2022
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", resTaskCode=").append(resTaskCode);
        sb.append(", resTaskType=").append(resTaskType);
        sb.append(", resInfoName=").append(resInfoName);
        sb.append(", resInfoType=").append(resInfoType);
        sb.append(", resInfoParentCode=").append(resInfoParentCode);
        sb.append(", resInfoPath=").append(resInfoPath);
        sb.append(", resInfoOwnerId=").append(resInfoOwnerId);
        sb.append(", resInfoOwnerType=").append(resInfoOwnerType);
        sb.append(", resInfoStore=").append(resInfoStore);
        sb.append(", resInfoRegion=").append(resInfoRegion);
        sb.append(", resInfoSize=").append(resInfoSize);
        sb.append(", partCount=").append(partCount);
        sb.append(", resTaskStatus=").append(resTaskStatus);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", createdUserId=").append(createdUserId);
        sb.append("]");
        return sb.toString();
    }
}