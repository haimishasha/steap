package com.thinkPro.steap.test;

import java.sql.SQLException;

import org.junit.Test;

import com.thinkPro.steap.bean.sys.module.Module;
import com.thinkPro.steap.db.service.sys.module.ModuleService;


public class TestModule {
	ModuleService ms=new ModuleService();
	
	@Test
	public void testAddModule() throws SQLException{
		Module module =new Module();
		module.setModuleId("16006");
		module.setModuleName("权限管理");
		ms.addModule(module);
	}
	
	@Test
	public void testDeleteModule() throws SQLException {
		ms.deleteModule("0b430143-545f-11e6-91ca-28d24414533b");
	}
	
	@Test
	public void testUpdateModule() throws SQLException{
		Module module =new Module();
		module.setId("0b430143-545f-11e6-91ca-28d24414533b");
		module.setModuleId("16006");
		module.setModuleName("权限的管理");
		ms.updateModule(module);
	}
	
	@Test
	public void testGetAllModule() throws SQLException{
		ms.getAllModule();
	}
}
