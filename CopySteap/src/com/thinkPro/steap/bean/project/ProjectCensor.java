package com.thinkPro.steap.bean.project;


public class ProjectCensor {
	private String censorId; // 审查编号
	private String projectId; // 项目编号
	private String censorDate; // 审查日期
	private String censorPerson; // 审查人
	private String censorResult; // 审查结果

	public String getCensorId() {
		return censorId;
	}

	public void setCensorId(String censorId) {
		this.censorId = censorId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getCensorDate() {
		return censorDate;
	}

	public void setCensorDate(String censorDate) {
		this.censorDate = censorDate;
	}

	public String getCensorPerson() {
		return censorPerson;
	}

	public void setCensorPerson(String censorPerson) {
		this.censorPerson = censorPerson;
	}

	public String getCensorResult() {
		return censorResult;
	}

	public void setCensorResult(String censorResult) {
		this.censorResult = censorResult;
	}

	@Override
	public String toString() {
		return "ProjectCensor [censorId=" + censorId + ", projectId="
				+ projectId + ", censorDate=" + censorDate + ", censorPerson="
				+ censorPerson + ", censorResult=" + censorResult + "]";
	}

}
