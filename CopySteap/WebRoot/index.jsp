<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>"/>
<meta charset="utf-8" />
<title>字典管理系统</title>
</head>
<body>
	<jsp:include page="admin/dictionary/dictionary.jsp"></jsp:include>
</body>
</html>