package com.thinkPro.steap.db.base.project;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.meeting.ProjectInfoResult;
import com.thinkPro.steap.bean.meeting.ProjectPreMaterialInfo;
import com.thinkPro.steap.bean.project.AuditInfo;
import com.thinkPro.steap.bean.project.EnterpriseInspect;
import com.thinkPro.steap.bean.project.IssueCertificate;
import com.thinkPro.steap.bean.project.Project;
import com.thinkPro.steap.bean.project.ProjectAccept;
import com.thinkPro.steap.bean.project.ProjectCensor;
import com.thinkPro.steap.bean.project.ProjectCharge;
import com.thinkPro.steap.bean.project.ProjectCondition;
import com.thinkPro.steap.bean.project.ProjectInfoOfPrepared;
import com.thinkPro.steap.bean.project.ProjectReceive;
import com.thinkPro.steap.bean.project.ProjectRecord;
import com.thinkPro.steap.db.mapper.project.IProjectMapper;

public class ProjectBase implements IProjectMapper {
	
	private ApplicationContext applicationContext;

	private IProjectMapper projectMapper;

	public ProjectBase() {

		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		projectMapper = (IProjectMapper) applicationContext
				.getBean("IProjectMapper");
	}
	/**
	 * 添加项目基本信息
	 * @param project 项目基本信息
	 * @return 插入成功的记录数
	 * @throws Exception
	 */
	public int addProject(Project project) throws SQLException{
		return projectMapper.addProject(project);
	}
	/**
	 * 添加项目登记信息
	 * @param projectRecord 项目登记信息
	 * @return 插入成功的记录数
	 * @throws Exception
	 */
	public int addProjectRecord(ProjectRecord projectRecord)throws SQLException{
		return projectMapper.addProjectRecord(projectRecord);
	}
	/**
	 * 添加确认项目负责部门信息
	 * @param projectCharge 项目负责部门信息
	 * @return 插入成功的记录数
	 * @throws Exception
	 */
	public int addProjectCharge(ProjectCharge projectCharge)throws SQLException{
		return projectMapper.addProjectCharge(projectCharge);
	}
	/**
	 * 添加领取项目资料信息
	 * @param projectReceive 项目领取资料信息
	 * @return 插入成功的记录数
	 * @throws Exception
	 */
	public int addProjectReceive(ProjectReceive projectReceive)throws SQLException{
		return projectMapper.addProjectReceive(projectReceive);
	}
	
	/**
	 * 添加审查项目资料信息(审查人，审查时间，审查结果)
	 * @param projectCensor审查项目资料信息
	 * @return
	 * @throws SQLException
	 */
	public int addProjectCensor(ProjectCensor projectCensor)throws SQLException{
		return projectMapper.addProjectCensor(projectCensor);
	}
	
	/**
	 * 添加企业现场考察信息(考察人，考察时间，考察结果)
	 * @param enterpriseInspect 企业现场考察时间
	 * @return
	 * @throws SQLException
	 */
	public int addEnterpriseInspect(EnterpriseInspect enterpriseInspect)throws SQLException{
		return projectMapper.addEnterpriseInspect(enterpriseInspect);
	}
	
	/**
	 * 添加项目审计信息(审计人，审计单位，审计结果)
	 * @param auditInfo
	 * @return
	 * @throws SQLException
	 */

	public int addAuditInfo(AuditInfo auditInfo)throws SQLException{
		return projectMapper.addAuditInfo(auditInfo);
	}
	
	/**
	 * 修改项目状态
	 * @param projectStatus 项目状态
	 * @return
	 * @throws SQLException
	 */
	public int updateProjectStatus(Map<String,String> projectStatus)throws SQLException{
		return projectMapper.updateProjectStatus(projectStatus);
	}
	
	/**
	 * 返回项目记录数(用于分页)
	 * @return 项目记录数
	 * @throws SQLException
	 */
	public int getProjectCount(ProjectCondition condition)throws SQLException{
		return projectMapper.getProjectCount(condition);
	}
	
	/**
	 * 根据项目Id查询企业现场考察信息
	 * @param projectId 项目Id
	 * @return 某个项目的企业现场考察信息
	 * @throws SQLException
	 */
	public String getNextInspectId()throws SQLException{
		return projectMapper.getNextInspectId();
	}

