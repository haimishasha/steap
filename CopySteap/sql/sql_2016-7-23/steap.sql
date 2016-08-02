/*
Navicat MySQL Data Transfer

Source Server         : program
Source Server Version : 50629
Source Host           : localhost:3306
Source Database       : steap

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2016-07-23 21:31:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for complete_material
-- ----------------------------
DROP TABLE IF EXISTS `complete_material`;
CREATE TABLE `complete_material` (
  `completeId` varchar(40) NOT NULL COMMENT '完善资料编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `fileId` int(11) NOT NULL,
  PRIMARY KEY (`completeId`),
  KEY `FK_Reference_27` (`projectId`),
  KEY `FK_Reference_30` (`fileId`),
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`),
  CONSTRAINT `FK_Reference_30` FOREIGN KEY (`fileId`) REFERENCES `t_files_index` (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='完善资料表\r\n';

-- ----------------------------
-- Records of complete_material
-- ----------------------------
INSERT INTO `complete_material` VALUES ('37bbc1ec-c47b-4286-a232-f54dfd24e5d6', 'P1000010', '97');
INSERT INTO `complete_material` VALUES ('461356fd-1e0b-4654-95e7-3f24bf403a1c', 'P1000006', '58');
INSERT INTO `complete_material` VALUES ('542a837e-f24d-4ded-ab12-6957fffd4901', 'P1000005', '48');
INSERT INTO `complete_material` VALUES ('63108749-256b-4e35-a3e1-f390f40568e6', 'P1000002', '18');
INSERT INTO `complete_material` VALUES ('648cb163-54a1-4a97-bbff-56dd75956fb3', 'P1000007', '67');
INSERT INTO `complete_material` VALUES ('71ac2431-4649-48f1-94f0-4c9ef2b5ae30', 'P1000003', '27');
INSERT INTO `complete_material` VALUES ('71ed9347-cb59-467c-af0e-ccaebe7a5db8', 'P1000009', '87');
INSERT INTO `complete_material` VALUES ('722eb38b-0e71-4261-8ff9-40f05fa95cba', 'P1000004', '38');
INSERT INTO `complete_material` VALUES ('75c7e492-3bfd-4c3c-92da-7f6161d5896e', 'P1000004', '37');
INSERT INTO `complete_material` VALUES ('779fb16a-2773-4a8d-b06a-6131386a12e9', 'P1000010', '98');
INSERT INTO `complete_material` VALUES ('928ebc38-dbdd-47b0-9c9c-866d710e2532', 'P1000003', '28');
INSERT INTO `complete_material` VALUES ('9ed8a08e-ba8a-44ad-9f2b-98b74a70f600', 'P1000001', '17');
INSERT INTO `complete_material` VALUES ('a7899926-ed9a-4c07-83c9-7babc312b607', 'P1000005', '47');
INSERT INTO `complete_material` VALUES ('afe095db-cbb1-46d0-bfe6-6c388b1ed91e', 'P1000008', '78');
INSERT INTO `complete_material` VALUES ('d31028a4-ed87-420e-905c-1f981fbff367', 'P1000007', '68');
INSERT INTO `complete_material` VALUES ('e1f929ca-8aa8-493b-9ed0-7c862014e859', 'P1000009', '88');
INSERT INTO `complete_material` VALUES ('f5a0ce93-1593-44fb-96c8-e65635612a2d', 'P1000008', '77');
INSERT INTO `complete_material` VALUES ('f859eb3b-bc6e-4c76-8cef-900edccc57f7', 'P1000006', '57');

-- ----------------------------
-- Table structure for dic_system_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dic_system_dictionary`;
CREATE TABLE `dic_system_dictionary` (
  `dictionaryOptionId` varchar(40) NOT NULL,
  `dictionaryOptionName` varchar(50) DEFAULT NULL,
  `upDictionaryOptionId` varchar(40) DEFAULT NULL,
  `isUse` bit(1) DEFAULT b'1',
  `description` varchar(200) DEFAULT NULL,
  `sortNo` int(11) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `englishName` varchar(100) DEFAULT NULL,
  `dataType` varchar(100) DEFAULT NULL,
  `remark1` varchar(50) DEFAULT NULL,
  `remark2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dictionaryOptionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典表';

-- ----------------------------
-- Records of dic_system_dictionary
-- ----------------------------
INSERT INTO `dic_system_dictionary` VALUES ('100', '项目状态', null, '', '项目状态', '0', '0', 'projectStatus', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100001', '已登记', '100', '', '已登记', '0', '0', 'recorded', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100002', '已确定验收负责部门', '100', '', '已确定验收负责部门', '0', '0', 'charged', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100003', '已领取验收项目资料', '100', '', '已领取验收项目资料', '0', '0', 'recieved', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100004', '已审核', '100', '', '已审核', '0', '0', 'verified', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100005', '已现场考察', '100', '', '已现场考察', '0', '0', 'censored', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('200', '会议状态', null, '', '会议状态', '0', '0', 'meetingStatus', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('200001', '准备中', '200', '', '准备中', '0', '0', 'preparing', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('200002', '召开中', '200', '', '召开中', '0', '0', 'holding', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('200003', '已完成', '200', '', '已完成', '0', '0', 'finished', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300', '文件类型', null, '', '文件类型', '0', '0', 'fileType', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300001', '验收意见初稿', '300', '', '验收意见初稿', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300002', '科技项目验收申请书', '300', '', '科技项目验收申请书', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300003', '承诺书', '300', '', '承诺书', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300004', '计划任务书', '300', '', '计划任务书', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300005', '项目实施工作总结报告', '300', '', '项目实施工作总结报告', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300006', '项目实施技术总结报告', '300', '', '项目实施技术总结报告', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300007', '项目立项后相关证明材料', '300', '', '项目立项后相关证明材料', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300008', '科技项目验收财务资料一套', '300', '', '科技项目验收财务资料一套', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('400', '图片类型', null, '', '图片类型', '0', '0', 'pictureType', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('400001', '考察照片', '400', '', '考察照片', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('400002', '廉洁承诺书', '400', '', '廉洁承诺书', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('400003', '真实性承诺书', '400', '', '真实性承诺书', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('500', '机构', null, '', '机构', '0', '0', 'institution', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('500001', '专项管理机构业务处室', '500', '', '专项管理机构业务处室', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('500002', '局纪检监察领导', '500', '', '局纪检监察领导', '0', '0', null, null, null, null);

-- ----------------------------
-- Table structure for enterprise_inspect
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_inspect`;
CREATE TABLE `enterprise_inspect` (
  `inspectId` varchar(10) NOT NULL COMMENT '考察编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `inspectPerson` varchar(30) NOT NULL,
  `inspectDate` date DEFAULT NULL,
  `inspectResult` longtext NOT NULL,
  `isAudit` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`inspectId`),
  KEY `FK_Reference_3` (`projectId`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业考察表';

-- ----------------------------
-- Records of enterprise_inspect
-- ----------------------------
INSERT INTO `enterprise_inspect` VALUES ('EI10000001', 'P1000001', 'U100006', '2016-05-19', '该项目验收资料基本合格', '\0');
INSERT INTO `enterprise_inspect` VALUES ('EI10000002', 'P1000002', 'U100006', '2016-05-22', '该项目验收资料基本合格', '');
INSERT INTO `enterprise_inspect` VALUES ('EI10000003', 'P1000003', 'U100006', '2016-05-23', '该项目验收资料基本合格', '');
INSERT INTO `enterprise_inspect` VALUES ('EI10000004', 'P1000004', 'U100006', '2016-05-24', '该项目验收资料基本合格', '');
INSERT INTO `enterprise_inspect` VALUES ('EI10000005', 'P1000005', 'U100006', '2016-05-26', '该项目验收资料基本合格', '');
INSERT INTO `enterprise_inspect` VALUES ('EI10000006', 'P1000006', 'U100006', '2016-06-19', '该项目验收资料基本合格', '\0');
INSERT INTO `enterprise_inspect` VALUES ('EI10000007', 'P1000007', 'U100006', '2016-06-20', '该项目验收资料基本合格', '');
INSERT INTO `enterprise_inspect` VALUES ('EI10000008', 'P1000008', 'U100006', '2016-06-21', '该项目验收资料基本合格', '\0');
INSERT INTO `enterprise_inspect` VALUES ('EI10000009', 'P1000009', 'U100006', '2016-06-21', '该项目验收资料基本合格', '');
INSERT INTO `enterprise_inspect` VALUES ('EI10000010', 'P1000010', 'U100006', '2016-06-22', '该项目验收资料基本合格', '');

-- ----------------------------
-- Table structure for evaluation_reslut
-- ----------------------------
DROP TABLE IF EXISTS `evaluation_reslut`;
CREATE TABLE `evaluation_reslut` (
  `evaluateResultId` varchar(40) NOT NULL COMMENT '评审结果编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `evaluateResult` longtext NOT NULL COMMENT '评审意见',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`evaluateResultId`),
  KEY `FK_Reference_17` (`projectId`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评审结果表';

-- ----------------------------
-- Records of evaluation_reslut
-- ----------------------------
INSERT INTO `evaluation_reslut` VALUES ('12ec23cd-f1ff-4a9f-86ad-c9b33fff18c5', 'P1000007', '根据项目验收时，专家提出的修改意见完善相应的资料，完善原则是增加不修改。比如，提出工作报告需要修改，则可以将修改后的工作报告上传到对应项目中，但不覆盖原来的工作报告，其他内容类似。', null);
INSERT INTO `evaluation_reslut` VALUES ('21de437c-4b2d-410d-aa29-0f2dc895c5ce', 'P1000004', '根据验收时间、项目名称、项目单位等等条件进行查询，并以列表展示查询结果，列表默认按照验收日期降序显示验收项目基本信息（项目名称、项目单位、项目金额、验收时间等），点击项目名称可以查看详情。', null);
INSERT INTO `evaluation_reslut` VALUES ('5d930460-455b-4d74-bdad-3a717754e59a', 'P1000010', '除基本信息外，展示项目的验收材料、验收信息（包括专家组名单、专家意见、项目意见）。', null);
INSERT INTO `evaluation_reslut` VALUES ('68a9dcb1-53f1-49e9-b34e-844b7e62587c', 'P1000002', '根据项目验收时，专家提出的修改意见完善相应的资料，完善原则是增加不修改。比如，提出工作报告需要修改，则可以将修改后的工作报告上传到对应项目中，但不覆盖原来的工作报告，其他内容类似。', null);
INSERT INTO `evaluation_reslut` VALUES ('791f9ec7-061d-4863-b759-fe0f9d23dfa6', 'P1000009', '根据验收时间、项目名称、项目单位等等条件进行查询，并以列表展示查询结果，列表默认按照验收日期降序显示验收项目基本信息（项目名称、项目单位、项目金额、验收时间等），点击项目名称可以查看详情，', null);
INSERT INTO `evaluation_reslut` VALUES ('b3c06212-704d-49d4-b284-a17a67db08a7', 'P1000008', '根据项目验收时，专家提出的修改意见完善相应的资料，完善原则是增加不修改。比如，提出工作报告需要修改，则可以将修改后的工作报告上传到对应项目中，但不覆盖原来的工作报告，其他内容类似。', null);
INSERT INTO `evaluation_reslut` VALUES ('e30a3056-e90d-4e35-8636-1fbb45345bbd', 'P1000003', '根据项目验收时，专家提出的修改意见完善相应的资料，完善原则是增加不修改。比如，提出工作报告需要修改，则可以将修改后的工作报告上传到对应项目中，但不覆盖原来的工作报告，其他内容类似。', null);
INSERT INTO `evaluation_reslut` VALUES ('e93362ad-f2fe-4660-86bd-a09d38cf15a4', 'P1000005', '根据验收时间、项目名称、项目单位等等条件进行查询，并以列表展示查询结果，列表默认按照验收日期降序显示验收项目基本信息（项目名称、项目单位、项目金额、验收时间等），点击项目名称可以查看详情，', null);
INSERT INTO `evaluation_reslut` VALUES ('e9747a8c-4fcd-4d37-90c2-36c63f251d7e', 'P1000006', '根据验收时间、项目名称、项目单位等等条件进行查询，并以列表展示查询结果，列表默认按照验收日期降序显示验收项目基本信息（项目名称、项目单位、项目金额、验收时间等），点击项目名称可以查看详情，', null);
INSERT INTO `evaluation_reslut` VALUES ('f5b73ace-2c7c-41c9-a202-93e68007bc2c', 'P1000001', '根据项目验收时，专家提出的修改意见完善相应的资料，完善原则是增加不修改。比如，提出工作报告需要修改，则可以将修改后的工作报告上传到对应项目中，但不覆盖原来的工作报告，其他内容类似。', null);

-- ----------------------------
-- Table structure for inspect_audit
-- ----------------------------
DROP TABLE IF EXISTS `inspect_audit`;
CREATE TABLE `inspect_audit` (
  `auditId` varchar(40) NOT NULL COMMENT '审计编号',
  `inspectId` varchar(10) NOT NULL COMMENT '考察编号',
  `financeUnit` varchar(30) NOT NULL COMMENT '财务单位\r\n            ',
  `auditingPerson` varchar(30) NOT NULL COMMENT '审计人员',
  `auditDate` date NOT NULL COMMENT '审计日期',
  PRIMARY KEY (`auditId`),
  KEY `FK_Reference_16` (`inspectId`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`inspectId`) REFERENCES `enterprise_inspect` (`inspectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目审计表\r\n';

-- ----------------------------
-- Records of inspect_audit
-- ----------------------------
INSERT INTO `inspect_audit` VALUES ('01a259e0-74dd-4d3d-82f7-53dc8102ce5e', 'EI10000004', '山西同联会计师事务所', '蒋毅', '2016-05-24');
INSERT INTO `inspect_audit` VALUES ('0908fec4-aade-4b41-8cf2-d7208067c455', 'EI10000009', '山西同联会计师事务所', '李春梅', '2016-06-21');
INSERT INTO `inspect_audit` VALUES ('1f4110e7-f62f-497f-bb4e-e3702152e24b', 'EI10000003', '山西同联会计师事务所', '刘乃玲', '2016-05-23');
INSERT INTO `inspect_audit` VALUES ('209d003c-1705-42ca-acbf-aa5c7f006e41', 'EI10000005', '山西同联会计师事务所', '李春梅', '2016-05-26');
INSERT INTO `inspect_audit` VALUES ('4a3cb485-d56f-42f0-af16-652b501589f1', 'EI10000002', '山西同联会计师事务所', '李春梅', '2016-05-22');
INSERT INTO `inspect_audit` VALUES ('888a555f-e3af-4d1a-9777-fbf421ae2c5e', 'EI10000007', '山西同联会计师事务所', '蒋毅', '2016-06-20');
INSERT INTO `inspect_audit` VALUES ('902b72cf-d3e0-454f-b796-eab202e82c68', 'EI10000010', '山西同联会计师事务所', '蒋毅', '2016-06-22');

-- ----------------------------
-- Table structure for institution_notify
-- ----------------------------
DROP TABLE IF EXISTS `institution_notify`;
CREATE TABLE `institution_notify` (
  `notifyId` varchar(40) NOT NULL COMMENT '通知编号',
  `meetingId` varchar(7) NOT NULL COMMENT '会议编号',
  `institutionName` varchar(30) NOT NULL COMMENT '部门名称',
  `notifier` varchar(30) NOT NULL COMMENT '通知人',
  `notifyDate` date DEFAULT NULL COMMENT '通知日期',
  `notifyMethod` varchar(10) DEFAULT NULL COMMENT '通知方式',
  `contactPerson` varchar(30) NOT NULL,
  PRIMARY KEY (`notifyId`),
  KEY `FK_Reference_34` (`meetingId`),
  CONSTRAINT `FK_Reference_34` FOREIGN KEY (`meetingId`) REFERENCES `t_meeting_base_info` (`meetingId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构通知表';

-- ----------------------------
-- Records of institution_notify
-- ----------------------------
INSERT INTO `institution_notify` VALUES ('119bf976-6cb0-4744-af85-2a9f92991013', 'M100001', '局纪检监察领导', 'U100004', '2016-05-31', '手机', '李彤');
INSERT INTO `institution_notify` VALUES ('17830dec-8e1c-486f-829e-7180bff1c2f2', 'M100001', '专项管理机构', 'U100004', '2016-05-31', '邮件', '高宏严');
INSERT INTO `institution_notify` VALUES ('188637aa-87a5-4ce2-9fb2-76258549239b', 'M100003', '局纪检监查领导', 'U100004', '2016-06-26', '邮件', '李彤');
INSERT INTO `institution_notify` VALUES ('18b9ad0a-35a9-4230-9b44-6fc49fe778a3', 'M100002', '专项管理机构', 'U100004', '2016-05-28', '邮件', '高宏严');
INSERT INTO `institution_notify` VALUES ('19e606ce-f262-4b98-98d1-1f921a0cb909', 'M100004', '专项管理机构', 'U100004', '2016-06-27', '手机', '高宏严');
INSERT INTO `institution_notify` VALUES ('1bdb12f2-9e14-477c-8aa5-52fa85eef3e4', 'M100004', '局纪检监察领导', 'U100004', '2016-07-27', '邮件', '李彤');
INSERT INTO `institution_notify` VALUES ('1e579b80-bd05-4235-be4f-53b8a13466b9', 'M100002', '局纪检监察领导', 'U100004', '2016-05-28', '邮件', '李彤');
INSERT INTO `institution_notify` VALUES ('6108c44f-28a6-4661-b3da-f9d7f4b7cdc6', 'M100003', '专项管理机构', 'U100004', '2016-06-26', '手机', '高宏严');

-- ----------------------------
-- Table structure for issue_certificate
-- ----------------------------
DROP TABLE IF EXISTS `issue_certificate`;
CREATE TABLE `issue_certificate` (
  `issueId` varchar(40) NOT NULL COMMENT '发放编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `issuePerson` varchar(30) NOT NULL COMMENT '发放人',
  `issueDate` date DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`issueId`),
  KEY `FK_Reference_20` (`projectId`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='证书发放表';

-- ----------------------------
-- Records of issue_certificate
-- ----------------------------
INSERT INTO `issue_certificate` VALUES ('0c16d2fe-1136-4377-a4f4-9f4da28dd39a', 'P1000002', 'U100006', '2016-07-10', null);
INSERT INTO `issue_certificate` VALUES ('28e8cb40-c30d-4feb-801d-14eabd47eb2c', 'P1000005', 'U100006', '2016-06-10', null);
INSERT INTO `issue_certificate` VALUES ('388188e3-f6e5-43a7-b98b-9d6aef1d3355', 'P1000010', 'U100006', '2016-07-10', null);
INSERT INTO `issue_certificate` VALUES ('68e7f2b1-9b2b-4e46-98d6-171094dfa0c3', 'P1000003', 'U100006', '2016-06-13', null);
INSERT INTO `issue_certificate` VALUES ('71529355-cc6f-408e-abbe-5dbcfb8896ed', 'P1000006', 'U100006', '2016-07-09', null);
INSERT INTO `issue_certificate` VALUES ('7282c932-c2cf-43f7-866d-7bd4b9cc8b0f', 'P1000004', 'U100006', '2016-06-10', null);
INSERT INTO `issue_certificate` VALUES ('8e60701a-6416-41b4-9441-38d271a9b092', 'P1000007', 'U100006', '2016-07-09', null);
INSERT INTO `issue_certificate` VALUES ('abfd258f-b199-4a20-b35a-0d4144ac1ffe', 'P1000001', 'U100006', '2016-06-13', null);
INSERT INTO `issue_certificate` VALUES ('b45e33cb-0991-429e-818a-5e805498e905', 'P1000008', 'U100006', '2016-07-09', null);
INSERT INTO `issue_certificate` VALUES ('b681ab01-d8ce-4066-8957-cbc1a1de6ed7', 'P1000009', 'U100006', '2016-07-10', null);

-- ----------------------------
-- Table structure for project_accept
-- ----------------------------
DROP TABLE IF EXISTS `project_accept`;
CREATE TABLE `project_accept` (
  `acceptId` varchar(40) NOT NULL COMMENT '项目接收编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `recordDate` date NOT NULL COMMENT '登记日期',
  `recordPerson` varchar(30) NOT NULL COMMENT '登记人',
  `chargeUnit` varchar(30) DEFAULT NULL COMMENT '负责部门',
  `chargePerson` varchar(30) DEFAULT NULL COMMENT '负责人',
  `distributionDate` date DEFAULT NULL COMMENT '分配时间',
  `receiveDate` date DEFAULT NULL COMMENT '领取时间',
  `receivePerson` varchar(30) DEFAULT NULL COMMENT '领取人',
  `receiveResult` longtext,
  `remark1` varchar(50) DEFAULT NULL COMMENT '备注1',
  `remark2` varchar(50) DEFAULT NULL COMMENT '备注2',
  `remark3` varchar(50) DEFAULT NULL COMMENT '备注3',
  PRIMARY KEY (`acceptId`),
  KEY `FK_Reference_5` (`projectId`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目接收表';

-- ----------------------------
-- Records of project_accept
-- ----------------------------
INSERT INTO `project_accept` VALUES ('098c1f31-eddf-465a-b20e-efba2ea80c9b', 'P1000006', '2016-06-14', 'U100007', '成果评估部门', 'U100006', '2016-06-14', '2016-06-15', 'U100006', '已全部领取', null, null, null);
INSERT INTO `project_accept` VALUES ('0be4617f-fd01-467e-a4d6-cea3de8cb6c4', 'P1000004', '2016-05-19', 'U100007', '成果评估部门', 'U100006', '2016-05-19', '2016-05-20', 'U100006', '已全部领取', null, null, null);
INSERT INTO `project_accept` VALUES ('14614d6a-99e0-43b5-8546-917379cd5ad2', 'P1000007', '2016-06-15', 'U100007', '成果评估部门', 'U100006', '2016-06-15', '2016-06-16', 'U100006', '已全部领取', null, null, null);
INSERT INTO `project_accept` VALUES ('325d4b22-444c-4703-bd8b-68e24c6c04ca', 'P1000003', '2016-05-18', 'U100007', '成果评估部门', 'U100006', '2016-05-18', '2016-05-19', 'U100006', '已全部领取', null, null, null);
INSERT INTO `project_accept` VALUES ('3cae4d4b-3ef8-4eb7-9971-6e928d4a260f', 'P1000002', '2016-05-17', 'U100007', '成果评估部门', 'U100006', '2016-05-17', '2016-05-18', 'U100006', '已全部领取', null, null, null);
INSERT INTO `project_accept` VALUES ('5453c482-9bb5-42c0-94a0-548a467fcab2', 'P1000010', '2016-06-17', 'U100007', '成果评估部门', 'U100006', '2016-06-17', '2016-06-18', 'U100006', '已全部领取', null, null, null);
INSERT INTO `project_accept` VALUES ('65ea74b7-5710-450d-adf1-5817c80a436a', 'P1000001', '2016-05-14', 'U100007', '成果评估部门', 'U100006', '2016-05-14', '2016-05-15', 'U100006', '已全部领取', null, null, null);
INSERT INTO `project_accept` VALUES ('94cc2644-7f81-452d-9c2f-d26d02549351', 'P1000009', '2016-06-16', 'U100007', '成果评估部门', 'U100006', '2016-06-16', '2016-06-17', 'U100006', '已全部领取', null, null, null);
INSERT INTO `project_accept` VALUES ('96296ac6-0269-4260-b838-99c56ca14ee8', 'P1000005', '2016-05-21', 'U100007', '成果评估部门', 'U100006', '2016-05-21', '2016-05-22', 'U100006', '已全部领取', null, null, null);
INSERT INTO `project_accept` VALUES ('e2b02637-c5d9-4fc9-b91a-b1c6628d5842', 'P1000008', '2016-06-16', 'U100007', '成果评估部门', 'U100006', '2016-06-16', '2016-06-17', 'U100006', '已全部领取', null, null, null);

-- ----------------------------
-- Table structure for project_censor
-- ----------------------------
DROP TABLE IF EXISTS `project_censor`;
CREATE TABLE `project_censor` (
  `censorId` varchar(40) NOT NULL COMMENT '审查Id',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `censorDate` date NOT NULL COMMENT '审查时间',
  `censorPerson` varchar(30) NOT NULL COMMENT '审查人',
  `censorResult` longtext NOT NULL COMMENT '审查意见',
  PRIMARY KEY (`censorId`),
  KEY `FK_Reference_2` (`projectId`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目审查表';

-- ----------------------------
-- Records of project_censor
-- ----------------------------
INSERT INTO `project_censor` VALUES ('0903906f-2e61-4b2f-b592-cf05e9ae12e2', 'P1000003', '2016-05-20', 'U100006', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件');
INSERT INTO `project_censor` VALUES ('1245bc35-b5ae-4480-a19f-6c2988405250', 'P1000008', '2016-06-18', 'U100006', '存在以下问题：1、没有提供财务证明 2、需要提供论文复印件');
INSERT INTO `project_censor` VALUES ('2d0a75b1-b9da-4efa-9547-a43a94a41acc', 'P1000005', '2016-05-23', 'U100006', '存在以下问题：1、没有提供财务证明 2、需要提供论文复印件');
INSERT INTO `project_censor` VALUES ('51f9b95f-6737-419e-a1d3-3c4aa2077507', 'P1000006', '2016-06-16', 'U100006', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明');
INSERT INTO `project_censor` VALUES ('62ef1de6-fbdf-4ee8-a83c-22879d6c6da3', 'P1000009', '2016-06-18', 'U100006', '该项目验收资料基本合格，但存在以下问题：需要提供论文复印件');
INSERT INTO `project_censor` VALUES ('6f0c8212-ada0-41b7-a339-41d8a3dca5c8', 'P1000010', '2016-06-19', 'U100006', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件');
INSERT INTO `project_censor` VALUES ('92881451-9f5e-45f2-b7fc-5f45329614e9', 'P1000004', '2016-05-21', 'U100006', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件');
INSERT INTO `project_censor` VALUES ('976aa703-813f-43cf-9b96-883e30084a90', 'P1000002', '2016-05-19', 'U100006', '该项目验收资料基本合格，但存在以下问题：需要提供论文复印件');
INSERT INTO `project_censor` VALUES ('98355987-2b4b-4426-aa9c-2734017159b7', 'P1000001', '2016-05-16', 'U100006', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件');
INSERT INTO `project_censor` VALUES ('d0442088-0e8a-4c0a-ac19-b37ce14503dd', 'P1000007', '2016-06-17', 'U100006', '问题：1、没有提供财务证明 2、需要提供论文复印件');

-- ----------------------------
-- Table structure for project_material
-- ----------------------------
DROP TABLE IF EXISTS `project_material`;
CREATE TABLE `project_material` (
  `materialId` varchar(40) NOT NULL,
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `fileId` int(11) NOT NULL,
  PRIMARY KEY (`materialId`),
  KEY `FK_Reference_18` (`projectId`),
  KEY `FK_Reference_29` (`fileId`),
  CONSTRAINT `FK_FILE` FOREIGN KEY (`fileId`) REFERENCES `t_files_index` (`fileId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`),
  CONSTRAINT `FK_Reference_29` FOREIGN KEY (`fileId`) REFERENCES `t_files_index` (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目资料表\r\n';

-- ----------------------------
-- Records of project_material
-- ----------------------------
INSERT INTO `project_material` VALUES ('08734fbe-8154-4cea-9cad-b0bf1f3f6649', 'P1000002', '13');
INSERT INTO `project_material` VALUES ('095d6273-e968-477a-80f0-75191c071e4b', 'P1000007', '61');
INSERT INTO `project_material` VALUES ('0978a666-e6ff-431a-a283-812c0b3dd07e', 'P1000006', '49');
INSERT INTO `project_material` VALUES ('0a99cef4-93d6-4e85-9f1e-c3729f57b2d3', 'P1000009', '85');
INSERT INTO `project_material` VALUES ('0b228a5c-30c3-4961-b991-833cc18dd144', 'P1000009', '85');
INSERT INTO `project_material` VALUES ('0b8eb87f-1efd-4c51-83a9-c4dc0aa164df', 'P1000007', '61');
INSERT INTO `project_material` VALUES ('11f8c074-7e01-4dcf-ae0b-69e2493de5f8', 'P1000006', '49');
INSERT INTO `project_material` VALUES ('1366e648-4864-4d0d-94d8-2df8e1505bd6', 'P1000003', '19');
INSERT INTO `project_material` VALUES ('1412f780-a84d-4155-8b88-5bb63990c1bc', 'P1000005', '46');
INSERT INTO `project_material` VALUES ('14170792-2bfc-4cf3-8b0f-e4d0d977fb84', 'P1000004', '29');
INSERT INTO `project_material` VALUES ('15a9d981-c161-4ce2-b75c-bdb91a25171e', 'P1000009', '85');
INSERT INTO `project_material` VALUES ('18d4298b-c563-42dd-b781-9115e3cd1d02', 'P1000008', '73');
INSERT INTO `project_material` VALUES ('1e9e38f4-c614-4d97-a9ad-92257e8ef512', 'P1000003', '20');
INSERT INTO `project_material` VALUES ('1f8f9eb8-8bf7-4fec-ac03-5da82a64ee9c', 'P1000007', '61');
INSERT INTO `project_material` VALUES ('22687522-a6a1-4d6b-8a86-847be93726f9', 'P1000001', '7');
INSERT INTO `project_material` VALUES ('22e838d9-f621-4b1a-b000-94c80b769388', 'P1000008', '73');
INSERT INTO `project_material` VALUES ('26711012-3d4b-48e8-ba32-08b9a82f9f2b', 'P1000007', '61');
INSERT INTO `project_material` VALUES ('2b4cf535-b754-45be-9b9b-8438ddd6fe45', 'P1000008', '73');
INSERT INTO `project_material` VALUES ('2d357c64-42d7-42d3-b340-cc5723b4dc9d', 'P1000003', '24');
INSERT INTO `project_material` VALUES ('32c606b0-9ba6-4ca4-aee8-46d897a31d8e', 'P1000009', '85');
INSERT INTO `project_material` VALUES ('3692f58e-2153-4c53-ab00-ae587f99b09b', 'P1000002', '9');
INSERT INTO `project_material` VALUES ('3a62a3c3-31a3-483f-a2d4-330285107575', 'P1000001', '1');
INSERT INTO `project_material` VALUES ('3b755d9a-c01d-4da3-821f-18ec2b79518c', 'P1000001', '2');
INSERT INTO `project_material` VALUES ('3d81fb1c-f78f-4e35-b700-545cfd439343', 'P1000001', '8');
INSERT INTO `project_material` VALUES ('3edac148-da1a-442c-8834-9f2b76d42d17', 'P1000005', '42');
INSERT INTO `project_material` VALUES ('47e1022a-a619-4545-88a9-c31d2cd85091', 'P1000007', '61');
INSERT INTO `project_material` VALUES ('4c4899a9-7d5d-418a-9352-5eb6f435ed12', 'P1000009', '85');
INSERT INTO `project_material` VALUES ('4cd6b8fe-194e-4f9d-93fa-765e61a8f0c0', 'P1000006', '49');
INSERT INTO `project_material` VALUES ('4d9e638d-1c66-44ef-af2b-40a1294370fc', 'P1000008', '73');
INSERT INTO `project_material` VALUES ('52632c34-8637-430d-908b-53727dccc393', 'P1000006', '49');
INSERT INTO `project_material` VALUES ('531188eb-d970-4487-9bff-728353109c7e', 'P1000008', '73');
INSERT INTO `project_material` VALUES ('568ec4d4-c3f6-4e0a-8865-2c7f08f3130e', 'P1000008', '73');
INSERT INTO `project_material` VALUES ('59108551-9035-4419-ba56-90d2f9fc3ada', 'P1000003', '21');
INSERT INTO `project_material` VALUES ('5fa1aef4-24ed-4bb9-a669-6d373dfc5759', 'P1000005', '40');
INSERT INTO `project_material` VALUES ('65fade38-afe2-4faa-bcc8-1e5bd050555b', 'P1000001', '4');
INSERT INTO `project_material` VALUES ('66dee828-6baa-4ab2-8687-75330e4667f0', 'P1000009', '85');
INSERT INTO `project_material` VALUES ('68c4ace7-b999-407c-b90e-55a4c9ceaca2', 'P1000006', '49');
INSERT INTO `project_material` VALUES ('6a285dd1-ba13-4e32-9fda-313d47344b14', 'P1000002', '16');
INSERT INTO `project_material` VALUES ('703e59a1-d47f-43d2-b46a-106d95bf29d9', 'P1000001', '6');
INSERT INTO `project_material` VALUES ('737272bb-140e-4b16-9838-61a299c4a744', 'P1000008', '73');
INSERT INTO `project_material` VALUES ('74926aa7-318b-49de-85ff-671f353db7ac', 'P1000005', '41');
INSERT INTO `project_material` VALUES ('86160c7b-9ba8-4388-88a1-fbc0050b3965', 'P1000004', '33');
INSERT INTO `project_material` VALUES ('87fbba99-d39f-4bab-a551-0c3802a554e8', 'P1000005', '43');
INSERT INTO `project_material` VALUES ('889fef77-55a3-45c2-9da7-985058c5bd41', 'P1000007', '61');
INSERT INTO `project_material` VALUES ('89b2677f-2ffc-4fd7-a72e-a2fd9a035330', 'P1000005', '44');
INSERT INTO `project_material` VALUES ('8bf70027-d1f3-4b55-a4b8-d2aab6f2cecf', 'P1000002', '14');
INSERT INTO `project_material` VALUES ('9294aed1-21ed-4905-a5ca-348b47ddb244', 'P1000007', '61');
INSERT INTO `project_material` VALUES ('98e35a5e-55bd-4fe6-a57a-c831b07a910c', 'P1000006', '49');
INSERT INTO `project_material` VALUES ('9a3c1f6f-064a-40e6-9e10-18c37cbc6b85', 'P1000004', '31');
INSERT INTO `project_material` VALUES ('9b7516f4-372e-444a-9abd-c4c657d7a33c', 'P1000006', '49');
INSERT INTO `project_material` VALUES ('9c1225ad-9f3f-4290-a55a-3766f85087fe', 'P1000005', '45');
INSERT INTO `project_material` VALUES ('a09b7320-f63f-454b-ac0e-32db9f384375', 'P1000007', '61');
INSERT INTO `project_material` VALUES ('a7881ed5-926e-49f2-a88a-fd9c47a0b11f', 'P1000009', '85');
INSERT INTO `project_material` VALUES ('a7c3e1da-fb07-483f-bea9-b97103ef9852', 'P1000004', '36');
INSERT INTO `project_material` VALUES ('a9c452e0-5cd2-4504-9319-6529886b4793', 'P1000009', '85');
INSERT INTO `project_material` VALUES ('ad6412dc-1c5f-4065-9d8e-a25d06e2fb12', 'P1000004', '30');
INSERT INTO `project_material` VALUES ('ae0c724b-72bc-4d64-8477-61ac1eb537ea', 'P1000002', '10');
INSERT INTO `project_material` VALUES ('b7468a6b-dbbb-4d77-b669-0c3938f3d0d4', 'P1000009', '85');
INSERT INTO `project_material` VALUES ('ce3a2eea-d953-4c80-91b8-b253cecc8320', 'P1000003', '26');
INSERT INTO `project_material` VALUES ('d0dd4394-27d4-4ed2-ab43-3db2463a3b78', 'P1000008', '73');
INSERT INTO `project_material` VALUES ('d420b768-e150-4db2-8f7a-4959d53d4518', 'P1000008', '73');
INSERT INTO `project_material` VALUES ('d5ea89b8-949c-47f9-8a01-b827c5639afe', 'P1000008', '73');
INSERT INTO `project_material` VALUES ('dc46ccd1-d146-410c-911c-bee22fb8ba6d', 'P1000004', '34');
INSERT INTO `project_material` VALUES ('ddb10714-7f15-4850-98f6-440963ee4fac', 'P1000004', '35');
INSERT INTO `project_material` VALUES ('e32b7e59-91d3-44d0-9fee-e6489276f0f3', 'P1000006', '49');
INSERT INTO `project_material` VALUES ('e431093a-8f1a-4ffa-a735-c213a84d85cb', 'P1000002', '12');
INSERT INTO `project_material` VALUES ('ea285880-1bdc-470c-a2f5-f12620056b64', 'P1000002', '15');
INSERT INTO `project_material` VALUES ('ebee2e4f-34c8-4779-9e70-02cb2cab6856', 'P1000001', '5');
INSERT INTO `project_material` VALUES ('eca8adc8-6cd5-4c61-82e3-0d38e4db27e9', 'P1000009', '85');
INSERT INTO `project_material` VALUES ('ecdd67c7-fa8e-40b4-90cc-07074ee35fb7', 'P1000003', '25');
INSERT INTO `project_material` VALUES ('ed8e90d6-f840-4d8a-b15a-8e5e7efc0a5b', 'P1000006', '49');
INSERT INTO `project_material` VALUES ('f166b4c6-be48-4e70-b619-c1abd39452aa', 'P1000007', '61');
INSERT INTO `project_material` VALUES ('f2a12195-2683-4320-a2e8-d950a9c102b2', 'P1000006', '49');
INSERT INTO `project_material` VALUES ('f36db3c5-2f2d-497d-8058-f15d9e90b351', 'P1000001', '3');
INSERT INTO `project_material` VALUES ('f5b8d9bb-2eda-4c0f-9475-8ab0a7c8f3c6', 'P1000002', '11');
INSERT INTO `project_material` VALUES ('f6fdc400-4f07-459f-b7cc-31cfd8fe7ba5', 'P1000003', '23');
INSERT INTO `project_material` VALUES ('f79232a6-53ff-420d-ab7a-924a4c7d65bb', 'P1000003', '22');
INSERT INTO `project_material` VALUES ('fb79f196-8b1a-4f36-9018-1f6d9837ee1d', 'P1000005', '39');
INSERT INTO `project_material` VALUES ('fd105421-b711-4c78-84a3-74adf638e59a', 'P1000004', '32');
INSERT INTO `project_material` VALUES ('ff358062-fabc-43d3-9901-c46c8e382e70', 'P1000006', '49');

-- ----------------------------
-- Table structure for project_meeting
-- ----------------------------
DROP TABLE IF EXISTS `project_meeting`;
CREATE TABLE `project_meeting` (
  `meetingId` varchar(7) NOT NULL COMMENT '会议编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `notifyDate` date DEFAULT NULL,
  `notifyMethod` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`meetingId`,`projectId`),
  KEY `FK_Reference_9` (`projectId`),
  CONSTRAINT `FK_MEETING` FOREIGN KEY (`meetingId`) REFERENCES `t_meeting_base_info` (`meetingId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`meetingId`) REFERENCES `t_meeting_base_info` (`meetingId`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目会议表';

-- ----------------------------
-- Records of project_meeting
-- ----------------------------
INSERT INTO `project_meeting` VALUES ('M100001', 'P1000001', '2016-05-31', '电话');
INSERT INTO `project_meeting` VALUES ('M100001', 'P1000003', '2016-05-31', 'QQ');
INSERT INTO `project_meeting` VALUES ('M100002', 'P1000004', '2016-05-28', '微信');
INSERT INTO `project_meeting` VALUES ('M100002', 'P1000005', '2016-05-28', 'EMAIL');
INSERT INTO `project_meeting` VALUES ('M100003', 'P1000006', '2016-06-26', '电话');
INSERT INTO `project_meeting` VALUES ('M100003', 'P1000007', '2016-06-26', '电话');
INSERT INTO `project_meeting` VALUES ('M100003', 'P1000008', '2016-06-26', 'QQ');
INSERT INTO `project_meeting` VALUES ('M100004', 'P1000002', '2016-05-27', '电话');
INSERT INTO `project_meeting` VALUES ('M100004', 'P1000009', '2016-06-27', '微信');
INSERT INTO `project_meeting` VALUES ('M100004', 'P1000010', '2016-06-27', 'EMAIL');

-- ----------------------------
-- Table structure for project_verify
-- ----------------------------
DROP TABLE IF EXISTS `project_verify`;
CREATE TABLE `project_verify` (
  `verifyId` varchar(40) NOT NULL COMMENT '审核编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `completeDescription` longtext COMMENT '资料完善说明',
  `verifyFileNum` int(11) DEFAULT NULL,
  `verifyPerson` varchar(30) NOT NULL COMMENT '审核人',
  `verifyDate` date NOT NULL COMMENT '审核日期',
  `verifyResult` longtext NOT NULL COMMENT '审核结果',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`verifyId`),
  KEY `FK_Reference_19` (`projectId`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目审核表';

-- ----------------------------
-- Records of project_verify
-- ----------------------------
INSERT INTO `project_verify` VALUES ('068bf88c-920a-47a1-8be0-c24e7ce6b2fd', 'P1000006', '提供了发明专利的复印件', '2', 'U100006', '2016-07-06', '没有提供财务证明', null);
INSERT INTO `project_verify` VALUES ('239a865e-ffd2-42aa-a2b5-cc65cf1ac1e9', 'P1000008', '提供了发明专利的复印件', '2', 'U100006', '2016-07-06', '没有提供财务证明', null);
INSERT INTO `project_verify` VALUES ('25bfdd65-8db2-4652-be06-f12e410e5dce', 'P1000009', '提供了发明专利的复印件', '2', 'U100006', '2016-07-07', '没有提供财务证明', null);
INSERT INTO `project_verify` VALUES ('5c5464c2-a018-4008-8c03-b0cc7172d092', 'P1000007', '提供了发明专利的复印件', '2', 'U100006', '2016-07-06', '没有提供财务证明', null);
INSERT INTO `project_verify` VALUES ('689a518c-1c8a-413e-b1e6-a002806b2a52', 'P1000005', '补充了财务证明', '2', 'U100006', '2016-06-07', '需要提供论文复印件', null);
INSERT INTO `project_verify` VALUES ('b0ac6363-ec2f-4bbe-b325-d0ccdd8a90de', 'P1000001', '补充了财务证明', '1', 'U100006', '2016-06-10', '需要提供论文复印件', null);
INSERT INTO `project_verify` VALUES ('c50f197c-30a4-46ac-b33d-5b861040bb30', 'P1000004', '补充了财务证明', '2', 'U100006', '2016-06-07', '需要提供论文复印件', null);
INSERT INTO `project_verify` VALUES ('d1d2ef98-0991-4d32-b9e7-f339cb9f7c30', 'P1000003', '补充了财务证明', '2', 'U100006', '2016-06-10', '需要提供论文复印件', null);
INSERT INTO `project_verify` VALUES ('e974bb06-7d2b-4f3d-8341-62abef85ccc7', 'P1000002', '提供了发明专利的复印件', '1', 'U100006', '2016-07-07', '没有提供财务证明', null);
INSERT INTO `project_verify` VALUES ('f3f27f23-80e6-4653-b834-174879a23e8c', 'P1000010', '提供了发明专利的复印件', '2', 'U100006', '2016-07-07', '没有提供财务证明', null);

-- ----------------------------
-- Table structure for role_module
-- ----------------------------
DROP TABLE IF EXISTS `role_module`;
CREATE TABLE `role_module` (
  `roleId` varchar(40) NOT NULL COMMENT '编号',
  `moduleId` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`roleId`,`moduleId`),
  KEY `FK_MODULE` (`moduleId`),
  CONSTRAINT `FK_MODULE` FOREIGN KEY (`moduleId`) REFERENCES `t_base_defined_url` (`moduleId`),
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`roleId`) REFERENCES `t_role_base_info` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of role_module
-- ----------------------------
INSERT INTO `role_module` VALUES ('1a368211-cc2f-4314-9fa0-c6e34b5fa57b', '11');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '11');
INSERT INTO `role_module` VALUES ('1a368211-cc2f-4314-9fa0-c6e34b5fa57b', '11001');
INSERT INTO `role_module` VALUES ('1a368211-cc2f-4314-9fa0-c6e34b5fa57b', '11002');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '11003');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '11004');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '11005');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '12');
INSERT INTO `role_module` VALUES ('cfbe1812-a965-494c-b5bc-90ef0ea99fc2', '12');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '12001');
INSERT INTO `role_module` VALUES ('cfbe1812-a965-494c-b5bc-90ef0ea99fc2', '12002');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '12003');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '12004');
INSERT INTO `role_module` VALUES ('cfbe1812-a965-494c-b5bc-90ef0ea99fc2', '12005');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '12006');
INSERT INTO `role_module` VALUES ('cfbe1812-a965-494c-b5bc-90ef0ea99fc2', '12007');
INSERT INTO `role_module` VALUES ('cfbe1812-a965-494c-b5bc-90ef0ea99fc2', '12008');
INSERT INTO `role_module` VALUES ('58637d33-c228-46bf-aaff-af31facbbedb', '13001');
INSERT INTO `role_module` VALUES ('f9c4ee7d-d5b5-4623-b3fa-29547b133885', '13002');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '14');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '14001');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '14002');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '14003');
INSERT INTO `role_module` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '14004');
INSERT INTO `role_module` VALUES ('9971d9bd-193e-4685-a396-242b0964e926', '15');
INSERT INTO `role_module` VALUES ('9971d9bd-193e-4685-a396-242b0964e926', '16');
INSERT INTO `role_module` VALUES ('9971d9bd-193e-4685-a396-242b0964e926', '16001');
INSERT INTO `role_module` VALUES ('9971d9bd-193e-4685-a396-242b0964e926', '16002');
INSERT INTO `role_module` VALUES ('9971d9bd-193e-4685-a396-242b0964e926', '16003');
INSERT INTO `role_module` VALUES ('9971d9bd-193e-4685-a396-242b0964e926', '16004');
INSERT INTO `role_module` VALUES ('9971d9bd-193e-4685-a396-242b0964e926', '16005');

-- ----------------------------
-- Table structure for specialist_arrangement
-- ----------------------------
DROP TABLE IF EXISTS `specialist_arrangement`;
CREATE TABLE `specialist_arrangement` (
  `meetingId` varchar(7) NOT NULL COMMENT '会议编号',
  `specialistId` varchar(8) NOT NULL,
  `isLeader` bit(1) DEFAULT b'0' COMMENT '是否组长',
  `isAgree` bit(1) DEFAULT b'0',
  `source` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`meetingId`,`specialistId`),
  KEY `AK_Key_2` (`specialistId`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`meetingId`) REFERENCES `t_meeting_base_info` (`meetingId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specialist_arrangement
-- ----------------------------
INSERT INTO `specialist_arrangement` VALUES ('M100001', 'SL100010', '', '', '专家库');
INSERT INTO `specialist_arrangement` VALUES ('M100001', 'SR100005', '\0', '', '太原理工大学');
INSERT INTO `specialist_arrangement` VALUES ('M100001', 'SR100006', '\0', '', '太原科技大学');
INSERT INTO `specialist_arrangement` VALUES ('M100001', 'SR100013', '\0', '', '太原理工大学');
INSERT INTO `specialist_arrangement` VALUES ('M100001', 'SR100014', '\0', '', '太原科技大学');
INSERT INTO `specialist_arrangement` VALUES ('M100002', 'SL100002', '', '', '专家库');
INSERT INTO `specialist_arrangement` VALUES ('M100002', 'SR100001', '\0', '', '中北大学');
INSERT INTO `specialist_arrangement` VALUES ('M100002', 'SR100004', '\0', '', '中北大学');
INSERT INTO `specialist_arrangement` VALUES ('M100002', 'SR100011', '\0', '', '中北大学');
INSERT INTO `specialist_arrangement` VALUES ('M100002', 'SR100012', '\0', '', '中北大学');
INSERT INTO `specialist_arrangement` VALUES ('M100003', 'P1000006', '', '', '专家库');
INSERT INTO `specialist_arrangement` VALUES ('M100003', 'P1000007', '\0', '', '专家库');
INSERT INTO `specialist_arrangement` VALUES ('M100003', 'SR100008', '\0', '', '太原理工大学');
INSERT INTO `specialist_arrangement` VALUES ('M100003', 'SR100009', '\0', '', '太原科技大学');
INSERT INTO `specialist_arrangement` VALUES ('M100003', 'SR100015', '\0', '', '太原大学');
INSERT INTO `specialist_arrangement` VALUES ('M100004', 'SL100002', '\0', '\0', '专家库');
INSERT INTO `specialist_arrangement` VALUES ('M100004', 'SL100003', '\0', '', '专家库');
INSERT INTO `specialist_arrangement` VALUES ('M100004', 'SL100006', '', '', '专家库');
INSERT INTO `specialist_arrangement` VALUES ('M100004', 'SR100002', '\0', '', '太原理工大学');
INSERT INTO `specialist_arrangement` VALUES ('M100004', 'SR100017', '\0', '', '中北大学');
INSERT INTO `specialist_arrangement` VALUES ('M100004', 'SR100019', '\0', '', '山西医科大学第一医院');

-- ----------------------------
-- Table structure for specialist_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `specialist_evaluation`;
CREATE TABLE `specialist_evaluation` (
  `reviewId` varchar(40) NOT NULL COMMENT '评审编号',
  `specialistId` varchar(8) NOT NULL,
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `reviewSuggestion` longtext NOT NULL COMMENT '评审意见',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`reviewId`),
  KEY `FK_Reference_37` (`projectId`),
  CONSTRAINT `FK_Reference_37` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家评审表';

-- ----------------------------
-- Records of specialist_evaluation
-- ----------------------------
INSERT INTO `specialist_evaluation` VALUES ('00393581-eb79-4fee-a167-c0d949f11929', 'SR100005', 'P1000004', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('02bb3a88-32ce-4e91-8c0e-c9ad12164f84', 'SR100011', 'P1000003', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('06d022e1-7034-4ba9-9ef3-587c613ee0a8', 'P1000006', 'P1000007', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('0b4eaf6c-e7c5-464e-b84c-dba92969f3c4', 'SR100002', 'P1000002', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('15cc1908-49e1-4db0-b706-3521f8ee2e78', 'SL100003', 'P1000009', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('269c2cf6-6c5a-4cd6-97ea-18f58a5e94a7', 'SR100014', 'P1000005', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('28261c1c-b720-4063-89f0-beedc4279c93', 'SR100008', 'P1000008', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('2f4260be-c465-4185-8569-aac31779ed5d', 'P1000006', 'P1000008', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('38a9cd87-7ded-4b17-86bb-701719bc2ee1', 'SR100019', 'P1000010', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('39c14343-047a-4854-8b68-d9ed684a375d', 'SR100004', 'P1000001', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('3b7d2b7f-f271-45ce-a55c-613e93f80bee', 'SR100001', 'P1000003', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('3c122010-1f85-4457-8ce0-2b404d92c9ce', 'SR100002', 'P1000010', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('3fd56924-dbeb-4a19-af84-e824524dc72b', 'SR100012', 'P1000001', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('470cd62c-6765-4001-aa55-b49d5312d7de', 'SL100006', 'P1000010', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('4af2de7b-370f-402b-89a1-47305d0e1717', 'SR100006', 'P1000005', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('4ca50b95-8e22-4157-9002-ea25cd3d0766', 'SR100009', 'P1000006', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('4f506d65-46e8-4a1f-9d1f-c53c23ac91b0', 'SL100003', 'P1000010', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('54756959-5d28-454c-8279-9104774a09fc', 'SR100017', 'P1000002', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('57d52f3a-b72e-420b-b11b-d2b02f3dea3e', 'SR100019', 'P1000009', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('5bd2e16a-f531-4b09-b1b0-f636016466cc', 'SL100006', 'P1000009', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('5e673199-e5b6-454c-8fce-ce273630bf96', 'SR100015', 'P1000008', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('6bcc94e6-9c03-4040-91bf-f69e21973855', 'P1000006', 'P1000006', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('76780c94-48c9-44c8-90c5-a21191c59c5f', 'SR100015', 'P1000007', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('79bc253b-4746-4712-9e54-0f3472799f83', 'SR100009', 'P1000007', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('82ac108a-4c91-4ea0-ae53-0fe172dc2272', 'SR100008', 'P1000007', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('83288a9e-6c4d-4c10-b144-912ad4daa59d', 'SR100008', 'P1000006', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('835ebc2a-89e8-4c04-82d7-946ecefb01cf', 'SR100006', 'P1000004', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('837f391e-9935-476d-9ce6-7cba7df3bfaf', 'P1000007', 'P1000008', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('86ec1ee4-adcf-47b4-9d59-e6d81ed19f52', 'SR100011', 'P1000001', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('8d2d8675-a22d-4c32-9077-0546c6aca6f9', 'SR100019', 'P1000002', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('8e77249c-02a3-4eec-a102-56689945bf9e', 'SL100002', 'P1000003', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('94930936-0533-4d79-bba7-3ed0b1828ed8', 'SR100002', 'P1000009', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('96ced00e-3cfc-41e3-8bd0-c74172887778', 'SR100005', 'P1000005', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('9bb589ad-3b94-4b74-b605-6f7f031811b1', 'SR100017', 'P1000009', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('9f9553ef-67e0-49aa-9fb8-01bb4da3a076', 'SL100002', 'P1000001', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('abacac62-687b-4a4a-9d12-93767583f3bf', 'SL100006', 'P1000002', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('abb8c924-6dc5-483e-833d-2bba7ee2f832', 'SR100012', 'P1000003', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('b9958542-ca00-420a-b5d5-0bcb53163270', 'SL100010', 'P1000005', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('ba23ea17-d438-48b7-a563-afbc2f8bbf36', 'SL100003', 'P1000002', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('c1839b6e-65b3-4f14-9bd2-0ea1886d4c6c', 'SR100001', 'P1000001', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('c25e346c-cae9-46f1-b8d4-e45c624113b0', 'P1000007', 'P1000006', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('c763c1b1-7459-4282-972d-67af7bdc457a', 'SR100015', 'P1000006', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('d07965de-ca1e-40a5-a14f-25b48b5092ff', 'SR100014', 'P1000004', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('d171f98a-ea4e-4893-b026-b95c6f3ebe54', 'SR100013', 'P1000005', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('d426d502-e22f-4bac-aaf0-2f97d5be6999', 'SL100010', 'P1000004', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('d517228c-28bb-4349-9c5f-4165e1f7ed66', 'P1000007', 'P1000007', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('dfd4a0d7-f61f-4e89-b486-7b907d659f13', 'SR100009', 'P1000008', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('e1823429-055b-4e8d-a815-f57c0b181ba1', 'SR100004', 'P1000003', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('e29d3979-5146-4e50-9af0-77db22e0ecf0', 'SR100013', 'P1000004', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ('f9bff197-2a75-4d61-9c9f-5c89d2f7fa61', 'SR100017', 'P1000010', '该项目验收资料基本合格，但存在以下问题：1、没有提供财务证明 2、需要提供论文复印件', null);

-- ----------------------------
-- Table structure for specialist_library
-- ----------------------------
DROP TABLE IF EXISTS `specialist_library`;
CREATE TABLE `specialist_library` (
  `specialistId` varchar(8) NOT NULL COMMENT '专家编号',
  `name` varchar(10) NOT NULL COMMENT '姓名\r\n            ',
  `sex` varchar(6) NOT NULL COMMENT '性别',
  `password` varchar(16) DEFAULT NULL,
  `signaturePass` varchar(16) DEFAULT NULL,
  `birthday` date NOT NULL COMMENT '出生年月',
  `engageDomain` varchar(16) NOT NULL COMMENT '从事专业\r\n            ',
  `duty` varchar(10) NOT NULL COMMENT '职务',
  `title` varchar(20) NOT NULL COMMENT '职称',
  `telephone` varchar(13) NOT NULL COMMENT '联系电话',
  `email` varchar(20) NOT NULL COMMENT '邮箱',
  `signature` varchar(50) DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `workUnit` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`specialistId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家库';

-- ----------------------------
-- Records of specialist_library
-- ----------------------------
INSERT INTO `specialist_library` VALUES ('SL100001', '韩俊玲', '女', 'qaz23456', '12345qaz', '1970-07-16', '信息领域', '太原研究院', '教授', '13324412290', '13324412290@163.com', null, null, null);
INSERT INTO `specialist_library` VALUES ('SL100002', '庄占斌', '男', 'qaz23456', '12345qaz', '1981-05-16', '能源与节能环保领域', '太原研究院', '副教授', '13383546099', '13324412290@163.com', null, null, null);
INSERT INTO `specialist_library` VALUES ('SL100003', '宋宏志', '男', 'qaz23456', '12345qaz', '1971-01-16', '现代服务业领域', '太原研究院', '教授', '15947238743', '15947238743@163.com', null, null, null);
INSERT INTO `specialist_library` VALUES ('SL100004', '许  睿', '男', 'qaz23456', '12345qaz', '1980-02-16', '交通运输领域', '太原研究院', '副教授', '18642892473', '18642892473@163.com', null, null, null);
INSERT INTO `specialist_library` VALUES ('SL100005', '贾军萍', '男', 'qaz23456', '12345qaz', '1972-03-16', '信息领域', '太原研究院', '教授', '13167826324', '13167826324@163.com', null, null, null);
INSERT INTO `specialist_library` VALUES ('SL100006', '郭建民', '男', 'qaz23456', '12345qaz', '1979-04-16', '现代服务业领域', '太原研究院', '教授', '18443875743', '18443875743@163.com', null, null, null);
INSERT INTO `specialist_library` VALUES ('SL100007', '张  莉', '女', 'qaz23456', '12345qaz', '1978-06-16', '信息领域', '太原研究院', '副教授', '15579887423', '15579887423@163.com', null, null, null);
INSERT INTO `specialist_library` VALUES ('SL100008', '田  杰', '男', 'qaz23456', '12345qaz', '1973-09-16', '能源与节能环保领域', '太原研究院', '教授', '15580982145', '15580982145@163.com', null, null, null);
INSERT INTO `specialist_library` VALUES ('SL100009', '宋志强', '男', 'qaz23456', '12345qaz', '1976-10-16', '现代服务业领域', '太原研究院', '副教授', '18956223468', '18956223468@163.com', null, null, null);
INSERT INTO `specialist_library` VALUES ('SL100010', '李今明', '男', 'qaz23456', '12345qaz', '1979-12-16', '交通运输领域', '太原研究院', '教授', '13858974389', '13858974389@163.com', null, null, null);

-- ----------------------------
-- Table structure for specialist_recommend
-- ----------------------------
DROP TABLE IF EXISTS `specialist_recommend`;
CREATE TABLE `specialist_recommend` (
  `specialistId` varchar(8) NOT NULL COMMENT '专家编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `name` varchar(30) NOT NULL COMMENT '姓名\r\n            ',
  `sex` varchar(6) NOT NULL COMMENT '性别',
  `password` varchar(16) DEFAULT NULL,
  `signaturePass` varchar(16) DEFAULT NULL,
  `birthday` date NOT NULL COMMENT '出生年月',
  `engageDomain` varchar(16) NOT NULL COMMENT '从事专业\r\n            ',
  `duty` varchar(10) NOT NULL COMMENT '职务',
  `title` varchar(20) NOT NULL COMMENT '职称',
  `telephone` varchar(13) NOT NULL COMMENT '联系电话',
  `email` varchar(20) NOT NULL COMMENT '邮箱',
  `signature` varchar(50) DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `workUnit` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`specialistId`),
  KEY `FK_Reference_28` (`projectId`),
  CONSTRAINT `FK_Reference_28` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家推荐表';

-- ----------------------------
-- Records of specialist_recommend
-- ----------------------------
INSERT INTO `specialist_recommend` VALUES ('SR100001', 'P1000001', '赵彦修', '男', null, null, '1971-01-16', '能源与节能环保领域', '教授', '高级', '13357398423', '13357398423@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100002', 'P1000002', '张斌', '男', null, null, '1980-02-16', '现代服务业领域', '教授', '高级', '18356287632', '18356287632@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100003', 'P1000002', '王雅明', '女', null, null, '1972-03-16', '现代服务业领域', '教授', '高级', '13132426583', '13132426583@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100004', 'P1000003', '张雪中', '男', null, null, '1971-01-16', '能源与节能环保领域', '教授', '高级', '13744234293', '13744234293@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100005', 'P1000004', '吕淑然', '女', null, null, '1972-03-16', '交通运输领域', '教授', '高级', '13257893493', '13257893493@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100006', 'P1000005', '李春青', '男', '', '', '1973-09-16', '交通运输领域', '教授', '高级', '18467826348', '18467826348@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100007', 'P1000006', '李双会', '男', null, null, '1980-02-16', '信息领域', '教授', '高级', '15249823473', '15249823473@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100008', 'P1000006', '赵阳', '男', null, null, '1973-09-16', '信息领域', '教授', '高级', '18943289492', '18943289492@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100009', 'P1000007', '邢云', '女', null, null, '1973-09-16', '信息领域', '教授', '高级', '15347238974', '15347238974@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100010', 'P1000007', '李长坤', '男', null, null, '1971-01-16', '信息领域', '教授', '高级', '15049832792', '15049832792@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100011', 'P1000001', '张起灵', '男', null, null, '1972-03-17', '能源与节能环保领域', '教授', '高级', '18456235702', '18456235702@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100012', 'P1000003', '刘凌', '男', null, null, '1972-03-22', '能源与节能环保领域', '教授', '高级', '18475692350', '18475692350@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100013', 'P1000004', '黎美香', '女', null, null, '1972-02-16', '交通运输领域', '教授', '高级', '18456923657', '18456923657@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100014', 'P1000005', '李陈江', '男', null, null, '1972-03-01', '交通运输领域', '教授', '高级', '18425698456', '18425698456@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100015', 'P1000008', '李春蕊', '女', null, null, '1973-10-27', '信息领域', '教授', '高级', '18452369752', '18452369752@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100016', 'P1000008', '李彩红', '女', null, null, '1975-07-26', '信息领域', '教授', '高级', '18524521258', '18524521258@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100017', 'P1000009', '李福海', '男', null, null, '1971-07-30', '现代服务业领域', '教授', '高级', '18456239562', '18456239562@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100018', 'P1000009', '李凤林', '女', null, null, '1979-07-27', '现代服务业领域', '教授', '高级', '18402563256', '18402563256@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100019', 'P1000010', '黎莹', '女', null, null, '1975-09-11', '现代服务业领域', '教授', '高级', '18475692302', '18475692302@163.com', '', null, null);
INSERT INTO `specialist_recommend` VALUES ('SR100020', 'P1000010', '金雅敏', '女', null, null, '1973-10-20', '现代服务业领域', '教授', '高级', '18425679302', '18425679302@163.com', '', null, null);

-- ----------------------------
-- Table structure for t_base_defined_url
-- ----------------------------
DROP TABLE IF EXISTS `t_base_defined_url`;
CREATE TABLE `t_base_defined_url` (
  `id` varchar(40) NOT NULL COMMENT '机构编号',
  `moduleId` varchar(40) NOT NULL COMMENT '机构名称',
  `moduleName` varchar(100) NOT NULL COMMENT '是否启用',
  `moduleURL` varchar(200) DEFAULT NULL COMMENT '备注',
  `memo1` varchar(100) DEFAULT NULL,
  `momo2` varchar(100) DEFAULT NULL,
  `inUse` bit(1) DEFAULT b'1',
  `sortNo` int(11) DEFAULT NULL,
  `menuClass` int(11) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `moduleId` (`moduleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_defined_url
-- ----------------------------
INSERT INTO `t_base_defined_url` VALUES ('00bfacb5-723b-4268-8d1c-903068ad46d1', '16001', '机构管理', null, '机构管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('05284357-cc85-48dd-82eb-bffc33fcb44b', '11003', '领取验收资料', null, '领取验收资料', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('07844542-9cb3-4902-82d2-6756ad58764a', '12006', '验收资料编制', null, '验收资料编制', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('121e2105-a54d-499a-bfc5-f6a90335bb5b', '14002', '验收项目资料完善', null, '验收项目资料完善', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('1a8e63cf-99c8-47b2-b1a3-f0b49ba2dd68', '14', '验收后管理', null, '验收后管理', null, '', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('24515a20-db8d-4ca1-ae8b-47dbcfcb65e3', '11002', '确定负责部门', null, '确定负责部门', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('2b1e1669-92ca-4b40-869e-e5f1d5721dbc', '16', '系统管理', null, '系统管理', null, '', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('441b3f60-ca17-490c-8e90-939b8a613670', '16002', '用户管理', null, '用户管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('5102bc52-a570-4011-91f4-23818b61d790', '13002', '会议主持人', null, '会议主持人', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('552032cc-6d49-4ba0-b001-61078dccd29a', '12002', '创建会议', null, '创建会议', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('5f9a4e38-b7bb-40a4-9eef-254869e1c0df', '11', '接受验收材料', null, '接受验收材料', null, '', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('652c614c-bc3a-46b9-874e-38452cf9edc5', '12001', '待验收项目管理', null, '待验收项目管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('749306a0-3272-46ca-b034-fb93943b3c94', '16005', '模块管理', null, '模块管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('77b9d609-b1b9-4fb0-b8ff-89445ff4fd91', '12003', '通知企业', null, '通知企业', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('7d68d036-6c66-4ff4-86bd-afd0f484cdd0', '11001', '登记验收材料', null, '登记验收材料', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('8d81507d-a793-45ff-9f24-0b176437ca77', '14003', '专家意见修改审核', null, '专家意见修改审核', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('91f0d174-fb60-4927-ade9-fc9412e14e84', '16004', '日志管理', null, '日志管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('93cb31ab-e38f-4c17-855b-3ee162406fa9', '12007', '编制验收会议', null, '编制验收会议', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('9a55f82e-a59f-459e-8856-a54a514d8604', '15', '专家管理', null, '专家管理', null, '', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('9e6d4748-8adb-4bc9-bae6-c81d4887f285', '12004', '企业准备资料上传', null, '企业准备资料上传', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('a87707c7-9136-4558-99dd-a286cec60883', '13', '验收会议管理', null, '验收会议管理', null, '', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('ae50c7d7-62c6-489d-8adb-8a088a765c4f', '12008', '通知相关人员', null, '通知相关人员', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('c8889fff-c6ef-493d-a526-6a3491b77f86', '13001', '专家项目验收评审', null, '专家项目验收评审', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('d0bcb0d7-f480-4486-a7b6-6de377b5e472', '12005', '确定验收专家', null, '确定验收专家', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('d0de4967-615b-4f65-a0f6-57c7d7416466', '12', '验收会前准备', null, '验收会前准备', null, '', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('ef69b324-6d10-4f75-9a97-908cc6c60a1d', '11005', '企业现场考察', null, '企业现场考察', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('f25a8b99-2ccc-4473-90a2-4201d4e9c33d', '14004', '验收证书发放', null, '验收证书发放', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('f6349cf8-782a-4cb8-89d7-06659aa363d3', '16003', '字典管理', null, '字典管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('f7f90dac-3882-406b-8896-04ce8b256039', '11004', '审查验收资料', null, '审查验收资料', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('f854ea3b-6d70-4301-bb40-dd1a12ff31c3', '14001', '已验收项目管理', null, '已验收项目管理', null, '', '0', '2', '0');

-- ----------------------------
-- Table structure for t_files_index
-- ----------------------------
DROP TABLE IF EXISTS `t_files_index`;
CREATE TABLE `t_files_index` (
  `fileId` int(11) NOT NULL AUTO_INCREMENT,
  `fileType` varchar(6) DEFAULT NULL,
  `originalName` varchar(50) DEFAULT NULL,
  `currentName` varchar(40) DEFAULT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `fileSize` varchar(10) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_files_index
-- ----------------------------
INSERT INTO `t_files_index` VALUES ('1', '300001', '验收意见初稿', '3f8d312b-ee51-490c-91a0-fd3f000a4527', '2016-06-01 16:48:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('2', '300002', '科技项目验收申请书', '49662cab-e1ea-4729-b7b4-974d6e649fe2', '2016-06-01 16:48:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('3', '300003', '承诺书', '6e463d47-7412-4c89-b962-9fd9cff8efdf', '2016-06-01 16:48:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('4', '300004', '计划任务书', 'c68d56c2-e936-4d66-8e18-968484e81ef1', '2016-06-01 16:48:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('5', '300005', '项目实施工作总结报告', '2c988937-aa76-434a-a428-77fda8245379', '2016-06-01 16:48:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('6', '300006', '项目实施技术总结报告', '07ef2f49-ecad-4805-aae5-ca164864d87b', '2016-06-01 16:48:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('7', '300007', '项目立项后相关材料证明', '54595325-b2d7-42b3-93fe-818f809157bb', '2016-06-01 16:48:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('8', '300008', '科技项目验收财务资料一套', '54595325-b2d7-42b3-93fe-818f809157bb', '2016-06-01 16:48:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('9', '300001', '验收意见初稿', '80a61215-6d56-4f30-9e0f-2aba50c60ab0', '2016-05-29 09:55:11', '120KB', null);
INSERT INTO `t_files_index` VALUES ('10', '300002', '科技项目验收申请书', '0b2a8693-1051-44f6-9912-53e7dd612996', '2016-05-29 09:55:11', '120KB', null);
INSERT INTO `t_files_index` VALUES ('11', '300003', '承诺书', '8b6d0f7c-d1d3-4197-aca4-c203317d0d6e', '2016-05-29 09:55:11', '120KB', null);
INSERT INTO `t_files_index` VALUES ('12', '300004', '计划任务书', '21920f4a-8994-47e2-a4c9-0ef300b65142', '2016-05-29 09:55:11', '120KB', null);
INSERT INTO `t_files_index` VALUES ('13', '300005', '项目实施工作总结报告', 'e1303fa5-3567-44b5-a4d7-cba0b4d71571', '2016-05-29 09:55:11', '120KB', null);
INSERT INTO `t_files_index` VALUES ('14', '300006', '项目实施技术总结报告', 'a04086e6-980d-47bd-ba75-6423351a5fb6', '2016-05-29 09:55:11', '120KB', null);
INSERT INTO `t_files_index` VALUES ('15', '300007', '项目立项后相关材料证明', 'bd55bafe-7520-401a-8e49-55e549926a5a', '2016-05-29 09:55:11', '120KB', null);
INSERT INTO `t_files_index` VALUES ('16', '300008', '科技项目验收财务资料一套', 'c62f568a-55e9-4fd0-b5c2-3a07f6a5b770', '2016-05-29 09:55:11', '120KB', null);
INSERT INTO `t_files_index` VALUES ('17', '300007', '项目立项后相关材料证明', '8097ec7e-13c2-433c-9463-1b4d1abb98c1', '2016-06-07 09:55:11', '120KB', null);
INSERT INTO `t_files_index` VALUES ('18', '300008', '科技项目验收财务资料一套', '706b9c42-ed93-4896-ba3a-f119ddd8b799', '2016-07-04 09:55:11', '120KB', null);
INSERT INTO `t_files_index` VALUES ('19', '300001', '验收意见初稿', '12ceadfb-7bd7-4d24-8b5c-1ebf251b545b', '2016-06-02 11:49:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('20', '300002', '科技项目验收申请书', '4ad897b8-2d9f-4dc5-bcb0-278cb30eef31', '2016-06-02 11:49:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('21', '300003', '承诺书', 'ba3a3326-1770-496e-bc0b-8aed6e89ca4b', '2016-06-02 11:49:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('22', '300004', '计划任务书', 'e9674d0a-1964-47d9-aa5d-1c128ed43784', '2016-06-02 11:49:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('23', '300005', '项目实施工作总结报告', '29843bd6-d1a8-499e-be7a-db6245a9028b', '2016-06-02 11:49:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('24', '300006', '项目实施技术总结报告', '35677aaa-8b7b-4af8-8f60-d26f8fb3dc7b', '2016-06-02 11:49:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('25', '300007', '项目立项后相关材料证明', '686bbaff-23e4-47f7-b61b-55e3749dd04f', '2016-06-02 11:49:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('26', '300008', '科技项目验收财务资料一套', '843a31fe-458d-40c2-b2f5-78399712fdc0', '2016-06-02 11:49:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('27', '300005', '项目实施工作总结报告', '5b9403e9-b87c-48a9-a472-fa58b17b35c8', '2016-06-02 11:49:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('28', '300006', '项目实施技术总结报告', '4e173d4c-1157-41bf-a5e1-a2552d40a5b7', '2016-06-02 11:49:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('29', '300001', '验收意见初稿', '738aaf7f-d9dd-4f37-bdec-ac440f200a3c', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('30', '300002', '科技项目验收申请书', '77320b1c-378a-465c-9e3b-a9df94891321', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('31', '300003', '承诺书', 'fb1fdf0c-d9cd-43ec-ae2c-47330f9ab76b', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('32', '300004', '计划任务书', '257b07eb-7d97-44f5-b416-4f8e1dd6f17c', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('33', '300005', '项目实施工作总结报告', '9f6df5b6-1d4b-4c03-9dd9-201ad9bf8ba6', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('34', '300006', '项目实施技术总结报告', '1dd9fc0c-d874-44e4-9e9a-e181d7c6ce69', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('35', '300007', '项目立项后相关材料证明', '589e56ef-d282-4580-b832-02c6570314d7', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('36', '300008', '科技项目验收财务资料一套', 'bfaeaa26-4451-40a4-9000-28ce3d01ad39', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('37', '300007', '项目立项后相关材料证明', '3a66e077-5d6a-4f07-8549-483d3b4feaee', '2016-06-07 09:55:11', '120KB', null);
INSERT INTO `t_files_index` VALUES ('38', '300008', '科技项目验收财务资料一套', 'c203748b-2da3-4706-b8a9-e74eae93a0ed', '2016-06-07 09:55:11', '120KB', null);
INSERT INTO `t_files_index` VALUES ('39', '300001', '验收意见初稿', 'e4b09e10-ed7d-42ac-a417-3e073d1693a8', '2016-05-30 11:51:08', '120KB', null);
INSERT INTO `t_files_index` VALUES ('40', '300002', '科技项目验收申请书', 'c4b3a4a8-81c0-41b1-98f4-77212cb4cb0a', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('41', '300003', '承诺书', 'be88902b-0003-4fef-9f5b-94d902c45867', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('42', '300004', '计划任务书', 'c81893f6-d043-4414-a022-baadb1245c93', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('43', '300005', '项目实施工作总结报告', '6a05256a-4530-4495-904e-0252fd0e6ddb', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('44', '300006', '项目实施技术总结报告', '9258243e-a923-4b46-a45f-30e2fe193dbd', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('45', '300007', '项目立项后相关材料证明', '2b450bdd-1632-4d85-bc60-04c5067e031c', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('46', '300008', '科技项目验收财务资料一套', 'a24a3d17-58ff-4826-9353-33be7d62796e', '2016-05-30 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('47', '300006', '项目实施技术总结报告', '3e8c19bb-b011-4a14-999e-a131de1082b3', '2016-06-04 11:50:23', '120KB', null);
INSERT INTO `t_files_index` VALUES ('48', '300007', '项目立项后相关材料证明', 'e3409698-1345-4b63-87c9-2fb894a95f54', '2016-06-04 12:10:15', '120KB', null);
INSERT INTO `t_files_index` VALUES ('49', '300001', '验收意见初稿', '84667706-e517-4c85-92b5-1bfd0407ca1f', '2016-06-11 11:51:43', '120KB', null);
INSERT INTO `t_files_index` VALUES ('50', '300002', '科技项目验收申请书', 'e337e97f-5da4-44a3-92af-6730aa49c288', '2016-06-28 11:51:43', '120KB', null);
INSERT INTO `t_files_index` VALUES ('51', '300003', '承诺书', '0c09582f-4404-415a-b31c-1d33206d28fa', '2016-06-28 11:51:43', '120KB', null);
INSERT INTO `t_files_index` VALUES ('52', '300004', '计划任务书', 'a94dab21-bdc4-48e7-a961-ac57d2dff2cf', '2016-06-28 11:51:43', '120KB', null);
INSERT INTO `t_files_index` VALUES ('53', '300005', '项目实施工作总结报告', 'd9e36965-62f3-41cd-8b8f-43b141965a6e', '2016-06-28 11:51:43', '120KB', null);
INSERT INTO `t_files_index` VALUES ('54', '300006', '项目实施技术总结报告', '1f0d9b10-01b7-4e87-8d26-b088d9d51cfb', '2016-06-28 11:51:43', '120KB', null);
INSERT INTO `t_files_index` VALUES ('55', '300007', '项目立项后相关材料证明', 'cece048c-6a2f-4de4-a562-4396aa15a735', '2016-06-28 11:51:43', '120KB', null);
INSERT INTO `t_files_index` VALUES ('56', '300008', '科技项目验收财务资料一套', '3a92eb42-f41b-4af9-bd86-8de4b654c8fd', '2016-06-28 11:51:43', '120KB', null);
INSERT INTO `t_files_index` VALUES ('57', '300005', '项目实施工作总结报告', 'db11e2fa-7527-4a46-aafb-6907ebb67ffc', '2016-06-04 11:51:43', '120KB', null);
INSERT INTO `t_files_index` VALUES ('58', '300006', '项目实施技术总结报告', '4ae12219-fd13-48c1-8d19-3f9daec81fc1', '2016-06-04 12:11:45', '120KB', null);
INSERT INTO `t_files_index` VALUES ('59', '300001', '验收意见初稿', '22d0d6b7-7665-471d-af09-91a8eb132087', '2016-06-28 11:52:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('60', '300002', '科技项目验收申请书', '341756b8-d5ca-4477-83a0-31f06e467107', '2016-06-28 11:52:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('61', '300003', '承诺书', '90b19f16-531f-4716-976f-64d84a1368ab', '2016-06-28 11:52:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('62', '300004', '计划任务书', '49eb43bd-3268-408b-9766-95c175b195d9', '2016-06-28 11:52:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('63', '300005', '项目实施工作总结报告', '01ac3cd6-1746-428d-8e49-99e89489b254', '2016-06-28 11:52:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('64', '300006', '项目实施技术总结报告', '1be64404-9b83-4094-bb0b-cb834ae89437', '2016-06-28 11:52:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('65', '300007', '项目立项后相关材料证明', '1ac2d8ea-bbb1-455a-8099-e2baadb77c2c', '2016-06-28 11:52:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('66', '300008', '科技项目验收财务资料一套', '7ec6145f-e6cb-465b-a9f1-9d9823b158a6', '2016-06-28 11:52:00', '120KB', null);
INSERT INTO `t_files_index` VALUES ('67', '300007', '项目立项后相关材料证明', 'be867496-0263-4df4-9a70-b321ab7d72ef', '2016-07-03 12:12:19', '120KB', null);
INSERT INTO `t_files_index` VALUES ('68', '300008', '科技项目验收财务资料一套', '100fc41c-d47f-4fa5-bcbe-175ca2c6a10c', '2016-07-03 12:12:22', '120KB', null);
INSERT INTO `t_files_index` VALUES ('69', '300001', '验收意见初稿', '5d0ccb65-7933-4d77-b133-d765df1cc2c1', '2016-06-28 11:52:15', '120KB', null);
INSERT INTO `t_files_index` VALUES ('70', '300002', '科技项目验收申请书', '7ca7c388-6167-468f-b147-0fe61804028a', '2016-06-28 11:52:15', '120KB', null);
INSERT INTO `t_files_index` VALUES ('71', '300003', '承诺书', '5afce54c-212b-4aba-8bb8-3fd285311e78', '2016-06-28 11:52:15', '120KB', null);
INSERT INTO `t_files_index` VALUES ('72', '300004', '计划任务书', '887c1376-22b4-47a6-a70a-c3bbc88f12cd', '2016-06-28 11:52:15', '120KB', null);
INSERT INTO `t_files_index` VALUES ('73', '300005', '项目实施工作总结报告', '104ada4e-51e7-4dee-a0e1-8dacca52a59b', '2016-06-28 11:52:15', '120KB', null);
INSERT INTO `t_files_index` VALUES ('74', '300006', '项目实施技术总结报告', 'abe0d742-4b64-4d10-a82f-37b7abaa2e8b', '2016-06-28 11:52:15', '120KB', null);
INSERT INTO `t_files_index` VALUES ('75', '300007', '项目立项后相关材料证明', '272d77d4-53bb-4189-8d5e-c70d5dfcab42', '2016-06-28 11:52:15', '120KB', null);
INSERT INTO `t_files_index` VALUES ('76', '300008', '科技项目验收财务资料一套', '8847bed2-21d2-439b-93a5-51a3ecd76382', '2016-06-28 11:52:15', '120KB', null);
INSERT INTO `t_files_index` VALUES ('77', '300003', '承诺书', 'e53b543b-8f19-4db3-993a-227abea1a828', '2016-07-03 12:12:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('78', '300004', '计划任务书', '8d8b7b6b-a408-4214-a557-0cc06f95b98a', '2016-07-03 12:12:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('79', '300001', '验收意见初稿', '0fa1e562-e0cb-400c-9bef-f69c8b1d809d', '2016-06-29 11:52:47', '120KB', null);
INSERT INTO `t_files_index` VALUES ('80', '300002', '科技项目验收申请书', 'e87cd948-42b8-4e81-9d11-5b7b6e5a9773', '2016-06-29 11:52:47', '120KB', null);
INSERT INTO `t_files_index` VALUES ('81', '300003', '承诺书', '5f649f8b-9a78-4828-987c-fefae8488a6f', '2016-06-29 11:52:47', '120KB', null);
INSERT INTO `t_files_index` VALUES ('82', '300004', '计划任务书', 'd2f38a0a-9826-48ec-8a4b-018a5c532e98', '2016-06-29 11:52:47', '120KB', null);
INSERT INTO `t_files_index` VALUES ('83', '300005', '项目实施工作总结报告', 'e40c4b13-15ed-4853-980a-70a7143029fa', '2016-06-29 11:52:47', '120KB', null);
INSERT INTO `t_files_index` VALUES ('84', '300006', '项目实施技术总结报告', '8d082c89-9683-4ea0-980e-ac3e22ac372a', '2016-06-29 11:56:46', '120KB', null);
INSERT INTO `t_files_index` VALUES ('85', '300007', '项目立项后相关材料证明', 'b842668c-1439-48fa-839e-d4b47aefea5b', '2016-06-29 11:56:46', '120KB', null);
INSERT INTO `t_files_index` VALUES ('86', '300008', '科技项目验收财务资料一套', 'c3650461-fb25-43ca-a542-3f3d64508ec2', '2016-06-29 11:56:46', '120KB', null);
INSERT INTO `t_files_index` VALUES ('87', '300004', '计划任务书', 'd638b2f0-6bcf-47f1-82d2-a8a9200d08db', '2016-07-04 12:12:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('88', '300005', '项目实施工作总结报告', '67cb838a-f353-4c76-9876-ddc0d3351b2e', '2016-07-04 12:12:52', '120KB', null);
INSERT INTO `t_files_index` VALUES ('89', '300001', '验收意见初稿', 'e46d3938-995e-4476-86ac-1d8141b75f37', '2016-06-29 11:53:19', '120KB', null);
INSERT INTO `t_files_index` VALUES ('90', '300002', '科技项目验收申请书', '9e46beb1-afe7-4d2c-b0b1-cbbe757ea6e9', '2016-06-29 11:53:19', '120KB', null);
INSERT INTO `t_files_index` VALUES ('91', '300003', '承诺书', 'a89e5bc0-abf8-465f-93a3-df299cf00f46', '2016-06-29 11:53:19', '120KB', null);
INSERT INTO `t_files_index` VALUES ('92', '300004', '计划任务书', '5a3137bf-32e6-40d6-ba5d-0aed4d995a6a', '2016-06-29 11:53:19', '120KB', null);
INSERT INTO `t_files_index` VALUES ('93', '300005', '项目实施工作总结报告', 'a943caf7-8349-4853-9f59-fab2da50f4d7', '2016-06-29 11:53:19', '120KB', null);
INSERT INTO `t_files_index` VALUES ('94', '300006', '项目实施技术总结报告', 'e1e16b5b-f9b3-4e96-b956-b13146f31521', '2016-06-29 11:53:19', '120KB', null);
INSERT INTO `t_files_index` VALUES ('95', '300007', '项目立项后相关材料证明', '9bbe76e6-8c74-415c-9750-cfb4b5784e45', '2016-06-29 11:53:19', '120KB', null);
INSERT INTO `t_files_index` VALUES ('96', '300008', '科技项目验收财务资料一套', '4beeed85-4ee7-47c4-b011-90a5ba1cb20a', '2016-06-29 11:53:19', '120KB', null);
INSERT INTO `t_files_index` VALUES ('97', '300007', '项目立项后相关材料证明', '97f28030-31e5-49ed-994c-1a9f4067658e', '2016-07-04 12:13:27', '120KB', null);
INSERT INTO `t_files_index` VALUES ('98', '300008', '科技项目验收财务资料一套', 'c87b9970-6b09-4145-bba6-23aada918e20', '2016-07-04 12:13:30', '120KB', null);

-- ----------------------------
-- Table structure for t_meeting_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_meeting_base_info`;
CREATE TABLE `t_meeting_base_info` (
  `meetingId` varchar(7) NOT NULL COMMENT '会议编号',
  `hostId` varchar(40) DEFAULT NULL COMMENT '编号',
  `meetingName` varchar(30) NOT NULL COMMENT '会议名称',
  `meetingTime` datetime NOT NULL COMMENT '会议时间',
  `meetingPlace` varchar(30) NOT NULL COMMENT '会议地点',
  `meetingNotice` varchar(40) DEFAULT NULL,
  `meetingStatus` varchar(6) DEFAULT '200001' COMMENT '会议状态',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`meetingId`),
  KEY `FK_Reference_33` (`hostId`),
  CONSTRAINT `FK_Reference_33` FOREIGN KEY (`hostId`) REFERENCES `t_user_base_info` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会议基本信息表';

-- ----------------------------
-- Records of t_meeting_base_info
-- ----------------------------
INSERT INTO `t_meeting_base_info` VALUES ('M100001', 'U100005', '2016年交通运输领域项目评估和审核大会', '2016-06-02 09:00:00', '太原市科技评估中心', '2d284dd9-6692-4c68-a035-0dcc822eed81.pdf', '200003', null);
INSERT INTO `t_meeting_base_info` VALUES ('M100002', 'U100005', '2016年能源与节能环保领域项目评估和审核大会', '2016-05-30 09:00:00', '太原市科技评估中心', '601bc105-e216-4def-8b6a-7ecac32a71c7.pdf', '200003', null);
INSERT INTO `t_meeting_base_info` VALUES ('M100003', 'U100005', '2016年信息领域项目评估和审核大会', '2016-06-28 09:00:00', '太原市科技评估中心', '277441eb-6401-47e5-bb0f-169e632f432b.pdf', '200003', '');
INSERT INTO `t_meeting_base_info` VALUES ('M100004', 'U100005', '2016年现代服务业领域项目评估和审核大会', '2016-06-29 09:00:00', '太原市科技评估中心', '56fbaa2a-3bc9-4a03-a179-b980405e69fe.pdf', '200003', '');

-- ----------------------------
-- Table structure for t_pictures_index
-- ----------------------------
DROP TABLE IF EXISTS `t_pictures_index`;
CREATE TABLE `t_pictures_index` (
  `pictureId` varchar(40) NOT NULL COMMENT '图片编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `pictureType` varchar(6) DEFAULT NULL COMMENT '图片类型',
  `originalName` varchar(50) DEFAULT NULL COMMENT '图片原始名称',
  `currentName` varchar(40) DEFAULT NULL COMMENT '图片当前名称',
  `uploadTime` datetime DEFAULT NULL,
  `pictureSize` varchar(10) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`pictureId`),
  KEY `FK_Reference_26` (`projectId`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片';

-- ----------------------------
-- Records of t_pictures_index
-- ----------------------------
INSERT INTO `t_pictures_index` VALUES ('0414084a-746b-4c5d-811f-214b702a9339', 'P1000002', '400002', '廉洁承诺书', 'a01ceddd-3ee7-45b4-94ee-51470394d152', '2016-05-22 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('08547a97-72a6-4f0c-b876-e1bdbfdafc7f', 'P1000009', '400001', '考察照片', '6297765e-0d15-4643-a5ba-a110a6ed98b5', '2016-06-21 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('17771ab0-a7a0-4a0c-8ce5-bb8ac1a025b3', 'P1000009', '400003', '真实性承诺书', '80bb2965-8c78-4a7a-96ef-849f56132d51', '2016-06-29 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('1ed182a2-fb2b-4b21-8267-58051fced556', 'P1000004', '400003', '真实性承诺书', '4505d2db-bca2-49c0-bfca-a7dded73307d', '2015-05-31 00:00:00', '120KB', '');
INSERT INTO `t_pictures_index` VALUES ('251e04ec-c7fe-4eaa-952e-0c39977e3b6b', 'P1000002', '400001', '考察照片', '55e708b0-ec1d-49df-90ce-098818851718', '2016-05-22 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('27ea2604-78d4-4c30-aa55-37e3dfa855c3', 'P1000003', '400003', '真实性承诺书', '960d2adb-29c6-4c80-a80c-34e8dc16f683', '2016-06-02 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('2cc7fcfa-c5a0-4f0d-a080-b1cd5edda8fc', 'P1000008', '400003', '真实性承诺书', '69c2a947-ecb2-4cf6-a907-756e9247f8f5', '2016-06-28 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('2f0dd437-a424-4c22-a576-720571b9b9a3', 'P1000007', '400003', '真实性承诺书', '8d3877ba-57ec-4aa8-9ba3-4793381e3fc5', '2016-06-28 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('350294e6-50a1-4529-8969-4e9fbb3f473e', 'P1000006', '400003', '真实性承诺书', 'c3208bc7-1d45-4a08-9fa9-94b708b56517', '2016-06-28 00:00:00', '120KB', '');
INSERT INTO `t_pictures_index` VALUES ('36a8da3b-ac01-458d-991b-c5f03fdba5f0', 'P1000010', '400003', '真实性承诺书', '6297765e-0d15-4643-a5ba-a110a6ed98b5', '2016-06-29 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('3c93ab0b-b26b-44c1-8469-d8371bc2d36b', 'P1000005', '400001', '考察照片', 'c3208bc7-1d45-4a08-9fa9-94b708b56517', '2016-05-26 00:00:00', '120KB', '');
INSERT INTO `t_pictures_index` VALUES ('3ee56d3c-7cf5-43f2-a530-520bfb1beb4d', 'P1000007', '400001', '考察照片', '69c2a947-ecb2-4cf6-a907-756e9247f8f5', '2016-06-20 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('4fb3cccd-c20d-46dd-ad3e-84f88ec62312', 'P1000004', '400001', '考察照片', '4505d2db-bca2-49c0-bfca-a7dded73307d', '2016-05-24 00:00:00', '120KB', '');
INSERT INTO `t_pictures_index` VALUES ('5045f061-7de3-46ea-853d-ab9b84afe731', 'P1000010', '400002', '廉洁承诺书', 'e1e48ea9-1273-444a-b737-3e0dca21031f', '2016-06-22 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('5b5e277c-0e57-492f-8a69-d84f788f962f', 'P1000001', '400003', '真实性承诺书', '41cb42c7-0c71-4eb9-87cf-496691a1b3a9', '2016-06-02 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('6562c30f-6bd9-4a75-8e52-090410da030b', 'P1000006', '400001', '考察照片', 'c3208bc7-1d45-4a08-9fa9-94b708b56517', '2016-06-19 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('6723dd4f-5b43-430a-b196-e11797d2ecb5', 'P1000007', '400002', '廉洁承诺书', '69c2a947-ecb2-4cf6-a907-756e9247f8f5', '2016-06-20 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('6d5c0de8-e113-4753-b23d-ad8a570b1e80', 'P1000009', '400002', '廉洁承诺书', '80bb2965-8c78-4a7a-96ef-849f56132d51', '2016-06-21 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('6dfd2d45-e1af-4b2b-8568-2a6d75ea404b', 'P1000008', '400001', '考察照片', '80bb2965-8c78-4a7a-96ef-849f56132d51', '2016-06-21 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('b18f429d-de76-458e-97fa-5b9bfbb862b8', 'P1000003', '400001', '考察照片', '9680f072-c666-4e7e-ad08-95875b8286ad', '2016-05-23 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('bde5da26-2a79-4810-a5e9-b155537db7e2', 'P1000010', '400001', '考察照片', 'e1e48ea9-1273-444a-b737-3e0dca21031f', '2016-06-22 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('cc2627ad-cf93-493c-b934-c4df2a69f4ba', 'P1000004', '400002', '廉洁承诺书', '4505d2db-bca2-49c0-bfca-a7dded73307d', '2016-05-24 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('d45f0548-8d99-44d9-9e21-c98611f52aa4', 'P1000002', '400003', '真实性承诺书', 'bf7fe32d-53b4-4809-933e-20896e1cadf6', '2016-05-29 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('e8b21081-0608-442f-aadb-7db33c2c4cb1', 'P1000001', '400001', '考察照片', '5d7af03f-7b4c-43ef-9268-e6567fd03909', '2016-05-19 00:00:00', '120KB', null);
INSERT INTO `t_pictures_index` VALUES ('f2e88773-357a-44d2-ba0f-d6aca804d7b3', 'P1000005', '400002', '廉洁承诺书', '573061fa-99e0-4013-ac0a-0b23ab35f554', '2016-05-26 00:00:00', '120KB', '');
INSERT INTO `t_pictures_index` VALUES ('f3ce439d-40f8-4533-a092-8b42e45fe39d', 'P1000005', '400003', '真实性承诺书', '4505d2db-bca2-49c0-bfca-a7dded73307d', '2016-05-31 00:00:00', '120KB', '');
INSERT INTO `t_pictures_index` VALUES ('f50e1074-4adb-4ce7-a677-b7b1250880b3', 'P1000003', '400002', '廉洁承诺书', '563cd69d-6009-46ff-b3ba-f54cb3003eb4', '2016-05-23 00:00:00', '120KB', null);

-- ----------------------------
-- Table structure for t_project_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_project_base_info`;
CREATE TABLE `t_project_base_info` (
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `projectName` varchar(100) DEFAULT NULL,
  `applicant` varchar(50) DEFAULT NULL,
  `applicationDate` date NOT NULL COMMENT '申请日期',
  `contactPerson` varchar(30) NOT NULL COMMENT '联系人',
  `telephone` varchar(13) NOT NULL COMMENT '联系电话',
  `domain` varchar(16) NOT NULL COMMENT '所属领域',
  `projectFunds` float(7,3) DEFAULT NULL,
  `status` varchar(6) DEFAULT '100001' COMMENT '当前状态',
  `certificate` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否发放证书',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目基本信息表\r\n';

-- ----------------------------
-- Records of t_project_base_info
-- ----------------------------
INSERT INTO `t_project_base_info` VALUES ('P1000001', '工业燃气的动态爆炸极限测定关键技术研究', '中北大学', '2016-01-01', '张子枫', '18435155745', '能源与节能环保领域', '49.000', '100005', '\0', null);
INSERT INTO `t_project_base_info` VALUES ('P1000002', '“管一家在线”智慧家庭服务平台', '太原理工大学', '2015-11-02', '黄克智', '18435154521', '现代服务业领域', '78.000', '100005', '\0', null);
INSERT INTO `t_project_base_info` VALUES ('P1000003', '在线式微量烟尘颗粒称重系统的研发', '中北大学', '2015-06-02', '吴建平', '18435157452', '能源与节能环保领域', '60.000', '100005', '\0', null);
INSERT INTO `t_project_base_info` VALUES ('P1000004', '物流车辆车联网技术研究与应用', '中北大学', '2015-01-29', '吴佑寿', '18435157458', '交通运输领域', '50.000', '100005', '\0', null);
INSERT INTO `t_project_base_info` VALUES ('P1000005', '煤矿防爆无人驾驶车辆', '太原科技大学', '2014-02-16', '过增元', '18435147545', '交通运输领域', '78.000', '100005', '\0', null);
INSERT INTO `t_project_base_info` VALUES ('P1000006', '煤与瓦斯突出综合预警软件开发', '太原理工大学', '2015-06-18', '孙元章', '18435154445', '信息领域', '40.000', '100005', '\0', null);
INSERT INTO `t_project_base_info` VALUES ('P1000007', '起重机模块化参数化云设计平台应用示范研究', '太原科技大学', '2014-07-10', '邱勇', '18435174545', '信息领域', '80.000', '100005', '\0', null);
INSERT INTO `t_project_base_info` VALUES ('P1000008', '面向智能车间的三维工艺研究与应用示范', '太原大学', '2015-03-16', '张希', '18435151175', '信息领域', '45.000', '100005', '\0', null);
INSERT INTO `t_project_base_info` VALUES ('P1000009', '基于微震的地下入侵监控系统关键技术研究', '中北大学', '2015-05-29', '卢强', '18435158545', '现代服务业领域', '90.000', '100005', '\0', null);
INSERT INTO `t_project_base_info` VALUES ('P1000010', '喉癌切缘的3D重建及病理检查标准化研究', '山西医科大学第一医院', '2014-08-23', '田俊', '18435159545', '现代服务业领域', '100.000', '100005', '\0', null);

-- ----------------------------
-- Table structure for t_role_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_role_base_info`;
CREATE TABLE `t_role_base_info` (
  `roleId` varchar(40) NOT NULL COMMENT '编号',
  `roleName` varchar(50) DEFAULT NULL,
  `isUse` bit(1) DEFAULT b'1',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

-- ----------------------------
-- Records of t_role_base_info
-- ----------------------------
INSERT INTO `t_role_base_info` VALUES ('1a368211-cc2f-4314-9fa0-c6e34b5fa57b', '项目验收资料登记人员', '', '项目验收资料登记人员', null);
INSERT INTO `t_role_base_info` VALUES ('58637d33-c228-46bf-aaff-af31facbbedb', '专家', '', '专家', null);
INSERT INTO `t_role_base_info` VALUES ('95d60ee7-42e4-4a86-953f-7be6e94f876b', '项目验收负责人', '', '项目验收负责人', null);
INSERT INTO `t_role_base_info` VALUES ('9971d9bd-193e-4685-a396-242b0964e926', '系统管理员', '', '系统管理员', null);
INSERT INTO `t_role_base_info` VALUES ('cfbe1812-a965-494c-b5bc-90ef0ea99fc2', '会议创建人员', '', '会议创建人员', null);
INSERT INTO `t_role_base_info` VALUES ('f9c4ee7d-d5b5-4623-b3fa-29547b133885', '会议主持人', '', '会议主持人', null);

-- ----------------------------
-- Table structure for t_templeate_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_templeate_base_info`;
CREATE TABLE `t_templeate_base_info` (
  `templateId` varchar(40) NOT NULL COMMENT '模板编号',
  `templateName` varchar(10) NOT NULL COMMENT '模板名称',
  `templateURL` longtext NOT NULL COMMENT '内容(url)',
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`templateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_templeate_base_info
-- ----------------------------
INSERT INTO `t_templeate_base_info` VALUES ('fef1abd0-5038-11e6-b102-f0761cc1bacd', '模板一', 'fef1abd0-5038-11e6-b102-f0761cc1bace', '会议通知');

-- ----------------------------
-- Table structure for t_unit_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_unit_base_info`;
CREATE TABLE `t_unit_base_info` (
  `unitId` varchar(40) NOT NULL COMMENT '部门编号',
  `unitName` varchar(30) NOT NULL COMMENT '名称',
  `upUnitId` varchar(40) DEFAULT NULL COMMENT '上级部门编号',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`unitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表';

-- ----------------------------
-- Records of t_unit_base_info
-- ----------------------------
INSERT INTO `t_unit_base_info` VALUES ('10', '科技评估中心', '', null);
INSERT INTO `t_unit_base_info` VALUES ('10001', '项目评估部门', '10', null);
INSERT INTO `t_unit_base_info` VALUES ('10002', '成果评估部门', '10', null);
INSERT INTO `t_unit_base_info` VALUES ('10003', '综合部', '10', null);

-- ----------------------------
-- Table structure for t_user_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_base_info`;
CREATE TABLE `t_user_base_info` (
  `userId` varchar(40) NOT NULL COMMENT '编号',
  `unitId` varchar(40) NOT NULL COMMENT '部门编号',
  `userName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `name` varchar(30) NOT NULL,
  `sex` varchar(6) NOT NULL COMMENT '性别',
  `password` varchar(16) NOT NULL COMMENT '密码',
  `duty` varchar(10) NOT NULL COMMENT '职位',
  `telephone` varchar(13) NOT NULL,
  PRIMARY KEY (`userId`),
  KEY `FK_Reference_32` (`unitId`),
  CONSTRAINT `FK_Reference_32` FOREIGN KEY (`unitId`) REFERENCES `t_unit_base_info` (`unitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user_base_info
-- ----------------------------
INSERT INTO `t_user_base_info` VALUES ('U100001', '10002', '烟雨良辰', '王一梅', '女', 'a123456', '科员', '13455864432');
INSERT INTO `t_user_base_info` VALUES ('U100002', '10001', '黎明的苏醒', '董晨', '男', 'a123456', '科员', '13254985845');
INSERT INTO `t_user_base_info` VALUES ('U100003', '10001', '权良先森', '李权良', '男', 'a123456', '主任', '13354353432');
INSERT INTO `t_user_base_info` VALUES ('U100004', '10002', '小萌耐', '万楠', '女', 'a123456', '副主任', '15156387645');
INSERT INTO `t_user_base_info` VALUES ('U100005', '10001', '小小拖油瓶', '万冲', '男', 'a123456', '部长', '15245465776');
INSERT INTO `t_user_base_info` VALUES ('U100006', '10002', '几经风月', '陈张静', '女', 'a123456', '部长', '15367565423');
INSERT INTO `t_user_base_info` VALUES ('U100007', '10002', '月光舞裙', '李派', '男', 'a123456', '主任', '15832467763');
INSERT INTO `t_user_base_info` VALUES ('U100008', '10001', '幸福面包圈', '张昕若', '女', 'a123456', '副主任', '15907874564');
INSERT INTO `t_user_base_info` VALUES ('U100009', '10003', '带上猫猫履行', '王辰祖', '男', 'a123456', '主任', '18256456483');
INSERT INTO `t_user_base_info` VALUES ('U100010', '10003', '黎明的苏醒', '唐琦', '女', 'a123456', '部长', '18375653432');
INSERT INTO `t_user_base_info` VALUES ('U100011', '10003', '晓涵', '李晓涵', '女', 'a123456', '副主任', '18498776423');
INSERT INTO `t_user_base_info` VALUES ('U100012', '10003', '艳茹', '陈艳茹', '女', 'a123456', '科员', '18945458543');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userId` varchar(40) NOT NULL COMMENT '编号',
  `roleId` varchar(40) NOT NULL COMMENT '编号',
  PRIMARY KEY (`userId`,`roleId`),
  KEY `FK_Reference_36` (`roleId`),
  CONSTRAINT `FK_Reference_25` FOREIGN KEY (`userId`) REFERENCES `t_user_base_info` (`userId`),
  CONSTRAINT `FK_Reference_36` FOREIGN KEY (`roleId`) REFERENCES `t_role_base_info` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('U100007', '1a368211-cc2f-4314-9fa0-c6e34b5fa57b');
INSERT INTO `user_role` VALUES ('U100003', '95d60ee7-42e4-4a86-953f-7be6e94f876b');
INSERT INTO `user_role` VALUES ('U100006', '95d60ee7-42e4-4a86-953f-7be6e94f876b');
INSERT INTO `user_role` VALUES ('U100005', '9971d9bd-193e-4685-a396-242b0964e926');

-- ----------------------------
-- View structure for v_complete_material_file
-- ----------------------------
DROP VIEW IF EXISTS `v_complete_material_file`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_complete_material_file` AS select `complete_material`.`fileId` AS `fileId`,`complete_material`.`completeId` AS `completeId`,`complete_material`.`projectId` AS `projectId`,`t_files_index`.`fileType` AS `fileType`,`t_files_index`.`originalName` AS `originalName`,`t_files_index`.`currentName` AS `currentName`,`t_files_index`.`uploadTime` AS `uploadTime`,`t_files_index`.`fileSize` AS `fileSize`,`t_files_index`.`remark` AS `remark` from (`complete_material` join `t_files_index` on((`complete_material`.`fileId` = `t_files_index`.`fileId`))) ;

-- ----------------------------
-- View structure for v_project_accept_info
-- ----------------------------
DROP VIEW IF EXISTS `v_project_accept_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_project_accept_info` AS SELECT
	tpbi.*, 
	pa.recordDate,
	pa.recordPerson,
	pa.chargePerson,
	pa.chargeUnit,
	pa.distributionDate,
	pa.receiveDate,
	pa.receivePerson,
	pa.receiveResult,
	pa.remark1,
	pa.remark2,
	pa.remark3,
	pc.censorDate,
	pc.censorPerson,
	pc.censorResult,
	ei.inspectPerson,
	ei.inspectDate,
	ei.inspectResult,
	ei.isAudit,
	ia.financeUnit,
	ia.auditingPerson,
	ia.auditDate
FROM
	t_project_base_info tpbi
NATURAL JOIN project_accept pa
NATURAL JOIN project_censor pc
NATURAL JOIN enterprise_inspect ei
LEFT JOIN inspect_audit ia ON ei.inspectId = ia.inspectId ;

-- ----------------------------
-- View structure for v_project_material_file
-- ----------------------------
DROP VIEW IF EXISTS `v_project_material_file`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_project_material_file` AS select `project_material`.`fileId` AS `fileId`,`project_material`.`materialId` AS `materialId`,`project_material`.`projectId` AS `projectId`,`t_files_index`.`fileType` AS `fileType`,`t_files_index`.`originalName` AS `originalName`,`t_files_index`.`currentName` AS `currentName`,`t_files_index`.`uploadTime` AS `uploadTime`,`t_files_index`.`fileSize` AS `fileSize`,`t_files_index`.`remark` AS `remark` from (`project_material` join `t_files_index` on((`project_material`.`fileId` = `t_files_index`.`fileId`))) ;

-- ----------------------------
-- View structure for v_project_meeting_notify
-- ----------------------------
DROP VIEW IF EXISTS `v_project_meeting_notify`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_project_meeting_notify` AS SELECT
	*
FROM
	t_project_base_info
NATURAL JOIN project_meeting ;