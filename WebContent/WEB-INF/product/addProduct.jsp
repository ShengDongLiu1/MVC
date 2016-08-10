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

	<div id="content" >
		<form action="add" method="post" enctype="multipart/form-data" >
			<input type="text" name="name" placeholder="产品名称" />
			<input type="text" name="dec" placeholder="产品简介" /><br />
			<input type="text" name="price" placeholder="产品价格"/>
			<input type="file" name="img" placeholder="上传图片" /><br />
			<input  type="submit" value="确认添加 " />
		</form>
	</div>
</body>
</html>