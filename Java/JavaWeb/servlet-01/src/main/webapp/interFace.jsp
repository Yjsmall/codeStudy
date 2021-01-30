<%@ page contentType="text/html;charset=gb2312"%>
<html>
<head>
    <!-- 对的数据进行判断 -->
    <script language="javascript">
        function formcheck(){
            if(form1.num1.value==""||form1.num2.value=="")
            {
                window.alert("不能为空！");
                return false;
            }
            else if(Math.round(form1.num1.value)!=form1.num1.value||Math.round(form1.num2.value)!=form1.num2.value){
                window.alert("只能输入数字！");
                return false;
            }
            else if(form1.flag.options(3).value=="/"&&form1.num2.value==0){
                window.alert("0不能作为除数！");
                return false;
            }
        }
    </script>
</head>
<body>
<%
        //接收运算
        String flag=request.getParameter("flag");
        String num1=request.getParameter("num1");
        String num2=request.getParameter("num2");
        int mynum1=0,mynum2=0, result=0;
//为了防止出现异常（接收到的值为null），在这里进行处理。
        if(num1!=null&&num2!=null&&flag!=null){
            mynum1=Integer.parseInt(num1);
            mynum2=Integer.parseInt(num2);
            if(flag.equals("+"))
            {
                result=mynum1+mynum2;
            }
            else if(flag.equals("-"))
            {
                result=mynum1-mynum2;
            }else if(flag.equals("*"))
            {
                result=mynum1*mynum2;
            }else{
                result=mynum1/mynum2;}
        }
%>

<!-- JSP计算器的界面 -->
<h1>JSP计算器</h1>
<hr>
<form name="form1">
    请输入数字：<input type="text" name="num1" value="<%=mynum1 %>"><br>
    <select name="flag">
        <option value="+" selected>+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select><br>
    请输入数字：<input type="text" name="num2" value="<%=mynum2 %>"><br>
    <input type="submit" value="计算" οnclick="return formcheck();">
</form>
<hr>
<h3>运算的结果为</h3><br>
<%=result %>
<hr>
</body>
</html>