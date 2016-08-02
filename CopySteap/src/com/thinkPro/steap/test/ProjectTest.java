package com.thinkPro.steap.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.thinkPro.steap.bean.meeting.ProjectInfoResult;
import com.thinkPro.steap.bean.meeting.ProjectPreMaterialInfo;
import com.thinkPro.steap.bean.project.AuditInfo;
import com.thinkPro.steap.bean.project.EnterpriseInspect;
import com.thinkPro.steap.bean.project.Project;
import com.thinkPro.steap.bean.project.ProjectCensor;
import com.thinkPro.steap.bean.project.ProjectCharge;
import com.thinkPro.steap.bean.project.ProjectCondition;
import com.thinkPro.steap.bean.project.ProjectInfoOfPrepared;
import com.thinkPro.steap.bean.project.ProjectReceive;
import com.thinkPro.steap.bean.project.ProjectRecord;
import com.thinkPro.steap.db.service.project.ProjectService;

public class ProjectTest {

	private ProjectService service = new ProjectService();

	@Test
	public void testAddProject() throws Exception {
		Project project = new Project();
		project.setProjectId("22345679");
		project.setProjectName("lalalalala");
		project.setApplicant("太原科技大学");
		project.setApplicationDate("2016-01-01");
		project.setCertificate(false);
		project.setContactPerson("wang");
		project.setDomain("安全");
		project.setProjectFunds(50);
		;
		project.setTelephone("1123542");
		ProjectRecord projectRecord = new ProjectRecord();
		projectRecord.setProjectId("22345679");
		projectRecord.setRecordPerson("zhang");
		projectRecord.setRecordDate("2016-01-01");
		boolean result = service.addProject(project, projectRecord);
		System.out.println(result);
	}

	@Test
	public void testAddProjectCharge() throws Exception {
		ProjectCharge charge = new ProjectCharge();
		charge.setChargeUnit("综合部");
		charge.setChargePerson("wang");
		charge.setDestributionDate("2016-01-01");
		charge.setProjectId("22345679");
		boolean result = service.addProjectCharge(charge);
		System.out.println(result);
	}

	@Test
	public void testAddProjectReceive() throws Exception {
		ProjectReceive projectReceive = new ProjectReceive();
		projectReceive.setProjectId("22345679");
		projectReceive.setReceiveDate("2016-01-01");
		projectReceive.setReceivePerson("wang");
		projectReceive.setReceiveResult("资料领取，没问题");
		boolean result = service.addProjectReceive(projectReceive);
		System.out.println(result);
	}

	@Test
	public void testAddProjectCensor() throws Exception {
		ProjectCensor projectCensor = new ProjectCensor();
		projectCensor.setCensorDate("2016-01-01");
		projectCensor.setCensorPerson("wang");
		projectCensor.setCensorResult("审核没问题");
		projectCensor.setProjectId("12345678");
		boolean result = service.addProjectCensor(projectCensor);
		System.out.println(result);
	}

	@Test
	public void testAddEnterpriseInspect() throws Exception {
		EnterpriseInspect enterpriseInspect = new EnterpriseInspect();
		enterpriseInspect.setAudit(true);
		enterpriseInspect.setInspectDate("2016-01-01");
		enterpriseInspect.setInspectPerson("wang");
		enterpriseInspect.setInspectResult("考察没问题");
		enterpriseInspect.setProjectId("P1000001");
		boolean result = service.addEnterpriseInspect(enterpriseInspect);
		System.out.println(result+"   "+enterpriseInspect.getInspectId());
	}

	@Test
	public void testAddAuditInfo() throws Exception {
		AuditInfo auditInfo = new AuditInfo();
		auditInfo.setAuditDate("2016-01-01");
		auditInfo.setAuditingPerson("wang");
		auditInfo.setFinanceUnit("财经");
		auditInfo.setInspectId("EI10000012");
		boolean result = service.addAuditInfo(auditInfo);
		System.out.println(result);
	}

	@Test
	public void testGetProjectCount() throws Exception {
		ProjectCondition condition = new ProjectCondition();
		condition.setRecordPerson("U100007");
		System.out.println(service.getProjectCount(condition));
	}

	@Test
	public void testGetChargeByProjectId() throws SQLException {
		System.out.println(service.getChargeByProjectId("P1000001"));
	}

	@Test
	public void testGetInspectByProjectId() throws Exception {
		System.out.println(service.getInspectByProjectId("P1000002"));
	}

	@Test
	public void testGetAuditInfoByprojectId() throws Exception {
		System.out.println(service.getAuditInfoByprojectId("12345678"));
	}

	@Test
	public void testGetProjectInfoByIf() throws Exception {
		ProjectCondition condition = new ProjectCondition();
		condition.setRecordDate("2016-06-01");
		condition.setPageSize(10);
		condition.setPageBegin(0);
		System.out.println(service.getProjectInfoByIf(condition));
	}

	@Test
	public void testGetAcceptInfoByProjectId() throws Exception {
		System.out.println(service.getAcceptInfoByProjectId("P1000001"));
	}
	
	@Test
	public void testGetProjectAcceptInfoByIf() throws Exception {
		ProjectCondition condition = new ProjectCondition();
		condition.setApplicant("中北大学");
		condition.setPageSize(10);
		condition.setPageBegin(2);
		System.out.println(service.getProjectAcceptInfoByIf(condition));
	}
	/*------------------START BY HaoShaSha ----------------------------*/

	@Test
	public void testGetInspectedProjects() {

		System.out.println("===========getInspectedProjects==========");

		List<ProjectInfoResult> projects;
		
		ProjectCondition condition =  new ProjectCondition();
		
		//condition.setProjectName("起重机模块化参数化云设计平台应用示范研究");
		condition.setPageBegin(0);
		condition.setPageSize(10);
		condition.setApplicant("中北大学");
		condition.setDomain("能源与节能环保领域");
		condition.setProjectFunds("1");
		try {
			projects = service.getInspectedProjects(condition);
			for (ProjectInfoResult project : projects) {

				System.out.println(project.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetProjectPreMaterialInfo() {

		System.out
				.println("===========testGetProjectPreMaterialInfoMap==========");

		String meetingId = "M100001";

		List<ProjectPreMaterialInfo> pemis;
		try {
			pemis = service.getProjectPreMaterialInfo(meetingId);

			for (ProjectPreMaterialInfo pemi : pemis) {

				System.out.println(pemi.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetProjectInfoByProjectId(){
		
		String projectId = "P1000002";
		
		try {
			ProjectInfoOfPrepared project = service.getProjectInfoByProjectId(projectId);
			
			System.out.println(project);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/*------------------END BY HaoShaSha ----------------------------*/

}
