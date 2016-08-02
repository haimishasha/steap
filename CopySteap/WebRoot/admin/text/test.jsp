<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<title>prompt</title>
<script type="text/javascript">
  function disp_prompt()
  {
    var name=prompt("请输入您的姓名","");
    var sex=prompt("请输入您的性别","女");
    if (name!=null && name != "")
    {
      if (sex=="男")
      {
        alert(name+"先生您好！\n\n今天天气不错，希望您玩的开心！");
      }
      else
      {
        alert(name+"女士您好！\n\n今天天气不错，希望您玩的开心！");
      }
    }
  }
  </script>
</head>
<body>
<input type="button" onClick="disp_prompt()" value="单击这里" />
</body>
</html>