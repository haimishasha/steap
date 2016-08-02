package com.thinkPro.steap.db.mapper.material;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.material.Material;

public interface IFileMapper {
	/**
	 * 插入文件
	 * @return
	 */
	public int addFile(Material file) throws SQLException;
	
	/**
	 * 插入项目资料表
	 * @param material
	 * @return
	 */
	public int addProjectMaterial(Map<String,Object> material)throws SQLException;
	
	/**
	 * 根据文件编号删除文件, 级联删除项目材料信息
	 * @param fileId
	 * @return
	 */
	public int deleteFile(String fileId)throws SQLException;
	/**
	 * 根据文件类型和项目编号查询项目中文件资料
	 * @param condition
	 * @return
	 */
	public Material getFile(Map<String,Object> condition)throws SQLException;
	
	/**
	 * 根据项目编号获取项目原始资料信息
	 * @param projectId 项目编号
	 * @return 当前项目全部原始资料信息
	 */
	public List<Material> getOriginalMaterialsBy(String projectId) throws SQLException;
	
	/**
	 * 根据项目编号获取项目原始材料树
	 * @param projectId 项目编号
	 * @return 当前项目的原始材料数
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getOriginalMaterialsTree(String projectId) throws SQLException;
}
