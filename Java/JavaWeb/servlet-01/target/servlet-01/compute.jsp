<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<jsp:useBean id="calculater" scope="request" class="com.small.Compute" />
<jsp:setProperty name="calculater" property="*" />
<form action="compute.jsp" method="get">
    <hr align="left" style="width: 400px;">
    计算结果是：
    <span>
            <%
                if(request.getParameter("operator") != null){
                    String operator = request.getParameter("operator");
                    int oper = Integer.parseInt(operator);
                    if(oper == 4 && calculater.getNum2() == 0){
                        out.print("出错，除数不能为零！");
                    }else{
            %>
                <%=calculater.getNum1()%>
                <%

                    if(oper == 1) out.print("+");
                    if(oper == 2) out.print("-");
                    if(oper == 3) out.print("*");
                    if(oper == 4) out.print("/");

                %>
                <%=calculater.getNum2()%>
                =
                <%=calculater.getResult()%>
            <%
                    }
                }
            %>

        </span>
    <!-- 表达式显示 -->
    <hr align="left" style="width: 400px;">
    <div align="left" style="width: 400px;">

        <p align="center">简单计算器</p>

        第一个参数：<input type="text" name="num1" /><br>
        <div style="padding-left: 100px;">
            <select name="operator">
                <option value="1">+</option>
                <option value="2">-</option>
                <option value="3">*</option>
                <option value="4">/</option>
            </select>
        </div>

        第二个参数：<input type="text" name="num2" /><br>
        <input type="submit" value="计算" style="margin-left: 100px;" />
    </div>
</form>
</body>
</html>
