package com.thinkPro.steap.db.base.sys.module;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.sys.module.Module;
import com.thinkPro.steap.db.mapper.sys.module.IModuleMapper;

public class ModuleBase implements IModuleMapper {
	
	private ApplicationContext applicationContext;
	private IModuleMapper moduleMapper;
	
	public ModuleBase() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		moduleMapper = (IModuleMapper) applicationContext.getBean("IModuleMapper");
	}

	/**
	 * 添加模块 
	 * @param module
	 * @return
	 * @throws SQLException
	 */
	public int addModule(Module module) throws SQLException {
		return moduleMapper.addModule(module);
	}

	/**
	 *  根据模块id删除模块
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int deleteModule(String id) throws SQLException {
		return moduleMapper.deleteModule(id);
	}

	/**
	 * 修改模块信息
	 * @param module
	 * @return
	 * @throws SQLException
	 */
	public int updateModule(Module module) throws SQLException {
		return moduleMapper.updateModule(module);
	}

	/**
	 * 查询模块信息列表
	 * @return
	 * @throws SQLException
	 */
	public List<Module> getAllModule() throws SQLException {
		return moduleMapper.getAllModule();
	}

}
