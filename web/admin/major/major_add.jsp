<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>  
<head>
    <meta charset="utf-8">
    <title>专业信息-添加 </title>
  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all" />
    <script type="text/javascript">
    function add() {
	  var major_name=document.getElementById("major_name").value;

	  if(null==major_name || major_name==''){
		  alert("请输入专业名称");
		  return;
	  }
	  var form=document.getElementById("addform");
	  form.submit();
}
</script>
</head>
<body>
     <div class="x-body">
         <form action="majorinfo.do" id="addform" method="post">
    	 <!-- hidden 页面看不见，可以传数据 -->
	 	 <input type="hidden" name="action" value="add"/>
           
                
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>专业名称</label>
                    <div class="layui-input-inline">
                        <input type="text" id="username" name="major_name"  class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>学院名称</label>
                    <select name="academy_id">
                    <c:forEach items="${academy_list}" var="academy">
                    <option value="${academy.id}">${academy.academyName}</option>
                    </c:forEach></select>
                    
                </div>
               
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label"></label>
                    <button  class="layui-btn" onclick="javascript:add()">添加 </button>
                </div>
            </form>
        </div>
        <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8">
        </script>
    </body>
</html>