package com.thinkPro.steap.bean.project;


public class AuditInfo {
	private String auditId; // 审计编号
	private String inspectId; // 考察编号
	private String financeUnit; // 财务审计单位
	private String auditingPerson; // 审计人
	private String auditDate; // 审计日期

	public String getAuditId() {
		return auditId;
	}

	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}

	public String getInspectId() {
		return inspectId;
	}

	public void setInspectId(String inspectId) {
		this.inspectId = inspectId;
	}

	public String getFinanceUnit() {
		return financeUnit;
	}

	public void setFinanceUnit(String financeUnit) {
		this.financeUnit = financeUnit;
	}

	public String getAuditingPerson() {
		return auditingPerson;
	}

	public void setAuditingPerson(String auditingPerson) {
		this.auditingPerson = auditingPerson;
	}

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

	@Override
	public String toString() {
		return "AuditInfo [auditId=" + auditId + ", inspectId=" + inspectId
				+ ", financeUnit=" + financeUnit + ", auditingPerson="
				+ auditingPerson + ", auditDate=" + auditDate + "]";
	}

}
