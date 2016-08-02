package com.thinkPro.steap.bean.meeting;

import java.util.Date;

/**
 * 通知企业模块，查询项目信息的结果+通知
 * 仅用于显示数据
 */
public class EnterpriseNotify {
	private String projectId;// 项目编号
	private String projectName;// 项目名称
	private String applicant;// 申请单位
	private String domain;// 所属领域
	private float projectFunds;// 项目经费
	private Date notifyDate;// 通知日期
	private String notifyMethod;// 通知方式
	private String chargePerson;// 项目负责人

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

	public float getProjectFunds() {
		return projectFunds;
	}

	public void setProjectFunds(float projectFunds) {
		this.projectFunds = projectFunds;
	}

	public Date getNotifyDate() {
		return notifyDate;
	}

	public void setNotifyDate(Date notifyDate) {
		this.notifyDate = notifyDate;
	}

	public String getNotifyMethod() {
		return notifyMethod;
	}

	public void setNotifyMethod(String notifyMethod) {
		this.notifyMethod = notifyMethod;
	}

	public String getChargePerson() {
		return chargePerson;
	}

	public void setChargePerson(String chargePerson) {
		this.chargePerson = chargePerson;
	}

	@Override
	public String toString() {
		return "EnterpriseNotify [projectId=" + projectId + ", projectName="
				+ projectName + ", applicant=" + applicant + ", domain="
				+ domain + ", projectFunds=" + projectFunds + ", nofityDate="
				+ notifyDate + ", notifyMethod=" + notifyMethod
				+ ", chargePerson=" + chargePerson + "]";
	}

}
