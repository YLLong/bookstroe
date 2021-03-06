<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>top</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	background: #4682B4;
}

a {
	text-transform: none;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>

<body>
	<h1 style="text-align: center;">TARENA书店</h1>
	<div style="font-size: 10pt;">
		<c:choose>
			<c:when test="${empty user }">
				<a href="<c:url value='${request.contextPath }/login.jsp'/>" target="_parent">登录</a> |&nbsp;
				<a href="<c:url value='${request.contextPath }/regist.jsp'/>" target="_parent">注册</a>
			</c:when>
			<c:otherwise>
				您好：${user.username }&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="<c:url value='../cartServlet?method=myCart'/>" target="body">我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="<c:url value='../orderServlet?method=myOrder'/>" target="body">我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/logoutServlet;" target="_parent">退出</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
