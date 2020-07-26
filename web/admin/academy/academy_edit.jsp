<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>学院信息管理-编辑</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
    <script type="text/javascript">
function modify() {
	  var academy_name=document.getElementById("academy_name").value;

	  if(null==academy_name || academy_name==''){
		  alert("请输入学院名称");
		  return;
	  }
	  
	  var form=document.getElementById("modifyform");
	  form.submit();
}
</script>
</head>
<body>
     <div class="x-body">
       <form action="academyinfo.do" id="modifyform" method="post">
         <input type="hidden" name="action" value="update"/>
		 <input type="hidden" name="id" value="${academy_info.id}"/>
            <div class="layui-form-item">
                 <label class="layui-form-label">学院名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="academy_name" id="academy_name" value="${academy_info.academyName}" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">必填</div>
                </div>
                
                <div class="layui-form-item">
                    <label for="L_sign" class="layui-form-label">
                    </label>
                    <button class="layui-btn" key="set-mine" onclick="javascript:modify()">提交</button>
                </div>
            </form>
        </div>
        <script src="./lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="./js/x-layui.js" charset="utf-8">
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