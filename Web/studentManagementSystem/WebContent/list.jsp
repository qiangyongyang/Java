<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表页面</title>
<script>
	function doDelete(sid) {
		/*如果弹出的对话框，就马上请求servlet
		1.如何知道用户点击的是确定
		2.如何在js方法中请求servlet*/
		var flag=confirm("是否确定删除？");
		if(flag){
			//表明点了确定，访问servlet。在当前页面打开超链接
			window.location.href="DeleteServlet?sid="+sid;
		}
	}
</script>
</head>
<body>	
	<form action="SearchServlet" method="post">
		<table border="1" width="700px"> 
			<tr>
				<td colspan="8">
					按姓名查询：<input type="text" name="sname">
					按性别查询：<select name="gender">
								<option value="">---请选择---
								<option value="男">男
								<option value="女">女
							  </select>
					<input type="submit" value="查询">
					<a href="add.jsp">添加</a>
				</td>
			</tr>
			 
			<tr align="center">
				<td>编号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>电话</td>
				<td>生日</td>
				<td>爱好</td>
				<td>简介</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list }" var="stu">
				<tr>
					<td>${stu.sid }</td>
					<td>${stu.sname }</td>
					<td>${stu.gender }</td>
					<td>${stu.phone }</td>
					<td>${stu.birthday }</td>
					<td>${stu.hobby }</td>
					<td>${stu.info }</td>
					<td><a href="EditServlet?sid=${stu.sid }">更新</a>   <a href="#" onclick="doDelete(${stu.sid})">删除</a>  </td>
				</tr>
			</c:forEach>
			
		</table>
	</form>
</body>
</html>