package com.thinkPro.steap.bean.meeting;

/**
 * 查询专家用到的条件
 * 查询条件
 */
public class SpecialistCondition {
	private String name;// 专家姓名
	private String engageDomain;// 所属领域
	private int pageBegin;// 开始记录数
	private int pageSize;// 每页显示行数

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEngageDomain() {
		return engageDomain;
	}

	public void setEngageDomain(String engageDomain) {
		this.engageDomain = engageDomain;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "SpecialistCondition [name=" + name + ", engageDomain="
				+ engageDomain + ", pageBegin=" + pageBegin + ", pageSize="
				+ pageSize + "]";
	}

}
