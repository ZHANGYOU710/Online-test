<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>佑佑学习网提供技术支持</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>

<body id="bg">
	<!-- 左边节点 -->
	<div class="container">

		<div class="leftsidebar_box">
			<a href="main.jsp" target="main">
            <div class="line">
		    <img class="icon1" src="images/coin01.png" />
            <img class="icon2" src="images/coin02.png" />&nbsp;&nbsp;首页
			</div>
            </a>
            
           
        <c:if test="${not empty login_admin}">
             <!--管理员模块-->
            <dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin09.png" />
                    <img class="icon2" src="images/coin10.png" />
                     基础数据管理
                    <img class="icon3" src="images/coin19.png" />
                    <img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a href="admin/academy/academyinfo.do?action=findAll" target="main" class="cks">学院信息管理</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a href="admin/major/majorinfo.do?action=search&page=1" target="main" class="cks">专业信息管理</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a class="cks" href="admin/class/classinfo.do?action=findAll" target="main">班级信息管理</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a href="admin/paper/paperinfo.do?action=search&page=1" target="main" class="cks">试题信息管理</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
				<!-- <dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a href="admin/option/optioninfo.do?action=search&page=1" target="main" class="cks">选项信息管理</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd> -->
				<dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a href="admin/student/studentinfo.do?action=search&page=1" target="main" class="cks">学生信息管理</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
				
			</dl>
			
			
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin05.png" />
                    <img class="icon2" src="images/coin06.png" />
                     数据统计
                     <img class="icon3" src="images/coin19.png" />
                     <img class="icon4" src="images/coin20.png" />
				</dt>
                <dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a class="cks" href="admin/total/score_chart.jsp" target="main">总体成绩统计</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
                <dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a class="cks" href="admin/total/area_chart.jsp" target="main">地区成绩统计</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
				 <dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a href="admin/total/class_chart.jsp" target="main" class="cks">分班情况统计</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
			</dl>
			</c:if>
			<c:if test="${not empty login_student}">
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin03.png" />
                    <img class="icon2" src="images/coin04.png" />
                     个人中心
                     <img class="icon3" src="images/coin19.png" />
                     <img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a href="student/personalcenter/manage.do?action=detail" target="main" class="cks">查看个人信息</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
                <dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a href="student/personalcenter/manage.do?action=enter_update" target="main" class="cks">修改个人信息</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
                <dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a href="student/personalcenter/manage.do?action=enterModifyPassword" target="main" class="cks">修改密码</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin05.png" />
                    <img class="icon2" src="images/coin06.png" />
                     信息管理
                     <img class="icon3" src="images/coin19.png" />
                     <img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a class="cks" href="student/queryinfo.do" target="main">信息查询</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
			</dl>
			</c:if>
            <c:if test="${not empty login_admin}">
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin03.png" />
                    <img class="icon2" src="images/coin04.png" />
                     个人中心
                     <img class="icon3" src="images/coin19.png" />
                     <img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a href="admin/personalcenter/admininfo.do?action=detail" target="main" class="cks">查看个人信息</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
                <dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a href="admin/personalcenter/admininfo.do?action=enter_update" target="main" class="cks">修改个人信息</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
                <dd>
					<img class="coin11" src="images/coin111.png" />
                    <img class="coin22" src="images/coin222.png" />
                    <a href="admin/personalcenter/admininfo.do?action=enterModifyPassword" target="main" class="cks">修改密码</a>
                    <img class="icon5" src="images/coin21.png" />
				</dd>
			</dl>
		  </c:if>
		</div>

	</div>
</body>
</html>
