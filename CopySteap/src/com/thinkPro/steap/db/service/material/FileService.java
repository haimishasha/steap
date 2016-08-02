package com.thinkPro.steap.db.service.material;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.base.material.FileBase;


public class FileService {
	
	private FileBase fileBase;
	
	public FileService() {
		
		fileBase = new FileBase();
	}
	/* -------------------------START BY HaoShaSha -------------------*/
	/**
	 * 添加文件
	 * @param file 文件
	 * @return 是否添加成功
	 * @throws SQLException
	 */
	public boolean addFile(Material file) throws SQLException{
		
		if(file == null){
			
			return false;
			
		}else{
			
			boolean result =  fileBase.addFile(file) >0 ? true:false;
			 
			 if(result){
				 
				 Map<String,Object> material = new HashMap<String,Object>();
				 
				 //System.out.println("存入的文件的编号是"+file.getFileId());
				 
				 String fileId = file.getFileId();
				 
				 material.put("projectId", file.getProjectId());
				 
				 material.put("fileId", fileId);
				 
				 result = fileBase.addProjectMaterial(material)>0 ? true:false;
			 }
			 
			 return result;
		}
		 
	}
		
	/**
	 * 根据文件编号删除文件, 级联删除项目材料信息
	 * @param fileId
	 * @return
	 */
	public boolean deleteFile(String fileId) throws SQLException{
		
		boolean validate = ValidateCheck.isNotNull(fileId);
		
		if(validate){
			
			return fileBase.deleteFile(fileId) >0 ? true:false;
		
		}else{
			
			return false;
		}
		
	}
	/**
	 * 根据文件类型和项目编号查询项目中文件资料
	 * @param condition(projectId,fileType)
	 * (项目名称，文件类型)
	 * @return
	 */
	public Material getFile(Map<String,Object> condition) throws SQLException{
		
		//有问题  待完善 
		if(condition!=null && condition.size()>0){
			
			return fileBase.getFile(condition);
			
		}else{
			
			return null;
		}
	}

	/* -------------------------END BY HaoShaSha -------------------*/
	
	/**
	 * 根据项目编号获取项目资料信息
	 * @param projectId 项目编号
	 * @return 当前项目全部资料信息
	 */
	public List<Material> getOriginalMaterialsBy(String projectId) throws SQLException {
		
		if(projectId != null) {
			
			return fileBase.getOriginalMaterialsBy(projectId);
		}
		return null;
	}
	
	/**
	 * 根据项目编号获取项目原始材料树
	 * @param projectId 项目编号
	 * @return 当前项目的原始材料数
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getOriginalMaterialsTree(String projectId) throws SQLException {
		if(projectId != null && !"".equals(projectId)) {
			return fileBase.getOriginalMaterialsTree(projectId);
		}
		return null;
	}
}
