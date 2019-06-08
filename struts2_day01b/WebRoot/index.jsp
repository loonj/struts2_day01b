<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
    <frameset framespacing="0" rows="80,*" frameborder="1">
    	<frame name="top" src="top.html" frameborder="1" noresize="noresize" scrolling="no" />
    	
    	<frameset framespacing="0" frameborder="1" cols="220,*">
    		<frame name="menu" src="${pageContext.request.contextPath}/menu.jsp" frameborder="1" framespacing="0"/>
    		<frame name="main" src="${pageContext.request.contextPath}/welcome.html" frameborder="1" framespacing="0"/>
    	</frameset>
    	
    	 <noframes>
				<body>
				<p>对不起，您的浏览器不支持“框架”！</p>
				</body>
			</noframes>
			
    </frameset>

</html>
