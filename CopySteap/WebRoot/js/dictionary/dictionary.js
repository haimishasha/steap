$(document).ready(function() {
	/**
	 * 请求树信息
	 */
	$.ajax({
		type : "post",
		target : "#treeDemo",
		dataType : "json",
		url : "searchTreeAction",
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
						idKey: "dictionaryOptionId",
						pIdKey: "upDictionaryOptionId",
						rootPId : "1",
					},
					key : {
						name : "dictionaryOptionName",
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
	 * 点击树节点的同时，将该字典信息对应的字典编号，字典名称，上级字典编号，上级字典名称保存下来
	 */
	function clickOnTree(event, treeId, treeNode, clickFlag){
		//得到该节点的字典编号和字典名字
		document.getElementById("bt_dictionaryId").value = treeNode.dictionaryOptionId;
		document.getElementById("bt_dictionaryName").value = treeNode.dictionaryOptionName;
		if (treeNode.dictionaryOptionId == "1") {
			//如果本节点是根节点，那么就不能执行更新和删除操作
			$("#dictionary_change,#dictionary_delete").attr("disabled","disabled");
		} else {
			//如果本节点不是根节点，就可以执行更新和删除操作
			$("#dictionary_change,#dictionary_delete").removeAttr("disabled");
			//父节点
			var fatherNode=treeNode.getParentNode();
			//得到父节点的字典编号和字典名称
			document.getElementById("bt_upDictionaryId").value = fatherNode.dictionaryOptionId;
			document.getElementById("bt_upDictionaryName").value = fatherNode.dictionaryOptionName;
		}
		//点击一下树节点表格输出本节点以及下级节点的字典信息
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
	 *  点击一下树节点表格输出本节点以及下级节点的字典信息
	 */
	function searchDictionary() {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchDictionaryByUpId",
			data : {

				upDictionaryOptionId : $("#bt_dictionaryId").val(),
			},
			success : showTable
		});
	}
	/**
	 * 点击查询按钮，按条件查询字典信息
	 */
	$("#condition_sub").click(function(){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchDictionaryByCondition",
			data : {
				dictionaryOptionId :   $("#dic_id").val(),
				dictionaryOptionName : $("#dic_name").val()
			},
			success : showTable
		});
	});

	/**
	 * 显示表格
	 */
	function showTable(result) {

		var dictionaryList = eval("(" + result + ")");
		// 清空表格  待完善
		$("#dictionaryTable  tr:not(:first)").html("");
		// 在表格中添加数据
		for (var i = 0; i < dictionaryList.length; i++) {
			var index = i + 1;
			var isUse;
			if(dictionaryList[i].use==true){
				isUse="启用";
			}else{
				isUse="禁用";
			}
			$("#dictionaryTable").append(
					"<tr> <td>" + index                      + "</td><td>"
					+ dictionaryList[i].dictionaryOptionName + "</td><td>"
					+ dictionaryList[i].dictionaryOptionId	 + "</td><td>"
					+ isUse                                  + "</td><td>"
					+ dictionaryList[i].description	         + "</td><td>"
					+ dictionaryList[i].sortNo	             + "</td><td>"
					+ dictionaryList[i].flag                 + "</td><td>" 
					+ dictionaryList[i].englishName	         + "</td><td>"
					+ dictionaryList[i].dataType             + "</td><td>"
			);
		}
	}
	/**
	 * 实现字典信息的删除 
	 */
	$("#dictionary_delete").click(function() {

		deleteDictionary();

	});

	/**
	 * 点击删除按钮后需要 删除表+删除数据库
	 */
	function deleteDictionary(){
		var choose = isChoosed();
		if(!choose){
			alert("选择字典后才能删除，请选择");
		}else{
			//找到删除的是第几行
			var index = getRowInTable(); 
			//简单的删除要删除的表中的字典信息
			$("#dictionaryTable tr").eq(index).remove();
			//删除数据库中的字典信息
			$.ajax({
				type : "post",
				dataType : "json",
				url : "deleteDictionaryAction",
				data : {
					dictionaryOptionId : $("#bt_dictionaryId").val(),
				},
				success : function() {
					alert("删除成功");
				},
				error:function(){
					alert("删除失败");
				}
			});
		}
	}
	/**
	 * 判断是否选中树节点、表中数据
	 */
	function isChoosed(){
		var choose = $("#bt_dictionaryId").val();
		if(""==choose || choose==null|| "null"==choose){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 根据字典编号判断树对应字典与该字典对应的信息在表的哪一行
	 */
	function getRowInTable(){
		var index; 
		$("#dictionaryTable tr:gt(0)").each(function(i){
			if($(this).children("td").eq(2).text()==$('#bt_dictionaryId').val()){
				index = i;
			}
		});
		return index = index + 1;
	}
	/**
	 *  此处是为了识别 按钮事件是 保存 还是修改 
	 */
	var isAdd = false;
	var isChange = false;
	/**
	 *  实现点击保存按钮的监听事件 
	 */
	$('#dictionary_add').click(function() {
		var choose = isChoosed();
		if(!choose){
			alert("选择上级字典后才能添加，请选择");
			//隐藏模态框
			$("#dictionary_add").attr("data-target","");
		}else{
			setModalOfAdd();
		}
	});
	/**
	 * 设置添加的弹出框 (上级字典编号，上级字典名称，要添加的字典编号)
	 */
	function setModalOfAdd(){
		//设置模态框是属于 增加 还是 更新
		isAdd = true;
		isChange = false;
		//弹出模态框
		$("#dictionary_add").attr("data-target","#dictionary_add_modal");
		//填充上级级字典的值 （即当前点击的树节点,对于添加而言）
		var dictionaryName = document.getElementById("dap_add_name");
		dictionaryName.innerHTML = $('#bt_dictionaryName').val();
		var dictionaryId = document.getElementById("dap_add_id");
		dictionaryId.innerHTML = $('#bt_dictionaryId').val();
		//请求下一个添加的字典的编号Id
		$.ajax({
			type : "post",
			datatype : "json",
			url : "searchNextId",
			data : {
				upDictionaryOptionId: $('#bt_dictionaryId').val(),
			},
			success : function(nextId) {
				//得到下一个添加的字典的编号Id
				$('#dictionary_id').val(nextId);
			}
		});	
	}
	/**
	 *  实现点击修改按钮的时候，弹出框的处理
	 */
	$("#dictionary_change").click(function() {
		var choose = isChoosed();
		if(choose){
			//从数据库查找数据添加到修改界面中
			setModalOfChange();
		}else{
			alert("选择上级字典后才能添加，请选择");
			$("#dictionary_change").attr("data-target","");//隐藏模态框
		}
	});

	/**
	 * 设置添加的弹出框 (上级字典编号，上级字典名称，要修改的字典的原始信息)
	 */
	function setModalOfChange(){
		isChange = true;
		isAdd = false;
		//弹出模态框
		$("#dictionary_change").attr("data-target","#dictionary_add_modal");
		$('#dictionary_change').attr("name", "saveChange");
		//请求要修改的字典的原始信息
		$.ajax({
			type : "post",
			datatype : "json",
			url : "getUpdateDictionary",
			data : {
				dictionaryOptionId : $('#bt_dictionaryId').val(),
			},
			success : getInfoForChangeModal
		});
	}
	/**
	 * 得到需要修改的字典的原始信息
	 */
	function getInfoForChangeModal(result){
		//设置启用和禁用
		if(result.use==true){
			document.form1.radio[0].checked=true;//启用
		}else{
			document.form1.radio[1].checked=true;//禁用
		}
		//填充上级字典的信息
		var upDictionaryId = document.getElementById("dap_add_id");
		upDictionaryId.innerHTML = $('#bt_upDictionaryId').val();
		var upDictionaryName = document.getElementById("dap_add_name");
		upDictionaryName.innerHTML = $('#bt_upDictionaryName').val();
		//填充要修改的字典的信息
		$('#dictionary_id').val(result.dictionaryOptionId), 
		$('#dictionary_name').val(result.dictionaryOptionName), 
		$('#dictionary_description').val(result.description), 
		$('#dictionary_sortNo').val(result.sortNo),
		$('#dictionary_flag').val(result.flag),
		$('#dictionary_englishName').val(result.englishName),
		$('#dictionary_dataType').val(result.dataType),
		$('#dictionary_remark1').val(result.remark1)
	}

	/**
	 *  实现保存字典和修改字典 
	 */
	$('#dictionary_add_save').click(function() {
		if (isAdd) {
			//alert("我是保存");
			//在表的末尾追加新增的字典信息
			saveAddOfTable();
			//将新增的字典信息保存到数据库中
			saveAddOfDatabase();
		} 
		if(isChange){
			//alert("我是修改");
			//将表中对应的那条修改的信息内容进行更新
			saveChangeOfTable();
			//将更新的信息保存到数据库中
			saveChangeOfDatabase();
		}
	});

	/**
	 * 如果是添加的保存的话，在表的末尾追加新增的字典信息
	 */
	function saveAddOfTable(){
		//获得弹出框中的禁用启用按钮的值
		var isUse=getIsUseFromModal()
		//找到要添加的字典信息在表中的序号
		var index=parseFloat($("#dictionaryTable tr:last").find("td:first").text());
		//追加到表的末尾
		$("#dictionaryTable").append(
				"<tr> <td>" + (++index)              + "</td><td>"
				+ $('#dictionary_name').val()        + "</td><td>"
				+ $('#dictionary_id').val()	         + "</td><td>"
				+ isUse	                             + "</td><td>"
				+ $('#dictionary_description').val() + "</td><td>"
				+ $('#dictionary_sortNo').val()	     + "</td><td>"
				+ $('#dictionary_flag').val()        + "</td><td>"
				+ $('#dictionary_englishName').val() + "</td><td>"
				+ $('#dictionary_dataType').val()    + "</td><td>"
		);
	}

	/**
	 * 将新增的字典信息保存到数据库中
	 */
	function saveAddOfDatabase(){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "addDictionaryAction",
			data : {
				dictionaryOptionId : $('#dictionary_id').val(),
				upDictionaryOptionId : $('#bt_dictionaryId').val(),
				dictionaryOptionName : $('#dictionary_name').val(),
				isUse : $(":radio[name='radio']:checked").val(),
				description : $('#dictionary_description').val(),
				sortNo : $('#dictionary_sortNo').val(),
				flag : $('#dictionary_flag').val(),
				englishName : $('#dictionary_englishName').val(),
				dataType : $('#dictionary_dataType').val(),
				remark1 : $('#dictionary_remark1').val()
				//貌似不能用序列化
			},
			success : function(addResult) {
				alert("保存成功");
				$("input[type=reset]").trigger("click");
				$(".modal").modal("hide");
				//doReload(); //待完善
			},
			error : function(addResult) {
				alert("保存失败，字典编号 ");
				$("input[type=reset]").trigger("click");
			}
		});
	}
	/**
	 * 将表中对应的那条修改的信息内容进行更新
	 */
	function saveChangeOfTable(){
		//找到修改的是第几行
		var index = getRowInTable(); 
		//获得弹出框中的禁用启用按钮的值
		var isUse = getIsUseFromModal();
		$("#dictionaryTable tr").eq(index).find("td").eq(1).text($('#dictionary_name').val()); 
		$("#dictionaryTable tr").eq(index).find("td").eq(3).text(isUse); 
		$("#dictionaryTable tr").eq(index).find("td").eq(4).text($('#dictionary_description').val());
		$("#dictionaryTable tr").eq(index).find("td").eq(5).text($('#dictionary_sortNo').val());
		$("#dictionaryTable tr").eq(index).find("td").eq(6).text($('#dictionary_flag').val());
		$("#dictionaryTable tr").eq(index).find("td").eq(7).text($('#dictionary_englishName').val());
		$("#dictionaryTable tr").eq(index).find("td").eq(8).text($('#dictionary_dataType').val());
	}
	/**
	 * 将更新的信息保存到数据库中
	 */
	function saveChangeOfDatabase(){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "updateDictionaryAction",
			data : {
				dictionaryOptionId : $('#dictionary_id').val(),
				upDictionaryOptionId : $('#bt_dictionaryId').val(),
				dictionaryOptionName : $('#dictionary_name').val(),
				isUse : $(":radio[name='radio']:checked").val(),
				description : $('#dictionary_description').val(),
				sortNo : $('#dictionary_sortNo').val(),
				flag : $('#dictionary_flag').val(),
				englishName : $('#dictionary_englishName').val(),
				dataType : $('#dictionary_dataType').val(),
				remark1 : $('#dictionary_remark1').val()
			},
			success : function(updateResult) {
				alert("修改成功");
				$("input[type=reset]").trigger("click");
				$(".modal").modal("hide");
				//doReload();//待完善
			}
		});
	}
	/**
	 * 获得弹出框中的禁用启用按钮的值
	 */
	function getIsUseFromModal(){
		var isUse;
		//注意此处必须是字符串的“false”

		if($(":radio[name='radio']:checked").val()=="true"){
			isUse="启用";
		}else{
			isUse="禁用";
		}
		return isUse;
	}
			
})