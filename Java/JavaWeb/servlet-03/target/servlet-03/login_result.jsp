<%--
  Created by IntelliJ IDEA.
  User: small
  Date: 2020/11/28
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String[] hobbies = request.getParameterValues("hobby");
        out.println("爱好为:");
    %>

    <%
        for (String hobby : hobbies){
    %>
    <br><%=hobby%>
    <%}%>

</body>
</html>
