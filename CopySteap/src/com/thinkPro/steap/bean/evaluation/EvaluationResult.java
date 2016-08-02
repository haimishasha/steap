package com.thinkPro.steap.bean.evaluation;

public class EvaluationResult {
	private String evaluationResultId; // 评审结果编号 
	private String projectId; // 项目编号
	private String evaluateResult; // 评审结果
	private String remark; // 备注

	public String getEvaluationResultId() {
		return evaluationResultId;
	}

	public void setEvaluationResultId(String evaluationResultId) {
		this.evaluationResultId = evaluationResultId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getEvaluateResult() {
		return evaluateResult;
	}

	public void setEvaluateResult(String evaluateResult) {
		this.evaluateResult = evaluateResult;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "EvaluationResult [evaluationResultId=" + evaluationResultId
				+ ", projectId=" + projectId + ", evaluateResult="
				+ evaluateResult + ", remark=" + remark + "]";
	}

}
