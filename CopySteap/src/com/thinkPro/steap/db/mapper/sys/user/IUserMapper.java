package com.thinkPro.steap.db.mapper.sys.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.sys.user.TBaseRoleInfo;
import com.thinkPro.steap.bean.sys.user.TBaseUserInfo;
import com.thinkPro.steap.bean.sys.user.UserPrivilege;

public interface IUserMapper {


	/**
	 * 根据用户Id查询用户信息
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public TBaseUserInfo getUserById(String userId) throws SQLException;


	/**
	 * 判断用户是否存在
	 * @param loginInfo 登录信息(userName,password)
	 * @return 如果用户存在，但会用户的Id(userId)
	 * @throws SQLException
	 */
	public String isUser(Map<String, String> loginInfo) throws SQLException;

	/**
	 * 根据用户(userId)查询用户所拥有的权限(可以进入的页面)
	 * @param userId 用户的Id
	 * @return 模块(菜单)的名称，模块的URL，模块的等级
	 * @throws SQLException
	 */
	public UserPrivilege getPrivilegeByUserId(String userId)
			throws SQLException;
	/**
	 * 根据部门返回用户信息
	 * @param unitName 部门名称
	 * @return 部门名称(unitName)，用户Id(userId)，用户姓名(name)，职务(duty)(List<Map>)
	 */
	public List<Map<String,Object>> getUsersByUnit(String unitName)throws SQLException;
	
	
	
	/******************************* START BY HAOSHASHA *****************************************/
	
	/**
	 * 根据用户电话查询用户信息
	 * @param telephone电话号码
	 * @return 用户基本信息
	 * @throws SQLException
	 */
	public TBaseUserInfo getUserByTelephone(String telephone) throws SQLException;

	/**
	 * 添加用户基本信息
	 * @param user
	 * @throws SQLException
	 */
	public int addUser(TBaseUserInfo user)throws SQLException;
	
	/**
	 * 根据用户编号删除用户
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public int deleteUserById(String userId)throws SQLException;
	
	/**
	 * 修改用户基本信息(不包括密码)
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int updateUserInfo(TBaseUserInfo user)throws SQLException;
	
	/**
	 * 修改用户密码
	 * @param userPassword map里面包括(userId,password)
	 * @return
	 * @throws SQLException
	 */
	public int updateUserPassword(Map<String,Object> userPassword)throws SQLException;
	
	/**
	 * 根据部门Id查询该部门下的用户
	 * @param unitId
	 * @return List<TBaseUserInfo> 用户基本信息 
	 * @throws SQLException
	 */
	public List<TBaseUserInfo> getUsersByUnitId(String unitId)throws SQLException;
	
	/**
	 * 给用户分配角色
	 * @param userRole map里面应该包含（用户编号，角色编号）
	 * (userId,roleId)
	 * @return
	 * @throws SQLException
	 */
	public int addRoleToUser(Map<String,Object> userRole)throws SQLException;
	
	/**
	 * 撤销分配给用户的角色
	 * @param userRole map里面应该包含（用户编号，角色编号）
	 * (userId,roleId)
	 * @return
	 * @throws SQLException
	 */
	public int deleteRoleFromUser(Map<String,Object> userRole)throws SQLException;
	
	
	/**
	 * 根据用户编号查询该用户所扮演的角色
	 * @param userId 用户编号
	 * @return 角色基本信息
	 * @throws SQLException
	 */
	public List<TBaseRoleInfo> getRoleByUserId(String userId)throws SQLException;
	
	/**
	 * 根据用户编号查询该用户不扮演的角色
	 * @param userId 用户编号
	 * @return 角色基本信息
	 * @throws SQLException
	 */
	public List<TBaseRoleInfo> getLeftRoleByUserId(String userId)throws SQLException;
	
	/**
	 * 根据角色编号查询该角色下的所有用户
	 * @param unitId
	 * @return List<TBaseUserInfo> 用户基本信息 
	 * @throws SQLException
	 */
	public List<TBaseUserInfo> getUserByRoleId(String roleId)throws SQLException;
	
	/**
	 * 根据条件查询用户(用户姓名，用户职务)
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public List<TBaseUserInfo> getUsersByCondition(Map<String,Object> condition)throws SQLException;
	
	/******************************* END BY HAOSHASHA *******************************************/
	
}
