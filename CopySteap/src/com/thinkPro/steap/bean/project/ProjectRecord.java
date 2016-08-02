package com.thinkPro.steap.bean.project;


public class ProjectRecord {
	private String acceptId; // 项目接收编号
	private String projectId; // 项目编号
	private String recordDate; // 登记日期
	private String recordPerson; // 登记人
	private String remark1;

	public String getAcceptId() {
		return acceptId;
	}

	public void setAcceptId(String acceptId) {
		this.acceptId = acceptId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getRecordPerson() {
		return recordPerson;
	}

	public void setRecordPerson(String recordPerson) {
		this.recordPerson = recordPerson;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	@Override
	public String toString() {
		return "ProjectRecord [acceptId=" + acceptId + ", projectId="
				+ projectId + ", recordDate=" + recordDate + ", recordPerson="
				+ recordPerson + ", remark1=" + remark1 + "]";
	}

}
