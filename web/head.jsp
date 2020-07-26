<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>佑佑学习网提供技术支持</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
<script type="text/javascript" src="js/external.js"></script>
 <script type="text/javascript">
 function adminlogout() {
		parent.location.href="adminlogout.do";
	}
 function studentlogout() {
		parent.location.href="studentlogout.do";
	}
</script>
</head>
<body>
	<!-- 头部 -->
	<div class="head">
		<div class="headL">
<%--			<img class="headLogo" src="images/banner88.png"/>--%>
		</div>
		<div class="headR">
		 <c:if test="${not empty login_admin }">
    <a href="javascript:adminlogout();"><span>退出</span></a>
    </c:if>
    <c:if test="${not empty login_student }">
    <a href="javascript:studentlogout();"><span>退出</span></a>
    </c:if>
		</div>
	</div>
   
    
    
    <div class="user">
    <span>
     <c:if test="${not empty login_admin }">
     欢迎您：${login_admin.adminName }！
     </c:if>
    <c:if test="${not empty login_student }">
    欢迎您： ${login_student.studentName }！
    </c:if>
    </span>
    </div> 
    
     
</body>
</html>