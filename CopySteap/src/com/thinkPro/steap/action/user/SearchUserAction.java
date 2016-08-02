package com.thinkPro.steap.action.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.user.TBaseUserInfo;
import com.thinkPro.steap.db.service.sys.user.UserService;


public class SearchUserAction extends ActionSupport {

	private static final long serialVersionUID = -2718753766487238403L;
	
	private TBaseUserInfo user;
	
	private String unitId;//部门编号
	
	private String telephone; //用户联系方式
	
	private String userId;//用户编号
	
	private String result;//返回的结果
	
	private String name;//用户姓名
	
	private String duty;//用户职务
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public TBaseUserInfo getUser() {
		return user;
	}

	public void setUser(TBaseUserInfo user) {
		this.user = user;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

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
	 * 根据用户编号查询用户信息
	 * @return
	 */
	public String searchUserByUserId(){
		
		UserService userService = new UserService();
		
		TBaseUserInfo user = new TBaseUserInfo();
		
		try {
			
			user =userService.getUserById(userId);
			
			JSONArray jsonArray = JSONArray.fromObject(user);

			this.result = jsonArray.toString();
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 根据用户联系方式查询用户信息
	 * @return
	 */
	public String searchUserByTelephone(){
		
		UserService userService = new UserService();
		
		TBaseUserInfo user = new TBaseUserInfo();
		
		try {
			
			user =userService.getUserByTelephone(telephone);
			
			JSONArray jsonArray = JSONArray.fromObject(user);

			this.result = jsonArray.toString();
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(this.result!=null){
			
			return SUCCESS;
		
		}else{
			
			return ERROR;
		}
		
	}
	
	/**
	 * 根据部门编号查询用户
	 * @return
	 */
	public String searchUserByUnitId(){
		
		UserService userService = new UserService();
		
		List<TBaseUserInfo> users = new ArrayList<TBaseUserInfo>();
		
		try {
			
			users =userService.getUsersByUnitId(unitId);
			
			JSONArray jsonArray = JSONArray.fromObject(users);

			this.result = jsonArray.toString();
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 根据部门编号查询用户
	 * @return
	 */
	public String searchUserByCondition(){
		
		UserService userService = new UserService();
		
		List<TBaseUserInfo> users = new ArrayList<TBaseUserInfo>();
		
		Map<String,Object> condition = new HashMap<String,Object>();

		condition.put("name", name);
		
		condition.put("duty", duty);
		
		System.out.println(condition);
		
		try {
			
			users=userService.getUsersByCondition(condition);
			
			JSONArray jsonArray = JSONArray.fromObject(users);

			this.result = jsonArray.toString();
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
