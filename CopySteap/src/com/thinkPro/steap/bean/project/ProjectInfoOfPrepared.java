package com.thinkPro.steap.bean.project;

public class ProjectInfoOfPrepared {
	private String projectId;  // 项目编号
	private String projectName; // 项目名称
	private String applicant;  // 申请单位
	private String applicationDate;//申请日期
	private String domain; // 领域
	private ProjectRecord projectRecord;   //项目登记
	private ProjectCharge projectCharge;   //确定负责部门
	private ProjectReceive projectReceive; //领取项目材料
	private ProjectCensor projectCensor; //项目审查
	private EnterpriseInspect enterpriseInspect;//项目考察
	private AuditInfo auditInfo;//项目审计
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
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
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
	public EnterpriseInspect getEnterpriseInspect() {
		return enterpriseInspect;
	}
	public void setEnterpriseInspect(EnterpriseInspect enterpriseInspect) {
		this.enterpriseInspect = enterpriseInspect;
	}
	public AuditInfo getAuditInfo() {
		return auditInfo;
	}
	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}
	@Override
	public String toString() {
		return "ProjectInfoOfPrepared [projectId=" + projectId
				+ ", projectName=" + projectName + ", applicant=" + applicant
				+ ", applicationDate=" + applicationDate + ", domain=" + domain
				+ ", projectRecord=" + projectRecord + ", projectCharge="
				+ projectCharge + ", projectReceive=" + projectReceive
				+ ", projectCensor=" + projectCensor + ", enterpriseInspect="
				+ enterpriseInspect + ", auditInfo=" + auditInfo + "]";
	}
	
	
	
}
