package com.thinkPro.steap.action.dictionary;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.dic.SystemDictionary;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;


public class SearchDictionaryAction extends ActionSupport {

	private static final long serialVersionUID = -2718753766487238403L;
	
	private SystemDictionary systemDictionary;
	
	private String upDictionaryOptionId;//上级字典编号  方法一和方法二公用
	
	private String result;//返回的结果
	
	private String nextId;//下级中下一个字典的编号 
	
	private String dictionaryOptionId; //字典的编号  查询条件
	
	private String dictionaryOptionName;//字典的名字 查询条件
	
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

	public SystemDictionary getSystemDictionary() {
		return systemDictionary;
	}

	public void setSystemDictionary(SystemDictionary systemDictionary) {
		this.systemDictionary = systemDictionary;
	}

	public String getUpDictionaryOptionId() {
		return upDictionaryOptionId;
	}

	public void setUpDictionaryOptionId(String upDictionaryOptionId) {
		this.upDictionaryOptionId = upDictionaryOptionId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public String getNextId() {
		return nextId;
	}

	public void setNextId(String nextId) {
		this.nextId = nextId;
	}
	public String searchDictionaryByUpId(){
		
		DictionaryService ditionaryService = new DictionaryService();
		
		List<SystemDictionary> systemDictionary;
		
		try {
			//返回自己的子节点
			systemDictionary = ditionaryService.getDictionaryByUpDicId(upDictionaryOptionId);
			
			SystemDictionary dictionary=ditionaryService.getDictionaryById(upDictionaryOptionId);
			//返回自己本身
			systemDictionary.add(dictionary);
			
			//将java对象转化为json对象
			
			JSONArray jsonArray = JSONArray.fromObject(systemDictionary);
			//返回给Ajax
			this.result = jsonArray.toString();
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String searchDictionaryByCondition(){
		
		DictionaryService ditionaryService = new DictionaryService();
		
		List<SystemDictionary> systemDictionary;
		
		try {
			
			Map<String,Object> condition = new HashMap<String,Object>();
			
			condition.put("dictionaryOptionId", dictionaryOptionId);
			
			condition.put("dictionaryOptionName", dictionaryOptionName);
			
			System.out.println("map"+condition);
			systemDictionary = ditionaryService.getDictionaryByConditon(condition);
			
			//将java对象转化为json对象
			
			JSONArray jsonArray = JSONArray.fromObject(systemDictionary);
			
			//返回给Ajax
			this.result = jsonArray.toString();
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	

	public String searchNextId(){
		
		DictionaryService ditionaryService = new DictionaryService();
		
		try {
			
			this.nextId = (ditionaryService.getNextDictionaryId(upDictionaryOptionId));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
}
