package com.thinkPro.steap.db.base.sys.dic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.sys.dic.SystemDictionary;
import com.thinkPro.steap.db.mapper.sys.dic.IDictionaryMapper;

public class DictionaryBase implements IDictionaryMapper{

	private ApplicationContext applicationContext;
	private IDictionaryMapper dictionaryMapper;
	
	public DictionaryBase() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		dictionaryMapper = (IDictionaryMapper) applicationContext.getBean("IDictionaryMapper");
	}
	
	/**
	 * 根据字典名称查询字典编码
	 * @param dictionaryName 字典名称
	 * @return 字典编码
	 * @throws SQLException
	 */
	public  String getCodeByName(String dictionaryName)throws SQLException{
		return dictionaryMapper.getCodeByName(dictionaryName);
	}
	
	/**
	 * 根据字典编码查询字典名称
	 * @param dictionaryId 字典Id
	 * @return 字典名称
	 * @throws SQLException
	 */
	public String getNameByCode(String dictionaryId)throws SQLException{
		return dictionaryMapper.getNameByCode(dictionaryId);
	}
	
	/**
	 * 添加字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException
	 */
	public int addDictionary(SystemDictionary dictionary)throws SQLException{
		return dictionaryMapper.addDictionary(dictionary);
	}
	
	/**
	 * 根据字典Id删除字典信息
	 * @param dictionaryOptionId
	 * @return
	 * @throws SQLException
	 */
	public int deleteDictionary(String dictionaryOptionId)throws SQLException{
		return dictionaryMapper.deleteDictionary(dictionaryOptionId);
	}
	
	/**
	 * 修改字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException
	 */
	public int updateDictionary(SystemDictionary dictionary)throws SQLException{
		return dictionaryMapper.updateDictionary(dictionary);
	}
	
	/**
	 * 根据字典编码查询字典信息
	 * @param dictionaryOptionId
	 * @return
	 * @throws SQLException
	 */
	public SystemDictionary getDictionaryById(String dictionaryOptionId)throws SQLException{
		return dictionaryMapper.getDictionaryById(dictionaryOptionId);
	}
	
	
	/* ----------START BY HaoShaSha --------------*/
	
	/**
	 * 根据条件查询字典信息(字典编号，字典名称)
	 * @param condition(字典编号，字典名称)
	 * @return 
	 * @throws SQLException
	 */
	public List<SystemDictionary> getDictionaryByConditon(Map<String,Object> condition) throws SQLException{
		
		return dictionaryMapper.getDictionaryByConditon(condition);
	}
	
	
	/**
	 * 根据上级字典编号查询字典信息
	 * @param upDictionaryOptionId(上级字典编号)
	 * @return List<SystemDictionary> (下级字典列表)
	 * @throws SQLException
	 */
	public List<SystemDictionary> getDictionaryByUpDicId(String upDictionaryOptionId)throws SQLException{

		return dictionaryMapper.getDictionaryByUpDicId(upDictionaryOptionId);
	}
	
	/**
	 * 查询全部字典列表
	 * @return List<SystemDictionary> (全部字典列表)
	 * @throws SQLException
	 */
	public List<SystemDictionary> getAllDictionary()throws SQLException{
		
		return dictionaryMapper.getAllDictionary();
	}
	
	/**
	 * 查询字典树信息
	 * @return List<Map<String,Object>>
	 * 返回的map包括(dictionaryOptionId,dictionaryOptionName,upDictionaryOptionId)
	 * (字典编号，字典名称，上级字典编号)
	 * @throws SQLException
	 */
	public List<Map<String,Object>> getDictionaryTree() throws SQLException{
		
		return dictionaryMapper.getDictionaryTree();
	}
	/**
	 * 根据上级字典Id查询下一个要插入的下一级字典的编号 
	 * @param upDictionaryOptionId 上级字典Id
	 * @return
	 * @throws SQLException
	 */
	public String getMaxDictionaryId(String upDictionaryOptionId) throws SQLException{
		
		return dictionaryMapper.getMaxDictionaryId(upDictionaryOptionId);
	}
	
	/**
	 * 根据上级字典Id查询最新的一个下级字典信息
	 * @param upDictionaryOptionId 上级字典Id
	 * @return 最新的一个下级字典信息
	 * @throws SQLException
	 */
	public SystemDictionary getNewDictionary(String upDictionaryOptionId)throws SQLException{
		
		return dictionaryMapper.getNewDictionary(upDictionaryOptionId);
	}
	
	/**
	 * 上一级字典禁用后，下一级字典也得禁用
	 * @param upDictionaryOptionId 上级字典Id
	 * @throws SQLException
	 */
	public int updateChildNotUse(String upDictionaryOptionId)throws SQLException{
		
		return dictionaryMapper.updateChildNotUse(upDictionaryOptionId);
	}
	
	/* ----------END BY HaoShaSha --------------*/
}
