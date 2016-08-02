package com.thinkPro.steap.bean.material;

import java.sql.Timestamp;

public class Material {
	private String fileId; // 文件编号
	private String projectId; // 项目编号编号
	private String fileType; // 文件类型
	private String originalName; // 原始名称
	private String currentName; // 当前名称
	private Timestamp uploadTime; // 上传时间
	private String fileSize; // 文件大小
	private String remark; // 备注
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
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
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Material [fileId=" + fileId + ", projectId=" + projectId
				+ ", fileType=" + fileType + ", originalName=" + originalName
				+ ", currentName=" + currentName + ", uploadTime=" + uploadTime
				+ ", fileSize=" + fileSize + ", remark=" + remark + "]";
	}

	

}
