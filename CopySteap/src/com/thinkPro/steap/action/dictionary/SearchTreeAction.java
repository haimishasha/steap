package com.thinkPro.steap.action.dictionary;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;


@SuppressWarnings("serial")
public class SearchTreeAction extends ActionSupport {
	
	private String treeList2;//返回的json对象
	
	List<Map<String, Object>> treeList;//得到java对象


	public String getTreeList2() {
		
		return treeList2;
	}

	public void setTreeList2(String treeList2) {
		
		this.treeList2 = treeList2;
	}

	public List<Map<String, Object>> getTreeList() {
		
		return treeList;
	}

	public void setTreeList(List<Map<String, Object>> treeList) {
		
		this.treeList = treeList;
	}
	

	public String  searchTree(){
		
	     DictionaryService ditionaryService = new DictionaryService();
	     
	     try {
	    	 
			this.treeList =ditionaryService.getDictionaryTree();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		JSONArray jsonArray = JSONArray.fromObject(treeList);
		
		this.treeList2 = jsonArray.toString();

		return SUCCESS;
	 }
}
