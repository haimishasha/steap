package com.thinkPro.steap.bean.sys.user;

import java.util.List;

public class TBaseRolePrivilege {
	private String roleId;
	private List<SystemPrivilege> privileges;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<SystemPrivilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<SystemPrivilege> privileges) {
		this.privileges = privileges;
	}

	@Override
	public String toString() {
		return "TBaseRolePrivilege [roleId=" + roleId + ", privileges="
				+ privileges + "]";
	}

}
