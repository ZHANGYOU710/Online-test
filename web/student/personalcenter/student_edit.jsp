<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <title>学生个人中心</title>
   
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
	<script type="text/javascript">
   function submit_modify() {
	  var form=document.getElementById("modifyform");
	  form.submit();
  }
</script>
</head>
<body>
	<form action="manage.do" id="modifyform" method="post">
        <input type="hidden" name="action" value="update"/>
	<div class="x-body">
   	<div class="layui-form-item">
        	<label for="link" class="layui-form-label">学号</label>
            	<div class="layui-input-inline">
                	<input type="text" id="link" name="student_num" class="layui-input" 
                        value="${student_info.studentNum}">
                    </div>
                </div>
        <div class="layui-form-item">
        	<label for="link" class="layui-form-label">姓名</label>
            	<div class="layui-input-inline">
                	<input type="text" id="link" name="student_name" class="layui-input" 
                        value="${student_info.studentName}">
                    </div>
                </div>
         <div class="layui-form-item">
        	<label for="link" class="layui-form-label">性别</label>
            	<div class="layui-input-inline">
                	 <input type="radio" name="student_gender" value="0" 
                	 <c:if test="${student_info.studentGender eq 0}">checked="checked"</c:if>
                	 />&nbsp;男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                	  <input type="radio" name="student_gender" value="1" 
                	  <c:if test="${student_info.studentGender eq 1}">checked="checked"</c:if>
                	  />&nbsp;女
                	 
                
                    </div>
                </div>
         <div class="layui-form-item">
			<label for="link" class="layui-form-label">学院</label>
			<div class="layui-input-inline layui-input">
			${academyInfo.academyName}
			</div>
		</div>
			<div class="layui-form-item">
				<label for="link" class="layui-form-label">专业</label>
				<div class="layui-input-inline layui-input">
					${majorInfo.majorName}</div>
			</div>
			<div class="layui-form-item">
        	<label for="link" class="layui-form-label">省份</label>
            	<div class="layui-input-inline">
                	 <select name="student_province">
                              <option value ="北京" 
                               <c:if test="${student_info.studentProvince eq '北京'}">selected="selected"</c:if>
                              >北京</option>
                              <option value ="天津" 
                              <c:if test="${student_info.studentProvince eq '天津'}">selected="selected"</c:if>
                              >天津</option>
                              <option value="河北" 
                              <c:if test="${student_info.studentProvince eq '河北'}">selected="selected"</c:if>
                              >河北</option>
                              <option value="黑龙江" 
                              <c:if test="${student_info.studentProvince eq '黑龙江'}">selected="selected"</c:if>
                              >黑龙江</option>
                              <option value="吉林" 
                              <c:if test="${student_info.studentProvince eq '吉林'}">selected="selected"</c:if>
                              >吉林</option>
                              <option value="辽宁" 
                              <c:if test="${student_info.studentProvince eq '辽宁'}">selected="selected"</c:if>
                              >辽宁</option>
                              <option value="山西" 
                              <c:if test="${student_info.studentProvince eq '山西'}">selected="selected"</c:if>
                              >山西</option>
                              <option value="内蒙古" 
                              <c:if test="${student_info.studentProvince eq '内蒙古'}">selected="selected"</c:if>
                              >内蒙古</option>
                              <option value="陕西" 
                              <c:if test="${student_info.studentProvince eq '陕西'}">selected="selected"</c:if>
                              >陕西</option>
                              <option value="河南" 
                              <c:if test="${student_info.studentProvince eq '河南'}">selected="selected"</c:if>
                              >河南</option>
                              <option value="云南" 
                              <c:if test="${student_info.studentProvince eq '云南'}">selected="selected"</c:if>
                              >云南</option>
                              <option value="广西" 
                              <c:if test="${student_info.studentProvince eq '广西'}">selected="selected"</c:if>
                              >广西</option>
                              <option value="广东" 
                              <c:if test="${student_info.studentProvince eq '广东'}">selected="selected"</c:if>
                              >广东</option>
                              <option value="福建" 
                              <c:if test="${student_info.studentProvince eq '福建'}">selected="selected"</c:if>
                              >福建</option>
                              <option value="安徽" 
                              <c:if test="${student_info.studentProvince eq '安徽'}">selected="selected"</c:if>
                              >安徽</option>
                              <option value="江苏" 
                              <c:if test="${student_info.studentProvince eq '江苏'}">selected="selected"</c:if>
                              >江苏</option>
                              <option value="重庆" 
                              <c:if test="${student_info.studentProvince eq '重庆'}">selected="selected"</c:if>
                              >重庆</option>
                              <option value="四川" 
                              <c:if test="${student_info.studentProvince eq '四川'}">selected="selected"</c:if>
                              >四川</option>
                              <option value="澳门" 
                              <c:if test="${student_info.studentProvince eq '澳门'}">selected="selected"</c:if>
                              >澳门</option>
                              <option value="香港" 
                              <c:if test="${student_info.studentProvince eq '香港'}">selected="selected"</c:if>
                              >香港</option>
                              <option value="台湾" 
                              <c:if test="${student_info.studentProvince eq '台湾'}">selected="selected"</c:if>
                              >台湾</option>
                              <option value="山东" 
                              <c:if test="${student_info.studentProvince eq '山东'}">selected="selected"</c:if>
                              >山东</option>
                              <option value="湖南" 
                              <c:if test="${student_info.studentProvince eq '湖南'}">selected="selected"</c:if>
                              >湖南</option>
                              <option value="湖北" 
                              <c:if test="${student_info.studentProvince eq '湖北'}">selected="selected"</c:if>
                              >湖北</option>
                              <option value="甘肃" 
                              <c:if test="${student_info.studentProvince eq '甘肃'}">selected="selected"</c:if>
                              >甘肃</option>
                              <option value="西藏" 
                              <c:if test="${student_info.studentProvince eq '西藏'}">selected="selected"</c:if>
                              >西藏</option>
                              <option value="宁夏" 
                              <c:if test="${student_info.studentProvince eq '宁夏'}">selected="selected"</c:if>
                              >宁夏</option>
                              <option value="新疆" 
                              <c:if test="${student_info.studentProvince eq '新疆'}">selected="selected"</c:if>
                              >新疆</option>
                              <option value="青海" 
                              <c:if test="${student_info.studentProvince eq '青海'}">selected="selected"</c:if>
                              >青海</option>
                        </select>
                    </div>
                </div>      
         <div class="layui-form-item">
         	<label for="link" class="layui-form-label">联系电话</label>
            	<div class="layui-input-inline">
                	<input type="text" id="link" name="student_phone" class="layui-input"
                         value="${student_info.studentPhone}">
                    </div>
                </div>
            <div class="layui-form-item">
         <label for="link" class="layui-form-label">&nbsp;</label>
             	<button type="button" class="layui-btn" key="set-mine" onclick="javascript:submit_modify()"> 提交</button>
                </div>
          
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
        </form>
</body>
</html>