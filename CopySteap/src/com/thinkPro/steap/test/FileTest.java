package com.thinkPro.steap.test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.db.service.material.FileService;

public class FileTest {
	
	FileService fs = new FileService();
	
	@Test
	public void testAddFiles() {
			
		System.out.println("===========test AddFiles ==========");
		
		Material file = new Material();
		file.setFileType("承诺书");
		file.setOriginalName("hahaha");
		file.setCurrentName("fafasfafa");
		file.setUploadTime(Timestamp.valueOf("2015-09-09 09:09:09"));
		file.setFileSize("111MB");
		file.setProjectId("P1000002");
		try {
			fs.addFile(file);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() {
		
		try {
			fs.deleteFile("99");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetFile() {
		
		Map<String,Object> condition = new HashMap<String,Object>();
		
		String projectId = "P1000002";
		String fileType = "300003";
		condition.put("projectId", projectId);
		condition.put("fileType", fileType);
		
		Material file;
		try {
			file = fs.getFile(condition);
			System.out.print(file.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}
