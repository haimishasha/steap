package com.thinkPro.steap.db.mapper.specialist;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.specialist.Specialist;

public interface ISpecialistMapper {

	/**
	 * 插入会议安排的专家
	 * 
	 * @param specialists
	 *            map中的内容为(meetingId,specialistId,source) 会议编号,专家编号,专家来源
	 * @return
	 */
	public int insertArrangedSpecialist(List<Map<String, Object>> specialists) throws SQLException;

	/**
	 * 修改会议安排的专家的信息 是否是组长 数据库中默认是不是组长
	 * 
	 * @param Leader
	 *            map中包括(meetingId,specialistId,isLeader)
	 * @return
	 */
	public int updateLeader(Map<String, Object> leader) throws SQLException;

	public String getNextRecommendSpecialistId() throws SQLException;

	public List<Specialist> getRecommendSpecialistList(String projectId) throws SQLException;

	/*---------------Start: 专家信息 by yachao--------------------*/

	/**
	 * 根据会议编号获取全部专家信息
	 * @param meetingId 会议编号
	 * @return 全部会议专家基本信息
	 */
	public List<Specialist> getSpecialistsByMeetingId(String meetingId) throws SQLException;

	/**
	 * 根据专家编号从专家推荐表中获取专家基本信息
	 * @param specialistId 专家编号
	 * @return 专家基本信息
	 * @throws SQLException
	 */
	public Specialist getRecommendSpecialistById(String specialistId) throws SQLException;
	
	/**
	 * 根据专家编号从专家库中获取专家基本信息
	 * @param specialistId 专家编号
	 * @return 专家基本信息
	 * @throws SQLException
	 */
	public Specialist getLibrarySpecialistById(String specialistId) throws SQLException;
	
	/**
	 * 查询专家来源（根据会议编号和专家编号）
	 * @param meeting_specialist 会议编号、专家编号
	 * @return 专家来源
	 * @throws SQLException
	 */
	public String getSpecialistSource(Map<String, Object> meeting_specialist) throws SQLException;
	
	/**
	 * 根据会议编号查询专家组名单
	 * @param meetingId 会议编号
	 * @return 专家组名单
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getSpecialistGroupByMeetingId(String meetingId) throws SQLException;
	
	public List<Specialist> getSpecialistsByIf(Map<String, Object> specialistCon) throws SQLException;
	
	/**
	 * 录入专家基本信息到推荐表中
	 * @param specialist 专家基本信息
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertRecommendSpecialist(Specialist specialist) throws SQLException;
	
	/**
	 * 录入企业推荐专家列表
	 * @param specialists
	 * @return 录入记录数
	 * @throws SQLException
	 */
	/*public int insertRecommentSpecialistList(List<Specialist> specialists) throws SQLException;*/
	
	/**
	 * 录入专家基本信息到专家库中
	 * @param specialist 专家基本信息
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertLibrarySpecialist(Specialist specialist) throws SQLException;
	
	/**
	 * 设置推荐专家的密码
	 * @param specialist_password 专家编号和密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistPassword(Map<String, Object> specialist_password) throws SQLException;
	
	/**
	 * 设置库专家的密码
	 * @param specialist_password 专家编号和密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistPassword(Map<String, Object> specialist_password) throws SQLException;
	
	/**
	 * 设置推荐专家签名和签名密码
	 * @param signature 专家编号、签名、签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistSignatureInfo(Map<String, Object> signature) throws SQLException;
	
	/**
	 * 设置库专家签名和签名密码
	 * @param signature 专家编号、签名、签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistSignatureInfo(Map<String, Object> signature) throws SQLException;
	
	/**
	 * 设置推荐专家签名
	 * @param specialist_signature 专家编号和签名
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistSignature(Map<String, Object> specialist_signature) throws SQLException;

	/**
	 * 设置推荐专家签名密码
	 * @param specialist_signaturePass 专家编号和签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistSignaturePass(Map<String, Object> specialist_signaturePass) throws SQLException;
	
	/**
	 * 设置库专家签名
	 * @param specialist_signarure 专家编号和签名
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistSignature(Map<String, Object> specialist_signarure) throws SQLException;

	
	/**
	 * 设置库专家签名密码
	 * @param specialist_signaturePass 专家编号和签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistSignaturePass(Map<String, Object> specialist_signaturePass) throws SQLException;
	
	/**
	 * 专家签订承诺书
	 * @param specialist_agree 专家编号、同意承诺书与否
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateSpecialistGignAgree(Map<String, Object> specialist_agree) throws SQLException;
	
	/**
	 * 修改专家库专家基本信息
	 * @param specialist 专家基本信息
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialist(Specialist specialist) throws SQLException;
	
	/**
	 * 修改企业推荐专家信息
	 * @param specialist 专家基本信息
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialist(Specialist specialist) throws SQLException;
	
	/**
	 * 根据专家编号删除推荐专家信息
	 * @param specialistId 推荐专家编号
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteRecommendSpecialistById(String specialistId) throws SQLException;
	
	/**
	 * 根据专家编号删除库专家信息
	 * @param specialistId 库专家编号
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteLibrarySpecialistById(String specialistId) throws SQLException;
	
	/**
	 * 删除会议确定的全部专家
	 * @param meetingId 会议编号
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteSpecialistsByMeetingId(String meetingId) throws SQLException;
	
	/**
	 * 删除会议安排的某个专家
	 * @param arrangedSpecialist 会议编号、专家编号 
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteArrangedSpecialist(Map<String, Object> arrangedSpecialist) throws SQLException;
	/*---------------End: 专家信息by yachao--------------------*/
}
