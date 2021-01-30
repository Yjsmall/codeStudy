<%@ page import="com.small.bean.Word" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: small
  Date: 2020/12/4
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <%
        List<Word> list=(List<Word>)session.getAttribute("wordlist");
        if(list==null) //说明还没有成语
        {
            out.println("暂时没有成语，请进行输入四字成语：");
        }else{
            Word word=list.get(list.size()-1);
    %>
    上一个成语：<%=word.getStr()%><br>
    最后一个字：<%= word.getLast()%>
    <%
        }
    %>
    <form action="LinkServlet" method="get">
        <label>
            <input type="text" name=str style="height: 30px; ">
        </label>
        <input type="submit" value="接龙">
    </form>
</div>

</body>
</html>
