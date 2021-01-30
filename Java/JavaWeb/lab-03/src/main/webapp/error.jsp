<%--
  Created by IntelliJ IDEA.
  User: small
  Date: 2020/12/4
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <%  String a=request.getParameter("action");
        switch (a) {
            case "1":
                out.println("含有非汉字!");
                break;
            case "2":
                out.println("非四字成语!");
                break;
            case "3":
                out.println("接龙失败，换个词吧!");
                break;
        }
    %>
    <br>
    <a href="show.jsp"> 查看成语接龙</a> <br>
    <a href="add.jsp"> 继续成语接龙</a> <br>
</div>

</body>
</html>
