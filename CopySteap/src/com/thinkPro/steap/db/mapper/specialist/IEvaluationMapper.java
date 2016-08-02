package com.thinkPro.steap.db.mapper.specialist;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.evaluation.EvaluationInfo;
import com.thinkPro.steap.bean.evaluation.EvaluationResult;
import com.thinkPro.steap.bean.evaluation.SpecialistEvaluation;


public interface IEvaluationMapper {
	
	/**
	 * 录入专家评审意见信息
	 * @param specialistEvaluation 专家评审意见
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertSpecialistEvaluationInfo(SpecialistEvaluation specialistEvaluation) throws SQLException;
	
	/**
	 * 录入项目评审结果
	 * @param evaluationResult 项目评审结果
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertEvalutionResult(EvaluationResult evaluationResult) throws SQLException;
	
	/**
	 * 根据项目编号查询专家评审信息
	 * @param projectId 项目编号
	 * @return 专家评审信息列表
	 * @throws SQLException
	 */
	public List<EvaluationInfo> getSpecialistEvaluationList(String projectId) throws SQLException;
	
	/**
	 * 根据项目编号和专家编号查询评审意见
	 * @param evaluationInfo 项目编号和专家编号
	 * @return 评审意见
	 * @throws SQLException
	 */
	public String getSpecialistEvaluation(Map<String, Object> evaluationInfo) throws SQLException;
	
	/**
	 * 根据专家编号和会议状态当前专家获取待评审项目数
	 * @param meeting_specialist 专家编号、会议状态
	 * @return 待评审项目数
	 * @throws SQLException
	 */
	public String getEvaluatedProjectCount(Map<String, Object> meeting_specialist) throws SQLException;
	
}
