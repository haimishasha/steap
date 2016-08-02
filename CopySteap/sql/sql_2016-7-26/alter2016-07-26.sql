/**
 * 项目接受视图：第一模块项目接受阶段的项目的所有信息
 */
CREATE
OR REPLACE VIEW V_PROJECT_ACCEPT_INFO AS SELECT
	tpbi.*, 
	pa.recordDate,
	pa.recordPerson,
	pa.chargePerson,
	pa.chargeUnit,
	pa.distributionDate,
	pa.receiveDate,
	pa.receivePerson,
	pa.receiveResult,
	pa.remark1,
	pa.remark2,
	pa.remark3,
	pc.censorDate,
	pc.censorPerson,
	pc.censorResult,
	ei.inspectPerson,
	ei.inspectDate,
	ei.inspectResult,
	ei.isAudit,
	ia.financeUnit,
	ia.auditingPerson,
	ia.auditDate
FROM
	t_project_base_info tpbi
LEFT JOIN project_accept pa on tpbi.projectId = pa.projectId
LEFT JOIN project_censor pc on tpbi.projectId = pc.projectId
LEFT JOIN enterprise_inspect ei on tpbi.projectId = ei.projectId
LEFT JOIN inspect_audit ia ON ei.inspectId = ia.inspectId 
