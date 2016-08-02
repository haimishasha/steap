<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>字典管理</title>
<script type="text/javascript" src="js/jquery-2.2.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="js/jquery.validate-1.13.1.js"></script>
<!--  
<script type="text/javascript" src="js/student_info/student_info.js"></script>
-->
<script type="text/javascript" src="js/dictionary/dictionary.js"></script>
<link rel="stylesheet" type="text/css" media="screen"
	href="css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/main2.css" />


</head>

<body>
	<jsp:include page="../../nav.jsp" />
	<div class="Mycontent">
		<div class="container">
			<form action="" method="" style="border: 1px solid #EEEEEE;">
				<fieldset style="margin: 20px;">
					<legend>
						<span>查询条件</span>
					</legend>
					<div class="row">
						<div class="col-lg-6">
							<div class="input-group">
								<span class="input-group-addon">字典名称: </span> 
								<input type="text" id="dic_name"  class="form-control">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="input-group">
								<span class="input-group-addon">字典编号:</span> 
								<input type="text" id="dic_id"  class="form-control">
							</div>
							
						</div>
					</div>
					<input type="button" value="查 询" class="fr btn distance"
						id="condition_sub" />
				</fieldset>
			</form>
			
			<!--select_form end-->
			<!--select_form end-->

			<div class="dictionary_main">
			
				<div class="dapartment_left"">
					<fieldset>
						<legend>
							<span>字典</span>
						</legend>
						<!-- 这是添加zTree的div -->
						<div class="panel-group" id="accordion" role="tablist"
							aria-multiselectable="true">
							<ul id="treeDemo" class="ztree"></ul>
						</div>
					</fieldset>
				</div>
				
				<!--添加 修改 部门信息-->
				<div class="dapartment_right ">
					<div class="btn-group" role="group" aria-label="...">
						<button type="button" class="btn btn-default" id="dictionary_add"
							data-toggle="modal" data-target="#dictionary_add_modal">添 加</button>
						<button type="button" class="btn btn-default"
							id="dictionary_change" data-toggle="modal" data-target="#dictionary_add_modal">修 改</button>
						<input type="hidden" value="" id="bt_dictionaryId"> 
						<input type="hidden" value="" id="bt_dictionaryName">
						<input type="hidden" value="" id="bt_upDictionaryId"> 
						<input type="hidden" value="" id="bt_upDictionaryName">
						<input type="hidden" value="" id="table_row">
						<button type="button" class="btn btn-default"
							id="dictionary_delete">删 除</button>
						<!--添加，修改弹出框-->
						
						<!--添加弹出框-->
						<div class="modal fade" id="dictionary_add_modal">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title">添加字典信息</h4>
									</div>
									<div class="modal-body" id="divFrame">
										<form name="form1" id="form1" action="">
											<div class="table-responsive">
												<table class="table" style="border:1px solid grey">
													<tr>
														<td>上级字典</td>
														<td style="text-align:center disabled"><span
															id="dap_add_name">字典列表</span></td>
													</tr>
													<tr>
														<td style="text-align:center disabled">上级字典编号</td>
														<td><span id="dap_add_id">1</span></td>
													</tr>
													<tr>
														<td>字典名称</td>
														<td><input type="text" name="dictionary_name"
															id="dictionary_name" placeholder="请输入一个2-10的字典名称..."></td>
													</tr>
													<tr>
														<td>字典编号</td>
														<td><input type="text" id="dictionary_id" readonly="readonly"></td>
													</tr> 
													<tr>
														<td>是否启用</td>
														<td><input type="radio" id="dictionary_isUse" name="radio" checked="checked" value="true">启用
															<input type="radio" id="dictionary_isUse" name="radio" value="false">禁用 
														</td>
													</tr>
													<tr>
														<td>字典描述</td>
														<td><input type="text" id="dictionary_description"></td>
													</tr>
													<tr>
														<td>字典排序号</td>
														<td><input type="text" id="dictionary_sortNo"></td>
													</tr>
													<tr>
														<td>字典标志位</td>
														<td><input type="text" id="dictionary_flag"></td>
													</tr>
													<tr>
														<td>字典英文名字</td>
														<td><input type="text" id="dictionary_englishName"></td>
													</tr>
													<tr>
														<td>字典数据类型</td>
														<td>
															<select id="dictionary_dataType" style="width:170px">
																<option value="varchar">varchar</option>
																<option value="int">int</option>
																<option value="double">double</option>
																<option value="float">float</option>
																<option value="boolean">boolean</option>
																<option value="char">char</option>
															</select>
														</td>
													</tr>
													<tr>
														<td>备注1</td>
														<td><textarea name="" id="dictionary_remark1"
																cols="22" rows="1" style="resize:none"></textarea></td>
													</tr>
													<tr>
														<td>备注2</td>
														<td><textarea name="" id="dictionary_remark2"
																cols="22" rows="1" style="resize:none"></textarea></td>
													</tr>
													<input type="reset" style="display:none;" />
												</table>
											</div>
										</form>
									</div>

									<div class="modal-footer">
										 <button type="button" class="btn btn-primary"
											id="dictionary_add_save">Save changes</button> 
										<!-- <input type="submit" value="Save changes"
											class="btn btn-primary" style="float: left;" /> -->
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->
					</div>
					<div>
						<div class="fl">
							<label class="btn"> <span> </span> 
							</label>
						</div>
						<div class="clearfix"></div>
					</div>
					<from>
					<table class="dap_table" id="dictionaryTable">
						<thead>
							<tr>
								<th>序号</th>
								<th>字典名称</th>
								<th>字典编号</th>
								<th>是否启用</th>
								<th>描述</th>
								<th>排序号</th>
								<th>标志位</th>
								<th>英文名字</th>
								<th>数据类型</th>
								<!-- 
								<th>备注1</th>
								<th>备注2</th>
								-->
							</tr>
						</thead>
						<tbody id="tabody">
						</tbody>
					</table>
					</from>
				</div>
			</div>
			<!--dictionary_main end-->


		</div>
	</div>


	<!----------------------------------------------------------------------------------->
	<!-- 这是新加入的部门管理模块 上面的改善版 -->
	<!--------------------------------------------------------------------------------------->

	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>
