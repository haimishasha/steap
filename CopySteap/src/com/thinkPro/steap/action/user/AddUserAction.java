package com.thinkPro.steap.action.user;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.thinkPro.steap.bean.sys.user.TBaseUserInfo;
import com.thinkPro.steap.db.service.sys.user.UserService;

public class AddUserAction extends ActionSupport implements ModelDriven<TBaseUserInfo>{
	
	private static final long serialVersionUID = -606136789052608961L;

	private TBaseUserInfo user = new TBaseUserInfo();
	
	private String userId;



	public TBaseUserInfo getUser() {
		return user;
	}

	public void setUser(TBaseUserInfo user) {
		this.user = user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String addUser(){

		UserService userService = new UserService();
		
		boolean result = false;
		try {
			
			result = userService.addUser(user);
			
			this.userId = user.getUserId();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			Logger logger = Logger.getLogger(AddUserAction.class);
			logger.info(logger);
		}
		if (result) {
			
			return SUCCESS;
		} 
		return ERROR;
	}

	@Override
	public TBaseUserInfo getModel() {
		
		return user;
	}
}
