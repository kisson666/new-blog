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
    <title>写新文章</title>
</head>
<body>
<form action="addarticle" method="post">
    <center><p>请输入文章的标题:<input type="text" name="title" style="height:51px;width:350px; font-size:30px;"></p>
        <!-- 加载编辑器的容器 -->
        <script id="container" name="content" type="text/plain"></script>
        <input type="radio" name="privatesee" value="1">仅自己可见&nbsp;<input type="radio" name="privatesee" value="0"
                                                                          checked>所有人可见<br><input type="submit"
                                                                                                  value="提交文章"
                                                                                                  style="font-size:25px">
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