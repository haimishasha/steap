package com.thinkPro.steap.db.service.project;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.meeting.ProjectInfoResult;
import com.thinkPro.steap.bean.meeting.ProjectPreMaterialInfo;
import com.thinkPro.steap.bean.project.AuditInfo;
import com.thinkPro.steap.bean.project.EnterpriseInspect;
import com.thinkPro.steap.bean.project.Project;
import com.thinkPro.steap.bean.project.ProjectAccept;
import com.thinkPro.steap.bean.project.ProjectCensor;
import com.thinkPro.steap.bean.project.ProjectCharge;
import com.thinkPro.steap.bean.project.ProjectCondition;
import com.thinkPro.steap.bean.project.ProjectInfoOfPrepared;
import com.thinkPro.steap.bean.project.ProjectReceive;
import com.thinkPro.steap.bean.project.ProjectRecord;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.base.project.ProjectBase;
import com.thinkPro.steap.db.base.sys.dic.DictionaryBase;


/**
 * 关于项目的基本操作，包括
 * 添加项目信息
 * 添加项目登记信息
 * 添加项目确定负责部门信息
 * 添加项目领取材料信息
 * 添加项目审查信息
 * 添加企业现场考察信息
 * 获得项目信息总记录树
 * 根据条件查询项目基本信息
 * 根据项目ID查询确定负责部门信息
 * 根据条件查询项目接收信息本信息
 * @author mei
 *
 */
public class ProjectService {

	private ApplicationContext context;
	private ProjectBase projectBase;
	private DictionaryBase dictionaryBase;

	public ProjectService() {
		context = new ClassPathXmlApplicationContext("applicationContext-base.xml");
		projectBase = (ProjectBase) context.getBean("projectBase");
		dictionaryBase = (DictionaryBase) context.getBean("dictionaryBase");
	}
	
	/**
	 * 登记项目信息，同时记录登记人、登记时间
	 * @param project 项目信息
	 * @param projectRecord 项目登记信息
	 * @return 如果项目信息和项目登记信息同时添加成功，返回true；否则，返回false
	 * @throws SQLException
	 */
	public boolean addProject(Project project,ProjectRecord projectRecord)throws SQLException{
		if(project != null && projectRecord != null){
			int addProjectResult = projectBase.addProject(project);
			int addRecordResult = projectBase.addProjectRecord(projectRecord);
			
			boolean result = addProjectResult>-1&&addRecordResult>-1?true:false;
			return result;
		}
		return false;
	}
	
	/**
	 * 添加项目确定负责部门信息，并修改项目状态为‘已确定负责部门’
	 * @param projectCharge 确定负责部门信息
	 * @return 如果添加确定负责部门信息和修改项目状态同时成功，返回true；否则，返回false
	 * @throws SQLException
	 */
	public boolean addProjectCharge(ProjectCharge projectCharge)throws SQLException{
		
		if(projectCharge!=null){
			int addChargeResult = projectBase.addProjectCharge(projectCharge);
			Map<String,String> projectStatus = new HashMap<String, String>();
			projectStatus.put("projectId", projectCharge.getProjectId());
			projectStatus.put("status", "100002");
			int updateStatus = projectBase.updateProjectStatus(projectStatus);
			boolean result = addChargeResult>-1&&updateStatus>-1?true:false;
			return result;
		}
		return false;
	}
	
	/**
	 * 添加领取项目资料信息，并修改项目状态为‘已领取’
	 * @param projectReceive 领取项目资料信息
	 * @return 如果添加领取项目资料信息和修改项目状态同时成功，返回true；否则，返回false
	 * @throws SQLException
	 */
	public boolean addProjectReceive(ProjectReceive projectReceive)throws SQLException{
		if(projectReceive!=null){
			int addReceiveReslt =  projectBase.addProjectReceive(projectReceive);
			Map<String,String> projectStatus = new HashMap<String, String>();
			projectStatus.put("projectId", projectReceive.getProjectId());
			projectStatus.put("status", "100003");
			int updateStatus = projectBase.updateProjectStatus(projectStatus);
			boolean result = addReceiveReslt>-1&&updateStatus>-1?true:false;
			return result;
		}
		return false;
	}
	
