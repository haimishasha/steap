package com.thinkPro.steap.db.service.sys.dic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.sys.dic.SystemDictionary;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.base.sys.dic.DictionaryBase;

public class DictionaryService {
	private DictionaryBase dictionaryBase;

	public DictionaryService() {
		dictionaryBase = new DictionaryBase();
	}
	
	/**
	 * 添加字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException
	 */
	public boolean addDictionary(SystemDictionary dictionary)throws SQLException{
		
		if(dictionary!=null){
			System.out.println(dictionary);
			int addDictionaryResult = dictionaryBase.addDictionary(dictionary);
			
			boolean result = addDictionaryResult>-1?true:false;
			
			return result;
			
		}
			return false;
	}
	/**
	 * 根据字典Id删除字典信息
	 * @param dictionaryOptionId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteDictionary(String dictionaryOptionId)throws SQLException{
		if(dictionaryOptionId != null && !"".equals(dictionaryOptionId)) {
			return dictionaryBase.deleteDictionary(dictionaryOptionId)>0 ? true:false;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据字典编码查询字典信息
	 * @param dictionaryOptionId
	 * @return
	 * @throws SQLException
	 */
	public SystemDictionary getDictionaryById(String dictionaryOptionId)throws SQLException{
		if(dictionaryOptionId != null && !"".equals(dictionaryOptionId)) {
			return dictionaryBase.getDictionaryById(dictionaryOptionId);
		}
		return null;
	}
	
/* ----------START BY HaoShaSha --------------*/
	/**
	 * 根据条件查询字典信息(字典编号，字典名称)
	 * @param condition(字典编号，字典名称)
	 * @return 
	 * @throws SQLException
	 */
	public List<SystemDictionary> getDictionaryByConditon(Map<String,Object> condition) throws SQLException{
		
		
		if(condition!=null && condition.size()>0){
			
			return dictionaryBase.getDictionaryByConditon(condition);
		
		}else{
			
			return null;
		}
		
	}
	
	
	/**
	 * 修改字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException
	 */
	public boolean updateDictionary(SystemDictionary dictionary)throws SQLException{
		
		if(dictionary!= null) {
			
			boolean updateResult = false;
			
			updateResult = dictionaryBase.updateDictionary(dictionary)>0?true:false;
			
			//此处待完善，对性能有很大的影响
			
			if(updateResult && dictionary.isUse()!=true){
				
				updateResult = dictionaryBase.updateChildNotUse(dictionary.getDictionaryOptionId())>=0?true:false;
			}
			
			return updateResult;
		
		}else{
			
			return false;
		}
	}
	
	/**
	 * 根据上级字典编号查询字典信息
	 * @param upDictionaryOptionId(上级字典编号)
	 * @return List<SystemDictionary> (下级字典列表)
	 * @throws SQLException
	 */
	public List<SystemDictionary> getDictionaryByUpDicId(String upDictionaryOptionId)throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(upDictionaryOptionId);
		
		if(result){
			
			return dictionaryBase.getDictionaryByUpDicId(upDictionaryOptionId);
		
		}else{
			
			return null;
		}
		
	}
	
	/**
	 * 查询全部字典列表
	 * @return List<SystemDictionary> (全部字典列表)
	 * @throws SQLException
	 */
	public List<SystemDictionary> getAllDictionary()throws SQLException{
		
		return dictionaryBase.getAllDictionary();
	}
	
	/**
	 * 查询字典树信息
	 * @return List<Map<String,Object>>
	 * 返回的map包括(dictionaryOptionId,dictionaryOptionName,upDictionaryOptionId)
	 * (字典编号，字典名称，上级字典编号)
	 * @throws SQLException
	 */
	public List<Map<String,Object>> getDictionaryTree() throws SQLException{
		
		return dictionaryBase.getDictionaryTree();
	}
	/**
	 * 根据上级字典Id查询下一个要插入的下一级字典的编号 
	 * @param upDictionaryOptionId 上级字典Id
	 * @return
	 * @throws SQLException
	 */
	public String getNextDictionaryId(String upDictionaryOptionId) throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(upDictionaryOptionId);
		
		if(result){
			
			String nextId = dictionaryBase.getMaxDictionaryId(upDictionaryOptionId);
			
			if(nextId==null){
				
				nextId = upDictionaryOptionId + "001";
			
			}else if(Integer.parseInt(nextId)/100 < 1000){
				
				nextId = Integer.toString(Integer.parseInt(nextId)+100);
			
			}else{
				
				nextId = Integer.toString(Integer.parseInt(nextId)+1);
			}
			
			return nextId;
			
		}else{
			
			return null;
		}
		
	}
	/**
	 * 根据上级字典Id查询最新的一个下级字典信息
	 * @param upDictionaryOptionId 上级字典Id
	 * @return 最新的一个下级字典信息
	 * @throws SQLException
	 */
	public SystemDictionary getNewDictionary(String upDictionaryOptionId)throws SQLException{

		boolean result = ValidateCheck.isNotNull(upDictionaryOptionId);

		if(result){

			return dictionaryBase.getNewDictionary(upDictionaryOptionId);

		}else{

			return null;
		}

	}
	
	/* ----------END BY HaoShaSha --------------*/
}