<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/1/29
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>查询人数</title>
  </head>
  <body>
  <table>
  <tr>
    <th>编号</th>
    <th>姓名</th>
    <th>年龄</th>
  </tr>
    <c:forEach items="${list }" var="peo">
      <tr>
        <td>${peo.id }</td>
        <td>${peo.name }</td>
        <td>${peo.age }</td>
      </tr>


    </c:forEach>
    </table>
  </body>
</html>
