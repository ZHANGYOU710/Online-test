<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <title>修改密码</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
	<script type="text/javascript">
	function submit_modify(){
		var o_pass=document.getElementById("original_pass").value;
		var new_pass=document.getElementById("new_pass").value;
		var confirm_new_pass=document.getElementById("confirm_new_pass").value;
		if(null==o_pass || o_pass==''){
			alert("请输入原密码");
			return ;
		}
		if(null==new_pass || new_pass==''){
			alert("请输入新密码");
			return ;
		}
		if(null==confirm_new_pass || confirm_new_pass==''){
			alert("请输入确认密码");
			return;
		}
		if(new_pass!=confirm_new_pass){
			alert("两次输入新密码不一致，请重新输入");
			return;
		}
		document.getElementById("modifyform").submit();
		
	}
</script>
</head>

<body>
<div class="x-body">
	${tip_info }
	<form action="manage.do" id="modifyform" method="post">
        <input type="hidden" name="action" value="modifyPassword"/>

        <div class="layui-form-item">
        	<label for="link" class="layui-form-label">原密码</label>
            	<div class="layui-input-inline">
                	<input type="password" name="original_pass" id="original_pass"  class="layui-input" 
                       />
                    </div>
                </div>
         <div class="layui-form-item">
         	<label for="link" class="layui-form-label">新密码</label>
            	<div class="layui-input-inline">
                	<input  type="password" name="new_pass"  id="new_pass" class="layui-input"
                         value="${admin_info.adminPhone}">
                    </div>
                </div>
           <div class="layui-form-item">
         	<label for="link" class="layui-form-label">确认密码</label>
            	<div class="layui-input-inline">
                	<input type="password" name="confirm_new_pass" id="confirm_new_pass"  class="layui-input"
                         value="${admin_info.adminPhone}">
                    </div>
                </div>
                
         <div class="layui-form-item">
         <label for="link" class="layui-form-label">&nbsp;</label>
             	<button type="button" class="layui-btn" key="set-mine" onclick="javascript:submit_modify()"> 提交</button>
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
