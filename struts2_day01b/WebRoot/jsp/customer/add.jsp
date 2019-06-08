<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style>
		table{
	border: 1px solid #000;
	border-collapse: collapse;
	
	}

table td{
	border: 1px solid #000;
	padding: 3px;
}

table th{
	border: 1px solid #000;
}

tbody th{
	background-color: #a3bae9;
}
	</style>

  </head>
  
  <body>
  
    <form action="${pageContext.request.contextPath }/customer/addCustomer.action" method="post">
    	客户名称：<input name="custName" type="text"/>
    	客户来源：
    	<select name="custSource" style="width:180px">
    		<option value="non">---请选择---</option>
    		<option value="电话营销">电话营销</option>
    		<option value="网络营销">网络营销</option>
    	</select>
    	
    	
    	<br/>
    	所属行业：<input name="custIndustry" type="text"/>
    	客户级别：
    	<select name="custLevel" style="width:180px">
    		<option value="non">---请选择---</option>
    		<option value="普通客户">普通客户</option>
    		<option value="VIP客户">VIP客户</option>
    	</select>
    	<br/>
    	
    	客户地址：<input name="custAddress" type="text"/>
    	联系电话：<input name="custPhone" type="text"/>
    	<br/>
    	<br/>
    	<input type="submit" value="增加"/>
    </form>
    
  </body>
</html>
