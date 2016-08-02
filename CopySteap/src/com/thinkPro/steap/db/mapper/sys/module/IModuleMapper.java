package com.thinkPro.steap.db.mapper.sys.module;

import java.sql.SQLException;
import java.util.List;

import com.thinkPro.steap.bean.sys.module.Module;

public interface IModuleMapper {
	
	/**
	 * 添加模块 
	 * @param module
	 * @return
	 * @throws SQLException
	 */
	public int addModule(Module module) throws SQLException;
	
	/**
	 *  根据模块id删除模块
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int deleteModule(String id) throws SQLException;
	
	/**
	 * 修改模块信息
	 * @param module
	 * @return
	 * @throws SQLException
	 */
	public int updateModule(Module module) throws SQLException;
	
	/**
	 * 查询模块信息列表
	 * @return
	 * @throws SQLException
	 */
	public List<Module> getAllModule() throws SQLException;
}
