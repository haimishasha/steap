package com.thinkPro.steap.bean.meeting;

/**
 * 通知模板
 */
public class MeetingTemplate {
	private String templateId;// 模板编号
	private String templateName;// 模班名称
	private String templateURL;// 模板路由
	private String remark;// 模板备注

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateURL() {
		return templateURL;
	}

	public void setTemplateURL(String templateURL) {
		this.templateURL = templateURL;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "MeetingTemplate [templateId=" + templateId + ", templateName="
				+ templateName + ", templateURL=" + templateURL + ", remark="
				+ remark + "]";
	}

}
