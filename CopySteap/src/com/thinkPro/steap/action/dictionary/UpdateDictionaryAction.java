package com.thinkPro.steap.action.dictionary;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.thinkPro.steap.bean.sys.dic.SystemDictionary;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;


public class UpdateDictionaryAction extends ActionSupport  implements ModelDriven<SystemDictionary>{
	
	private static final long serialVersionUID = 519320461749415711L;
	
	private SystemDictionary systemDictionary = new SystemDictionary();
	
	private SystemDictionary result;
	
	private boolean updateResult;
   

	public boolean isUpdateResult() {
		
		return updateResult;
	}

	

	public SystemDictionary getSystemDictionary() {
		return systemDictionary;
	}



	public void setSystemDictionary(SystemDictionary systemDictionary) {
		this.systemDictionary = systemDictionary;
	}



	public SystemDictionary getResult() {
		return result;
	}



	public void setResult(SystemDictionary result) {
		this.result = result;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public void setUpdateResult(boolean updateResult) {
		this.updateResult = updateResult;
	}



	public String updateDictionary(){
		
		DictionaryService ditionaryService = new DictionaryService();
		
		System.out.println(systemDictionary);
		
		boolean updateResult = false;
		
		try {
			
			updateResult = ditionaryService.updateDictionary(systemDictionary);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(updateResult){
			
			return SUCCESS;
		}else{
			
			return ERROR;
		}
		
	}
	
	public String getUpdateDictionary(){
		
		DictionaryService ditionaryService = new DictionaryService();
		
		try {
			
			this.result = ditionaryService.getDictionaryById(systemDictionary.getDictionaryOptionId());
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Override
	public SystemDictionary getModel() {
		
		return systemDictionary;
	}
	
}
