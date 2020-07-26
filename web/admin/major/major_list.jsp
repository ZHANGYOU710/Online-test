<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>专业信息管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pag.css" media="all">  
 <script type="text/javascript">
    function del(id){
	if(confirm("您确定要删除吗?")){
		var visitPath="majorinfo.do?action=delete&id="+id;
	    location.href=visitPath
	}
} 
</script>
</head>
<body>
		
        <div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>专业信息管理</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
        </div>
	<div class="x-body">
	<div class="tools">
	${tip_info }
   		<ul class="toolbar">
        <li><span><img src="${pageContext.request.contextPath}/images/t03.png" /></span>批量删除</li>
        <li onclick="user_management_add('添加专业信息','majorinfo.do?action=enter_add','600','500')"><span><img src="${pageContext.request.contextPath}/images/t01.png" /></span>添加</li>
      </ul>  
   </div>
            <table class="tablelist">
                <thead>
                    <tr>
                        <th>编号</th>
                        <th>专业名称</th>
                        <th>学院名称</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${page_vo.list}" var="major" varStatus="i">
                    <tr>
                     <td class="td-manage">${i.count}</td>
					 <td class="center">${major.majorName}</td>
					 <td class="center">${major.academyInfo.academyName}</td>
                     <td class="td-manage">
                        <a title="编辑" href="#" onclick="user_management_add('修改专业信息','majorinfo.do?action=enter_update&id=${major.id}','600','500')"
                            class="ml-5" style="text-decoration:none">
                                <i class="layui-icon">&#xe642;</i>
                            </a>
                            <a title="删除" href="#" onclick="del('${major.id}')" 
                                     style="text-decoration:none">
                                <i class="layui-icon">&#xe640;</i>
                            </a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
   <div class="turnPage center fr">
	       <span style="margin-right:20px;">共${page_vo.recordCount}条记录,当前第${page_vo.page }页,共${page_vo.pageCount}页  </span> 
	   <a href="majorinfo.do?action=search&page=1">首页</a>
	   <c:if test="${page_vo.page gt 1 }">
	   <a href="majorinfo.do?action=search&page=${page_vo.page-1}">上一页</a>
	   </c:if>
	   <c:if test="${page_vo.page le 1 }">
	   <a href="#">上一页</a>
	   </c:if>
	   <c:if test="${page_vo.page lt page_vo.pageCount }">
	   <a href="majorinfo.do?action=search&page=${page_vo.page+1}">下一页</a>
	   </c:if>
	    <c:if test="${page_vo.page ge page_vo.pageCount }">
	   <a href="#">下一页</a>
	   </c:if>
	
	   <a href="majorinfo.do?action=search&page=${page_vo.pageCount}">尾页</a>
	   
</div>
</div>
<br/>
<br/>
<br/>
        <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
        <script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script> 
<script src="${pageContext.request.contextPath}/js/jquery2.js" charset="utf-8"></script> 
<script src="${pageContext.request.contextPath}/js/js.js" charset="utf-8"></script>
        <script>
            layui.use(['laydate','element','laypage','layer'], function(){
                $ = layui.jquery;//jquery
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层

            });

             /*用户-添加*/
            function user_management_add(title,url,w,h){
                x_admin_show(title,url,w,h);
            }
            /*用户-查看*/
            function user_management_show(title,url,id,w,h){
                x_admin_show(title,url,w,h);
            }
            // 用户-编辑
            function user_management_edit (title,url,id,w,h) {
                x_admin_show(title,url,w,h); 
            }
            /*密码-修改*/
            function user_management_password(title,url,id,w,h){
                x_admin_show(title,url,w,h);  
            }
           
	$('.tablelist tbody tr:odd').addClass('odd');
            </script>
    </body>
</html>