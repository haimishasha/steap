package com.thinkPro.steap.bean.project;


public class IssueCertificate {
	private String issueId;
	private String projectId;
	private String issuePerson;
	private String issueDate;
	private String remark;

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getIssuePerson() {
		return issuePerson;
	}

	public void setIssuePerson(String issuePerson) {
		this.issuePerson = issuePerson;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "IssueCertificate [issueId=" + issueId + ", projectId="
				+ projectId + ", issuePerson=" + issuePerson + ", issueDate="
				+ issueDate + ", remark=" + remark + "]";
	}

}
