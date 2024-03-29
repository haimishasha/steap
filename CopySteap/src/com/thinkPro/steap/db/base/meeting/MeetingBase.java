package com.thinkPro.steap.db.base.meeting;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.meeting.EnterpriseNotify;
import com.thinkPro.steap.bean.meeting.InstitutionNotify;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.bean.meeting.MeetingCondition;
import com.thinkPro.steap.db.mapper.meeting.IMeetingMapper;
/**
 * 这个类主要负责三方面的数据库基本层操作
 * 1.关于会议增删改查的数据库操作
 * 2.通知负责项目的企业 的数据库操作
 * 3.通知机构相关人员    的数据库操作  
 * 
 */
public class MeetingBase implements IMeetingMapper{
	
	private ApplicationContext applicationContext;

	private IMeetingMapper iMeetingMapper;

	public MeetingBase() {

		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		iMeetingMapper = (IMeetingMapper) applicationContext
				.getBean("IMeetingMapper");
	}
	
	/*****************************************************************************/
	/*******************     1.关于会议增删改查的数据库操作               ***************************/
	/*****************************************************************************/
	
	/**
	 * 创建会议
	 * @param meeting
	 * @return
	 */
	public int addMeeting(Meeting meeting) throws SQLException{
		
		return iMeetingMapper.addMeeting(meeting);
	}
	
	/**
	 * 插入新创建的会议对应的项目信息
	 * @param projectMeeting
	 * @return
	 */
	
	public int addProjectMeeting(Map<String,Object> projectMeeting) throws SQLException{
		
		return iMeetingMapper.addProjectMeeting(projectMeeting);
	}
	
	/**
	 * 删除会议(Delete)+级联删除会议项目信息(Delete)
	 * @return
	 */
	public int deleteMeeting(String meetingId) throws SQLException{
		
		return iMeetingMapper.deleteMeeting(meetingId);
	}
	
	/**
	 * 修改会议的状态 
	 * @param meetingStatus
	 * @return
	 */
	public int updateMeetingStatus(Map<String,Object> meetingStatus) throws SQLException{
		
		return iMeetingMapper.updateMeetingStatus(meetingStatus);
	}
	/**
	 * 修改会议的通知
	 * @param meetingNotice
	 * @return
	 */
	public int updateMeetingNotice(Map<String,Object> meetingNotice) throws SQLException{
		
		return iMeetingMapper.updateMeetingNotice(meetingNotice);
	}

	/**
	 * 按条件分页查询会议基本信息
	 * （会议状态+会议日期+页码+每页显示的行数）
	 * @param meetingCondition
	 * @return
	 */
	public List<Meeting> getMeetingInfos(MeetingCondition condition) throws SQLException{
		
		return iMeetingMapper.getMeetingInfos(condition);
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
		
		return iMeetingMapper.getEnterpriseNotify(meetingId);
	}

	/**
	 * 批量更新通知企业的信息(通知方式,通知时间)
	 * @param enterpriseNotify（map里面的信息是  会议编号，项目编号，通知日期，通知方式）
	 * @return
	 */
	public int updateProjectMeeting(List<Map<String,Object>> enterpriseNotify) throws SQLException{
		
		return iMeetingMapper.updateProjectMeeting(enterpriseNotify);
	}

	/*****************************************************************************/
	/*******************     3.关于通知机构相关人员的数据库操作        ***************************/
	/*****************************************************************************/
	
	/**
	 * 查询通知相关人员的基本情况
	 * @return
	 */
	public List<InstitutionNotify> getInstitutionNotify(String meetingId) throws SQLException{
		
		return iMeetingMapper.getInstitutionNotify(meetingId);
	}
	
	/**
	 * 批量插入通知相关人员的基本情况
	 * @param institutionNotify
	 * @return
	 */
	public int addInstitutionNotify(List<InstitutionNotify> institutionNotify) throws SQLException{
		
		return iMeetingMapper.addInstitutionNotify(institutionNotify);
	}
	
	/**
	 * 批量更新通知相关人员的基本情况
	 * @param enterpriseNotify
	 * @return
	 */
	public int updateInstitutionNotify(List<Map<String,Object>> enterpriseNotify) throws SQLException{
		
		return iMeetingMapper.updateInstitutionNotify(enterpriseNotify);
	}

	/**
	 * 根据专家编号和会议状态查询参加的会议信息
	 * @param mapInfo 专家编号、会议状态
	 * @return 会议信息
	 * @throws SQLException
	 */
	public Meeting getMeetingByMapInfo(Map<String, Object> mapInfo) throws SQLException {
		return iMeetingMapper.getMeetingByMapInfo(mapInfo);
	}
	
	/**
	 * 根据会议主持人编号和会议状态查询已经主持过的会议信息集合
	 * @param hostId 
	 * @return
	 * @throws SQLException
	 */
	public List<Meeting> getMeetingListByHostId(Map<String, Object> meeting_host) throws SQLException {
		return iMeetingMapper.getMeetingListByHostId(meeting_host);
	}
	
	/**
	 * 根据会议主持人编号和会议状态查询会议主持人当前要主持的会议
	 * @param meeting_host 主持人编号、会议状态
	 * @return 待主持的会议信息
	 * @throws SQLException
	 */
	public Meeting getMeetingByHostId(Map<String, Object> meeting_host) throws SQLException {
		return iMeetingMapper.getMeetingByHostId(meeting_host);
	}
}
