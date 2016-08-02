package com.thinkPro.steap.bean.evaluation;

public class EvaluationInfo {
	private String specialistId;
	private String name;
	private String workUnit;
	private String reviewSuggestion;

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getReviewSuggestion() {
		return reviewSuggestion;
	}

	public void setReviewSuggestion(String reviewSuggestion) {
		this.reviewSuggestion = reviewSuggestion;
	}

	@Override
	public String toString() {
		return "EvaluationInfo [specialistId=" + specialistId + ", name="
				+ name + ", workUnit=" + workUnit + ", reviewSuggestion="
				+ reviewSuggestion + "]";
	}

}
