package com.thinkPro.steap.bean.sys.user;

public class TBaseRoleInfo {
	private String roleId;
	private String roleName;
	private boolean isUse;
	private String description;
	private String remark;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isUse() {
		return isUse;
	}

	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TBaseRoleInfo [roleId=" + roleId + ", roleName=" + roleName
				+ ", isUse=" + isUse + ", description=" + description
				+ ", remark=" + remark + "]";
	}

}
