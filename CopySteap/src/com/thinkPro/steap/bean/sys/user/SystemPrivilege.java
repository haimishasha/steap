package com.thinkPro.steap.bean.sys.user;

public class SystemPrivilege {
	private String privilegeId;
	private String privilegeName;
	private boolean isUse;
	private String description;
	private String remark;

	public String getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
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
		return "SystemPrivilege [privilegeId=" + privilegeId
				+ ", privilegeName=" + privilegeName + ", isUse=" + isUse
				+ ", description=" + description + ", remark=" + remark + "]";
	}

}
