<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生个人中心</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
</head>
<body>

	<div class="x-body">
	${tip_info }
		<div class="layui-form-item">
			<label for="link" class="layui-form-label">学号</label>
			<div class="layui-input-inline layui-input">${student_info.studentNum}</div>
		</div>
		<div class="layui-form-item">
			<label for="link" class="layui-form-label">姓名</label>
			<div class="layui-input-inline layui-input">
				${student_info.studentName}</div>
		</div>
		<div class="layui-form-item">
			<label for="link" class="layui-form-label">性别</label>
			<div class="layui-input-inline layui-input">

				<c:if test="${student_info.studentGender eq 0}">男</c:if>
				<c:if test="${student_info.studentGender eq 1}">女</c:if>
			</div>
		</div>
		<div class="layui-form-item">
			<label for="link" class="layui-form-label">学院</label>
			<div class="layui-input-inline layui-input">
			${academyInfo.academyName}
			</div>
		</div>
		<div class="layui-form-item">
			<label for="link" class="layui-form-label">专业</label>
			<div class="layui-input-inline layui-input">
			${majorInfo.majorName}
			</div>
		</div>
		<div class="layui-form-item">
			<label for="link" class="layui-form-label">省份</label>
			<div class="layui-input-inline layui-input">
				${student_info.studentProvince}</div>
		</div>
		<div class="layui-form-item">
			<label for="link" class="layui-form-label">联系电话</label>
			<div class="layui-input-inline layui-input">
				${student_info.studentPhone}</div>
		</div>

	</div>
	<script src="${pageContext.request.contextPath}/lib/layui/layui.js"
		charset="utf-8">
		
	</script>
	<script src="${pageContext.request.contextPath}/js/x-layui.js"
		charset="utf-8">
		
	</script>
	<script>
		layui
				.use(
						[ 'form', 'layer', 'layedit' ],
						function() {
							$ = layui.jquery;
							var form = layui.form(), layer = layui.layer, layedit = layui.layedit;
						});
	</script>

</body>
</html>