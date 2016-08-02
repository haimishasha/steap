package com.thinkPro.steap.test;

import java.sql.SQLException;

import org.junit.Test;

import com.thinkPro.steap.bean.sys.unit.TBaseUnitInfo;
import com.thinkPro.steap.db.service.sys.unit.UnitService;


public class TestUnit {

	UnitService service = new UnitService();
	
	@Test
	public void testGetUnitTree() throws Exception {
		System.out.println(service.getUnitTree());
	}
	
	@Test
	public void testAddUnit() throws SQLException{
		TBaseUnitInfo tBaseUnitInfo=new TBaseUnitInfo();
		tBaseUnitInfo.setUnitId("10004");
		tBaseUnitInfo.setUnitName("审查部");
		service.addUnit(tBaseUnitInfo);
	}
	
	@Test
	public void testDeleteUnit() throws SQLException{
		service.deleteUnit("10004");
	}
	
	@Test
	public void testUpdateUnit() throws SQLException{
		TBaseUnitInfo tBaseUnitInfo=new TBaseUnitInfo();
		tBaseUnitInfo.setUnitId("10004");
		tBaseUnitInfo.setUnitName("审核部");
		service.updateUnit(tBaseUnitInfo);
	}
	
	@Test
	public void testGetAllUnit() throws SQLException{
		service.getAllUnit();
	}
}
