<%@ page contentType="text/html;charset=UTF-8" import="com.small.vo.Book" %>
<%@ page import="java.util.HashMap" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String bookno = request.getParameter("bookno");
    HashMap<String,Book> allbook = (HashMap<String, Book>) session.getAttribute("allbook");
    Book book = allbook.get(bookno);
%>
<div align="center">
欢迎购买:<%=book.getBookname()%>
<form action="${pageContext.request.contextPath}/addServlet" method="post">
    书本价格：<%=book.getBookprice()%>
    <label><input name="bookno" type="hidden" value="<%=book.getBookno()%>"></label>
    <label><input name="bookname" type="hidden" value="<%=book.getBookname()%>"></label>
    <label><input name="bookprice" type="hidden" value="<%=book.getBookprice()%>"></label>
    <label>数量：<input name="booknumber" type="text"></label>
    <label><input type="submit" value="购买"></label>
</form>
</div>

</body>
</html>
