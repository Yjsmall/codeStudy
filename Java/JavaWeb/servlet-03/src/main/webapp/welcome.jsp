<%--
  Created by IntelliJ IDEA.
  User: small
  Date: 2020/11/28
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <!--    这是html注释,在源代码中显示-->
    <script type="text/javascript">
        document.write("欢迎来到本系统");
    </script>

    <!--Java代码和网页代码可以混一起
    html的welcome
    Java的welcome
    -->
    <br>
    <%
        //这是Java注释，客户端查看源代码不显示
        out.print("welcome");
    %>

    <%
        //这个标签里面显示的是Java中的各种定义
        String name = "Java";
        String msg = "欢迎";
    %>
    <br>
    <%=
        //则里面显示Java定义中的值,没有分号
        name + "," + msg
    %>

    <%
        for (int i = 0; i < 10; i++) {
    %>
        <%= i%>:欢迎（这是HTML格式）<br>
    <%
        }
    %>

    <% out.print(str); %>
    <%! String str = "全部变量"; %>

    <%
        String nu = "12";
        int number = Integer.parseInt(nu);
    %>

    这个数字的平方为：<%= number*number %><hr>
    <a href="welcome2.jsp?number=<%=number%>">跳转并且传入number</a>


</body>
</html>
