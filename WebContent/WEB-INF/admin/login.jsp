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
		<form action="admin/login" method="post">
			<input type="email" name="email" placeholder="管理员邮箱 " /> <br />
			<input type="password" name="password" placeholder="邮箱密码" /><br />
			<input type="submit" value="登录" />
		</form>
	</div>
</body>
</html>