package com.thinkPro.steap.db.service.specialist;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.db.base.specialist.SpecialistBase;

public class SpecialistService {
	private SpecialistBase specialistBase;

	public SpecialistService() {
		specialistBase = new SpecialistBase();
	}

	/**
	 * 插入会议安排的专家
	 * @param specialists
	 * map中的内容为(meetingId,specialistId,source)
	 * 会议编号,专家编号,专家来源
	 * @return
	 */
	public int insertArrangedSpecialist(List<Map<String,Object>> specialists) throws SQLException{
		
		return specialistBase.insertArrangedSpecialist(specialists);
	}
	
	/**
	 * 修改会议安排的专家的信息  是否是组长  数据库中默认是不是组长
	 * @param Leader
	 * map中包括(meetingId,specialistId,isLeader)
	 * @return
	 */
	public int updateLeader(Map<String,Object> leader) throws SQLException{
		if(leader.size() != 0) {
			return specialistBase.updateLeader(leader);
		}
		return -1;
	}
	
	/**
	 * 添加企业推荐专家的信息
	 * @param specialists 企业推荐专家的信息(List)
	 * @return 如果全部添加成功，返回true；其中一条插入失败，之前添加全部撤销，返回false
	 * @throws Exception
	 */
	public boolean insertRecommendSpecialistList(List<Specialist> specialists) throws SQLException{
		String specialistId = null;
		boolean result = false;
		for(Specialist specialist:specialists){
			specialistId = specialistBase.getNextRecommendSpecialistId();
			specialist.setSpecialistId(specialistId);
			if(specialistBase.insertRecommendSpecialist(specialist)>0){
				result = true;
			}else{
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * 根据项目返回Id返回专家信息
	 * @param projectId 项目Id
	 * @return 推荐专家信息(List)
	 * @throws Exception
	 */
	public List<Specialist> getRecommendSpecialistList(String projectId) throws SQLException{
		return specialistBase.getRecommendSpecialistList(projectId);
	}
	
	/*--------------------Start: 专家推荐 by yachao----------------------------*/
	
	/**
	 * 根据会议编号获取全部专家信息
	 * @param meetingId 会议编号
	 * @return 会议全部专家基本信息
	 */
	public List<Specialist> getSpecialistsByMeetingId(String meetingId) throws SQLException{
		if (meetingId != null && !"".equals(meetingId)) {
			 return specialistBase.getSpecialistsByMeetingId(meetingId);
		}
		return null;
	}
	
	/**
	 * 根据专家编号获取专家基本信息
	 * @param specialistId 专家编号
	 * @return 专家基本信息
	 * @throws SQLException
	 */
	public Specialist getSpecialistById(String specialistId) throws SQLException {
		if(specialistId != null && !"".equals(specialistId)) {
			Specialist specialist = null;
			specialist = specialistBase.getRecommendSpecialistById(specialistId);
			if(specialist != null) {
				return specialist;
			}
			return specialistBase.getLibrarySpecialistById(specialistId);
		}
		return null;
	}
	
	/**
	 * 根据专家编号从专家推荐表中获取专家基本信息
	 * @param specialistId 专家编号
	 * @return 专家基本信息
	 * @throws SQLException
	 */
	public Specialist getRecommendSpecialistById(String specialistId)
			throws SQLException {
		if(specialistId != null && !"".equals(specialistId)) {
			return specialistBase.getRecommendSpecialistById(specialistId);
		}
		return null;
	}

	/**
	 * 根据专家编号从专家库中获取专家基本信息
	 * @param specialistId 专家编号
	 * @return 专家基本信息
	 * @throws SQLException
	 */
	public Specialist getLibrarySpecialistById(String specialistId) throws SQLException {
		if(specialistId != null && !"".equals(specialistId)) {
			return specialistBase.getLibrarySpecialistById(specialistId);
		}
		return null;
	}

	/**
	 * 查询专家来源（根据会议编号和专家编号）
	 * @param meeting_specialist 会议编号、专家编号
	 * @return 专家来源
	 * @throws SQLException
	 */
	public String getSpecialistSource(Map<String, Object> meeting_specialist) throws SQLException {
		if(meeting_specialist.size() != 0) {
			return specialistBase.getSpecialistSource(meeting_specialist);
		}
		return null;
	}
	
	/**
	 * 根据会议编号查询专家组名单
	 * @param meetingId 会议编号
	 * @return 专家组名单
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getSpecialistGroupByMeetingId(String meetingId) throws SQLException {
		if(meetingId != null && !"".equals(meetingId)) {
			return specialistBase.getSpecialistGroupByMeetingId(meetingId);
		}
		return null;
	}
	
	public List<Specialist> getSpecialistsByIf(Map<String, Object> specialistCon) throws SQLException {
		if(specialistCon.size() != 0) {
			return specialistBase.getSpecialistsByIf(specialistCon);
		}
		return null;
	}
	
	/**
	 * 录入专家基本信息到推荐表中
	 * @param specialist 专家基本信息
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertRecommendSpecialist(Specialist specialist) throws SQLException {
		if(specialist != null) {
			return specialistBase.insertRecommendSpecialist(specialist);
		}
		return -1;
	}
	
	/**
	 * 录入专家基本信息到专家库中
	 * @param specialist 专家基本信息
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertLibrarySpecialist(Specialist specialist) throws SQLException {
		if(specialist != null) {
			return specialistBase.insertLibrarySpecialist(specialist);
		}
		return -1;
	}

	/**
	 * 修改推荐专家的密码
	 * @param specialist_password 专家编号和密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistPassword(Map<String, Object> specialist_password) throws SQLException {
		if(specialist_password.size() != 0) {
			return specialistBase.updateRecommendSpecialistPassword(specialist_password);
		}
		return 0;
	}

	/**
	 * 修改库专家的密码
	 * @param specialist_password 专家编号和密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistPassword(Map<String, Object> specialist_password) throws SQLException {
		if(specialist_password.size() != 0) {
			return specialistBase.updateLibrarySpecialistPassword(specialist_password);
		}
		return 0;
	}
	
	/**
	 * 修改专家密码。注:当不知道专家来源是什么时，采用该方法进行修改
	 * @param specialist_password 专家编号、密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateSpecialistPassword(Map<String, Object> specialist_password) throws SQLException {
		int result = -1;
		if(specialist_password.size() != 0) {
			result = specialistBase.updateLibrarySpecialistPassword(specialist_password);
			if(result != -1) {
				return result;
			} 
		}
		return specialistBase.updateRecommendSpecialistPassword(specialist_password);
	}
	
	/**
	 * 设置推荐专家签名和签名密码
	 * @param signature 专家编号、签名、签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistSignatureInfo(Map<String, Object> signature) throws SQLException {
		if(signature.size() != 0) {
			return specialistBase.updateRecommendSpecialistSignatureInfo(signature);
		}
		return -1;
	}
	
	/**
	 * 设置库专家签名和签名密码
	 * @param signature 专家编号、签名、签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistSignatureInfo(Map<String, Object> signature) throws SQLException {
		if(signature.size() != 0) {
			return specialistBase.updateLibrarySpecialistSignatureInfo(signature);
		}
		return -1;
	}
	
	/**
	 * 修改推荐专家签名
	 * @param specialist_signature 专家编号和签名
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistSignature(Map<String, Object> specialist_signature) throws SQLException {
		if(specialist_signature.size() != 0) {
			return specialistBase.updateRecommendSpecialistSignature(specialist_signature);
		}
		return -1;
	}
	
	/**
	 * 修改库专家签名
	 * @param specialist_signarure 专家编号和签名
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistSignature(Map<String, Object> specialist_signarure) throws SQLException {
		if(specialist_signarure.size() != 0) {
			return specialistBase.updateLibrarySpecialistSignature(specialist_signarure);
		}
		return -1;
	}
	
	/**
	 * 设置推荐专家签名密码
	 * @param specialist_signaturePass 专家编号和签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistSignaturePass(Map<String, Object> specialist_signaturePass) throws SQLException {
		if(specialist_signaturePass.size() != 0) {
			return specialistBase.updateRecommendSpecialistSignaturePass(specialist_signaturePass);
		}
		return -1;
	}
	
	/**
	 * 设置库专家签名密码
	 * @param specialist_signaturePass 专家编号和签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistSignaturePass(Map<String, Object> specialist_signaturePass) throws SQLException {
		if(specialist_signaturePass.size() != 0) {
			return specialistBase.updateLibrarySpecialistSignaturePass(specialist_signaturePass);
		}
		return -1;
	}
	
	/**
	 * 专家签订承诺书
	 * @param specialist_agree 专家编号、同意承诺书与否
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateSpecialistGignAgree(Map<String, Object> specialist_agree) throws SQLException {
		if(specialist_agree.size() != 0) {
			return specialistBase.updateSpecialistGignAgree(specialist_agree);
		}
		return -1;
	}
	
	/**
	 * 修改专家库专家基本信息
	 * @param specialist 专家基本信息
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialist(Specialist specialist) throws SQLException {
		if(specialist != null) {
			return specialistBase.updateLibrarySpecialist(specialist);
		}
		return -1;
	}
	
	/**
	 * 修改企业推荐专家信息
	 * @param specialist 专家基本信息
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialist(Specialist specialist) throws SQLException {
		if(specialist != null) {
			return specialistBase.updateRecommendSpecialist(specialist);
		}
		return -1;
	}
	
	/**
	 * 修改专家信息。当不知道专家来源时使用该方法进行修改专家信息
	 * @param specialist 专家基本信息
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateSpecialist(Specialist specialist) throws SQLException {
		int result = -1;
		if(specialist != null) {
			result = specialistBase.updateLibrarySpecialist(specialist);
			if(result != -1) {
				return result;
			}
		}
		return specialistBase.updateRecommendSpecialist(specialist);
	}
	
	/**
	 * 根据专家编号删除推荐专家信息
	 * @param specialistId 推荐专家编号
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteRecommendSpecialistById(String specialistId) throws SQLException {
		if(specialistId != null && !"".equals(specialistId)) {
			return specialistBase.deleteRecommendSpecialistById(specialistId);
		}
		return -1;
	}
	
	/**
	 * 根据专家编号删除库专家信息
	 * @param specialistId 库专家编号
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteLibrarySpecialistById(String specialistId) throws SQLException {
		if(specialistId != null && !"".equals(specialistId)) {
			return specialistBase.deleteLibrarySpecialistById(specialistId);
		}
		return -1;
	}

	/**
	 * 删除会议确定的全部专家
	 * @param meetingId 会议编号
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteSpecialistsByMeetingId(String meetingId)
			throws SQLException {
		if(meetingId != null && !"".equals(meetingId)) {
			return specialistBase.deleteSpecialistsByMeetingId(meetingId);
		}
		return -1;
	}

	/**
	 * 删除会议安排的某个专家
	 * @param arrangedSpecialist 会议编号、专家编号 
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteArrangedSpecialist(Map<String, Object> arrangedSpecialist)
			throws SQLException {
		if(arrangedSpecialist.size() != 0) {
			return specialistBase.deleteArrangedSpecialist(arrangedSpecialist);
		}
		return -1;
	}
	
	/*--------------------End: 专家推荐 by yachao----------------------------*/
}
