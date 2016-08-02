package com.thinkPro.steap.bean.sys.unit;

public class TBaseUnitInfo {
	private String unitId;
	private String unitName;
	private String upUnitId;
	private String description;

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUpUnitId() {
		return upUnitId;
	}

	public void setUpUnitId(String upUnitId) {
		this.upUnitId = upUnitId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TBaseUnitInfo [unitId=" + unitId + ", unitName=" + unitName
				+ ", upUnitId=" + upUnitId + ", description=" + description
				+ "]";
	}

}
