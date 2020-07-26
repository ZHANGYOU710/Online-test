<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎教师登录在线答题平台</title>
    <link rel="shortcut icon" href="http://www.uu710.cn/PC-images/佑佑学习网_站标.ico" type="image/x-icon"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery2.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>
    <script language="javascript" src="js/js.js"></script>
    <script type="text/javascript">
        function login(){
            var adminName= document.getElementById("admin_name").value;
            var adminPass= document.getElementById("admin_pass").value;

            if(adminName==''){
                alert("请输入用户名");
                return;
            }
            if(adminPass==''){
                alert("请输入密码");
                return;
            }
            document.getElementById("login_form").submit();
        }
    </script>
</head>
<body style="background-color:#1c77ac; background-image: url(images/light.png) background-repeat:no-repeat; background-position:center top; overflow:hidden;">

<form name="adminlogin" id="login_form" action="adminlogin.do" method="post">
    <div id="mainBody">
        <div id="cloud1" class="cloud"></div>
        <div id="cloud2" class="cloud"></div>
    </div>
    <div class="logintop"> <span>欢迎教师登录在线答题平台</span>
    </div>
    <div class="loginbody"> <span class="systemlogo"></span>
        <div class="loginbox">

            <ul>
                ${tip_info }
                <li>
                    <input id="admin_name" name="admin_name" type="text" class="loginuser" value="教工号" onclick="JavaScript:this.value=''"/>
                </li>
                <li>
                    <input id="admin_pass" name="admin_pass" type="password" class="loginpwd" value="" onclick="JavaScript:this.value=''"/>
                </li>
                <li>
                    <input name="" type="button" class="loginbtn" onclick="login()" value="登录"/>
                    <label><a href="index.jsp">返回</a></label>
                </li>
            </ul>
        </div>
    </div>
    <div class="loginbm">版权所有： 佑佑学习网  © Copyright 2019-2020</div>
</form>
</body>
</html>
