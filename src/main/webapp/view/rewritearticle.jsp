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
    <title>修改文章</title>
</head>
<body>
<center>
    <%Article article = (Article) request.getAttribute("article"); %>
    <p><%out.println(article.getApk().getTitle()); %><br><br>
    <form action="rewritearticle" method="post">
        <!-- 加载编辑器的容器 -->
        <script id="container" name="content" type="text/plain">
			<%out.println(article.content);%>









        </script>
        <input type="hidden" name="cid" value=<%=article.cid %>>
        <input type="radio" name="privatesee" value="1">设置为仅自己可见 &nbsp;<input type="radio" name="privatesee" value="0"
                                                                              checked>设置为所有人可见<br>
        <input type="submit" value="提交文章">
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
            autoClearinitialContent: false,
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