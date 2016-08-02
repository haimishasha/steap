package com.thinkPro.steap.db.mapper.material;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.material.Picture;

public interface IPictureMapper {

	/**
	 * 添加项目的图片资料
	 * @param picture 图片信息
	 * @return
	 * @throws SQLException
	 */
	public int addPicture(Picture picture)throws SQLException;
	/**
	 * 根据项目Id和图片类型查询项目的图片资料
	 * @param pictureInfo 项目Id 图片类型(Map)
	 * @return 图片信息(List)
	 * @throws SQLException
	 */
	public List<Picture> getPicture(Map<String,String> pictureInfo)throws SQLException;
}
