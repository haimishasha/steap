package com.thinkPro.steap.db.base.sys.unit;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.sys.unit.TBaseUnitInfo;
import com.thinkPro.steap.db.mapper.sys.unit.IUnitMapper;

public class UnitBase implements IUnitMapper{

	private ApplicationContext applicationContext;
	private IUnitMapper unitMapper;
	
	public UnitBase() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		unitMapper = (IUnitMapper) applicationContext.getBean("IUnitMapper");
	}

	/**
	 * 返回部门结构
	 * @return
	 */
	public List<TBaseUnitInfo> getUnitTree() throws SQLException {
		return unitMapper.getUnitTree();
	}
	
	/**
	 * 添加部门
	 * @param tBaseUnitInfo
	 * @return
	 * @throws SQLException
	 */
	public int addUnit(TBaseUnitInfo tBaseUnitInfo) throws SQLException {
		return unitMapper.addUnit(tBaseUnitInfo);
	}

	/**
	 * 根据部门id删除部门
	 * @param unitId
	 * @return
	 * @throws SQLException
	 */
	public int deleteUnit(String unitId) throws SQLException {
		return unitMapper.deleteUnit(unitId);
	}

	/**
	 * 修改部门信息 
	 * @param tBaseUnitInfo
	 * @return
	 * @throws SQLException
	 */
	public int updateUnit(TBaseUnitInfo tBaseUnitInfo) throws SQLException {
		return unitMapper.updateUnit(tBaseUnitInfo);
	}

	/**
	 * 查询部门信息列表
	 * @return
	 * @throws SQLException
	 */
	public List<TBaseUnitInfo> getAllUnit() throws SQLException {
		return unitMapper.getAllUnit();
	}
}
