package com.thinkPro.steap.bean.meeting;

import java.util.Date;
/**
 * 查询项目基本信息（登记日期，考察日期）
 * 用于显示信息
 */
public class ProjectInfoResult {
	private String projectId;// 项目编号
	private String projectName;// 项目名称
	private String applicant;// 申请单位
	private String domain;// 所属领域
	private Date recordDate;// 登记日期
	private float projectFunds;// 项目经费
	private Date inspectDate;// 考察日期

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

	

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	

	public Date getInspectDate() {
		return inspectDate;
	}

	public void setInspectDate(Date inspectDate) {
		this.inspectDate = inspectDate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SearchProjectInfoResult=[projectId=" + projectId
				+ ",projectName=" + projectName + ",applicant=" + applicant
				+ ",domain=" + domain + ",recordDate=" + recordDate
				+ ",projectFunds=" + projectFunds + ",inspectDate=" + inspectDate
				+ "]";
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public float getProjectFunds() {
		return projectFunds;
	}

	public void setProjectFunds(float projectFunds) {
		this.projectFunds = projectFunds;
	}

}
