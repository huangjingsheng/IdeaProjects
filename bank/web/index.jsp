<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/2/4
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="transfer" method="post">
    转账账户:<input type="text" name="accOutNo"><br/>
    账户密码:<input type="password" name="password"><br/>
    金额:<input type="text" name="outMoney"><br/>
    收款账户:<input type="text" name="accInNo"><br/>
    收款人名称:<input type="text" name="name"><br/>
  <input type="submit" value="提交"><br/>
  </form>
  </body>
</html>
