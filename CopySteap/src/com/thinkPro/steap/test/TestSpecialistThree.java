package com.thinkPro.steap.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

public class TestSpecialistThree {
	private SpecialistService specialistService;
	
	@Before
	public void testBefore() {
		specialistService = new SpecialistService();
	}
	
	
	@Test
	public void testGetRecommendSpecialistList() throws SQLException {
		List<Specialist> specialists = specialistService.getRecommendSpecialistList("P1000001");
		System.out.println("specialists: " + specialists);
	}
	
	@Test
	public void testUpdateLibrarySpecialist() throws SQLException {
		Specialist specialist = new Specialist();
		specialist.setSpecialistId("SL100010");
		specialist.setEmail("3590@qq.com");
		int result = specialistService.updateLibrarySpecialist(specialist);
		System.out.println("testUpdateLibrarySpecialist: " + result);
	}
	
	@Test
	public void testUpdateRecommendSpecialist() throws SQLException {
		Specialist specialist = new Specialist();
		specialist.setSpecialistId("SR100020");
		specialist.setEmail("35qo@qq.com");
		int result = specialistService.updateRecommendSpecialist(specialist);
		System.out.println("testUpdateRecommendSpecialist: " + result);
	}
}
