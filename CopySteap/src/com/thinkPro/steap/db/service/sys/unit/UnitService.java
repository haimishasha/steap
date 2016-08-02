package com.thinkPro.steap.db.service.sys.unit;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.sys.unit.TBaseUnitInfo;
import com.thinkPro.steap.db.base.sys.unit.UnitBase;

public class UnitService {

	private ApplicationContext context;
	private UnitBase unitBase;

	public UnitService() {
		context = new ClassPathXmlApplicationContext(
				"applicationContext-base.xml");
		unitBase = (UnitBase ) context.getBean("unitBase");
	}
	
	/**
	 * 返回部门结构
	 * @return
	 */
	public List<TBaseUnitInfo> getUnitTree() throws SQLException {
		return unitBase.getUnitTree();
	}
	
	/**
	 * 添加部门
	 * @param tBaseUnitInfo
	 * @return
	 * @throws SQLException
	 */
	public boolean addUnit(TBaseUnitInfo tBaseUnitInfo) throws SQLException {
		if(tBaseUnitInfo!=null){
			int addDictionaryResult = unitBase.addUnit(tBaseUnitInfo);
			boolean result = addDictionaryResult>-1?true:false;
			return result;
			}
			return false;
	}

	/**
	 * 根据部门id删除部门
	 * @param unitId
	 * @return
	 * @throws SQLException
	 */
	public int deleteUnit(String unitId) throws SQLException {
		if(unitId != null && !"".equals(unitId)) {
			return unitBase.deleteUnit(unitId);
		}
		return -1;
	}

	/**
	 * 修改部门信息 
	 * @param tBaseUnitInfo
	 * @return
	 * @throws SQLException
	 */
	public int updateUnit(TBaseUnitInfo tBaseUnitInfo) throws SQLException {
		if(tBaseUnitInfo!= null) {
			return unitBase.updateUnit(tBaseUnitInfo);
		}
		return -1;
	}

	/**
	 * 查询部门信息列表
	 * @return
	 * @throws SQLException
	 */
	public List<TBaseUnitInfo> getAllUnit() throws SQLException {
		return unitBase.getAllUnit();
	}
}