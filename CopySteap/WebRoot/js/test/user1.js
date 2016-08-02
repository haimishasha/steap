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
		//有待完善
		function onClick(event, treeId, treeNode, clickFlag) {
			clickOnTree(event, treeId, treeNode, clickFlag);
		}
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	}
	/**
	 * 点击树节点的同时，将该用户信息对应的用户编号，用户名称，上级用户编号，上级用户名称保存下来
	 */
	function clickOnTree(event, treeId, treeNode, clickFlag){
		//得到该节点的用户编号和用户名字
		document.getElementById("bt_unitId").value = treeNode.unitId;
		document.getElementById("bt_unitName").value = treeNode.unitName;
		if (treeNode.unitId == "10") {
			//如果本节点是根节点，那么就不能执行添加操作
			$("#user_add").attr("disabled","disabled");
		} else {
			//如果本节点不是根节点，就可以执行更新和删除操作
			$("#user_add").removeAttr("disabled");
		}
		//点击一下树节点表格输出本节点以及下级节点的用户信息
		searchDictionary();
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
	 *  点击一下树节点，表格输出本部门内部的用户信息
	 */
	function searchDictionary() {
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
//	/**
//	 * 点击查询按钮，按条件查询用户信息
//	 */
//	$("#condition_sub").click(function(){
//		$.ajax({
//			type : "post",
//			dataType : "json",
//			url : "searchDictionaryByCondition",
//			data : {
//				dictionaryOptionId :   $("#dic_id").val(),
//				dictionaryOptionName : $("#dic_name").val()
//			},
//			success : showTable
//		});
//	});

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
					+ index                 + "</td><td>"
					+ userList[i].userId    + "</td><td>"
					+ userList[i].unitId    + "</td><td>"
					+ userList[i].name      + "</td><td>"
					+ userList[i].unitName	+ "</td><td>"
					+ userList[i].sex	    + "</td><td>"
					+ userList[i].duty	    + "</td><td>"
					+ userList[i].telephone + "</td><td>"
					+ "<button   class='tb_alter'>修改</button>    "
					+ "<button   class='tb_role'>角色管理</button>    "
					+ "<button   class='tb_delete' href='javascript:void(0)' onclick='del_tr("+index+")'>删除</button></td></tr>"
			);
			
		}
	}
	

//	function deleteOneUser(){
//		
//		alert("fasd");
//	}
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
			
			alert("开始删除");
			//得到要删除的用户的编号
			var userIds = getUserIdsOfDelete();
			//删除数据库中对应的用户的信息
			deleteUsersOfDatabase(userIds);
		}
	}
	/**
	 * 得到要删除的用户的编号
	 */
	function getUserIdsOfDelete(){
		
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
		//删除对应的行后，修改表的序号
		
		var len = $('#userTable tr').length;
		for(var i = 1;i<len;i++){
			$('#userTable tr:eq('+i+') td:first').text(i);
		}
	}
	
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
	 * 判断是否选中树节点、表中数据
	 */
	function isChoosed(){
		var choose = $("#bt_unitId").val();
		if(""==choose || choose==null|| "null"==choose){
			return false;
		}else{
			return true;
		}
	}
//	/**
//	 * 根据用户编号判断树对应用户与该用户对应的信息在表的哪一行
//	 */
//	function getRowInTable(){
//		var index; 
//		$("#dictionaryTable tr:gt(0)").each(function(i){
//			if($(this).children("td").eq(2).text()==$('#bt_unitId').val()){
//				index = i;
//			}
//		});
//		return index = index + 1;
//	}
//	/**
//	 *  此处是为了识别 按钮事件是 保存 还是修改 
//	 */
	var isAdd = false;
	var isChange = false;
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
			alert("要添加了");
			setModalOfAdd();
		}
	});
	/**
	 * 设置添加的弹出框 (上级用户编号，上级用户名称，要添加的用户编号)
	 */
	function setModalOfAdd(){
		//设置模态框是属于 增加 还是 更新
		isAdd = true;
		isChange = false;
		//弹出模态框
		$("#user_add").attr("data-target","#user_add_modal");
		//填充上级级用户的值 （即当前点击的树节点,对于添加而言）
		var unitName = document.getElementById("dap_add_name");
		unitName.innerHTML = $('#bt_unitName').val();
		var unitId = document.getElementById("dap_add_id");
		unitId.innerHTML = $('#bt_unitId').val();
	}
