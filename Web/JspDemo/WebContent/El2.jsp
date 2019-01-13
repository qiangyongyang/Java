<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("name", "page");
		request.setAttribute("name", "req");
		session.setAttribute("name", "session");
		application.setAttribute("name", "app");
	%>
使用El表达式式取作用域中的值<br/>
	先从page找，若 没有去request找，去session，去application找<br/>
	${name}
</body>
</html>