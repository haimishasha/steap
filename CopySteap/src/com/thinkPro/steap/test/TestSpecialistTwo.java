package com.thinkPro.steap.test;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

public class TestSpecialistTwo {
	private Logger log = Logger.getLogger(TestSpecialistTwo.class);
	private SpecialistService specialistService;
	
	@Before
	public void testBefore() {
		specialistService = new SpecialistService();
	}
	
	@Test
	public void testGetSpecialistsByMeetingId() throws SQLException {
		List<Specialist> specialists = specialistService.getSpecialistsByMeetingId("M100004");
		log.info("specialists: " + specialists);
	}
	
	@Test
	public void testGetLibrarySpecialist() throws SQLException {
		Specialist specialist = specialistService.getLibrarySpecialistById("SL100001");
		log.info("Library specialist: " + specialist);
	}
	
	@Test
	public void testGetRecommendSpecialist() throws SQLException {
		Specialist specialist = specialistService.getRecommendSpecialistById("SR1000001");
		log.info("Recommend specialist: " + specialist);
	}
	
	
	
	
}
