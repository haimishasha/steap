package com.thinkPro.steap.action.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.user.TBaseRoleInfo;
import com.thinkPro.steap.db.service.sys.user.UserService;


public class SearchUserRoleAction extends ActionSupport {
	
	private static final long serialVersionUID = 5413182626419331366L;

	private String userId;//用户编号
	
	private String result;//返回的结果
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * 根据用户编号查询该用户所扮演的角色
	 * @return
	 */
	public String searchRoleByUserId(){
		
		UserService userService = new UserService();
		
		List<TBaseRoleInfo> roles = new ArrayList<TBaseRoleInfo>();
		
		try {
			System.out.println(userId);
			roles =userService.getRoleByUserId(userId);
			
			JSONArray jsonArray = JSONArray.fromObject(roles);

			this.result = jsonArray.toString();
			
			System.out.println("role "+jsonArray);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 根据用户编号查询该用户不扮演的角色
	 * @return
	 */
	public String searchLeftRoleByUserId(){
		
		UserService userService = new UserService();
		
		List<TBaseRoleInfo> roles = new ArrayList<TBaseRoleInfo>();
		
		try {
			System.out.println(userId);
			roles =userService.getLeftRoleByUserId(userId);
			
			JSONArray jsonArray = JSONArray.fromObject(roles);

			this.result = jsonArray.toString();
			
			System.out.println("left role "+jsonArray);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
}
