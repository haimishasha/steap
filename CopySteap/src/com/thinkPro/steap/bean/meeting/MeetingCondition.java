package com.thinkPro.steap.bean.meeting;

import java.sql.Timestamp;

/**
 * 查询会议信息的条件
 * 用于查询
 */
public class MeetingCondition {
	private String meetingStatus;// 会议状态
	private Timestamp meetingTime;// 会议时间
	private int pageBegin=0;// 开始记录数
	private int pageSize=10;// 每页显示行数

	public String getMeetingStatus() {
		return meetingStatus;
	}

	public void setMeetingStatus(String meetingStatus) {
		this.meetingStatus = meetingStatus;
	}

	public Timestamp getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(Timestamp meetingTime) {
		this.meetingTime = meetingTime;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "MeetingCondition [meetingStatus=" + meetingStatus
				+ ", meetingTime=" + meetingTime + ", pageBegin=" + pageBegin
				+ ", pageSize=" + pageSize + "]";
	}
}
