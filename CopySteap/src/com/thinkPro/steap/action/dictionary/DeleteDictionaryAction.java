package com.thinkPro.steap.action.dictionary;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

public class DeleteDictionaryAction extends ActionSupport {

	private static final long serialVersionUID = -796150785473757381L;
	
	private String dictionaryOptionId;//Ajax传过来的值（字典编号）
	
	private String result;

	public String getResult() {
		
		return result;
	}

	public void setResult(String result) {
		
		this.result = result;
	}

	public String getDictionaryOptionId() {
		
		return dictionaryOptionId;
	}

	public void setDictionaryOptionId(String dictionaryOptionId) {
		
		this.dictionaryOptionId = dictionaryOptionId;
	}

	public String deleteDictionary() {
		
		DictionaryService ditionaryService = new DictionaryService();
		
		boolean result = false;
		
		try {
			
			 result = ditionaryService.deleteDictionary(dictionaryOptionId);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(result){
			
			return SUCCESS;
		}else{
			
			return ERROR;
		}
		
	}

}
