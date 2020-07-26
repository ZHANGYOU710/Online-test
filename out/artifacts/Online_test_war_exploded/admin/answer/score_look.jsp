<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>查看学生答题情况</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="./css/x-admin.css" media="all">
<link rel="stylesheet" href="css/pag.css" media="all">
</head>
<body>

	<div class="x-nav">
		<span class="layui-breadcrumb"></span>总分：<span id="score">0</span>
	</div>
	<div class="x-body">

		<table class="tablelist">
			<thead>
				<tr>
					<th>题号</th>
					<th>学生选项</th>
					<th>得分</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="total_score" value="0" />
				<c:forEach items="${student_answer}" var="answer">
					<tr>
						<td class="center">${answer.questionNumId}</td>
						<td class="center">${answer.answerType}</td>
						<td class="center">${answer.studentScore}</td>
						<c:set var="total_score"
							value="${total_score+answer.studentScore}" />
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br />
	<br />
	<br />
	<script src="./lib/layui/layui.js" charset="utf-8"></script>
	<script src="./js/x-layui.js" charset="utf-8"></script>
	<script src="js/jquery2.js" charset="utf-8"></script>
	<script src="js/js.js" charset="utf-8"></script>
	<script>
		document.getElementById("score").innerHTML = $
		{
			total_score
		};
		layui.use([ 'laydate', 'element', 'laypage', 'layer' ], function() {
			$ = layui.jquery;//jquery
			lement = layui.element();//面包导航
			laypage = layui.laypage;//分页
			layer = layui.layer;//弹出层

		});
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>