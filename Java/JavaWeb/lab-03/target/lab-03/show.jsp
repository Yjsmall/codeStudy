<%@ page import="com.small.bean.Word" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: small
  Date: 2020/12/4
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <%
    	List<Word> list=(List<Word>)session.getAttribute("wordlist"); //取出list
    	if(list==null) //说明还没有成语
	 	{
	 		response.sendRedirect("add.jsp");
	 	}else{
    %>

    <table border="2">
        <tr>
            <th>序号</th>
            <th>内容</th>
        </tr>

        <%
            for(int i=0;i<list.size();i++){
                Word word=list.get(i);
        %>

        <tr>
            <td><%=i+1 %></td>
            <td><%=word.getStr()%></td>
        </tr>

        <%}}%>

    </table>
    <a href="add.jsp"> 继续成语接龙</a> <br>
</div>

</body>
</html>
