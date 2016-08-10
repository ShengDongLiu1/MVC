<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path%>/css/main.css" />
</head>
<body>
	<div id="all" style="width:600px;heigth:auto;margin:auto;" >
	<c:if test="${requestScope.products != null }">
		<c:forEach items="${products.getResultList() }" var="product" varStatus="status">
			<div style="float:left;width:200px;margin-top:10px;" >
				<img src="<%=path %>/uploads/${product.img }" style="width: 100px; height: 99px" />
				<p>商品名称：${product.name }</p>
				<p>商品价格：${product.price }</p>
				<p>商品介绍：${product.dec }</p>
				<a href="#">修改商品</a>
				<a href="<%=path %>/product/delete?id=${product.id }">删除商品</a>
			</div>
		</c:forEach>
		<p style="clear:both"></p>
		<div>
			<form action="all" method="post" >
				<a href="<%=path %>/product/all?pageNo=${requestScope.products.getPageNo() - 1 }">上一页</a>
				${requestScope.products.getPageNo() }/${requestScope.products.getTotalPage() }
				<input type="text" name="pageNo" size="1" value="0" />
				<input type="submit" value="跳转" />
				<a href="<%=path %>/product/all?pageNo=${requestScope.products.getPageNo() + 1 }">下一页</a>
			</form>
		</div>
		</c:if>
	</div>
</body>
</html>