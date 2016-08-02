package com.thinkPro.steap.db.service.material;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.material.Picture;
import com.thinkPro.steap.db.base.material.PictureBase;
import com.thinkPro.steap.db.base.sys.dic.DictionaryBase;


public class PictureService {

	private ApplicationContext context;
	private PictureBase pictureBase;
	private DictionaryBase dictionaryBase;
 
	public PictureService() {
		context = new ClassPathXmlApplicationContext("applicationContext-base.xml");
		pictureBase = (PictureBase) context.getBean("pictureBase");
		dictionaryBase = (DictionaryBase) context.getBean("dictionaryBase");
	}
	/**
	 * 添加项目的图片资料
	 * @param picture 图片信息
	 * @return
	 * @throws SQLException
	 */
	public boolean addPicture(Picture picture)throws SQLException{
		if(picture!=null){
			String code = dictionaryBase.getCodeByName(picture.getPictureType());
			picture.setPictureType(code);
			boolean result = pictureBase.addPicture(picture)>-1?true:false;
			return result;
		}
		return false;
	}
	
	/**
	 * 根据项目Id和图片类型查询项目的图片资料
	 * @param pictureInfo 项目Id 图片类型(Map)
	 * @return 图片信息(List)
	 * @throws SQLException
	 */
	public List<Picture> getPicture(Map<String,String> pictureInfo)throws SQLException{
		if(pictureInfo.size()>0){
			return pictureBase.getPicture(pictureInfo);
		}
		return null;
	}
}
