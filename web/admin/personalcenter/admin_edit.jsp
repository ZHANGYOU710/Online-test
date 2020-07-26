<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <title>管理员个人中心</title>
   
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
	<script type="text/javascript">
   function modify() {
	  var admin_name=document.getElementById("admin_name").value;
	  if(null==admin_name || admin_name==''){
		  alert("请输入名称");
		  return;
	  }
	  var form=document.getElementById("modifyform");
	  form.submit();
  }
</script>
</head>
<body>
	<div class="x-body">
	<form action="admininfo.do" id="modifyform" method="post">
        <input type="hidden" name="action" value="update"/>
		<input type="hidden" name="id" value="${admin_info.id}"/>
        <div class="layui-form-item">
        	<label for="link" class="layui-form-label">名称</label>
            	<div class="layui-input-inline">
                	<input type="text" id="admin_name" name="admin_name" class="layui-input" 
                        value="${admin_info.adminName}">
                    </div>
                </div>
         <div class="layui-form-item">
         	<label for="link" class="layui-form-label">联系电话</label>
            	<div class="layui-input-inline">
                	<input type="text" id="admin_phone" name="admin_phone" class="layui-input"
                         value="${admin_info.adminPhone}">
                    </div>
                </div>
                
         <div class="layui-form-item">
         <label for="link" class="layui-form-label">&nbsp;</label>
             	<button type="button" class="layui-btn" key="set-mine" onclick="javascript:modify()"> 提交</button>
                </div>
          </form>
    </div>
    <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8">
        </script>
    <script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8">
        </script>
    <script>
            layui.use(['form','layer','layedit'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer
              ,layedit = layui.layedit;
            });
        </script>
</body>
</html>