<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/14
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>$Title$</title>
  </head>
  <body>
  <form action="airportList" method="get">
起飞机场:
    <select name="takeid">
      <option value="0">全部起飞机场</option>
      <c:forEach items="${airportList}" var="airport">
        <option value="${airport.id}">${airport.portName}</option>
      </c:forEach>
    </select>
降落机场:
    <select name="landid">
      <option value="0">全部降落机场</option>
      <c:forEach items="${airportList}" var="airport">
        <option value="${airport.id}">${airport.portName}</option>
      </c:forEach>
    </select>
<input type="submit" value="查询"/>
  </form>
  <table border="1">
      <tr>
          <td>飞机编号</td>
          <td>起飞机场</td>
          <td>起飞城市</td>
          <td>降落机场</td>
          <td>降落城市</td>
          <td>航行时间</td>
          <td>票价(元)</td>
      </tr>
      <c:forEach items="${airplaneList}" var="airplane">
          <tr>
              <td>${airplane.airno}</td>
              <td>${airplane.takePort.portName}</td>
              <td>${airplane.takePort.cityName}</td>
              <td>${airplane.landPort.portName}</td>
              <td>${airplane.landPort.cityName}</td>
              <td>
                  <c:if test="${airplane.time/60>0}">
                      <fmt:formatNumber value="${airplane.time/60 }" pattern="0"></fmt:formatNumber>小时
                  </c:if>
                  <c:if test="${ airplane.time%60>0}">
                      ${ airplane.time%60}分钟
                  </c:if>
              </td>
              <td>${airplane.price}</td>
          </tr>
      </c:forEach>
  </table>
  </body>
</html>
