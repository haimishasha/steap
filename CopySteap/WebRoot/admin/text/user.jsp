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
<title>用户管理</title>
<script type="text/javascript" src="js/jquery-2.2.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="js/jquery.validate-1.13.1.js"></script>
<!--  
<script type="text/javascript" src="js/student_info/student_info.js"></script>
-->
<script type="text/javascript" src="js/user/user.js"></script>
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
								<span class="input-group-addon">用户姓名: </span> 
								<input type="text" id="user_name_condition"  class="form-control">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="input-group">
								<span class="input-group-addon">用户职务:</span> 
								<input type="text" id="user_duty_condition"  class="form-control">
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
							<span>部门</span>
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
						<button type="button" class="btn btn-default" id="user_add"
							data-toggle="modal" data-target="#user_add_modal">添 加</button>
						<!-- 
						<button type="button" class="btn btn-default"
							id="user_change" data-toggle="modal" data-target="#user_add_modal">修 改</button>
						 -->
						<input type="hidden" value="" id="bt_unitId"> 
						<input type="hidden" value="" id="bt_unitName">
						<input type="hidden" value="" id="table_row">
						<button type="button" class="btn btn-default"
							id="user_delete">删 除</button>
						<button type="button" class="btn btn-default"
							id="reset_password">重置密码</button>
						<!--添加，修改弹出框-->
						
						<!--添加弹出框-->
						<div class="modal fade" id="user_add_modal">
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
														<td>部门名称</td>
														<td style="text-align:center disabled"><span
															id="dap_add_name">项目评估部</span></td>
													</tr>
													<tr>
														<td style="text-align:center disabled">部门编号</td>
														<td><span id="dap_add_id">10001</span></td>
													</tr>
													<tr>
														<td>姓名</td>
														<td><input type="text" name="user_name"
															id="user_name" placeholder="请输入您的姓名..."></td>
													</tr>
													<tr style="display:none" border="1px">
														<td>用户编号</td>
														<td><input type="text" name="user_id"
															id="user_id"></td>
													</tr>
													<tr>
														<td>性别</td>
														<td><input type="radio" id="user_sex" name="user_sex" checked="checked" value="男">男
															<input type="radio" id="user_sex" name="user_sex" value="女">女
														</td>
													</tr>
													<tr>
														<td>职务</td>
														<td><input type="text" id="user_duty" value="科员"></td>
													</tr>
													<tr>
														<td>电话</td>
														<td><input type="text" id="user_telephone"></td>
													</tr>
													
													<input type="reset" style="display:none;" />
												</table>
											</div>
										</form>
									</div>

									<div class="modal-footer">
										 <button type="button" class="btn btn-primary"
											id="user_add_save">Save changes</button> 
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

					<div class="modal fade" id="user_role_add_modal">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title">用户角色管理</h4>
								</div>
								<div class="modal-body" id="divFrame">
									<form name="form2" id="form2" action="">
										<div class="table-responsive">
											<table class="dap_table" id="userLeftRoleTable">
												<thead>
													<tr>
														<th>序号</th>
														<th class="hide">角色编号</th>
														<th>角色名称</th>
														<th>角色描述</th>
														<!-- <th>是否启用</th> -->
														<th>操作</th>
													</tr>
												</thead>
												<tbody id="tabody">
												</tbody>
											</table>
										</div>
										<div class="table-responsive">
											<table class="dap_table" id="userRoleTable">
												<thead>
													<tr>
														<th>序号</th>
														<th class="hide">角色编号</th>
														<th>角色名称</th>
														<th>角色描述</th>
														<!--  <th>是否启用</th>  -->
														<th>操作</th>
													</tr>
												</thead>
												<tbody id="tabody">
												</tbody>
											</table>
										</div>
									</form>


									<div class="modal-footer">
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
					<table class="dap_table" id="userTable">
						<thead>
							<tr>
								<th>序号</th>
								<th class='hide'>用户编号</th>
								<th class='hide'>部门编号</th>
								<th>姓名</th>
								<th>部门名称</th>
								<th>性别</th>
								<th>职务</th>
								<th>电话</th>
								<th>操作</th>
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
<script>

var isAdd = false;
var isChange = false;
var alterRow;
var userIdForRole;
/**
 * 单条删除用户
 */
