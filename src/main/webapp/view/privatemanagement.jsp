<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>管理我的账号</title>
</head>
<body>
<div style="position:fixed; width:100%; height:100%; z-index:-1; left:0; top:0;">
    <img src="../img/bg.jpg" height="100%" width="100%" style="left:0; top:0;">
</div>
<center>
    <form action="changemydata.jsp" method="post">
        <input type="submit" value="修改我的个人资料">
    </form>
    <br><br>
    <form action="changepassword.jsp" method="post">
        <input type="submit" value="修改密码">
    </form>
    <br><br>
    <form action="deleteaccount.jsp" method="post">
        <input type="submit" value="删除这个账号">
    </form>
</center>
</body>
</html>