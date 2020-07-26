<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>班级信息管理-编辑</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/x-admin.css" media="all" />
<script type="text/javascript">
	function modify() {
		var class_name = document.getElementById("class_name").value;

		if (null == class_name || class_name == '') {
			alert("请输入班级名称");
			return;
		}
		var form = document.getElementById("modifyform");
		form.submit();
	}
</script>
</head>
<body>
	<div class="x-body">
		<form action="classinfo.do" id="modifyform" method="post">
			<input type="hidden" name="action" value="update" /> <input
				type="hidden" name="id" value="${class_info.id}" />
			<div class="layui-form-item">
				<label class="layui-form-label">班级名称</label>
				<div class="layui-input-inline">
					<input type="text" name="class_name" id="class_name"
						value="${class_info.className}" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">必填</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">分班规则之最高分</label>
				<div class="layui-input-inline">
					<input type="text" name="max_score" id="max_score"
						value="${class_info.maxScore}" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">必填</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">分班规则之最低分</label>
				<div class="layui-input-inline">
					<input type="text" name="min_score" id="min_score"
						value="${class_info.minScore}" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">必填</div>
			</div>
			<div class="layui-form-item">
				<label for="L_sign" class="layui-form-label"> </label>
				<button class="layui-btn" key="set-mine"
					onclick="javascript:modify()">提交</button>
			</div>
		</form>
	</div>
	<script src="${pageContext.request.contextPath}/lib/layui/layui.js"
		charset="utf-8">
		
	</script>
	<script src="${pageContext.request.contextPath}/js/x-layui.js"
		charset="utf-8">
		
	</script>
	<script>
		layui.use([ 'form', 'layer' ], function() {
			$ = layui.jquery;
			var form = layui.form(), layer = layui.layer;

		});
	</script>
</body>
</html>