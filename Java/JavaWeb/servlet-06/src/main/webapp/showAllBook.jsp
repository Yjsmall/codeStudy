<%--
  Created by IntelliJ IDEA.
  User: small
  Date: 2020/11/29
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.small.vo.Book" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
<h2>欢迎选购图书</h2><br>
<%
    if (session.getAttribute("allbook") != null){
        HashMap<String,Book> allbook = (HashMap<String, Book>) session.getAttribute("allbook");
%>
<table border="2">
    <tr style="background: pink">
        <td>书本名称</td>
        <td>书本价格</td>
        <td>购买</td>
    </tr>
    <%
        Set<String> set = allbook.keySet();
        for (String bookno : set) {
            Book book = allbook.get(bookno);
    %>
    <tr style="background: yellow">
        <td><%=book.getBookname()%>
        </td>
        <td><%=book.getBookprice()%>
        </td>
        <td><a href="buyform.jsp?bookno=<%=bookno%>">购买</a></td>
    </tr>
    <% } %>
    <%
        }
    %>
</table>
<a href="showCart.jsp">查看购物车</a>
</div>

</body>
</html>