	/**
	 * 添加项目资料审查信息，并修改项目状态为‘已审查’
	 * @param projectCensor 项目资料审查信息
	 * @return 如果添加领取项目资料信息和修改项目状态同时成功，返回true；否则，返回false
	 * @throws SQLException
	 */
	public boolean addProjectCensor(ProjectCensor projectCensor) throws SQLException{
		
		if(projectCensor!=null){
			int addCensorResult = projectBase.addProjectCensor(projectCensor);
			Map<String,String> projectStatus = new HashMap<String, String>();
			projectStatus.put("projectId", projectCensor.getProjectId());
			projectStatus.put("status", "100004");
			int updateStatus = projectBase.updateProjectStatus(projectStatus);
			boolean result = addCensorResult>-1&&updateStatus>-1?true:false;
			return result;
		}
		return false;
	}
	
	
	/**
	 * 添加企业现场考察信息
	 * @param enterpriseInspect
	 * @return 如果添加企业现场考察信息和修改项目状态同时成功，返回true；否则，返回false
	 * @throws SQLException
	 */
	public boolean addEnterpriseInspect(EnterpriseInspect enterpriseInspect) throws SQLException{
		
		if(enterpriseInspect!=null){
			String inspectId = projectBase.getNextInspectId();
			enterpriseInspect.setInspectId(inspectId);
			int addInspectResult = projectBase.addEnterpriseInspect(enterpriseInspect);
			Map<String,String> projectStatus = new HashMap<String, String>();
			projectStatus.put("projectId", inspectId);
			projectStatus.put("status", "100005");
			int updateStatus = projectBase.updateProjectStatus(projectStatus);
			boolean result = addInspectResult>-1&&updateStatus>-1?true:false;
			return result;
		}
		return false;
	}
	
	/**
	 * 添加审计信息
	 * @param auditInfo 审计信息
	 * @return 如果添加审计信息成功，返回true；否则，返回false
	 * @throws SQLException
	 */
	public boolean addAuditInfo(AuditInfo auditInfo) throws SQLException{
		if(auditInfo!=null){
		int addInspectResult = projectBase.addAuditInfo(auditInfo);
		boolean result = addInspectResult>-1?true:false;
		return result;
		}
		return false;
	}
	
	/**
	 * 返回项目信息总记录数(用于分页)
	 * @param countCondition 查询条件(projectName,applicant,domain,recordDate)
	 * @return
	 * @throws SQLException
	 */
	public int getProjectCount(ProjectCondition condition) throws SQLException{
		return projectBase.getProjectCount(condition);
	}
	
	/**
	 * 根据项目Id查询企业现场考察信息
	 * @param projectId 项目Id
	 * @return 企业现场考察信息(EnterpriseInspect)
	 * @throws SQLException
	 */
	public EnterpriseInspect getInspectByProjectId(String projectId)throws SQLException{
		if(projectId != null && !"".equals(projectId)){
			return projectBase.getInspectByProjectId(projectId);
		}
		return null;
	}
	
	/**
	 * 根据项目Id查询审计信息
	 * @param projectId 项目Id
	 * @return 审计信息(AuditInfo)
	 * @throws SQLException
	 */
	public AuditInfo getAuditInfoByprojectId(String projectId)throws SQLException{
		if(projectId != null && !"".equals(projectId)){
			return projectBase.getAuditInfoByProjectId(projectId);
		}
		return null;
	}
	/**
	 * 根据条件分页查询项目信息
	 * @param condition 查询条件(项目名称，项目编号，所属领域，登记时间)
	 * @return 项目信息(List)
	 * @throws SQLException
	 */
	public List<Project> getProjectInfoByIf(ProjectCondition condition) throws SQLException{
		List<Project> projectList=null;
		String dictionaryName = null;
		if(condition!=null){
			projectList = projectBase.getProjectInfoByIf(condition);
			for(Project project:projectList){
				dictionaryName = dictionaryBase.getNameByCode(project.getStatus());
				project.setStatus(dictionaryName);
			}
		}
		return projectList;
	}
	
