package com.thinkPro.steap.bean.project;

public class ProjectVerify {
	private String verifyId; // 审核编号
	private String projectId; // 项目编号
	private String completeDescription; // 资料完善说明
	private int verifyFileNum; // 完善文件数
	private String verifyPerson; // 审核人
	private String verifyDate; // 审核日期
	private String verifyResult; // 审核结果
	private String remark; // 备注

	public String getVerifyId() {
		return verifyId;
	}

	public void setVerifyId(String verifyId) {
		this.verifyId = verifyId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getCompleteDescription() {
		return completeDescription;
	}

	public void setCompleteDescription(String completeDescription) {
		this.completeDescription = completeDescription;
	}

	public int getVerifyFileNum() {
		return verifyFileNum;
	}

	public void setVerifyFileNum(int verifyFileNum) {
		this.verifyFileNum = verifyFileNum;
	}

	public String getVerifyPerson() {
		return verifyPerson;
	}

	public void setVerifyPerson(String verifyPerson) {
		this.verifyPerson = verifyPerson;
	}

	public String getVerifyDate() {
		return verifyDate;
	}

	public void setVerifyDate(String verifyDate) {
		this.verifyDate = verifyDate;
	}

	public String getVerifyResult() {
		return verifyResult;
	}

	public void setVerifyResult(String verifyResult) {
		this.verifyResult = verifyResult;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ProjectVerify [verifyId=" + verifyId + ", projectId="
				+ projectId + ", completeDescription=" + completeDescription
				+ ", verifyFileNum=" + verifyFileNum + ", verifyPerson="
				+ verifyPerson + ", verifyDate=" + verifyDate
				+ ", verifyResult=" + verifyResult + ", remark=" + remark + "]";
	}

}
