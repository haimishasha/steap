package com.thinkPro.steap.db.base.meeting;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.meeting.MeetingTemplate;
import com.thinkPro.steap.db.mapper.meeting.ITemplateMapper;
/**
 * 这个类主要负责会议通知的数据库基本层操作
 */
public class TemplateBase implements ITemplateMapper{
	
	private ApplicationContext applicationContext;

	private ITemplateMapper iTemplateMapper;

	public TemplateBase() {

		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		iTemplateMapper = (ITemplateMapper) applicationContext
				.getBean("ITemplateMapper");
	}
	
	/**
	 * 查询所有的会议通知的模板
	 * @return
	 */
	public List<MeetingTemplate> getAllTemplate() throws SQLException{
		
		return iTemplateMapper.getAllTemplate();
	}
	
	/**
	 * 根据条件进行查询会议通知的模板
	 * @param templateId
	 * @return
	 */
	public MeetingTemplate getTemplateById(String templateId) throws SQLException{
		
		return iTemplateMapper.getTemplateById(templateId);
	}
	
	/**
	 * 创建会议通知的模板 
	 * @param meetingTemplate
	 * @return
	 */
	public int addTemplate(MeetingTemplate meetingTemplate) throws SQLException{
		
		return iTemplateMapper.addTemplate(meetingTemplate);
	}
	
	/**
	 * 修改会议通知的模板
	 * @param meetingTemplate
	 * @return
	 */
	public int updateTrainPlanInfo(MeetingTemplate meetingTemplate) throws SQLException{
		
		return iTemplateMapper.updateTrainPlanInfo(meetingTemplate);
	}
	
	/**
	 * 删除会议通知的模板
	 * @param templateId
	 * @return
	 */
	public int deleteTemplate(String templateId) throws SQLException{
		
		return iTemplateMapper.deleteTemplate(templateId);
	}
}