	/**
	 * 根据项目Id返回项目确认负责部门信息
	 * @param projectId 项目Id
	 * @return 确认负责部门信息
	 */
	public ProjectCharge getChargeByProjectId(String projectId)throws SQLException{
		if(projectId != null && !"".equals(projectId)){
			return projectBase.getChargeByProjectId(projectId);
		}
		return null;
	}
	
	/**
	 * 根据项目Id查询项目接受信息
	 * @param projectId
	 * @return
	 * @throws SQLException
	 */
	public ProjectAccept getAcceptInfoByProjectId(String projectId)throws SQLException{
		if(projectId != null && !"".equals(projectId)){
			return projectBase.getAcceptInfoByProjectId(projectId);
		}
		return null;
	}
	/**
	 * 根据条件分页查询项目接受信息
	 * @param condition 查询条件(项目名称，项目编号，所属领域，登记时间)
	 * @return 项目接受信息(List)
	 * @throws SQLException
	 */
	public List<ProjectAccept> getProjectAcceptInfoByIf(ProjectCondition condition) throws SQLException{
		List<ProjectAccept> projectAcceptList=null;
		String dictionaryName = null;
		if(condition!=null){
			projectAcceptList = projectBase.getProjectAcceptInfoByIf(condition);
			for(ProjectAccept project:projectAcceptList){
				dictionaryName = dictionaryBase.getNameByCode(project.getStatus());
				project.setStatus(dictionaryName);
			}
		}
		return projectAcceptList;
	}
	
	/*------------------START BY HaoShaSha ----------------------------*/
	
	/**
	 * 查询所有已考察项目的部分待验收信息
	 * @param condition 查询条件(项目名称，项目编号，所属领域，经费，起始行数，记录数)
	 * @return
	 */
	public List<ProjectInfoResult> getInspectedProjects(ProjectCondition condition) throws SQLException{
		if(condition!=null){
			
			return projectBase.getInspectedProjects(condition); 
		}
		return null;
	}
	/**
	 * 根据meetingId某一个会议涉及到的所有项目的信息 主要是针对项目信息+验收意见初稿+真实性承诺书
	 * @param meetingId 会议编号
	 * @return
	 */
	public List<ProjectPreMaterialInfo> getProjectPreMaterialInfo(String meetingId) throws SQLException{
		if(meetingId != null && !"".equals(meetingId)){
			
			return projectBase.getProjectPreMaterialInfo(meetingId);
		}
		return null;
	}
	
	/**
	 * 根据项目编号查询项目第一阶段的所有信息
	 * @param projectId
	 * @return
	 * @throws SQLException
	 */
	public ProjectInfoOfPrepared getProjectInfoByProjectId(String projectId)throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(projectId);

		if(result){
			
			return projectBase.getProjectInfoByProjectId(projectId);
		
		}else{
			
			return null;
		}
		
	}
	
	/*------------------END BY HaoShaSha ----------------------------*/
	
	
	/**
	 * 根据会议编号获取全部项目信息
	 * @param meetingId 会议编号
	 * @return 全部项目基本信息
	 */
	public List<Map<String, Object>> getProjectsByMeetingId(String meetingId) throws SQLException {
		if(meetingId != null && !"".equals(meetingId)) {
			return projectBase.getProjectsByMeetingId(meetingId);
		}
		return null;
	}
	
	/**
	 * 根据专家编号查询当前专家已经评审过的项目基本信息
	 * @param specialistId 专家编号
	 * @return 全部评审过的项目
	 * @throws SQLException
	 */
	public List<Project> getPastProjectsBySpecialistId(String specialistId) throws SQLException {
		if(specialistId != null && !"".equals(specialistId)) {
			return projectBase.getPastProjectsBySpecialistId(specialistId);
		}
		return null;
	}
}
