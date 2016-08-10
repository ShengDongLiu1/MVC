<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=path %>/css/main.css" />
<title>Insert title here</title>
</head>
<body>
	<div id="content">
		登入失败，账号或密码输入错误。<br />
		请<a href="<%=path %>/admin/admin">重新登入</a>
		<%
			response.setHeader("refresh", "5;URL="+path+"/admin/index");
		%>
	</div>
</body>
</html>