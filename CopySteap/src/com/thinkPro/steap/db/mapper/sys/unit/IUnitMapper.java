package com.thinkPro.steap.db.mapper.sys.unit;

import java.sql.SQLException;
import java.util.List;

import com.thinkPro.steap.bean.sys.unit.TBaseUnitInfo;

public interface IUnitMapper {

	/**
	 * 返回部门结构
	 * @return
	 */
	public List<TBaseUnitInfo> getUnitTree()throws SQLException;
	
	/**
	 * 添加部门
	 * @param tBaseUnitInfo
	 * @return
	 * @throws SQLException
	 */
	public int addUnit(TBaseUnitInfo tBaseUnitInfo)throws SQLException;
	/**
	 * 根据部门id删除部门
	 * @param unitId
	 * @return
	 * @throws SQLException
	 */
	public int deleteUnit(String unitId)throws SQLException;
	
	/**
	 * 修改部门信息 
	 * @param tBaseUnitInfo
	 * @return
	 * @throws SQLException
	 */
	public int updateUnit(TBaseUnitInfo tBaseUnitInfo)throws SQLException;
	
	/**
	 * 查询部门信息列表
	 * @return
	 * @throws SQLException
	 */
	public List<TBaseUnitInfo> getAllUnit()throws SQLException;
	
}
