package com.thinkPro.steap.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.thinkPro.steap.bean.meeting.EnterpriseNotify;
import com.thinkPro.steap.bean.meeting.InstitutionNotify;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.bean.meeting.MeetingCondition;
import com.thinkPro.steap.db.service.meeting.MeetingService;

public class MeetingTest {
	
	MeetingService ms = new MeetingService();
	
	/*****************************************************************************/
	/*******************     1.关于会议增删改查的数据库测试               ***************************/
	/*****************************************************************************/
	
	/**
	 * 测试创建会议
	 */
	@Test
	public void testInsertMeeting() {
			
		System.out.println("===========create meeting ==========");
		
		Meeting meeting = new Meeting();
		
		meeting.setMeetingName("2016年第一届IT项目评估大会");
		
		meeting.setMeetingPlace("太原科技大学");
		
		meeting.setMeetingTime("2016-05-06 12:30:02");
		
		List<String> projectIds = new ArrayList<String>();
		
		projectIds.add("P1000001");
		
		projectIds.add("P1000002");
		
		try {
			ms.addMeeting(meeting,projectIds);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
	/**
	 * 测试修改会议的状态  
	 */
	@Test
	public void testUpdateMeetingStatus(){
		
		Map<String,Object> meetingStatus = new HashMap<String,Object>();
		
		String meetingId = "M100005";
		meetingStatus.put("meetingId", meetingId);
		meetingStatus.put("meetingStatus", "准备中");
		
		try {
			ms.updateMeetingStatus(meetingStatus);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 测试修改会议的通知
	 */
	@Test
	public void testUpdateMeetingNotice(){
		
		Map<String,Object> meetingStatus = new HashMap<String,Object>();
		
		String meetingId = "M100005";
		String meetingNotice = "文件名";
		meetingStatus.put("meetingId", meetingId);
		meetingStatus.put("meetingNotice", meetingNotice);
		
		try {
			ms.updateMeetingNotice(meetingStatus);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试根据会议编号删除会议
	 */
	@Test
	public void testDelete() {
		
		try {
			ms.deleteMeeting("M100005");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据条件查询会议信息
	 */
	
	@Test
	public void testSelect() {
		
		MeetingCondition condition = new MeetingCondition();
		
		//condition.setMeetingStatus("已完成");
		
		//condition.setMeetingStatus("200003");
		
		//condition.setMeetingTime(Timestamp.valueOf("2015-09-09 09:00:00"));
		
		//condition.setPageBegin(1);
		
		//condition.setPageSize(1);
		
		List<Meeting> meetings;
		try {
			meetings = ms.getMeetingInfos(condition);
			for (Meeting meeting : meetings) {
				
				System.out.print(meeting.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*****************************************************************************/
	/*******************     2.通知负责项目的企业 的数据库测试           ***************************/
	/*****************************************************************************/
	
	/**
	 * 测试根据meetingId查询某一个会议涉及到的项目的信息 主要是针对项目信息+通知日期+通知方式 
	 */
	@Test
	public void testGetEnterpriseNotify() {
	
		System.out.println("===========testGetEnterpriseNotify==========");
		
		String meetingId = "M100001";
		
		List<EnterpriseNotify> pemis;
		try {
			
			pemis = ms.getEnterpriseNotify(meetingId);
			for (EnterpriseNotify pemi : pemis) {
				
				System.out.println(pemi.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 测试批量更新通知企业的信息(通知方式,通知时间)
	 */
	@Test
	public void testUpdateProjectMeeting() {
		System.out.println("===========test UpdateProjectMeeting==========");
		String meetingId = "M100005";
		String projectId1 = "P1000001";
		String projectId2 = "P1000002";
		Map<String,Object> notify1 = new HashMap<String,Object>();
		notify1.put("meetingId", meetingId);
		notify1.put("projectId", projectId1);
		notify1.put("notifyDate", "2016-06-27");
		notify1.put("notifyMethod", "微信");
		Map<String,Object> notify2 = new HashMap<String,Object>();
		notify2.put("meetingId", meetingId);
		notify2.put("projectId", projectId2);
		notify2.put("notifyDate", "2016-06-27");
		notify2.put("notifyMethod", "QQ");
		List<Map<String,Object>> enterpriseNotify = new ArrayList<Map<String,Object>>();
		enterpriseNotify.add(notify1);
		enterpriseNotify.add(notify2);
		try {
			ms.updateProjectMeeting(enterpriseNotify);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/*****************************************************************************/
	/*******************     3.关于通知机构相关人员的数据库测试        ***************************/
	/*****************************************************************************/
	
	/**
	 * 测试 根据会议编号查询 通知相关人员 的基本情况
	 */
	@Test
	public void testGetInstitutionNotify(){
		
		String meetingId = "M100001";
		
		List<InstitutionNotify> InstitutionNotify = new ArrayList<InstitutionNotify>();
		
		try {
			
			InstitutionNotify = ms.getInstitutionNotify(meetingId);
			
			for(InstitutionNotify institution:InstitutionNotify){
				
				System.out.println(institution);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试批量插入通知相关人员的基本情况
	 */
	@Test
	public void testAddInstitutionNotify(){
		
		InstitutionNotify institutionNotify1 = new InstitutionNotify();
		institutionNotify1.setMeetingId("M100005");
		institutionNotify1.setInstitutionName("专项管理机构");
		institutionNotify1.setNotifier("黄芳");
		institutionNotify1.setNotifyDate(new Date());
		institutionNotify1.setNotifyMethod("MSN");
		institutionNotify1.setContactPerson("李彤");
		
		InstitutionNotify institutionNotify2 = new InstitutionNotify();
		institutionNotify2.setMeetingId("M100005");
		institutionNotify2.setInstitutionName("局纪检监察领导");
		institutionNotify2.setNotifier("黄芳");
		institutionNotify2.setNotifyDate(new Date());
		institutionNotify2.setNotifyMethod("MSN");
		institutionNotify2.setContactPerson("李彤");
		
		List<InstitutionNotify> is = new ArrayList<InstitutionNotify>();
		is.add(institutionNotify1);
		is.add(institutionNotify2);
		
		try {
			ms.addInstitutionNotify(is);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 测试批量更新 通知相关人员 的基本情况
	 */
	@Test
	public void testUpdateInstitutionNotify(){
		
		List<Map<String,Object>> uin = new ArrayList<Map<String,Object>>();
		Map<String,Object> enterpriseNotify1 = new HashMap<String,Object>();
		
		enterpriseNotify1.put("notifyId", "1e5bb517-5034-11e6-b102-f0761cc1bacd");
		enterpriseNotify1.put("notifyDate","2017-09-09");
		enterpriseNotify1.put("notifyMethod","微信");
		
		Map<String,Object> enterpriseNotify2 = new HashMap<String,Object>();
		
		enterpriseNotify2.put("notifyId", "1e5bbb4a-5034-11e6-b102-f0761cc1bacd");
		//enterpriseNotify2.put("notifyDate","2017-09-09");
		enterpriseNotify2.put("notifyMethod","微信");
		
		uin.add(enterpriseNotify1);
		uin.add(enterpriseNotify2);
		try {
			ms.updateInstitutionNotify(uin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
