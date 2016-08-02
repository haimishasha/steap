package com.thinkPro.steap.test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.thinkPro.steap.bean.material.Picture;
import com.thinkPro.steap.db.service.material.PictureService;


public class TestPicture {

	PictureService service = new PictureService();
	
	@Test
	public void testAddPicture() throws Exception {
		Picture picture = new Picture();
		picture.setProjectId("12345678");
		picture.setCurrentName("lalalala");
		picture.setOriginalName("lalala");
		picture.setPictureSize("120");
		picture.setPictureType("考察照片");
		picture.setUploadTime(Timestamp.valueOf("2015-09-09 09:00:00"));
		System.out.println(service.addPicture(picture));
	}


	@Test
	public void testGetPicture() throws Exception {
		Map<String,String> pictureInfo = new HashMap<String,String>();
		pictureInfo.put("projectId", "12345678");
		pictureInfo.put("pictureType", "400001");
		System.out.println(service.getPicture(pictureInfo));
	}
}
