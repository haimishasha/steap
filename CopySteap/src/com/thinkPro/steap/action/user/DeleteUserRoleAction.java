package com.thinkPro.steap.action.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.user.UserService;

public class DeleteUserRoleAction extends ActionSupport {

	private static final long serialVersionUID = -745140785473757381L;
	
	private String userId;//Ajax传过来的值（用户编号）
	private String roleId;
	private boolean result;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String deleteRoleFromUser() {

		UserService userService = new UserService();

		Map<String,Object> userRole = new HashMap<String,Object>();
		
		userRole.put("userId", userId);
		
		userRole.put("roleId", roleId);
		
		try {
			 this.result = userService.deleteRoleFromUser(userRole);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(result){
			
			return SUCCESS;
		}else{
			
			return ERROR;
		}
		
	}

}
