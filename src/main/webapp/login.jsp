<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript">
        //用于刷新验证码  
        function myReload() {
            document.getElementById("checkcode").src = document.getElementById("checkcode").src + "?nocache=" + new Date().getTime();
        }
    </script>
    <title>先登陆吧</title>
</head>


<div class="login-container">
    <h1>登陆</h1>

    <div class="connect">
        <p>${messages }</p>
    </div>
    <form method="post" id="loginForm">
        <div><input type="text" name="id" placeholder="请输入你的ID" autocomplete="off"></div>
        <div><input type="password" name="password" placeholder="请输入你的密码" autocomplete="off"></div>
        <!--<div><input type="text" name="checkcode" placeholder="请输入下图中的计算结果"></div><br>
<div><img  src="gercheckcodeservlet" id="checkcode"></div><div><a href = "#" style = "font-size: 13px;margin-left: 5px;" onclick = "myReload()">看不清换一张</a></div><br>-->
        <button type="submit" id="submit" onclick="javascript:this.form.action='check'" ;>普通用户登录</button>
        <button type="submit" id="submit1" onclick="javascript:this.form.action='checkadministrator'" ;>管理员登录</button>
    </form>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js?var1.14.0"></script>
</body>
</html>