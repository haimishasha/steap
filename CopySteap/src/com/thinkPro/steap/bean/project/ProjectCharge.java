package com.thinkPro.steap.bean.project;


public class ProjectCharge {
	private String projectId; // 项目编号
	private String chargeUnit; // 负责部门
	private String chargePerson; // 负责人
	private String destributionDate; // 分配日期
	private String remark2;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getChargeUnit() {
		return chargeUnit;
	}

	public void setChargeUnit(String chargeUnit) {
		this.chargeUnit = chargeUnit;
	}

	public String getChargePerson() {
		return chargePerson;
	}

	public void setChargePerson(String chargePerson) {
		this.chargePerson = chargePerson;
	}

	public String getDestributionDate() {
		return destributionDate;
	}

	public void setDestributionDate(String destributionDate) {
		this.destributionDate = destributionDate;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	@Override
	public String toString() {
		return "ProjectCharge [projectId=" + projectId + ", chargeUnit="
				+ chargeUnit + ", chargePerson=" + chargePerson
				+ ", destributionDate=" + destributionDate + ", remark2="
				+ remark2 + "]";
	}

}
