<%--
  Created by IntelliJ IDEA.
  User: small
  Date: 2020/11/28
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="com.small.beans.Student" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Student student = new Student();
    student.setStuNo("0001");
    student.setStuName("张三");
    session.setAttribute("stu",student);
%>
    学号：${stu.stuNo}<br>
    姓名：${stu.stuName}<br>

</body>
</html>
