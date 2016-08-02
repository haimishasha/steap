package com.thinkPro.steap.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.thinkPro.steap.bean.sys.dic.SystemDictionary;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

public class TestDictionary {
	
	DictionaryService ds=new DictionaryService();
	
	@Test
	public void testAddDictionary() throws SQLException {
		SystemDictionary sd=new SystemDictionary();
		sd.setDictionaryOptionId("600");
		ds.addDictionary(sd);
	}
	
	@Test
	public void testDeleteDictionary() throws SQLException {
		ds.deleteDictionary("600");
	}
	
	@Test
	public void testUpdateDictionary() throws SQLException{
		SystemDictionary sd=new SystemDictionary();
		sd.setDictionaryOptionId("100");
		sd.setDictionaryOptionName("项目状态");
		ds.updateDictionary(sd);
	}
	
	@Test
	public void testGetDictionaryById() throws SQLException {
		ds.getDictionaryById("100");
	}
	
	
/* ----------START BY HaoShaSha --------------*/
	/**
	 * 测试按照条件查询字典信息（字典名称和字典编号）
	 */
	
	@Test
	public void testGetDictionaryByConditon(){
		
		List<SystemDictionary> dictionarys = new ArrayList<SystemDictionary>();
		
		Map<String,Object> condition = new HashMap<String,Object>();
		
		condition.put("dictionaryOptionId", "");
		
		condition.put("dictionaryOptionName", "");
		
		try {
			
			dictionarys = ds.getDictionaryByConditon(condition);
			
			for(SystemDictionary dictionary: dictionarys){
				
				System.out.println(dictionary.toString());
			}
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 测试根据上级字典编号查询字典信息
	 */
	
	@Test
	public void testGetDictionaryByUpDicId(){
		
		List<SystemDictionary> dictionarys = new ArrayList<SystemDictionary>();
		
		String upDictionaryOptionId = "100";
		
		try {
			dictionarys=ds.getDictionaryByUpDicId(upDictionaryOptionId);
			
			for(SystemDictionary dic:dictionarys){
				
				System.out.println(dic.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试查询全部字典列表
	 */
	@Test
	public void testGetAllDictionary(){

		List<SystemDictionary> ditionarys = new ArrayList<SystemDictionary>();

		try {
			
			ditionarys=ds.getAllDictionary();

			for(SystemDictionary dic:ditionarys){

				System.out.println(dic.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询字典树信息
	 */
	@Test
	public void testGetDictionaryTree(){
		
		List<Map<String,Object>> ditionarys = new ArrayList<Map<String,Object>>();
		
		try {

			ditionarys = ds.getDictionaryTree();

			for(Map<String,Object> dic:ditionarys){

				System.out.println(dic.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据上级字典Id查询下一个要插入的下一级字典的编号 
	 */
	@Test
	public void testGetNextDictionaryId(){
		
		String upDictionaryOptionId = "100";

		try {
			String nextId =ds.getNextDictionaryId(upDictionaryOptionId);

			System.out.println(nextId);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据上级字典Id查询最新的一个下级字典信息
	 */
	@Test
	public void testGetNewDictionary(){

		SystemDictionary ditionary = new SystemDictionary();

		String upDictionaryOptionId = "100";

		try {
			ditionary=ds.getNewDictionary(upDictionaryOptionId);

			System.out.println(ditionary.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* ----------END BY HaoShaSha --------------*/
	
}
