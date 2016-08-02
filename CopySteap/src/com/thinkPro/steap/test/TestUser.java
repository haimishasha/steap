package com.thinkPro.steap.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.thinkPro.steap.bean.sys.user.TBaseRoleInfo;
import com.thinkPro.steap.bean.sys.user.TBaseUserInfo;
import com.thinkPro.steap.db.service.sys.user.UserService;


public class TestUser {

	UserService service = new UserService();
	
	@Test
	public void testIsUser() throws Exception {
		Map<String,String> loginInfo = new HashMap<String,String>();
		loginInfo.put("userName", "小萌耐");
		loginInfo.put("password", "a123456");
		System.out.println(service.isUser(loginInfo));
	}
	
	@Test
	public void testGetPrivilegeByUserId() throws Exception {
		System.out.println(service.getPrivilegeByUserId("U100007"));
	}
	
	@Test
	public void testGetUserByUnit() throws Exception {
		String unitName = "成果评估部门";
		System.out.println(service.getUsersByUnit(unitName));
	}
	
	
	/*****************************START BY HAOSHASHA**************************/
	/**
	 * 根据用户Id查询用户信息
	 */
	@Test
	public void testGetUserById(){
		
		
		String userId = "U100003";
		
		try {
			
			TBaseUserInfo user = service.getUserById(userId);
			
			System.out.println(user.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据用户电话查询用户信息
	 */
	@Test
	public void testGetUserByTelephone(){
		
		
		String telephone = "18456734567";
		
		try {
			
			TBaseUserInfo user = service.getUserByTelephone(telephone);
			
			System.out.println(user.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加用户基本信息
	 */
	@Test
	public void testAddUser(){
		
		TBaseUserInfo user = new TBaseUserInfo();
		user.setUnitId("10001");
		user.setName("猫の旅行");
		user.setPassword("123456");
		user.setSex("女");
		user.setDuty("职员");
		user.setTelephone("18456734567");
		
		try {
			boolean result = service.addUser(user);
			
			if(result){
				
				System.out.println("添加成功");
				
			}else{
				
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 修改用户基本信息(不包括密码)
	 */
	@Test
	public void testUpdateUserInfo(){
		
		TBaseUserInfo user = new TBaseUserInfo();
		//user.setUnitId("10001");
		user.setUserId("U100013");//必须有
		user.setName("小猫の旅行");
		//user.setPassword("123456");
		//user.setSex("女");
		//user.setDuty("职员");
		//user.setTelephone("18456734567");
		
		try {
			boolean result = service.updateUserInfo(user);
			
			if(result){
				
				System.out.println("修改成功");
				
			}else{
				
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 测试修改密码
	 */
	@Test
	public void testUpdateUserPassword(){
		
		Map<String,Object> userPassword = new HashMap<String,Object>();
		
		userPassword.put("userId", "U100013");
		userPassword.put("password", "a12345");
		
		try {
			
			boolean result = service.updateUserPassword(userPassword);
		
			if(result){
				
				System.out.println("密码修改成功");
			
			}else{
				
				System.out.println("密码修改失败");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据部门Id查询该部门下的用户
	 */
	@Test
	public void testGetUsersByUnitId(){
		
		List<TBaseUserInfo> users = new ArrayList<TBaseUserInfo>();
		
		String unitId = "10001";
		
		try {
			
			users = service.getUsersByUnitId(unitId);
			
			for(TBaseUserInfo user: users){
				
				System.out.println(user.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 给用户分配角色
	 */
	@Test
	public void testAddRoleToUser(){
		
		Map<String,Object> userRole = new HashMap<String,Object>();
		userRole.put("userId", "U100013");
		userRole.put("roleId", "95d60ee7-42e4-4a86-953f-7be6e94f876b");
		
		try {
			boolean result = service.addRoleToUser(userRole);
			
			if(result){
				
				System.out.println("角色分配成功");
			
			}else{
				
				System.out.println("角色分配失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据用户编号查询该用户所扮演的角色
	 */
	@Test
	public void testGetRoleByUserId(){
		
		List<TBaseRoleInfo> roles = new ArrayList<TBaseRoleInfo>();
		
		String userId = "U100013";
		
		try {
			
			roles = service.getRoleByUserId(userId);
			
			for(TBaseRoleInfo role: roles){
				
				System.out.println(role.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据用户编号查询该用户不扮演的角色
	 */
	@Test
	public void testGetLeftRoleByUserId(){
		
		List<TBaseRoleInfo> roles = new ArrayList<TBaseRoleInfo>();
		
		String userId = "U100013";
		
		try {
			
			roles = service.getLeftRoleByUserId(userId);
			
			for(TBaseRoleInfo role: roles){
				
				System.out.println(role.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据角色编号查询该角色下的所有用户
	 */
	@Test
	public void testGetUserByRoleId(){
		
		List<TBaseUserInfo> users = new ArrayList<TBaseUserInfo>();
		
		String roleId = "95d60ee7-42e4-4a86-953f-7be6e94f876b";
		
		try {
			
			users = service.getUserByRoleId(roleId);
			
			for(TBaseUserInfo user: users){
				
				System.out.println(user.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 撤销分配给用户的角色
	 */
	@Test
	public void testDeleteRoleFromUser(){
		
		Map<String,Object> userRole = new HashMap<String,Object>();
		userRole.put("userId", "U100013");
		//userRole.put("roleId", "95d60ee7-42e4-4a86-953f-7be6e94f876b");
		
		try {
			boolean result = service.deleteRoleFromUser(userRole);
			
			if(result){
				
				System.out.println("角色撤销成功");
			
			}else{
				
				System.out.println("角色撤销失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 测试删除用户
	 */
	@Test
	public void testDeleteUserById(){
		
		String userId = "U100013";
		
		try {
			
			boolean result = service.deleteUserById(userId);
			
			if(result){
				
				System.out.println("删除成功");
				
			}else{
				
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 根据条件查询用户(用户姓名，用户职务)
	 */
	@Test
	public void testGetUsersByCondition(){
		
		List<TBaseUserInfo> users = new ArrayList<TBaseUserInfo>();
		
		Map<String,Object> condition = new HashMap<String,Object>();
		
		//condition.put("name", "小猫の旅行");
		//condition.put("duty", "职员");
		
		try {
			users=service.getUsersByCondition(condition);
			
			for(TBaseUserInfo user:users){
				
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*******************************END BY HAOSHASHA *************************/
}
