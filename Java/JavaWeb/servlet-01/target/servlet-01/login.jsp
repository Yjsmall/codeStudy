<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login_result.jsp"  name="loginForm"  method="post">
    用户名：<input name="name" type="text" ><br>
    密  码：  <input name="pwd" type="password" ><br>
    性别:
    <select name="sex">
        <option value="man" aria-checked="true">男</option>
        <option value="woman">女</option>
    </select><br>
    爱好:
    <input name="hobby" type="checkbox" value="sing" checked>唱歌
    <input name="hobby" type="checkbox" value="dance">跳舞
    <input name="hobby" type="checkbox" value="read">阅读<br>
    记住我<input name="check" type="checkbox"><br>

    <input type="submit" value="登陆" >
</form>
<%
    String name = request.getParameter("name");
    String pwd = request.getParameter("pwd");

    Cookie name1 = new Cookie("userName",name);
    Cookie pwd1 = new Cookie("userPwd", pwd);
    if (request.getParameter("check") != null){
        name1.setMaxAge(2*7*24*60*60);
        pwd1.setMaxAge(2*7*24*60*60);
    } else {
        name1.setMaxAge(0);
        pwd1.setMaxAge(0);
    }
    response.addCookie(name1);
    response.addCookie(pwd1);
%>

</body>
</html>