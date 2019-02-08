<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/2/4
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>转账账号</th>
        <th>收款账号</th>
        <th>转账金额</th>
        <th>转账日期</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="log">
        <tr>
            <td>${log.accout}</td>
            <td>${log.accin}</td>
            <td>${log.money}</td>
            <td>${log.date.toLocaleString()}</td>
        </tr>
    </c:forEach>
</table>
<a href="show?pageSize=${pageInfo.pageSize}&pageNumber=${pageInfo.pageNumber-1}" <c:if test="${pageInfo.pageNumber<=1}"> onclick="javascript:return false" </c:if>>上一页</a>
<a href="show?pageSize=${pageInfo.pageSize}&pageNumber=${pageInfo.pageNumber+1}" <c:if test="${pageInfo.pageNumber>=pageInfo.total}"> onclick="javascript:return false" </c:if>>下一页</a>
</body>
</html>
