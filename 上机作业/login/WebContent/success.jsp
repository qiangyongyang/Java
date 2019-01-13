<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登陆成功，欢迎你</h1>
	<h3>你的名字是：${user.username }</h3>
	<h3>你的性别是：${user.gender }</h3>
	<h3>你的邮箱是：${user.email }</h3>
	<h3>你的身份证是：${user.idcard }</h3>
	<h3>你的生日是：${user.birthday }</h3>
	<h3>你的爱好是：${user.hobby }</h3>
	<h3>你的简介是：${user.info }</h3>
</body>
</html>