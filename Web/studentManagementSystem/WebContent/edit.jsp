<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生界面</title>
</head>
<body>
	<h3>更新学生界面</h3>
	<form action="UpdateServlet" method="post">
			<input type="hidden" name="sid" value="${stu.sid }">
		<table border="1" width="700px">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="sname" value="${stu.sname }"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="gender" value="男"
						<c:if test="${stu.gender =='男' }">checked</c:if>
					>男
					<input type="radio" name="gender" value="女"
						<c:if test="${stu.gender=='女' }">checked</c:if>
					>女
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone" value="${stu.phone}"></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" name="birthday" value="${stu.birthday }"></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>
					<input type="checkbox" name="hobby" value="book"
						<c:if test="${fn:contains(stu.hobby,'book') }">checked</c:if>
					>book
					<input type="checkbox" name="hobby" value="lol"
						<c:if test="${fn:contains(stu.hobby,'lol') }">checked</c:if>
					>lol
					<input type="checkbox" name="hobby" value="cf"
						<c:if test="${fn:contains(stu.hobby,'cf') }">checked</c:if>
					>cf
					<input type="checkbox" name="hobby" value="dnf"
						<c:if test="${fn:contains(stu.hobby,'dnf') }">checked</c:if>
					>dnf
				</td>
			</tr>
			<tr>
				<td>简介</td>
				<td><textarea name="info" rows="3" cols="20">${stu.info}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="添加" > </td>
			</tr>
	</table>
	</form>
</body>
</html>