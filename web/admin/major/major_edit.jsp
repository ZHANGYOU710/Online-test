<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>专业信息管理-编辑</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all" />
    <script type="text/javascript">
	function modify() {
	  var major_name=document.getElementById("major_name").value;

	  if(null==major_name || major_name==''){
		  alert("请输入专业名称");
		  return;
	  }
	  var form=document.getElementById("modifyform");
	  form.submit();
	}
</script>
</head> 
<body>
	<div class="x-body">
       <form action="majorinfo.do" id="modifyform" method="post">
         <input type="hidden" name="action" value="update"/>
		 <input type="hidden" name="id" value="${major_info.id}"/>
            <div class="layui-form-item">
                 <label class="layui-form-label">专业名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="major_name" id="major_name" value="${major_info.majorName}" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">必填</div>
                </div>
            <div class="layui-form-item">
                 <label for="L_username" class="layui-form-label">
                     <span class="x-red">*</span>学院名称</label>
                    <select name="academy_id">
                    <c:forEach items="${academy_list}" var="academy">
                    <option value="${academy.id}"
                    <c:if test="${academy.id eq major_info.academyInfoId }"> selected="selected" </c:if> 
                    >${academy.academyName}</option>
                    </c:forEach></select>
                </div>
                <div class="layui-form-item">
                    <label for="L_sign" class="layui-form-label">
                    </label>
                    <button class="layui-btn" key="set-mine" onclick="javascript:modify()">提交</button>
                </div>
            </form>
        </div>
        <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8">
        </script>
        <script>
            layui.use(['form','layer'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer;
            });
        </script>
    </body>

</html>