function del_tr(id){
	var tr = document.getElementById("tr_"+id);
    var userIds = tr.cells[1].innerHTML+",";
   	$.ajax({
   		type : "post",
   		dataType : "json",
   		url : "<%=basePath%>deleteUserById",
			data : {
				deleteIds : userIds,
			},
			success : function() {
				alert("删除成功");
				tr.parentNode.removeChild(tr);
				alterNoOfTable();
			},
			error : function() {
				alert("删除失败");
			}
	});
}
	/**
	 *修改用户数据
	 */
	function alt_tr(id) {

		isAdd = false;
		isChange = true;
		alterRow = "tr_" + id;
		var tr = document.getElementById(alterRow);
		setChangInfoModal(tr);
	}
	/**
	* 显示要修改的用户的原始信息
	*/
	function setChangInfoModal(tr) {
		//填充上级级用户的值 （即当前点击的树节点,对于添加而言）
		//表从0开始
		var unitId = document.getElementById("dap_add_id");
		unitId.innerHTML = tr.cells[2].innerHTML;
		var unitName = document.getElementById("dap_add_name");
		unitName.innerHTML = tr.cells[4].innerHTML;
		//设置性别
		if (tr.cells[5].innerHTML == "男") {
			document.form1.user_sex[0].checked = true;//男
		} else {
			document.form1.user_sex[1].checked = true;//女
		}
		//填充用户的信息
		$("#user_id").val(tr.cells[1].innerHTML);
		$("#user_name").val(tr.cells[3].innerHTML);
		$("#user_duty").val(tr.cells[6].innerHTML);
		$("#user_telephone").val(tr.cells[7].innerHTML);
	}
	/**
	*更新后修改表中显示的数据
	*/
	function alterNoOfTable(){
		//删除对应的行后，修改表的序号
		var len = $('#userTable tr').length;
		for(var i = 1;i<len;i++){
			$('#userTable tr:eq('+i+') td:first').html("<input type='checkbox' name='allcheckbox'/>"+i);
		}
	}
	
	
	function role_tr(id){
		var tr = document.getElementById("tr_"+id);
	    var userId = tr.cells[1].innerHTML;
	    userIdForRole=userId;
	    getRoleOfUser(userIdForRole);
	    getLeftRoleOfUser(userIdForRole);
	}
	
	function getRoleOfUser(userIdForRole){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchRoleByUserId",
			data : {
				userId : userIdForRole,
			},
			success : showRoleTable
		});
	}

	function showRoleTable(result) {

		var roleList = eval("(" + result + ")");
		// 删除表格(除了表头)
		$("#userRoleTable  tr:not(:first)").remove();
		// 在表格中添加数据
		for (var i = 0; i < roleList.length; i++) {
			var index = i + 1;
			$("#userRoleTable").append(
					"<tr id='role_tr_"+index+"'> <td>" + index + "</td><td class='hide'>"
							+ roleList[i].roleId + "</td><td>"
							+ roleList[i].roleName + "</td><td>"
							+ roleList[i].description + "</td><td>"
							//+ roleList[i].isUse + "</td><td>"
							+ "<button class='tb_alter'  onclick='del_role("
							+ index + ")'>删除</button></td></tr>");
		}
	}
	function del_role(index) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "deleteRoleFromUser",
			data : {
				userId : userIdForRole,
				roleId :1
			},
			success : function(result){
				alert("角色删除成功");
			}
		});
	}
	
	function deleteRoleFromTable(){
		
	}
	function getLeftRoleOfUser(userIdForRole) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchLeftRoleByUserId",
			data : {
				userId : userIdForRole,
			},
			success : showLeftRoleTable
		});
	}

	function showLeftRoleTable(result) {

		var roleList = eval("(" + result + ")");
		// 删除表格(除了表头)
		$("#userLeftRoleTable  tr:not(:first)").remove();
		// 在表格中添加数据
		for (var i = 0; i < roleList.length; i++) {
			var index = i + 1;
			$("#userLeftRoleTable").append(
					"<tr id='left_role_tr_"+index+"'> <td>" + index
							+ "</td><td class='hide'>" + roleList[i].roleId + "</td><td>"
							+ roleList[i].roleName + "</td><td>"
							+ roleList[i].description + "</td><td>"
							//+ roleList[i].isUse + "</td><td>"
							+ "<button class='tb_alter'  onclick='add_role("
							+ index + ")'>增加</button></td></tr>");
		}
	}
</script>
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>
