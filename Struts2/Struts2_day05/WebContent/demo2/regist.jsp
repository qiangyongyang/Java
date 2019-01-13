<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>注册页面</h1>
<s:fielderror/>
<form action="${pageContext.request.contextPath }/regist.action" method="post">
	账号<input type="text" name="username"><br/> 
	密码<input type="password" name="password1"><br/> 
	确认密码<input type="password" name="password2"><br/> 
	年龄<input type="text" name="age"><br/> 
	邮箱<input type="email" name="email"><br/> 
	电话<input type="text" name="phone"><br/> 
	生日<input type="text" name="birthday"><br/> 
	<input type="submit" value="注册".>
</form>
</body>
</html>