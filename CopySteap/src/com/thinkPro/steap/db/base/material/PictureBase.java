package com.thinkPro.steap.db.base.material;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.material.Picture;
import com.thinkPro.steap.db.mapper.material.IPictureMapper;

public class PictureBase implements IPictureMapper{

	private ApplicationContext applicationContext;
	private IPictureMapper pictureMapper;
	
	public PictureBase() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		pictureMapper = (IPictureMapper) applicationContext.getBean("IPictureMapper");
	}
	
	/**
	 * 添加项目的图片资料
	 * @param picture 图片信息
	 * @return
	 * @throws SQLException
	 */
	public  int addPicture(Picture picture)throws SQLException{
		return pictureMapper.addPicture(picture);
	}
	
	/**
	 * 根据项目Id和图片类型查询项目的图片资料
	 * @param pictureInfo 项目Id 图片类型(Map)
	 * @return 图片信息(List)
	 * @throws SQLException
	 */
	public List<Picture> getPicture(Map<String,String> pictureInfo)throws SQLException{
			return pictureMapper.getPicture(pictureInfo);
	}
}
