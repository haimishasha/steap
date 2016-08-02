package com.thinkPro.steap.action.user;

import java.sql.SQLException;
import java.util.List;
import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.unit.TBaseUnitInfo;
import com.thinkPro.steap.db.service.sys.unit.UnitService;


@SuppressWarnings("serial")
public class SearchUnitTreeAction extends ActionSupport {
	
	private String treeList2;//返回的json对象
	
	List<TBaseUnitInfo> treeList;//得到java对象

	public String getTreeList2() {
		return treeList2;
	}

	public void setTreeList2(String treeList2) {
		this.treeList2 = treeList2;
	}

	public List<TBaseUnitInfo> getTreeList() {
		return treeList;
	}

	public void setTreeList(List<TBaseUnitInfo> treeList) {
		this.treeList = treeList;
	}

	public String  searchTree(){
		
		UnitService unitService = new UnitService();
		 
	     try {
	    	 
			this.treeList =unitService.getUnitTree();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		JSONArray jsonArray = JSONArray.fromObject(treeList);
		
		this.treeList2 = jsonArray.toString();

		return SUCCESS;
	 }
}
