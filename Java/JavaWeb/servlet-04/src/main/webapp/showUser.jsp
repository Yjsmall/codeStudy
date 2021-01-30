<%--
  Created by IntelliJ IDEA.
  User: small
  Date: 2020/11/28
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.small.beans.User" %>
<%@page import="com.small.dao.UserDao" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    UserDao userDao = new UserDao();
    ArrayList<User> users = null;
    try {
        users = userDao.query();
    } catch (Exception exception) {
        exception.printStackTrace();
    }
%>
<table>
    <tr>
        <td>学号</td>
        <td>姓名</td>
    </tr>
    <%
        if (users != null){
            for (User user : users){
    %>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getName()%></td>
    </tr>
    <%
            }
        }
    %>

</table>

</body>
</html>
