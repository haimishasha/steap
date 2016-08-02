package com.thinkPro.steap.bean.evaluation;

public class SpecialistEvaluation {
	private String reviewId; // 专家评估编号
	private String specialistId; // 专家编号
	private String projectId; // 项目编号
	private String reviewSuggestion; // 评估意见
	private String remark; // 备注

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getReviewSuggestion() {
		return reviewSuggestion;
	}

	public void setReviewSuggestion(String reviewSuggestion) {
		this.reviewSuggestion = reviewSuggestion;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SpecialistEvaluation [reviewId=" + reviewId + ", specialistId="
				+ specialistId + ", projectId=" + projectId
				+ ", reviewSuggestion=" + reviewSuggestion + ", remark="
				+ remark + "]";
	}

}
