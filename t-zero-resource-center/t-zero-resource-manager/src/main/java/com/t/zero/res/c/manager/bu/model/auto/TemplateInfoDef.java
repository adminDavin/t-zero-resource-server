package com.t.zero.res.c.manager.bu.model.auto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TemplateInfoDef implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.id
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.template_type_id
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private Integer templateTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.template_type_code
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private String templateTypeCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.template_info_code
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private String templateInfoCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.template_info_name
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private String templateInfoName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.template_file_name
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private String templateFileName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.template_file_address
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private String templateFileAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.template_file_storage
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private String templateFileStorage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.created_user_id
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private String createdUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.created_time
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private LocalDateTime createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.updated_user_id
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private String updatedUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.updated_time
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private LocalDateTime updatedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.is_deleted
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private String deletedFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_zero_template_info_def.template_info_desc
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private String templateInfoDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_zero_template_info_def
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.id
     *
     * @return the value of t_zero_template_info_def.id
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.id
     *
     * @param id the value for t_zero_template_info_def.id
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.template_type_id
     *
     * @return the value of t_zero_template_info_def.template_type_id
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public Integer getTemplateTypeId() {
        return templateTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.template_type_id
     *
     * @param templateTypeId the value for t_zero_template_info_def.template_type_id
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setTemplateTypeId(Integer templateTypeId) {
        this.templateTypeId = templateTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.template_type_code
     *
     * @return the value of t_zero_template_info_def.template_type_code
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public String getTemplateTypeCode() {
        return templateTypeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.template_type_code
     *
     * @param templateTypeCode the value for t_zero_template_info_def.template_type_code
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setTemplateTypeCode(String templateTypeCode) {
        this.templateTypeCode = templateTypeCode == null ? null : templateTypeCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.template_info_code
     *
     * @return the value of t_zero_template_info_def.template_info_code
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public String getTemplateInfoCode() {
        return templateInfoCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.template_info_code
     *
     * @param templateInfoCode the value for t_zero_template_info_def.template_info_code
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setTemplateInfoCode(String templateInfoCode) {
        this.templateInfoCode = templateInfoCode == null ? null : templateInfoCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.template_info_name
     *
     * @return the value of t_zero_template_info_def.template_info_name
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public String getTemplateInfoName() {
        return templateInfoName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.template_info_name
     *
     * @param templateInfoName the value for t_zero_template_info_def.template_info_name
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setTemplateInfoName(String templateInfoName) {
        this.templateInfoName = templateInfoName == null ? null : templateInfoName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.template_file_name
     *
     * @return the value of t_zero_template_info_def.template_file_name
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public String getTemplateFileName() {
        return templateFileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.template_file_name
     *
     * @param templateFileName the value for t_zero_template_info_def.template_file_name
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName == null ? null : templateFileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.template_file_address
     *
     * @return the value of t_zero_template_info_def.template_file_address
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public String getTemplateFileAddress() {
        return templateFileAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.template_file_address
     *
     * @param templateFileAddress the value for t_zero_template_info_def.template_file_address
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setTemplateFileAddress(String templateFileAddress) {
        this.templateFileAddress = templateFileAddress == null ? null : templateFileAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.template_file_storage
     *
     * @return the value of t_zero_template_info_def.template_file_storage
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public String getTemplateFileStorage() {
        return templateFileStorage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.template_file_storage
     *
     * @param templateFileStorage the value for t_zero_template_info_def.template_file_storage
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setTemplateFileStorage(String templateFileStorage) {
        this.templateFileStorage = templateFileStorage == null ? null : templateFileStorage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.created_user_id
     *
     * @return the value of t_zero_template_info_def.created_user_id
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public String getCreatedUserId() {
        return createdUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.created_user_id
     *
     * @param createdUserId the value for t_zero_template_info_def.created_user_id
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId == null ? null : createdUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.created_time
     *
     * @return the value of t_zero_template_info_def.created_time
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.created_time
     *
     * @param createdTime the value for t_zero_template_info_def.created_time
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.updated_user_id
     *
     * @return the value of t_zero_template_info_def.updated_user_id
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public String getUpdatedUserId() {
        return updatedUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.updated_user_id
     *
     * @param updatedUserId the value for t_zero_template_info_def.updated_user_id
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId == null ? null : updatedUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.updated_time
     *
     * @return the value of t_zero_template_info_def.updated_time
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.updated_time
     *
     * @param updatedTime the value for t_zero_template_info_def.updated_time
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.is_deleted
     *
     * @return the value of t_zero_template_info_def.is_deleted
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public String getDeletedFlag() {
        return deletedFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.is_deleted
     *
     * @param deletedFlag the value for t_zero_template_info_def.is_deleted
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag == null ? null : deletedFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_zero_template_info_def.template_info_desc
     *
     * @return the value of t_zero_template_info_def.template_info_desc
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public String getTemplateInfoDesc() {
        return templateInfoDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_zero_template_info_def.template_info_desc
     *
     * @param templateInfoDesc the value for t_zero_template_info_def.template_info_desc
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    public void setTemplateInfoDesc(String templateInfoDesc) {
        this.templateInfoDesc = templateInfoDesc == null ? null : templateInfoDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_zero_template_info_def
     *
     * @mbg.generated Tue May 17 13:12:24 CST 2022
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", templateTypeId=").append(templateTypeId);
        sb.append(", templateTypeCode=").append(templateTypeCode);
        sb.append(", templateInfoCode=").append(templateInfoCode);
        sb.append(", templateInfoName=").append(templateInfoName);
        sb.append(", templateFileName=").append(templateFileName);
        sb.append(", templateFileAddress=").append(templateFileAddress);
        sb.append(", templateFileStorage=").append(templateFileStorage);
        sb.append(", createdUserId=").append(createdUserId);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedUserId=").append(updatedUserId);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", deletedFlag=").append(deletedFlag);
        sb.append(", templateInfoDesc=").append(templateInfoDesc);
        sb.append("]");
        return sb.toString();
    }
}