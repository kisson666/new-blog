<%@ page import="com.wang.model.User" %>
<%@ page import="com.wang.model.Article" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>欢迎你，我的朋友</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
</head>
<body style="background-image: url('../img/bg.jpg'); padding-bottom: 50px">
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#our-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <%
                String counter = (String) application.getAttribute("counter");
                User user = (User) session.getAttribute("user");
            %>
            <%int n = Integer.valueOf(counter); %>
            <a class="navbar-brand" href="#">欢迎你, <strong>${user.name}</strong></a>
        </div>
        <div class="collapse navbar-collapse" id="our-navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="myblog.jsp">我的博客</a></li>
                <li><a href="privatemanagement.jsp">帐号管理</a></li>
                <li><a href="../logoff">注销登录</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container alert alert-info alert-dismissable text-center">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <%out.println("你是访问本网站的第" + n + "人次"); %>
</div>

<div class="container">
    <div class="row">
        <div class="col-xs-6">
            <form class="form-inline" action="sercharticles" method="GET" role="form">
                <div class="form-group">
                    <label for="search-title">搜索文章</label>
                    <input type="text" class="form-control" id="search-title" name="title" placeholder="输入关键字进行搜索">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
        </div>
        <div class="col-xs-6">
            <form class="form-inline" action="serchuser" method="GET" role="form">
                <div class="form-group">
                    <label for="search-user">搜索用户</label>
                    <input type="text" class="form-control" id="search-user" name="id" placeholder="输入用户ID查看TA的资料">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
        </div>
    </div>
</div>

<%if (session.getAttribute("isReadMessage") != null) {%>
<div class="container alert alert-danger alert-dismissable text-center">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <a href="isreadmessage?articleauthorid=<%=user.getId()%>">有新的留言，点击查看</a>
</div>
<%}%>

<div class="container text-center">
    <h2>近期文章</h2>
    <div class="row">
        <%!int i = 1; %>
        <%List<Article> articles = (List<Article>) session.getAttribute("recentArticles");%>
        <%for (Article article : articles) {%>
        <%--<% if(article.privatesee==0){%>--%>
        <div class="col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><%out.println("第" + i + "篇");%></h3>
                </div>
                <div class="panel-body">
                    <h4>
                        <span class="label label-info">标题: <% out.print(article.getApk().getTitle() + "");%></span>
                        <span class="label label-info">最后修改时间: <% out.print(article.time + "");%></span>
                        <span class="label label-info">作者的昵称: <a href="serchuser?id=<%=article.getApk().getId()%>">
                            <%out.print(article.name + "  ");%></a></span>
                    </h4>
                    <form action="articleandmessage" method="GET" role="form" style="padding: 10px">
                        <input type="hidden" name="cid" value=<%=article.cid %>>
                        <button type="submit" class="btn btn-default">点击查看此篇文章</button>
                    </form>
                </div>
            </div>
        </div>
        <br><br>
        <%i++; %>
        <%--<% }%>--%>
        <%}%>
        <%i = 1; %>
    </div>
</div>
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
