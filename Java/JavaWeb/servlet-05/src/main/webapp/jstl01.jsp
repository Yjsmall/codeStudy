<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: small
  Date: 2020/11/28
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.setAttribute("score",5);
%>
<%--流程控制--%>
<c:if test="${score>=60}">及格</c:if>
<c:if test="${score<60}">不及格</c:if>

<c:choose>
    <c:when test="${score>=60}">及格</c:when>
    <c:when test="${score<60}">no及格</c:when>
</c:choose>

<%
    ArrayList<Object> al = new ArrayList<>();
    al.add("abc");
    al.add("def");
    session.setAttribute("character",al);
%>
<c:forEach items="${character}" var="c">
   <br> ${c}
</c:forEach>

</body>
</html>
