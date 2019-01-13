<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:set value="3" var="i" scope="page"/>
	<s:if test="#page.i>3">
		i 大于 3
	</s:if>
	<s:elseif test="#page.i<3">
		i 小于 3
	</s:elseif>
	<s:else>
		i 等于 3
	</s:else>
	
</body>
</html>