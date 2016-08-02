package com.thinkPro.steap.bean.sys.user;

public class UserPrivilege {

	private String modelId;  //模块Id
	private String modelName; //模块名字
	private String modelUrl;
	
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelUrl() {
		return modelUrl;
	}
	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
	}
	@Override
	public String toString() {
		return "UserPrivilege [ modelId=" + modelId + ", modelName="
				+ modelName + ", modelUrl=" + modelUrl + "]";
	}
	
}