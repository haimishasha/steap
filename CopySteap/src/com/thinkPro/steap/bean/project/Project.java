package com.thinkPro.steap.bean.project;



public class Project {
	private String projectId;  // 项目编号
	private String projectName; // 项目名称
	private String applicant;  // 申请单位
	private String applicationDate; // 申请日期
	private String contactPerson; // 联系人
	private String telephone; // 联系电话
	private String domain; // 领域
	private float projectFunds; // 经费
	private String status; // 状态
	private boolean certificate; // 是否发放证书
	private String remark; // 备注

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public float getProjectFunds() {
		return projectFunds;
	}

	public void setProjectFunds(float projetFunds) {
		this.projectFunds = projetFunds;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isCertificate() {
		return certificate;
	}

	public void setCertificate(boolean certificate) {
		this.certificate = certificate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName="
				+ projectName + ", applicant=" + applicant
				+ ", applicationDate=" + applicationDate + ", contactPerson="
				+ contactPerson + ", telephone=" + telephone + ", domain="
				+ domain + ", projetFunds=" + projectFunds + ", status="
				+ status + ", certificate=" + certificate + ", remark="
				+ remark + "]";
	}
}
