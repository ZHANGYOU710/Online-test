<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>在线答题平台</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" media="all"/> 

<script type="text/javascript">
 function test(){
	window.open("student/exam.do?action=enter_exam");	
	}
 
 <c:if test="${not empty tip_info}">
 alert("${tip_info}");
 window.close();
 </c:if>
</script>
</head>
<body background="${pageContext.request.contextPath}/images/mainbg.jpg">
		<div class="clearfix" id="contentBox">
   <!-- <div id="first" class="buttonBox">
    <button style="color:#666; font-size:20px;">审核人员</button>
    <div class="border"></div>
    <div class="border"></div>
  </div>  -->

  <div id="first" class="buttonBox">
   <!-- <button style="color:#666; font-size:20px;" >测试结果 ${totalScore }</button>
    <div class="border" onclick="javascript:look();" ></div>
    <div class="border" onclick="javascript:look();" ></div> -->
  
    </div> 
 <c:if test="${not empty login_student }">
<div id="first" class="buttonBox">
    <button type="button" style="color:#666; font-size:20px;" onclick="javascript:test();" >点我测试</button>
    <div class="border" onclick="javascript:test();" ></div>
    <div class="border" onclick="javascript:test();" ></div> 
  </div>
 </c:if>
</div>
</body>
</html>