<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/3/31
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="get" action="demo7">
    姓名：<input type="text" name="peo[0].name">
    年龄：<input type="text" name="peo[0].age">
    年龄：<input type="text" name="peo[1].name">
    年龄：<input type="text" name="peo[1].age">
    爱好：<input type="checkbox" name="hover" value="学习">
    爱好：<input type="checkbox" name="hover" value="听歌">
    爱好：<input type="checkbox" name="hover" value="吃饭">
    爱好：<input type="checkbox" name="hover" value="打机">
    爱好：<input type="checkbox" name="hover" value="搭讪">
    <input type="submit" value="提交">
  </form>
  <a href="demo10/张三/12">跳转</a>
  </body>
</html>
