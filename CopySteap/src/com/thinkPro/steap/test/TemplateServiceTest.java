package com.thinkPro.steap.test;

import java.sql.SQLException;

import org.junit.Test;

import com.thinkPro.steap.bean.meeting.MeetingTemplate;
import com.thinkPro.steap.db.service.meeting.TemplateService;

public class TemplateServiceTest {
	
	TemplateService ts = new TemplateService();
	/**
	 * 测试创建会议通知的模板
	 */
	@Test
	public void testAddTemplate(){
		
		MeetingTemplate meetingTemplate = new MeetingTemplate();
		
		meetingTemplate.setTemplateName("模板一");
		
		meetingTemplate.setTemplateURL("模板一");
		
		meetingTemplate.setRemark("会议通知");
		
		try {
			ts.addTemplate(meetingTemplate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试查询所有的会议通知的模板
	 */
	@Test
	public void testGetAllTemplate(){
		
		try {
			ts.getAllTemplate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试根据条件进行查询会议通知的模板
	 */
	@Test
	public void testGetTemplateById(){
		
		String templateId = "fef1abd0-5038-11e6-b102-f0761cc1bacd";
		
		MeetingTemplate meetingTemplate;
		try {
			meetingTemplate = ts.getTemplateById(templateId);
			
			System.out.println(meetingTemplate.toString());
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 测试删除会议通知的模板
	 */
	@Test
	
	public void testDeleteTemplate(){
		
		String templateId = "fef1abd0-5038-11e6-b102-f0761cc1bacd";
		
		try {
			ts.deleteTemplate(templateId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
