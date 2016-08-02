package com.thinkPro.steap.bean.project;


public class ProjectAccept {

	private String projectId;  // 项目编号
	private String projectName; // 项目名称
	private String applicant;  // 申请人
	private String domain; // 领域
	private String status;//状态
	private ProjectRecord projectRecord;   //项目登记
	private ProjectCharge projectCharge;   //确定负责部门
	private ProjectReceive projectReceive; //领取项目材料
	private ProjectCensor projectCensor;  
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
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ProjectRecord getProjectRecord() {
		return projectRecord;
	}
	public void setProjectRecord(ProjectRecord projectRecord) {
		this.projectRecord = projectRecord;
	}
	public ProjectCharge getProjectCharge() {
		return projectCharge;
	}
	public void setProjectCharge(ProjectCharge projectCharge) {
		this.projectCharge = projectCharge;
	}
	public ProjectReceive getProjectReceive() {
		return projectReceive;
	}
	public void setProjectReceive(ProjectReceive projectReceive) {
		this.projectReceive = projectReceive;
	}
	
	public ProjectCensor getProjectCensor() {
		return projectCensor;
	}
	public void setProjectCensor(ProjectCensor projectCensor) {
		this.projectCensor = projectCensor;
	}
	@Override
	public String toString() {
		return "ProjectAccept [projectId=" + projectId + ", projectName="
				+ projectName + ", applicant=" + applicant + ", domain="
				+ domain + ", status=" + status + ", projectRecord="
				+ projectRecord + ", projectCharge=" + projectCharge
				+ ", projectReceive=" + projectReceive + ", projectCensor="
				+ projectCensor + "]";
	}
	
}
