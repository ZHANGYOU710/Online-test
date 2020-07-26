<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html> 
<head>
   <meta charset="utf-8">
   <title>学生信息管理-添加</title>
 
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
   <script type="text/javascript">
    function add() {
	  var student_num=document.getElementById("student_num").value;

	  if(null==student_num || student_num==''){
		  alert("请输入学号");
		  return;
	  }
	  var form=document.getElementById("addform");
	  form.submit();
}
</script>
</head>
<body>
<div class="x-body">
    <form action="studentinfo.do" method="post" id="addform">
    <!-- hidden 页面看不见，可以传数据 -->
	<input type="hidden" name="action" value="add"/>
	 	 
            <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>学号</label>
                    <div class="layui-input-inline">
                        <input type="text" id="student_num" name="student_num"  class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>姓名</label>
                    <div class="layui-input-inline">
                        <input type="text"  name="student_name" class="layui-input">
                    </div> 
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        <span class="x-red">*</span>密码
                    </label>
                    <div class="layui-input-inline">
                        <input type="password" id="L_pass" name="student_password" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">6到16个字符 </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>手机号</label>
                    <div class="layui-input-inline">
                        <input type="text" id="username" name="student_phone"  class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>省份</label>
                    <div class="layui-input-inline">
                        <select name="student_province">
                              <option value ="北京">北京</option>
                              <option value ="天津">天津</option>
                              <option value="河北">河北</option>
                              <option value="黑龙江">黑龙江</option>
                              <option value="吉林">吉林</option>
                              <option value="辽宁">辽宁</option>
                              <option value="山西">山西</option>
                              <option value="内蒙古">内蒙古</option>
                              <option value="陕西">陕西</option>
                              <option value="河南">河南</option>
                              <option value="云南">云南</option>
                              <option value="广西">广西</option>
                              <option value="广东">广东</option>
                              <option value="福建">福建</option>
                              <option value="安徽">安徽</option>
                              <option value="江苏">江苏</option>
                              <option value="重庆">重庆</option>
                              <option value="四川">四川</option>
                              <option value="澳门">澳门</option>
                              <option value="香港">香港</option>
                              <option value="台湾">台湾</option>
                              <option value="山东">山东</option>
                              <option value="湖南">湖南</option>
                              <option value="湖北">湖北</option>
                              <option value="甘肃">甘肃</option>
                              <option value="西藏">西藏</option>
                              <option value="宁夏">宁夏</option>
                              <option value="新疆">新疆</option>
                              <option value="青海">青海</option>
                        </select>
                    </div>
                </div>
         <div class="layui-form-item">
                    <label class="layui-form-label"><span class="x-red">*</span>性别</label>
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <input type="radio" name="student_gender" value="0" checked title="男">男
                            <input type="radio" name="student_gender" value="1" title="女">女
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>专业</label>
                    <div class="layui-input-inline">
                    <select name="major_info_id">
                    <c:forEach items="${major_list}" var="major">
                    <option value="${major.id}">${major.majorName}</option>
                    </c:forEach></select>
                    </div>
                </div>
               
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label"></label>
                    <button type="button" class="layui-btn" onclick="javascript:add()">增加 </button>
                </div>
            </form>
        </div>
        <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8">
        </script>
    </body>

</html>