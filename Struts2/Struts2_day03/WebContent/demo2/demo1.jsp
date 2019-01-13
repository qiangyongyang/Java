<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>#号的用法</h1>
<h3>获取context的数据</h3>
<%
	request.setAttribute("name", "李兵");
%>
<s:property value="#request.name"/>

<h3>构建list集合</h3>
<s:iterator value="{'aa','aadd','gtyok'}" var="list">
	<s:property value="list"/>----<s:property value="#list"/><br/>
</s:iterator>

<h3>构建map集合</h3>
<s:iterator value="#{'name':'yyq','age':18,'sex':'man'}" var="map">
	<s:property value="#map.key"/>----<s:property value="#map.value"/><br/>
</s:iterator>

<s:debug></s:debug>
</body>
</html>


























































