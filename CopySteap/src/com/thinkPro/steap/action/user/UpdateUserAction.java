package com.thinkPro.steap.action.user;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.thinkPro.steap.bean.sys.user.TBaseUserInfo;
import com.thinkPro.steap.db.service.sys.user.UserService;


public class UpdateUserAction extends ActionSupport  implements ModelDriven<TBaseUserInfo>{
	
	private static final long serialVersionUID = 519320461749415712L;
	
	private TBaseUserInfo user = new TBaseUserInfo();
	
	private TBaseUserInfo result;
	
	private boolean updateResult;
	
	public TBaseUserInfo getUser() {
		return user;
	}

	public void setUser(TBaseUserInfo user) {
		this.user = user;
	}

	public TBaseUserInfo getResult() {
		return result;
	}

	public void setResult(TBaseUserInfo result) {
		this.result = result;
	}

	public boolean isUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(boolean updateResult) {
		this.updateResult = updateResult;
	}

	public String updateUserInfo(){
		
		UserService userService = new UserService();
		
		try {
			
			this.updateResult = userService.updateUserInfo(user);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(updateResult){
			
			return SUCCESS;
		}else{
			
			return ERROR;
		}
		
	}
	
	public String getUpdateUserInfo(){
		
		UserService userService = new UserService();
		
		try {
			
			this.result = userService.getUserById(user.getUserId());
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Override
	public TBaseUserInfo getModel() {
		
		return user;
	}
	
}
