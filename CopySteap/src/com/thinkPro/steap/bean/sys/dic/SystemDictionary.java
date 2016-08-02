package com.thinkPro.steap.bean.sys.dic;

public class SystemDictionary {
	private String dictionaryOptionId;
	private String dictionaryOptionName;
	private String upDictionaryOptionId;
	private boolean isUse;
	private String description;
	private int sortNo;
	private int flag;
	private String englishName;
	private String dataType;
	private String remark1;
	private String remark2;
	private String matchDicId;

	public String getDictionaryOptionId() {
		return dictionaryOptionId;
	}

	public void setDictionaryOptionId(String dictionaryOptionId) {
		this.dictionaryOptionId = dictionaryOptionId;
	}

	public String getDictionaryOptionName() {
		return dictionaryOptionName;
	}

	public void setDictionaryOptionName(String dictionaryOptionName) {
		this.dictionaryOptionName = dictionaryOptionName;
	}

	public String getUpDictionaryOptionId() {
		return upDictionaryOptionId;
	}

	public void setUpDictionaryOptionId(String upDictionaryOptionId) {
		this.upDictionaryOptionId = upDictionaryOptionId;
	}
	/**
	 * 这部分容易出错,再与json传递数据时候必须这么写 假如以is开头的话  读取值
	 * @return
	 */
	public boolean isUse() {
		return isUse;
	}
	/**
	 * 这部分容易出错,再与json传递数据时候必须这么写 假如以is开头的话 赋值
	 * @return
	 */
	public void setIsUse(boolean isUse) {
		this.isUse = isUse;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getMatchDicId() {
		return matchDicId;
	}

	public void setMatchDicId(String matchDicId) {
		this.matchDicId = matchDicId;
	}

	@Override
	public String toString() {
		return "SystemDictionary [dictionaryOptionId=" + dictionaryOptionId
				+ ", dictionaryOptionName=" + dictionaryOptionName
				+ ", upDictionaryOptionId=" + upDictionaryOptionId + ", isUse="
				+ isUse + ", description=" + description + ", sortNo="
				+ sortNo + ", flag=" + flag + ", englishName=" + englishName
				+ ", dataType=" + dataType + ", remark1=" + remark1
				+ ", remark2=" + remark2 + ", matchDicId=" + matchDicId + "]";
	}

}
