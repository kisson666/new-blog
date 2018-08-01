<%@page import="java.util.List" %>
<%@page import="com.wang.model.Message" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css">
        /*img {     */
        /*border:0;     */
        /*margin:0;     */
        /*padding:0;     */
        /*max-width:500px;     */
        /*width:expression(this.width>500?"500px":this.width);     */
        /*max-height:500px;     */
        /*height:expression(this.height>500?"  500px":this.height);     */
        /*}    */
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>我写的所有留言</title>
</head>
<body>
<div style="position:fixed; width:100%; height:100%; z-index:-1; left:0; top:0;">
    <img src="../img/bg.jpg" height="100%" width="100%" style="left:0; top:0;">
</div>
<center>
    <%List<Message> messages = (List<Message>) request.getAttribute("messages"); %>
    <%!long i = 1; %>
    <%if (messages.isEmpty()) { %>
    <font color="red"><%out.println("你暂时还没有给任何文章留过言");%></font><br>
    <%} else { %>
    <% for (Message message : messages) {%>
    <br><br>
    <font color="red"><%out.println("第" + i + "条  ");%></font><br>
    <font color="red">留言内容:</font><%out.println(message.content + "  ");%><br>
    <font color="red">留言时间:</font><%out.println(message.time + "  ");%><br>
    <font color="red">这条留言所在的文章:</font><%out.println(message.articletitle + "  ");%><br>
    <font color="red">文章作者的昵称:</font><a href="serchuser?id=<%=message.articleauthorid%>"><%
    out.println(message.articleauthorname + "  ");%></a>
    <form action="myblogdeletemessage">
        <input type="hidden" name="mid" value="<%=message.mid%>">
        <input type="submit" value="删除这条留言" onclick='return confirm("真的要删除这条留言吗？")'>
    </form>
    <form action="articleandmessage">
        <input type="hidden" name="cid" value="<%=message.cid%>">
        <input type="submit" value="查看这篇文章">
    </form>
    <br><br>
    <%i++;%>
    <% }%>
    <%i = 1; %>
    <%} %>
</center>
</body>
</html>