	/**
	 * 根据项目Id查询审计信息
	 * @param projectId 项目Id
	 * @return
	 * @throws SQLException
	 */
	public EnterpriseInspect getInspectByProjectId(String projectId)throws SQLException{
		return projectMapper.getInspectByProjectId(projectId);
	}
	
	/**
	 * 根据项目信息查询项目负责部门信息
	 * @param projectId 项目Id
	 * @return 项目负责部门信息
	 * @throws SQLException
	 */
	public AuditInfo getAuditInfoByProjectId(String projectId)throws SQLException{
		return projectMapper.getAuditInfoByProjectId(projectId);
	}
	
	/**
	 * 查询企业现场考察信息下一条记录的Id
	 * @return 企业现场考察Id
	 * @throws SQLException
	 */
	public ProjectCharge getChargeByProjectId(String projectId)throws SQLException{
		return projectMapper.getChargeByProjectId(projectId);
	}
	
	/**
	 * 根据条件分页查询项目信息
	 * @param condition 查询条件(项目名称，申请单位，所属领域，登记时间)
	 * @return 项目基本信息(List)
	 * @throws SQLException
	 */
	public List<Project> getProjectInfoByIf(ProjectCondition condition)throws SQLException{
		return projectMapper.getProjectInfoByIf(condition);
	}
	
	/**
	 * 根据项目Id查询项目接受信息
	 * @param projectId
	 * @return
	 * @throws SQLException
	 */
	public ProjectAccept getAcceptInfoByProjectId(String projectId)throws SQLException{
		return projectMapper.getAcceptInfoByProjectId(projectId);
	}
	/**
	 * 根据条件分页查询项目接收信息
	 * @param condition 查询条件(项目名称，申请单位，所属领域，登记时间)
	 * @return 项目接收信息(List)
	 * @throws SQLException
	 */
	public List<ProjectAccept> getProjectAcceptInfoByIf(ProjectCondition condition)throws SQLException{
		return projectMapper.getProjectAcceptInfoByIf(condition);
	}
	
	/**
	 * 添加项目发放证书信息
	 * @param issueCertificate 项目证书发放信息
	 * @return
	 * @throws SQLException
	 */
	public int addCertificate(IssueCertificate issueCertificate)throws SQLException{
		return projectMapper.addCertificate(issueCertificate);
	}
	
	/**
	 * 根据项目Id修改项目发放证书情况
	 * @param certificateInfo 项目Id 发放证书情况 
	 * @return
	 * @throws SQLException
	 */
	public int updateCertificate(Map<String,String> certificateInfo)throws SQLException{
		return updateCertificate(certificateInfo);
	}
	
	/*------------------START BY HaoShaSha ----------------------------*/
	/**
	 * 查询所有已考察项目的部分待验收信息
	 * @param condition 查询条件(项目名称，项目编号，所属领域，经费，起始行数，记录数)
	 * @return
	 */
	public List<ProjectInfoResult> getInspectedProjects(ProjectCondition condition) throws SQLException{
		
		return projectMapper.getInspectedProjects(condition); 
	}
	/**
	 * 根据meetingId某一个会议涉及到的所有项目的信息 主要是针对项目信息+验收意见初稿+真实性承诺书
	 * @param meetingId 会议编号
	 * @return
	 */
	public List<ProjectPreMaterialInfo> getProjectPreMaterialInfo(String meetingId) throws SQLException{
		
		return projectMapper.getProjectPreMaterialInfo(meetingId);
	}
	
	
	/**
	 * 根据项目编号查询项目第一阶段的所有信息
	 * @param projectId
	 * @return
	 * @throws SQLException
	 */
	public ProjectInfoOfPrepared getProjectInfoByProjectId(String projectId)throws SQLException{
		
		return projectMapper.getProjectInfoByProjectId(projectId);
	}
	/*------------------END BY HaoShaSha ----------------------------*/
	/**
	 * 根据会议编号获取全部项目信息
	 * @param meetingId 会议编号
	 * @return 全部项目基本信息
	 */
	public List<Map<String, Object>> getProjectsByMeetingId(String meetingId) throws SQLException {
		return projectMapper.getProjectsByMeetingId(meetingId);
	}
	
	/**
	 * 根据专家编号查询当前专家已经评审过的项目基本信息
	 * @param specialistId 专家编号
	 * @return 全部评审过的项目
	 * @throws SQLException
	 */
	public List<Project> getPastProjectsBySpecialistId(String specialistId) throws SQLException {
		return projectMapper.getPastProjectsBySpecialistId(specialistId);
	}

}
