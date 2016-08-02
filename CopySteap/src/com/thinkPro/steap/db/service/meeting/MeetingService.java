package com.thinkPro.steap.db.service.meeting;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.meeting.EnterpriseNotify;
import com.thinkPro.steap.bean.meeting.InstitutionNotify;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.bean.meeting.MeetingCondition;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.base.meeting.MeetingBase;

/**
 * 这个类主要负责三方面的数据库服务层操作
 * 1.关于会议增删改查的数据库操作
 * 2.通知负责项目的企业 的数据库操作
 * 3.通知机构相关人员    的数据库操作  
 * 
 */
public class MeetingService {
	
private MeetingBase meetingBase;
	
	public MeetingService() {
		
		meetingBase = new MeetingBase();
	}
	/* -------------------------START BY HaoShaSha -------------------*/
	
	/*****************************************************************************/
	/*******************     1.关于会议增删改查的数据库操作               ***************************/
	/*****************************************************************************/
	
	/**
	 * 创建会议+创建的会议对应的项目信息
	 * @param meeting
	 * @return
	 */
	public boolean addMeeting(Meeting meeting,List<String> projectIds) throws SQLException{
		 
		if(meeting!=null && projectIds!=null && projectIds.size()>0){
			
			//创建一条会议信息
			 
			 boolean result = meetingBase.addMeeting(meeting) > 0 ? true : false;
		
			 if(result){
				 
				 //创建会议对应的项目信息（会议项目表）
				 
				 Map<String,Object> projectMeeting = new HashMap<String, Object>(); 
				 
				 projectMeeting.put("meetingId",meeting.getMeetingId());
				 
				 projectMeeting.put("projectIds",projectIds);
					
				 result = meetingBase.addProjectMeeting(projectMeeting) > 0 ? true : false;
					
			 }
			 return result;
			 
		}else{
			
			return false;
		}
		 
	}
	/**
	 * 根据会议编号删除会议项目信息(Delete)
	 * @return
	 */
	public boolean deleteMeeting(String meetingId) throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(meetingId);
		
