<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
	

	<style>
		table{
	border: 1px solid #000;
	border-collapse: collapse;
	
	}

table td{
	border: 1px solid #000;
	padding: 10px;
}
	</style>
</head>

    Menu... <br>
    
    <table>
    	<tr><td style="font-size: large;"> 客户管理 </td></tr>
    	<tr><td><a href="${pageContext.request.contextPath}/customer/findAllCustomer.action" target="main">客户列表</a></td></tr>
    	<tr><td><a href="${pageContext.request.contextPath}/customer/addUICustomer.action" target="main">增加客户</a></td></tr>
    	
    	<tr><td><a href="${pageContext.request.contextPath}/customer/demo1.action" target="main">demo1</a></td></tr>
    	<!-- /customer 是struts.xml里的namespace="/customer" -->
    </table>
    
