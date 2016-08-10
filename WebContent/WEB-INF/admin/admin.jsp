<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>/css/main.css" />
</head>
<body>
	<div id="content">
		<a href="<%=path %>/product/all">查看所有商品</a>
		<a href="<%=path %>/product/add_product">添加商品</a>
	</div>
</body>
</html>