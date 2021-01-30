<%@ page  contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login">
    用户名： <label>
    <input  type="text" name="user">
</label><br>
    密  码： <label>
    <input  type="password" name="pwd">
</label><br>
    爱好:
    <label>
        <input name="hobby" type="checkbox" value="sing">唱歌
        <input name="hobby" type="checkbox" value="dance">跳舞
        <input name="hobby" type="checkbox" value="read">阅读<br>
    </label>

    记住我:
    <label>
        <input name="check" type="checkbox">
    </label><br>

    <input type="submit" value="登陆">
</form>

</body>
</html>