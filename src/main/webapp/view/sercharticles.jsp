<%@page import="java.util.List" %>
<%@page import="com.wang.model.Article" %>
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
    <title>搜索结果</title>
</head>
<body>
<%--<canvas class='background' height='2000px' width='2000px'> </canvas>--%>
<div style="position:fixed; width:100%; height:100%; z-index:-1; left:0; top:0;">
    <img src="../img/bg.jpg" height="100%" width="100%" style="left:0; top:0;">
</div>
<center>
    <p>以下是搜索结果<br><br>
            <%!int i=1; %>
            <%List<Article> articles=(List<Article>)request.getAttribute("articles");%>
            <%if(articles.isEmpty()||articles==null){%>
        <font color="red"><%out.println("暂时还没有相关的文章哦！");%></font>
            <% }else{%>
            <%for(Article article:articles){%>
            <% if(article.privatesee==0){%>
        <font color="red"><%out.println("第" + i + "篇");%></font><br>
        <font color="red">标题:</font><% out.println(article.getApk().getTitle()+"  ");%>
        <font color="red">最后修改时间:</font><% out.println(article.time+"  ");%>
        <font color="red">作者的昵称:<a
                href="serchuser?id=<%=article.getApk().getId()%>"></font><%out.println(article.name+"  ");%></a>
    <form action="articleandmessage" method="get">
        <input type="hidden" name="cid" value=<%=article.cid %>>
        <input type="submit" value="点击查看此篇文章">
    </form>
    <br><br>
    <%i++; %>
    <% }%>
    <%}%>
    <%i = 1; %>
    <%}%>
</center>
<script src="../js/jquery-1.11.1.min.js"></script>
</body>
</html>