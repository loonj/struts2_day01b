<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

 <script type="text/javascript">
 	function delOne(custId){
 		var sure=window.confirm("确定要删除吗？");
 		if(sure){
 			window.location.href="${pageContext.request.contextPath}/customer/deleteCustomer?custId="+custId;
 		}

 	}
 </script>
  </head>
  
  <body>
  	<s:debug></s:debug>
    <table>
    	  <tr>
		    <th>名字</th>
		    <th>等级</th>
		     <th>来源</th>
		    <th>行业</th>
		     <th>地址</th>
		    <th>电话</th>
		    <th>操作</th>
		  </tr>
    	<c:forEach items="${customers}" var="customer">
    	<tr>
    		<td>${customer.custName}</td>
    		<td>${customer.custLevel}</td>
    		<td>${customer.custSource}</td>
    		<td>${customer.custIndustry}</td>
    		<td>${customer.custAddress}</td>
    		<td>${customer.custPhone}</td>
    		<td><a href="javascript:delOne('${customer.custId}')">删除</a></td>
    	</tr>
    	</c:forEach>
    	<tr><td colspan="7"><hr></td></tr>
    	<s:iterator value="customers">
    	<tr>
    		<td>${custName}</td>
    		<td>${custLevel}</td>
    		<td>${custSource}</td>
    		<td>${custIndustry}</td>
    		<td>${custAddress}</td>
    		<td>${custPhone}</td>
    		<td><a href="javascript:delOne('${custId}')">删除</a></td>
    	</tr>
    	</s:iterator>
    </table>
  </body>
</html>
