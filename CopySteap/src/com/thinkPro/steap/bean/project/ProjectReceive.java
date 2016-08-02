package com.thinkPro.steap.bean.project;


public class ProjectReceive {

	private String projectId; // 项目编号
	private String receiveDate; // 领取日期
	private String receivePerson; // 领取人
	private String receiveResult; // 领取结果
	private String remark3;

	public String getProjectId() {
		return projectId;
	}
	
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getReceivePerson() {
		return receivePerson;
	}

	public void setReceivePerson(String receivePerson) {
		this.receivePerson = receivePerson;
	}

	public String getReceiveResult() {
		return receiveResult;
	}

	public void setReceiveResult(String receiveResult) {
		this.receiveResult = receiveResult;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	@Override
	public String toString() {
		return "ProjectReceive [projectId=" + projectId + ", receiveDate="
				+ receiveDate + ", receivePerson=" + receivePerson
				+ ", receiveResult=" + receiveResult + ", remark3=" + remark3
				+ "]";
	}

}
