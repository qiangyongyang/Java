<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
使用作用域来储存数据：<br/>
<%
	pageContext.setAttribute("name", "page");  
	/*作用域仅限于当前页面*/

	request.setAttribute("name", "request");
	/*作用域仅限于一次请求，只要服务器对该请求作出了相应，域中的值就没了*/
	
	session.setAttribute("name", "session");
	/*作用域限于一次会话*/
	
	application.setAttribute("name", "app");
	/*整个工程一直可以用*/
%>
取出4个作用域中的值：<br/>
<%=pageContext.getAttribute("name") %>  <br/>
<%=request.getAttribute("name") %>     <br/>
<%=session.getAttribute("name") %>     <br/>
<%=application.getAttribute("name") %> <br/>
</body>
</html>