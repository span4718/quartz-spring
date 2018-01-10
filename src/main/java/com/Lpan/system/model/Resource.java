package com.Lpan.system.model;

import java.util.Date;

public class Resource {

   private Integer id;

   private String resourceName;			//资源名称

   private String resourceUrl;			//资源路径

   private String type;					//资源类型  菜单或按钮

   private Integer level;				//等级  一级菜单  二级菜单

   private String path;					//路径

   private Integer parentId;			//父id

   private String permissionCode;		//访问编码

   private String status;				//状态

   private Date createTime;

   private Date updateTime;

   private String memo;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getResourceName() {
	return resourceName;
}

public void setResourceName(String resourceName) {
	this.resourceName = resourceName;
}

public String getResourceUrl() {
	return resourceUrl;
}

public void setResourceUrl(String resourceUrl) {
	this.resourceUrl = resourceUrl;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public Integer getLevel() {
	return level;
}

public void setLevel(Integer level) {
	this.level = level;
}

public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}

public Integer getParentId() {
	return parentId;
}

public void setParentId(Integer parentId) {
	this.parentId = parentId;
}

public String getPermissionCode() {
	return permissionCode;
}

public void setPermissionCode(String permissionCode) {
	this.permissionCode = permissionCode;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
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
