package com.thinkPro.steap.bean.meeting;
import java.util.List;

import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.bean.material.Picture;
/**
 * 企业准备材料管理（验收意见初稿和真实性承诺书）
 * 用于显示数据
 */
public class ProjectPreMaterialInfo {
	private String projectId;// 项目编号
	private String projectName;// 项目名称
	private String applicant;// 申请单位
	private String domain;// 所属领域
	private float projectFunds;// 项目经费
	private Material material;//验收意见初稿
	private List<Picture> pictureList;// 真实性承诺状态
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
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public float getProjectFunds() {
		return projectFunds;
	}
	public void setProjectFunds(float projectFunds) {
		this.projectFunds = projectFunds;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public List<Picture> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}
	@Override
	public String toString() {
		return "ProjectPreMaterialInfo [projectId=" + projectId
				+ ", projectName=" + projectName + ", applicant=" + applicant
				+ ", domain=" + domain + ", projectFunds=" + projectFunds
				+ ", material=" + material + ", pictureList=" + pictureList
				+ "]";
	}

	
}
