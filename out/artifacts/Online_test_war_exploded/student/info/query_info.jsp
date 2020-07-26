<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="swipebox.css">
</head>
<body>
	<p>
	<c:if test="${not empty totalScore }">
	您的成绩：${totalScore}
	</c:if>
	<c:if test="${empty totalScore }">
	您尚未答题，请先答题！
	</c:if>
	</p>
	<p>
	<c:if test="${not empty class_name }">
	您被成功分配到：${class_name}
	</c:if>
	</p>
	<p><c:if test="${not empty stu_info.recommendCourse }">
		为您推荐选修课：${stu_info.recommendCourse}
	</c:if></p>

</body>
</html>