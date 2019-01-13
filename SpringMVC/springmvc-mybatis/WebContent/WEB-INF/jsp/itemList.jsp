<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js">
<script type="text/javascript">
	$(function(){
		var params={
				"id": 1,
				"name": "测试商品",
				"price": 99.9,
				"detail": "测试商品描述",
				"pic": "123456.jpg"
				};
		
		$.ajax({
			url:"${pageContext.request.contextPath }/json.action",
			data:params,
			type:"post",
			dataType:"json", //回调
			success: function(data){
				alert(data.name);
			}
			
		});
	});
</script>
</head>
<body> 
<form action="${pageContext.request.contextPath }/itemlist.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
</form>
商品列表：
<form  action="${pageContext.request.contextPath }/itemdeletes.action" method="post">
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品图片</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemList }" var="item">
<tr>
	<td>${item.name }</td>
	<td>${item.price }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td><img src="/pic/${item.pic}" width=100 height=100/></td>
	<td>${item.detail }</td>
	
	<td><a href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}">修改</a></td>

</tr>
</c:forEach>

</table>
<input type="submit" value="删除">
</form>
</body>

</html>