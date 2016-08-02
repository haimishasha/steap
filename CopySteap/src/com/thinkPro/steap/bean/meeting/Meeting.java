package com.thinkPro.steap.bean.meeting;

/**
 * 会议信息
 * 用于显示和保存数据
 */
public class Meeting {
	private String meetingId;// 会议编号
	private String meetingName;// 会议名称 通知前端加上
	private String meetingTime;// 会议时间
	private String meetingPlace;// 会议地点
	private String meetingStatus; // 会议状态
	private String hostId;// 会议主持人
	private String remark; // 会议备注

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public String getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}

	public String getMeetingPlace() {
		return meetingPlace;
	}

	public void setMeetingPlace(String meetingPlace) {
		this.meetingPlace = meetingPlace;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMeetingStatus() {
		return meetingStatus;
	}

	public void setMeetingStatus(String meetingStatus) {
		this.meetingStatus = meetingStatus;
	}

	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", meetingName="
				+ meetingName + ", meetingTime=" + meetingTime
				+ ", meetingPlace=" + meetingPlace + ", meetingStatus="
				+ meetingStatus + ", hostId=" + hostId + ", remark=" + remark
				+ "]";
	}

}
