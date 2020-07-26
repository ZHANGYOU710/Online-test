<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>操作结果页</title>
	<link rel="shortcut icon" href="http://www.uu710.cn/PC-images/佑佑学习网_站标.ico" type="image/x-icon"/>
</head>

<body>
	${tip_info }
	<a href="#" onclick="javascript:parent.location.reload()">返回</a>
</body>
</html>
