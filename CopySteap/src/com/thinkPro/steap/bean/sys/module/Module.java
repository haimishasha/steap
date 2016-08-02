package com.thinkPro.steap.bean.sys.module;

public class Module {
	private String id;
	private String moduleId;
	private String moduleName;
	private String moduleURL;
	private String memo1;
	private String momo2;
	private Boolean inUse;
	private int sortNo;
	private int menuClass;
	private int flag;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleURL() {
		return moduleURL;
	}
	public void setModuleURL(String moduleURL) {
		this.moduleURL = moduleURL;
	}
	public String getMemo1() {
		return memo1;
	}
	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}
	public String getMomo2() {
		return momo2;
	}
	public void setMomo2(String momo2) {
		this.momo2 = momo2;
	}
	public Boolean getInUse() {
		return inUse;
	}
	public void setInUse(Boolean inUse) {
		this.inUse = inUse;
	}
	public int getSortNo() {
		return sortNo;
	}
	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}
	public int getMenuClass() {
		return menuClass;
	}
	public void setMenuClass(int menuClass) {
		this.menuClass = menuClass;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		return "Module [id=" + id + ", moduleId=" + moduleId + ", moduleName="
				+ moduleName + ", moduleURL=" + moduleURL + ", memo1=" + memo1
				+ ", momo2=" + momo2 + ", inUse=" + inUse + ", sortNo="
				+ sortNo + ", menuClass=" + menuClass + ", flag=" + flag + "]";
	}
}
