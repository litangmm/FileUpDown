<%--
  Created by IntelliJ IDEA.
  User: LiTangMM
  Date: 2019/2/28
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="/DownLoad">download</a>
  <form action="/UpLoad" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" name="upload" value="上传文件">
  </form>
  <a href="/ReadFile">readfile</a>
  <a href="/WriteFile">writefile</a>
  $END$
  </body>
</html>
