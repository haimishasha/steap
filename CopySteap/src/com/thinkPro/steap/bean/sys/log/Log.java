package com.thinkPro.steap.bean.sys.log;

import java.util.Date;

public class Log {
	private String logId;
	private String actionType;
	private String actionPeople;
	private String actionUnit;
	private Date actionDate;
	private String actionResult;
	private String ip;
	private String operateObject;

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActionPeople() {
		return actionPeople;
	}

	public void setActionPeople(String actionPeople) {
		this.actionPeople = actionPeople;
	}

	public String getActionUnit() {
		return actionUnit;
	}

	public void setActionUnit(String actionUnit) {
		this.actionUnit = actionUnit;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public String getActionResult() {
		return actionResult;
	}

	public void setActionResult(String actionResult) {
		this.actionResult = actionResult;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOperateObject() {
		return operateObject;
	}

	public void setOperateObject(String operateObject) {
		this.operateObject = operateObject;
	}

	@Override
	public String toString() {
		return "Log [logId=" + logId + ", actionType=" + actionType
				+ ", actionPeople=" + actionPeople + ", actionUnit="
				+ actionUnit + ", actionDate=" + actionDate + ", actionResult="
				+ actionResult + ", ip=" + ip + ", operateObject="
				+ operateObject + "]";
	}

}
