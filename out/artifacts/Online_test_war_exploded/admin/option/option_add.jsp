<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加选项</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
</head>
<body>
	<div class="x-body">
		<form action="optioninfo.do" method="post">
			<!-- hidden 页面看不见，可以传数据 -->
			<input type="hidden" name="action" value="add" />
			<div class="layui-form-item">
				<label class="layui-form-label"> <span class="x-red">*</span>题号
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_pass" name="question_num_id"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>选项
				</label>
				<div class="layui-input-inline">
					<input type="text" name="option_type" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>必填
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>选项内容
				</label>
				<div class="layui-input-inline">
					<input type="text" name="option_content" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>必填
				</div>
			</div>


			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn">添加</button>
			</div>

		</form>

	</div>
	<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8">
		
	</script>
	<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8">
		
	</script>
</body>

</html>