<%@page import="java.util.List" %>
<%@page import="com.wang.model.Message" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css">
        img {
            border: 0;
            margin: 0;
            padding: 0;
            max-width: 500px;
            width: expression(this.width>500?"500px":this.width);
            max-height: 500px;
            height: expression(this.height>500?"  500px":this.height);
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>我的博客的内容</title>
</head>
<body>
<center>
    <font color="red">文章内容</font><br>
    <% out.println(request.getAttribute("content"));%>
    <br><br>
    <form action="getaarticleinarticle" method="post">
        <input type="hidden" name="cid" value=<%=request.getAttribute("cid") %>>
        <input type="submit" value="修改这篇文章">
    </form>
    <form action="myblogdeletearticle" method="post">
        <input type="hidden" name="cid" value=<%=request.getAttribute("cid") %>>
        <input type="submit" value="删除这篇文章" onclick='return confirm("真的要删除这篇文章吗？")'>
    </form>
    <br><br>
    <font color="red">以下是留言</font>&nbsp;&nbsp;<a href="#writemessage">点击给自己的文章留言</a><br>
    <br>
    <%List<Message> messages = (List<Message>) request.getAttribute("messages"); %>
    <%!long i = 1; %>
    <%if (messages.isEmpty()) { %>
    <font color="red"><%out.println("暂时还没有人留言，你自己来座沙发吧！");%></font><br>
    <%} else { %>
    <% for (Message message : messages) {%>
    <font color="red"><%out.println(i + "楼  ");%></font><br>
    <font color="red">留言内容:</font><%out.println(message.content + "  ");%><br>
    <font color="red">留言时间:</font><%out.println(message.time + "  ");%><br>
    <font color="red">楼主的昵称:</font><a href="serchuser?id=<%=message.id%>"><%out.println(message.name + "  ");%></a>
    <form action="myblogdeletemessage">
        <input type="hidden" name="mid" value="<%=message.mid%>">
        <input type="submit" value="删除这条留言" onclick='return confirm("真的要删除这条留言吗？")'>
    </form>
    <br><br>
    <%i++;%>
    <% }%>
    <%i = 1; %>
    <%} %>
    <br><br>
    <font color="red">给自己的文章留言</font><br>
    <a name="writemessage"></a>
    <form action="addmessage" method="post">
        <!-- 加载编辑器的容器 -->
        <script id="container" name="content" type="text/plain"></script>
        <input type="hidden" name="cid" value=<%=request.getAttribute("cid")%>>
        <input type="submit" value="提交留言">
    </form>
    <!-- 配置文件 -->
    <script type="text/javascript" src="../editor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="../editor/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('container', {
            //这里可以选择自己需要的工具按钮名称,此处仅选择如下五个  
            toolbars: [['emotion', 'simpleupload', 'music', 'insertvideo', 'forecolor', 'imagecenter', 'italic', 'underline', 'selectall', 'justifyleft', 'justifyright', 'justifycenter', 'justifyjustify', 'FullScreen']],
            //focus时自动清空初始化时的内容  
            autoClearinitialContent: true,
            //关闭字数统计  
            wordCount: false,
            //关闭elementPath  
            elementPathEnabled: false,
            //默认的编辑区域高度  
            initialFrameHeight: 300
            //更多其他参数，请参考ueditor.config.js中的配置项  
        });
    </script>
</center>
</body>
</html>