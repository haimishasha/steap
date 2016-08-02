package com.thinkPro.steap.test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

public class TestSpecialist {
	SpecialistService ss=new SpecialistService();
	
	
	/**
	 * 测试更新专家信息
	 */
	@Test
	public void testUpdateSpecialist() throws SQLException{
		Specialist specialist = new Specialist();
		specialist.setSpecialistId("SL100010");
		specialist.setName("李明");
		System.out.println(ss.updateLibrarySpecialist(specialist));
	}
	
	/**
	 * 测试根据条件查询专家信息
	 */
	@Test
	public void testSelectSpecialistsByIf() throws SQLException{
		Map<String,Object> specialistCon = new HashMap<String,Object>();
		specialistCon.put("engageDomain", "信息领域");
		System.out.println(ss.getSpecialistsByIf(specialistCon));
	}
}
