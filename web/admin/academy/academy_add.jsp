<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学院信息-添加</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/x-admin.css" media="all" />
</head>

<body>
	<div class="x-body">
		<form action="academyinfo.do" method="post">
			<input type="hidden" name="action" value="add" />
			<div class="layui-form-item">
				<label for="L_username" class="layui-form-label"> <span
					class="x-red">*</span>学院名称
				</label>
				<div class="layui-input-inline">
					<input type="text" id="username" name="academy_name"
						class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>必填
				</div>
			</div>

			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"></label>
				<button class="layui-btn">添加</button>
			</div>
		</form>
	</div>
</body>

</html>