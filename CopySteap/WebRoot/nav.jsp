<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
	<%@ taglib uri="/struts-tags" prefix="s" %>
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
<title>footer</title>
</head>
<body>
<div class="bef_nav">
	<div class="container">
		<div class="bef_nav_right">
			<span style="margin-right: 20px;">欢迎 :<s:property value="#session.userName"/></span><a href="#">修改密码</a><a
				href="quitSystem.action">退出系统</a>
		</div>
	</div>
</div>

<nav class="nav navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<!-- <button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button> -->
			<a class="navbar-brand" href="#">LOGO</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">首页</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">培训计划管理<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="toAddPlan.action">添加</a></li>
						<li><a href="#">修改</a></li>
						<li><a href="#">删除</a></li>
						<li><a href="#">查询</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">培训成绩管理<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="Result/entryMark.jsp">录入</a></li>
						<li><a href="Result/updateMark.jsp">修改</a></li>
						<li><a href="Result/searchMark.jsp">查询</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">培训考勤管理<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="Attendance/searchTrainplan.jsp">录入</a></li>
						<li><a href="Attendance/searchAttendance.jsp">查询</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">其他<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="toDepart.action">部门管理</a></li>
						<li><a href="#">指纹库管理</a></li>
						<li><a href="#">用户管理</a></li>
					</ul></li>
				<li><a href="toStaff.action">学员管理</a></li>
			</ul>
		</div>

	</div>
</nav>
</body>
</html>