//	/**
//	 *  实现点击修改按钮的时候，弹出框的处理
//	 */
//	$("#dictionary_change").click(function() {
//		var choose = isChoosed();
//		if(choose){
//			//从数据库查找数据添加到修改界面中
//			setModalOfChange();
//		}else{
//			alert("选择上级用户后才能添加，请选择");
//			$("#dictionary_change").attr("data-target","");//隐藏模态框
//		}
//	});
//
//	/**
//	 * 设置添加的弹出框 (上级用户编号，上级用户名称，要修改的用户的原始信息)
//	 */
//	function setModalOfChange(){
//		isChange = true;
//		isAdd = false;
//		//弹出模态框
//		$("#dictionary_change").attr("data-target","#dictionary_add_modal");
//		$('#dictionary_change').attr("name", "saveChange");
//		//请求要修改的用户的原始信息
//		$.ajax({
//			type : "post",
//			datatype : "json",
//			url : "getUpdateDictionary",
//			data : {
//				dictionaryOptionId : $('#bt_unitId').val(),
//			},
//			success : getInfoForChangeModal
//		});
//	}
//	/**
//	 * 得到需要修改的用户的原始信息
//	 */
//	function getInfoForChangeModal(result){
//		//设置启用和禁用
//		if(result.use==true){
//			document.form1.radio[0].checked=true;//启用
//		}else{
//			document.form1.radio[1].checked=true;//禁用
//		}
//		//填充上级用户的信息
//		//填充要修改的用户的信息
//		$('#dictionary_id').val(result.dictionaryOptionId), 
//		$('#dictionary_name').val(result.dictionaryOptionName), 
//		$('#dictionary_description').val(result.description), 
//		$('#dictionary_sortNo').val(result.sortNo),
//		$('#dictionary_flag').val(result.flag),
//		$('#dictionary_englishName').val(result.englishName),
//		$('#dictionary_dataType').val(result.dataType),
//		$('#dictionary_remark1').val(result.remark1)
//	}
	
	/**
	 *  实现保存用户和修改用户 
	 */
	$('#user_add_save').click(function() {
		if (isAdd) {
			
			alert("我是保存");
			//将新增的用户信息保存到数据库中
			saveAddToDatabase();
		} 
//		if(isChange){
//			//alert("我是修改");
//			//将表中对应的那条修改的信息内容进行更新
//			saveChangeOfTable();
//			//将更新的信息保存到数据库中
//			saveChangeOfDatabase();
//		}
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
				+ index        	           					+ "</td><td>"
				+ userId   											+ "</td><td>"
				+ $('#bt_unitId').val()  	  					+ "</td><td>"
				+ $('#user_name').val()    	 					+ "</td><td>"
				+ $('#bt_unitName').val()						+ "</td><td>"
				+  $(":radio[name='user_sex']:checked").val()	+ "</td><td>"
				+ $('#user_duty').val()							+ "</td><td>"
				+ $('#user_telephone').val()  					+ "</td><td>"
				+ "<button type='button'   class='tb_alter'>修改</button>    "
				+ "<button type='button'   class='tb_role'>角色管理</button>    "
				+ "<button  class='tb_delete' href='javascript:void(0)' onclick='del_tr("+index+")'>删除</button></td></tr>"
		);
	}

	/**
	 * 将新增的用户信息保存到数据库中
	 */
	function saveAddToDatabase(){
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
	
	
//	/**
//	 * 将表中对应的那条修改的信息内容进行更新
//	 */
//	function saveChangeOfTable(){
//		//找到修改的是第几行
//		var index = getRowInTable(); 
//		//获得弹出框中的禁用启用按钮的值
//		var isUse = getIsUseFromModal();
//		$("#dictionaryTable tr").eq(index).find("td").eq(1).text($('#dictionary_name').val()); 
//		$("#dictionaryTable tr").eq(index).find("td").eq(3).text(isUse); 
//		$("#dictionaryTable tr").eq(index).find("td").eq(4).text($('#dictionary_description').val());
//		$("#dictionaryTable tr").eq(index).find("td").eq(5).text($('#dictionary_sortNo').val());
//		$("#dictionaryTable tr").eq(index).find("td").eq(6).text($('#dictionary_flag').val());
//		$("#dictionaryTable tr").eq(index).find("td").eq(7).text($('#dictionary_englishName').val());
//		$("#dictionaryTable tr").eq(index).find("td").eq(8).text($('#dictionary_dataType').val());
//	}
//	/**
//	 * 将更新的信息保存到数据库中
//	 */
//	function saveChangeOfDatabase(){
//		$.ajax({
//			type : "post",
//			dataType : "json",
//			url : "updateDictionaryAction",
//			data : {
//				dictionaryOptionId : $('#dictionary_id').val(),
//				upDictionaryOptionId : $('#bt_unitId').val(),
//				dictionaryOptionName : $('#dictionary_name').val(),
//				isUse : $(":radio[name='radio']:checked").val(),
//				description : $('#dictionary_description').val(),
//				sortNo : $('#dictionary_sortNo').val(),
//				flag : $('#dictionary_flag').val(),
//				englishName : $('#dictionary_englishName').val(),
//				dataType : $('#dictionary_dataType').val(),
//				remark1 : $('#dictionary_remark1').val()
//			},
//			success : function(updateResult) {
//				alert("修改成功");
//				$("input[type=reset]").trigger("click");
//				$(".modal").modal("hide");
//				//doReload();//待完善
//			}
//		});
//	}
//	/**
//	 * 获得弹出框中的禁用启用按钮的值
//	 */
//	function getIsUseFromModal(){
//		var isUse;
//		//注意此处必须是字符串的“false”
//
//		if($(":radio[name='radio']:checked").val()=="true"){
//			isUse="启用";
//		}else{
//			isUse="禁用";
//		}
//		return isUse;
//	}
//			
})
