<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <link rel="stylesheet" href="css/style.css"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>注册</title>
</head>
<div class="register-container">
    <h1>注册</h1>

    <div class="connect">
        <p>${messages1 }</p>
    </div>
    <form method="post" id="registerForm">
        <div><input type="text" name="id" placeholder="请填写你的邮箱账号"></div>
        <div><input type="text" name="name" placeholder="请填写你的昵称"></div>
        <div><input type="password" name="password" placeholder="请填写你的密码"></div>
        <div><input type="password" name="password1" placeholder="请再次填写你的密码"></div>
        <!--<div><input type="text" name="checkcode" placeholder="请输入下图中的计算结果"></div>
<div><img  src="gercheckcodeservlet"></div>-->
        <button id="submit" type="submit" onclick="javascript:this.form.action='register'" ;>注 册</button>
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