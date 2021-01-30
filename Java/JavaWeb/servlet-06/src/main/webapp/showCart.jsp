<%@ page import="java.util.HashMap" %>
<%@ page import="com.small.vo.Book" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <table border="1">
        <tr bgcolor="#ffc0cb">
            <td>书本名称</td>
            <td>书本价格</td>
            <td>数量</td>
            <td>删除</td>
        </tr>
        <%
            HashMap<String, Book> books = (HashMap<String, Book>) session.getAttribute("books");
            Set<String> set = books.keySet();
            for (String bookno : set) {
                Book book = (Book) books.get(bookno);
        %>

        <tr>
            <td><%=book.getBookname()%></td>
            <td><%=book.getBookprice()%></td>
            <td><%=book.getBooknumber()%></td>
            <td><a href="${pageContext.request.contextPath}/removeServlet?bookno=<%=book.getBookno()%>">删除</a> </td>
        </tr>
        <%
            }
        %>
    </table>
    现金总额：<%=session.getAttribute("money")%><hr>
    <a href="showAllBook.jsp">继续购书</a>
</div>

</body>
</html>
