<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1">
    <title>欢迎大家</title>
    <link href="static/kisson.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div id="loader">
    <figure><img src="./static/avatar.jpg"></figure>
</div>
<main>
    <div class="content">
        <span id="hitokoto">Loading...</span>
        <section id="main">
            <a href="login.jsp"><i class="fa fa-sign-in"></i><span class="title">登录</span></a>
            <a href="register.jsp"><i class="fa fa-pencil"></i><span class="title">注册</span></a>
        </section>
    </div>
</main>
<footer><p>© 2018 <a href="http://blog.kisson.wang">blog.kisson.wang</a></p></footer>
<script src="static/kisson.js"></script>
<script src="https://v1.hitokoto.cn/?encode=js&select=%23hitokoto" defer></script>
</body>
</html>
