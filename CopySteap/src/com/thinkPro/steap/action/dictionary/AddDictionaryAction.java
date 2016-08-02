package com.thinkPro.steap.action.dictionary;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.thinkPro.steap.bean.sys.dic.SystemDictionary;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

public class AddDictionaryAction extends ActionSupport implements ModelDriven<SystemDictionary>{
	
	private static final long serialVersionUID = -606136789052608951L;

	private SystemDictionary systemDictionary = new SystemDictionary();
	
	private boolean addResult;


	public boolean isAddResult() {
		
		return addResult;
	}

	public void setAddResult(boolean addResult) {
		
		this.addResult = addResult;
	}

	
	public SystemDictionary getSystemDictionary() {
		
		return systemDictionary;
	}

	public void setSystemDictionary(SystemDictionary systemDictionary) {
		
		this.systemDictionary = systemDictionary;
	}

	public String addDictionary(){

		DictionaryService ditionaryService = new DictionaryService();
		
		boolean result = false;
		try {
			result = ditionaryService.addDictionary(systemDictionary);
			
			this.addResult = result;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			Logger logger = Logger.getLogger(AddDictionaryAction.class);
			logger.info(logger);
		}
		if (result) {
			
			return SUCCESS;
		} 
		return ERROR;
	}

	@Override
	public SystemDictionary getModel() {
		
		return systemDictionary;
	}
}
