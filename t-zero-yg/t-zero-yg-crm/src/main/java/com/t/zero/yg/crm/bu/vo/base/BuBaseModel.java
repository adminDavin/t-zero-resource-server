package com.t.zero.yg.crm.bu.vo.base;

import java.time.LocalDateTime;

public interface BuBaseModel {

	public void setId(Integer id);

	public void setPvCode(String pvCode);

	public void setTenantId(Integer tenantId);

	public void setCreatedTime(LocalDateTime createdTime);

	public void setCreatedUserId(String createdUserId);

	public void setUpdatedTime(LocalDateTime updatedTime);

	public void setUpdatedUserId(String updatedUserId);

	public void setDeletedFlag(String deletedFlag);

}
