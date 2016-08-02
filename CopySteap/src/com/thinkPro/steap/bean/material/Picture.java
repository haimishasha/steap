package com.thinkPro.steap.bean.material;

import java.sql.Timestamp;

public class Picture {
	private String pictureId; // 图片编号
	private String projectId; // 项目编号
	private String pictureType; // 图片类型
	private String originalName; // 原始名称
	private String currentName; // 当前名称
	private Timestamp uploadTime; // 上传时间
	private String pictureSize; // 图片大小
	private String remark; // 备注

	public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getPictureType() {
		return pictureType;
	}

	public void setPictureType(String pictureType) {
		this.pictureType = pictureType;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getCurrentName() {
		return currentName;
	}

	public void setCurrentName(String currentName) {
		this.currentName = currentName;
	}

	public Timestamp getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getPictureSize() {
		return pictureSize;
	}

	public void setPictureSize(String pictureSize) {
		this.pictureSize = pictureSize;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Picture [pictureId=" + pictureId + ", projectId=" + projectId
				+ ", pictureType=" + pictureType + ", originalName="
				+ originalName + ", currentName=" + currentName
				+ ", uploadTime=" + uploadTime + ", pictureSize=" + pictureSize
				+ ", remark=" + remark + "]";
	}

}
