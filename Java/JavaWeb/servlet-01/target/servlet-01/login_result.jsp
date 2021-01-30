<%--
  Created by IntelliJ IDEA.
  User: small
  Date: 2020/11/9
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String pwd = request.getParameter("pwd");

    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length;) {
        if (cookies[i].getName().equals(name) && cookies[i+1].getName().equals(pwd)){
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        }
        i+=2;
    }
    request.getRequestDispatcher("/error.jsp").forward(request,response);
%>

</body>
</html>
