<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	声明一个对象name，对象的值为zs，默认存到page，现指定是session  <br/>
	<c:set var="name" value="zs" scope="session"></c:set>
	${sessionScope.name }
	
	<br>-------------------------------------------------------------------------<br>
	<c:set var="age" value="19"></c:set>
	<c:if test="${age >15}" var="flag">
		可以去网吧了 <bt>  ${flag }
	</c:if>
	
	<br>-------------------------------------------------------------------------<br>
	<c:forEach begin="1" end="10" var="i" step="2 ">
		${i }
	</c:forEach>
	
</body> 
</html>

































































