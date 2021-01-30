<%--
  Created by IntelliJ IDEA.
  User: small
  Date: 2020/11/28
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //获取welcome的number参数
        String str = request.getParameter("number");
        int number = Integer.parseInt(str);
    %>
    <h1 style="align-content: center">立方：<%=number*number*number%></h1>

</body>
</html>
