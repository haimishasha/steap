<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
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
	<div class="hr"></div>
	<footer style="text-align: center;margin-bottom: 30px;">
		<p>版权信息</p>
		<p>版权信息一般还有两行</p>
	</footer>
</body>
</html>
