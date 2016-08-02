$(document).ready(function() {
	
	/**
	 * 请求树信息
	 */
	$.ajax({
		type : "post",
		target : "#treeDemo",
		dataType : "json",
		url : "searchUnitTree",
		success : getTree
	});
			
	/**
	 * 生成树
	 */
	function getTree(treeList2){
		var treeList3 = eval("(" + treeList2 + ")");
		var setting = {
				data : {
					simpleData : {
						enable : true,
						idKey: "unitId",
						pIdKey: "upUnitId",
						rootPId : "10",
					},
					key : {
						name : "unitName",
					}
				},
				callback : {
					onClick : onClick
				}
		};
		var zNodes = treeList3;

		//添加 树节点的 点击事件；
		var log, className = "dark";

		function onClick(event, treeId, treeNode, clickFlag) {
			
			clickOnTree(event, treeId, treeNode, clickFlag);
		}
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	}
	/**
	 * 给树添加点击事件
	 * 点击树节点的同时，将该用户信息对应的用户编号，用户名称，上级用户编号，上级用户名称保存下来
	 */
	function clickOnTree(event, treeId, treeNode, clickFlag){
		//得到该节点的用户编号和用户名字
		document.getElementById("bt_unitId").value = treeNode.unitId;     //得到上级部门编号
		document.getElementById("bt_unitName").value = treeNode.unitName; //得到上级部门名称

		if (treeNode.unitId == "10") {
			//如果本节点是根节点，那么就不能执行添加操作
			$("#user_add").attr("disabled","disabled");
		} else {
			//如果本节点不是根节点，就可以执行更新和删除操作
			$("#user_add").removeAttr("disabled");
		}
		//点击一下树节点表格输出本节点以及下级节点的用户信息
		searchUserByUnitId();
	}

	/**
	 * 重新加载树 （这一部分待完善）
	 */
	function doReload() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.reAsyncChildNodes(null, "refresh");
		//zTree.refresh();
	}

	/**
	 * 点击一下树节点，表格输出本部门内部的用户信息
	 */
	function searchUserByUnitId() {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchUserByUnitId",
			data : {

				unitId : $("#bt_unitId").val(),
			},
			success : showTable
		});
	}
	/**
	 * 点击查询按钮，按条件查询用户信息
	 */
	$("#condition_sub").click(function(){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchUserByCondition",
			data : {
				name : $("#user_name_condition").val(),
				duty : $("#user_duty_condition").val()
			},
			success : showTable
		});
	});

	/**
	 * 显示表格
	 */
	function showTable(result) {

		var userList = eval("(" + result + ")");
		// 删除表格(除了表头)
		$("#userTable  tr:not(:first)").remove();
		// 在表格中添加数据
		for (var i = 0; i < userList.length; i++) {
			var index = i + 1;
			$("#userTable").append(
					"<tr id='tr_"+index+"'> <td><input type='checkbox' name='allcheckbox'/>"
					+ index                 + "</td><td class='hide'>"
					+ userList[i].userId    + "</td><td class='hide'>"
					+ userList[i].unitId    + "</td><td>"
					+ userList[i].name      + "</td><td>"
					+ userList[i].unitName	+ "</td><td>"
					+ userList[i].sex	    + "</td><td>"
					+ userList[i].duty	    + "</td><td>"
					+ userList[i].telephone + "</td><td>"
					+ "<button   class='tb_alter' href='javascript:void(0)' onclick='alt_tr("+index+")' data-toggle='modal' data-target='#user_add_modal'>修改</button>    "
					+ "<button   class='tb_role' href='javascript:void(0)' onclick='role_tr("+index+")' data-toggle='modal' data-target='#user_role_add_modal'>角色管理</button>    "
					+ "<button   class='tb_delete' href='javascript:void(0)' onclick='del_tr("+index+")'>删除</button></td></tr>"
			);
			
		}
	}
	
	/**
	 * 实现用户信息的批量删除 
	 */
	$("#user_delete").click(function() {

		deleteUsers();

	});

	/**
	 * 点击删除按钮后需要 删除表+删除数据库
	 */
	function deleteUsers(){
		
		//批量删除之前判断是否已经选中用户
		var isChoosed = $("input[name='allcheckbox']:checked").length>0;
			
		if(!isChoosed){
			
			alert("选择用户后才能删除，请选择");
		}else{
			
			//alert("开始删除");
			//得到要删除的用户的编号
			var userIds = getUserIdsChoosed();
			//删除数据库中对应的用户的信息
			deleteUsersOfDatabase(userIds);
		}
	}
	/**
	 * 得到要删除的用户的编号（复选框选中的）
	 */
	function getUserIdsChoosed(){
		
		var deleteIds = "";
		
		// 遍历选中的checkbox
		$("input[name='allcheckbox']:checked").each(function() { 
			//得到删除的用户的编号
			deleteIds += $(this).parents("tr").find("td:eq(1)").text()+",";
			
		});
		
		return deleteIds;
	}
	/**
	 * 批量删除表中选中的行
	 */
	function deleteUsersOfTable(){
		
		// 遍历选中的checkbox
		$("input[name='allcheckbox']:checked").each(function() { 
			//得到删除的用户的编号
			// 获取checkbox所在行的顺序
			index = $(this).parents("tr").index()+1;
			//删除表中选中的信息
			$("table#userTable").find("tr:eq("+index+")").remove();
		});
		alterNoOfTable();
	}
	/**
	 * 删除
	 */
	function deleteUsersOfDatabase(userIds){
		//删除数据库中的用户信息
		$.ajax({
			type : "post",
			dataType : "json",
			url : "deleteUserById",
			data : {
				deleteIds : userIds,
			},
			success : function() {
				alert("删除成功");
				deleteUsersOfTable();
			},
			error:function(){
				alert("删除失败");
			}
		});
	}
	/**
	 * 判断是否选中部门
	 */
	function isChoosed(){
		var choose = $("#bt_unitId").val();
		if(""==choose || choose==null|| "null"==choose){
			return false;
		}else{
			return true;
		}
	}

	/**
	 *  实现点击保存按钮的监听事件 
	 */
	$('#user_add').click(function() {
		var choose = isChoosed();
		if(!choose){
			alert("选择部门后才能添加，请选择");
			//隐藏模态框
			$("#user_add").attr("data-target","");
		}else{
			isAdd=true;
			isChange=false;
			//alert("要添加了");
			setModalOfAdd();
		}
	});
	/**
	 * 设置添加的弹出框 (上级用户编号，上级用户名称，要添加的用户编号)
	 */
	function setModalOfAdd(){
		
		//弹出模态框
		$("#user_add").attr("data-target","#user_add_modal");
		//填充上级级用户的值 （即当前点击的树节点,对于添加而言）
		var unitName = document.getElementById("dap_add_name");
		unitName.innerHTML = $('#bt_unitName').val();
		var unitId = document.getElementById("dap_add_id");
		unitId.innerHTML = $('#bt_unitId').val();
	}
	/**
	 * 用户是否存在，如果存在的话，新增失败
	 */
	function existUser(){
		alert($('#user_telephone').val());
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchUserByTelephone",
			data : {
				telephone : $('#user_telephone').val() ,
			},
			success : saveAddToDatabase,
			error:function(result){
				
				alert("手机号码已经存在，添加失败，请重新添加");
			}
		});
		
	}
	/**
	 *  实现保存用户和修改用户 
	 */
	$('#user_add_save').click(function() {
		if (isAdd) {
			//alert("我是保存");
			//将新增的用户信息保存到数据库中
			existUser();
		} 
		if(isChange){
			//alert("我是修改");
			//将更新的信息保存到数据库中
			saveChangeOfDatabase();
		}
		//isAdd=false;
		//isChange=false;
	});

	/**
	 * 如果是添加的保存的话，在表的末尾追加新增的用户信息
	 */
	function saveAddToTable(userId){
		//获得弹出框中的禁用启用按钮的值
		//var isUse=getIsUseFromModal()
		//找到要添加的用户信息在表中的序号
		var index=parseFloat($("#userTable tr:last").find("td:first").text())+1;
		//追加到表的末尾
		$("#userTable").append(
				
				"<tr id='tr_"+index+"'> <td><input type='checkbox' name='allcheckbox'/>"
				+ index        	           						+ "</td><td class='hide'>"
				+ userId   										+ "</td><td class='hide'>"
				+ $('#bt_unitId').val()  	  					+ "</td><td>"
				+ $('#user_name').val()    	 					+ "</td><td>"
				+ $('#bt_unitName').val()						+ "</td><td>"
				+  $(":radio[name='user_sex']:checked").val()	+ "</td><td>"
				+ $('#user_duty').val()							+ "</td><td>"
				+ $('#user_telephone').val()  					+ "</td><td>"
				+ "<button  class='tb_alter' href='javascript:void(0)' onclick='alt_tr("+index+")' data-toggle='modal' data-target='#user_add_modal'>修改</button>    "
				+ "<button  class='tb_role' href='javascript:void(0)' onclick='role_tr("+index+")' data-toggle='modal' data-target='#user_role_add_modal'>角色管理</button>    "
				+ "<button  class='tb_delete' href='javascript:void(0)' onclick='del_tr("+index+")'>删除</button></td></tr>"
		);
	}

	/**
	 * 将新增的用户信息保存到数据库中
	 */
	function saveAddToDatabase(result){
		
		$.ajax({
			type : "post",
			dataType : "json",
			url : "addUser",
			data : {
				unitId : $('#bt_unitId').val(),
				unitName : $('#bt_unitName').val(),
				name : $('#user_name').val(),
				sex :  $(":radio[name='user_sex']:checked").val(),
				duty : $('#user_duty').val(),
				telephone : $('#user_telephone').val()
				//貌似不能用序列化
			},
			success : saveAddToDbSuccess,
			error : function(userId) {
				alert("保存失败 ");
				$("input[type=reset]").trigger("click");
			}
		});
	}
	
	function saveAddToDbSuccess(userId){
		
		alert("保存成功");
		//修改页面上的表，追加新添加的用户信息
		saveAddToTable(userId);
		$("input[type=reset]").trigger("click");
		$(".modal").modal("hide");
		//doReload(); //待完善
	}
	
	

	/**
	 * 将更新的信息保存到数据库中
	 */
	function saveChangeOfDatabase(){
		var unitId = $('#bt_unitId').val();
		var userId =$("#user_id").val();
		var unitName = $('#bt_unitName').val();
		var name = $('#user_name').val();
		var sex =  $(":radio[name='user_sex']:checked").val();
		var duty = $('#user_duty').val();
		var telephone = $('#user_telephone').val();
		$.ajax({
			type : "post",
			dataType : "json",
			url : "updateUserInfo",
			data : {
				unitId : unitId,
				userId :userId,
				unitName :unitName,
				name : name,
				sex :  sex,
				duty :duty,
				telephone : telephone
			},
			success : function(updateResult) {
				alert("修改成功");
				$("input[type=reset]").trigger("click");
				$(".modal").modal("hide");
				saveChangeOfTable(unitId,userId,unitName,name,sex,duty,telephone);
				//doReload();//待完善
			},
			error:function(){
				alert("修改失败");
				$(".modal").modal("hide");
			}
		});
	}	
	
	/**
	 * 将表中对应的那条修改的信息内容进行更新
	 */
	function saveChangeOfTable(unitId,userId,unitName,name,sex,duty,telephone){
		//找到修改的是第几行
		var index = alterRow;
		//获得弹出框中的禁用启用按钮的值
		$("#"+index).find("td").eq(1).text(userId);
		$("#"+index).find("td").eq(2).text(unitId);
		$("#"+index).find("td").eq(4).text(unitName);
		$("#"+index).find("td").eq(3).text(name);
		$("#"+index).find("td").eq(5).text(sex);
		$("#"+index).find("td").eq(6).text(duty);
		$("#"+index).find("td").eq(7).text(telephone);
	}
	
	$("#reset_password").click(function(){
		
		//批量删除之前判断是否已经选中用户
		var isChoosed = $("input[name='allcheckbox']:checked").length>0;
			
		if(!isChoosed){
			
			alert("选择用户后才能重置密码，请选择");
		}else{
			
			//得到要重置密码的用户的编号
			var userIds = getUserIdsChoosed();
			
			resetPassword(userIds);
		}
		
	});
	
	function resetPassword(userIds){

		var password=prompt("请输入新的密码");

		if (password!=null && password != ""){

			resetPasswordInDataBase(userIds,password);
		}
	}
	
	function resetPasswordInDataBase(userIds,password){
		
		//重置密码
		$.ajax({
			type : "post",
			dataType : "json",
			url : "updateUserPassword",
			data : {
				userIds : userIds,
				password:password
			},
			success : function() {
				alert("密码重置成功");
			},
			error:function(){
				alert("密码重置失败");
			}
		});
	}
	
})
