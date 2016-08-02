package com.thinkPro.steap.bean.meeting;

import java.util.Date;

/**
 * 通知企业
 * 用于保存数据
 */
public class ProjectOfMeeting {
	private String meetingId;// 会议编号
	private String projectId;// 项目编号
	private Date nofityDate;// 通知日期
	private String notifyMethod;// 通知方式

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Date getNofityDate() {
		return nofityDate;
	}

	public void setNofityDate(Date nofityDate) {
		this.nofityDate = nofityDate;
	}

	public String getNotifyMethod() {
		return notifyMethod;
	}

	public void setNotifyMethod(String notifyMethod) {
		this.notifyMethod = notifyMethod;
	}

	@Override
	public String toString() {
		return "ProjectOfMeeting [meetingId=" + meetingId + ", projectId="
				+ projectId + ", nofityDate=" + nofityDate + ", notifyMethod="
				+ notifyMethod + "]";
	}

}
