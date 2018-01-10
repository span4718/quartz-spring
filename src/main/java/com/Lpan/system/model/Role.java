package com.Lpan.system.model;

import java.util.Date;

public class Role {
   private Integer id;

   private String roleName;
   private Integer status;

   private Date createTime;

   private Date updateTime;

   private String memo;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getRoleName() {
	return roleName;
}

public void setRoleName(String roleName) {
	this.roleName = roleName;
}

public Integer getStatus() {
	return status;
}

public void setStatus(Integer status) {
	this.status = status;
}

public Date getCreateTime() {
	return createTime;
}

public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}

public Date getUpdateTime() {
	return updateTime;
}

public void setUpdateTime(Date updateTime) {
	this.updateTime = updateTime;
}

public String getMemo() {
	return memo;
}

public void setMemo(String memo) {
	this.memo = memo;
}
   
   
}
