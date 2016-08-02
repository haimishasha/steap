package com.thinkPro.steap.bean.project;

public class ProjectCondition {

	private String projectName; // 项目名称
	private String applicant;  // 申请人
	private String domain; // 领域
	private String projectFunds; //经费
	private String recordDate; // 登记日期
	private int pageSize; //每页记录数
	private int pageBegin;
	private String recordPerson;
	private String chargePerson;
	private float projectStandard=50; //项目经费,默认应该是50万;
	private String projectStatus="已现场考察";//项目的状态
	
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
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getProjectFunds() {
		return projectFunds;
	}
	public void setProjectFunds(String projectFunds) {
		this.projectFunds = projectFunds;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	
	
	public String getRecordPerson() {
		return recordPerson;
	}
	public void setRecordPerson(String recordPerson) {
		this.recordPerson = recordPerson;
	}
	public String getChargePerson() {
		return chargePerson;
	}
	public void setChargePerson(String chargePerson) {
		this.chargePerson = chargePerson;
	}
	@Override
	public String toString() {
		return "ProjectCondition [projectName=" + projectName + ", applicant="
				+ applicant + ", domain=" + domain + ", projectFunds="
				+ projectFunds + ", recordDate=" + recordDate + ", pageSize="
				+ pageSize + ", pageBegin=" + pageBegin +  ", chargePerson=" + chargePerson + "]";
	}
	public float getProjectStandard() {
		return projectStandard;
	}
	public void setProjectStandard(float projectStandard) {
		this.projectStandard = projectStandard;
	}

	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	
}
