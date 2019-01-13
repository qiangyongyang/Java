<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:iterator var="i" value="{'aa','ads','qwe'}">
		<s:property value="#i"/>
	</s:iterator>   <br/><br/><br/><br/>
	
	
	<s:iterator value="#{'name':'yyq','age':'18'}" var="map">
		<s:property value="#map.key"/>-------<s:property value="#map.value"/> <br/>
	</s:iterator>   <br/>
	
	
	<s:iterator begin="1" end="10" step="2" var="i">
		<s:property value="#i"/>
	</s:iterator>
	
</body>
</html>