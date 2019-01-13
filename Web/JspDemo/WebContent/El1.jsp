<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
-------------------单个字符串--------------------<br/>
<%
	pageContext.setAttribute("name", "page");
	request.setAttribute("name", "req");
	session.setAttribute("name", "session");
	application.setAttribute("name", "app");
%>
使用El表达式式取作用域中的值<br/>
	${pageScope.name }<br/>
	${requestScope.name }<br/>
	${sessionScope.name }<br/>
	${applicationScope.name }<br/>
	
--------------------数组------------------------<br/>	
<%
	String [] a={"aa","bb","vvv"};
	//将数组添加到作用域
	pageContext.setAttribute("array", a);
%>
使用El表达式式取作用域中数组的值<br/>
	${array[0]}<br/>
	${array[1]}<br/>
	

</body>
</html>
























