package com.thinkPro.steap.action.user;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.user.UserService;

public class DeleteUserAction extends ActionSupport {

	private static final long serialVersionUID = -796150785473757381L;
	
	private String deleteIds;//Ajax传过来的值（用户编号）
	
	private boolean result;


	public String getDeleteIds() {
		return deleteIds;
	}

	public void setDeleteIds(String deleteIds) {
		this.deleteIds = deleteIds;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String deleteUserById() {
		
		UserService userService = new UserService();
		
		try {
			//得到需要删除的用户的编号
			deleteIds = deleteIds.substring(0, deleteIds.length()-1);
			
			System.out.println(deleteIds);
			//将得到的用户编号的字符串变为列表
			List<String> userIds = java.util.Arrays.asList(deleteIds.split(","));
			//通过迭代达到批量删除用户的目的
			for(String userId:userIds){
				this.result = userService.deleteUserById(userId);
			}
			
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
