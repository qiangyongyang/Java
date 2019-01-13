<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	你的购物车商品如下：
	<%
		//1.先获取map
		Map<String,Integer> map=(Map<String,Integer>)session.getAttribute("cart");
		//2.遍历map
		if(map!=null){
			for(String key:map.keySet()){
				int value=map.get(key);
				//key：商品名称   value：商品个数
				//<h3>名称：iphone7 数量：7
	%>
				<h3>名称: <%=key %>     数量：<%=value %></h3>  <br/>
	<% 
			}
		}
	%>
	<a href="clearCartServlet">清空购物车</a>
</body>
</html>


















