		if(result){
			
			return meetingBase.deleteMeeting(meetingId)> 0 ? true : false;
		
		}else{
			
			return false;
		}
		
	}
	/**
	 * 修改会议的状态  
	 * @param meetingStatus中的值应该是  (会议编号，会议状态)
	 * （meetingId,meetingStatus）
	 * @return
	 */
	public boolean updateMeetingStatus(Map<String,Object> meetingStatus) throws SQLException{
		
		if(meetingStatus!=null && meetingStatus.size()==2){
			
			//此处应该补充，需要先从字典表中查找出对应的状态，再进行更新操作
			
			return meetingBase.updateMeetingStatus(meetingStatus)>0 ? true : false;
		
		}else{
			
			return false;
		}
		
	}
	/**
	 * 修改会议的通知
	 * @param meetingNotice中的值应该是  (会议编号，会议通知)
	 * （meetingId,meetingNotice）
	 * @return
	 */
	public boolean updateMeetingNotice(Map<String,Object> meetingNotice) throws SQLException{
		
		if(meetingNotice!=null && meetingNotice.size()==2){
			
			return meetingBase.updateMeetingNotice(meetingNotice)>0 ? true : false;
		
		}else{
			
			return false;
		}
		
		
	}
	
	/**
	 * 根据条件查询会议信息
	 * @param meetingCondition（会议状态+会议日期+页码+每页显示的行数）
	 * (meetingStatus,meetingTime,pageBegin,pageSize)
	 * @return
	 */
	public List<Meeting> getMeetingInfos(MeetingCondition condition) throws SQLException{
		
		//此处应该补充，需要先从字典表中查找出对应的状态，再进行更新操作
		
		if(condition!=null){
			
			return meetingBase.getMeetingInfos(condition);
		
		}else{
			
			return null;
		}
		
	}
	
	/*****************************************************************************/
	/*******************     2.通知负责项目的企业 的数据库操作           ***************************/
	/*****************************************************************************/
	
	/**
	 * 根据meetingId查询某一个会议涉及到的项目的信息 主要是针对项目信息+通知日期+通知方式 
	 * @param meetingId
	 * @return
	 */
	public List<EnterpriseNotify> getEnterpriseNotify(String meetingId) throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(meetingId);
		
		if(result){
			
			return meetingBase.getEnterpriseNotify(meetingId);
		
		}else{
			
			return null;
		}
		
	}
	
	/**
	 * 批量更新通知企业的信息(通知方式,通知时间)
	 * @param enterpriseNotify
	 * （map里面的信息是  会议编号，项目编号，通知日期，通知方式）
	 * (meetingId,projectId,notifyDate,notifyMethod)
	 * @return
	 */
	public boolean updateProjectMeeting(List<Map<String,Object>> enterpriseNotify) throws SQLException{
		
		if(enterpriseNotify!=null && enterpriseNotify.size()>0){
			
			return meetingBase.updateProjectMeeting(enterpriseNotify)>0 ? true : false;
		
		}else{
			
			return false;
		}
		
	}

	
	/*****************************************************************************/
	/*******************     3.关于通知机构相关人员的数据库操作        ***************************/
	/*****************************************************************************/
	
	
	/**
	 * 根据会议编号查询 通知相关人员 的基本情况
	 * @param meetingId 会议编号
	 * @return InstitutionNotify 通知机构相关人员
	 */
	public List<InstitutionNotify> getInstitutionNotify(String meetingId) throws SQLException{
		
		//机构的话，如果数据库字段保持不变的话，(即机构通知表使用的是institutionName)
		//查询字典的操作可以跳过，如果要变为 institutionId 则需要先关联字典表
		boolean result = ValidateCheck.isNotNull(meetingId);
		
		if(result){
			
			return meetingBase.getInstitutionNotify(meetingId);
		
		}else{
			
			return null;
		}
		
	}
	/**
	 * 批量插入通知相关人员的基本情况
	 * @param institutionNotify
	 * @return
	 */
	public boolean addInstitutionNotify(List<InstitutionNotify> institutionNotify) throws SQLException{
		
		//机构的话，如果数据库字段保持不变的话，(即机构通知表使用的是institutionName)
		//查询字典的操作可以跳过，如果要变为 institutionId 则需要先关联字典表 包装后再保存
		//但是这样会严重影响性能
		if(institutionNotify!=null && institutionNotify.size()>0){
			
			return meetingBase.addInstitutionNotify(institutionNotify)>0 ? true : false;
						
		}else{
			
			return false;
		}
		
	}
	/**
	 * 批量更新 通知相关人员 的基本情况
	 * @param enterpriseNotify
	 * （map里面的信息是  会议编号，项目编号，通知日期，通知方式）
	 * (notifyId,notifyDate,notifyMethod)
	 * @return
	 * 暂时不需要
	 */
	public boolean updateInstitutionNotify(List<Map<String,Object>> enterpriseNotify) throws SQLException{
		
		if(enterpriseNotify!=null && enterpriseNotify.size()>0){
			
			return meetingBase.updateInstitutionNotify(enterpriseNotify)>0 ? true : false;
		
		}else{
			
			return false;
		}
		
	}
	/* -------------------------END BY HaoShaSha -------------------*/
	/**
	 * 根据专家编号和会议状态查询参加的会议信息
	 * @param mapInfo 专家编号、会议状态
	 * @return 会议信息
	 * @throws SQLException
	 */
	public Meeting getMeetingByMapInfo(Map<String, Object> mapInfo) throws SQLException {
		if(mapInfo.size() != 0) {
			return meetingBase.getMeetingByMapInfo(mapInfo);
		}
		return null;
	}
	
	/**
	 * 根据会议主持人编号和会议状态查询已经主持过的会议信息集合
	 * @param hostId 
	 * @return
	 * @throws SQLException
	 */
	public List<Meeting> getMeetingListByHostId(Map<String, Object> meeting_host) throws SQLException {
		if(meeting_host.size() != 0) {
			return meetingBase.getMeetingListByHostId(meeting_host);
		}
		return null;
	}
	
	/**
	 * 根据会议主持人编号和会议状态查询会议主持人当前要主持的会议
	 * @param meeting_host 主持人编号、会议状态
	 * @return 待主持的会议信息
	 * @throws SQLException
	 */
	public Meeting getMeetingByHostId(Map<String, Object> meeting_host) throws SQLException {
		if(meeting_host.size() != 0) {
			return meetingBase.getMeetingByHostId(meeting_host);
		}
		return null;
	}
}
