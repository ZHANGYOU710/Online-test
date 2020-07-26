<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理员个人中心</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
</head>
<body>

		<div class="x-body">
			${tip_info}
			<div class="layui-form-item">
				<label for="link" class="layui-form-label ">名称</label>
				<div class="layui-input-inline layui-input">${admin_info.adminName}
				</div>
			</div>
			<div class="layui-form-item">
				<label for="link" class="layui-form-label ">联系电话</label>
				<div class="layui-input-inline layui-input">${admin_info.adminPhone}
				</div>
			</div>

	</div>
	<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8">
		
	</script>
	<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8">
		
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