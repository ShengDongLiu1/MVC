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
</head>
<body>
	<div id="content">
		添加商品失败，请<a href="<%=path %>/product/add_product">重新添加</a>
		<%
			response.setHeader("refresh", "5;URL="+path+"/product/add_product");
		%>
	</div>
</body>
</html>