<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta charset="utf-8" />
<meta name="robots" content="noodp" /><meta name="viewport" content="width=device-width,initial-scale=1.0" />
<style type="text/css">

</style>
</head>
<body>
<table border="1">
	<tr><th>ID</th><th>标题</th><th>时间</th><th>操作</th></tr>
	<!-- <tr id="tr_1"><td>1</td><td>标题1</td><td>时间1</td><td><a href="javascript:void(0)" onclick="del_tr(1)">删除</a></td></tr>
	<tr id="tr_2"><td>2</td><td>标题2</td><td>时间2</td><td><a href="javascript:void(0)" onclick="del_tr(2)">删除</a></td></tr>
	<tr id="tr_3"><td>3</td><td>标题3</td><td>时间3</td><td><a href="javascript:void(0)" onclick="del_tr(3)">删除</a></td></tr>
	<tr id="tr_4"><td>4</td><td>标题4</td><td>时间4</td><td><a href="javascript:void(0)" onclick="del_tr(4)">删除</a></td></tr> -->
	<tr id="tr_1"><td>1</td><td>标题1</td><td>时间1</td><td><button href="javascript:void(0)" onclick="del_tr(1)">删除</button></td></tr>
	<tr id="tr_2"><td>2</td><td>标题2</td><td>时间2</td><td><button href="javascript:void(0)" onclick="del_tr(2)">删除</button></td></tr>
	<tr id="tr_3"><td>3</td><td>标题3</td><td>时间3</td><td><button href="javascript:void(0)" onclick="del_tr(3)">删除</button></td></tr>
	<tr id="tr_4"><td>4</td><td>标题4</td><td>时间4</td><td><button href="javascript:void(0)" onclick="del_tr(4)">删除</button></td></tr>
</table>
</body>
<script>
function del_tr(id){
	var tr = document.getElementById("tr_"+id);
    tr.parentNode.removeChild(tr);
}
</script>
</html>
