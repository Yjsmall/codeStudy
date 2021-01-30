<%--
  Created by IntelliJ IDEA.
  User: small
  Date: 2020/11/28
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="login_result.jsp" method="post">
        账号：<input name="account" type="text"><br>
        密码：<input name="password" type="text"><br>
        爱好:
        <label>唱<input name="hobby" type="checkbox" value="sing"></label>
        <label>跳<input name="hobby" type="checkbox" value="dance"></label>
        <label>rap<input name="hobby" type="checkbox" value="rap"></label>
        <label>篮球<input name="hobby" type="checkbox" value="basketball"></label>
        <br><input type="submit" value="登陆">
    </form>

</body>
</html>
