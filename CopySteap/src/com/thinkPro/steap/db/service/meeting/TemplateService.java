package com.thinkPro.steap.db.service.meeting;

import java.sql.SQLException;
import java.util.List;

import com.thinkPro.steap.bean.meeting.MeetingTemplate;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.base.meeting.TemplateBase;

/**
 * 这个类主要负责会议通知的数据库服务层操作
 */
public class TemplateService {
	
private TemplateBase templateBase;
	
	public TemplateService() {
		
		templateBase = new TemplateBase();
	}
	/* -------------------------START BY HaoShaSha -------------------*/
	/**
	 * 查询所有的会议通知的模板
	 * @return
	 */
	public List<MeetingTemplate> getAllTemplate() throws SQLException{
		
		return templateBase.getAllTemplate();
	}
	
	/**
	 * 根据条件进行查询会议通知的模板
	 * @param templateId
	 * @return
	 */
	public MeetingTemplate getTemplateById(String templateId) throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(templateId);
		
		if(result){
			
			return templateBase.getTemplateById(templateId);
		
		}else{
			
			return null;
		}
		
	}
	
	/**
	 * 创建会议通知的模板 
	 * @param meetingTemplate
	 * @return
	 */
	public boolean addTemplate(MeetingTemplate meetingTemplate) throws SQLException{
		
		if(meetingTemplate!=null){
			
			return templateBase.addTemplate(meetingTemplate) > 0 ? true : false;
		
		}else{
			
			return false;
		}
		
	}
	
	/**
	 * 修改会议通知的模板
	 * @param meetingTemplate
	 * @return
	 */
	public boolean updateTrainPlanInfo(MeetingTemplate meetingTemplate) throws SQLException{
		
		if(meetingTemplate!=null){
			
			return templateBase.updateTrainPlanInfo(meetingTemplate) > 0 ? true : false;
		
		}else{
			
			return false;
		}
		
	}
	
	/**
	 * 删除会议通知的模板
	 * @param templateId
	 * @return
	 */
	public boolean deleteTemplate(String templateId) throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(templateId);
		
		if(result){
		
			return templateBase.deleteTemplate(templateId) > 0 ? true : false;
		
		}else{
			
			return false;
		}
	}
	
	/* -------------------------END BY HaoShaSha -------------------*/
}
