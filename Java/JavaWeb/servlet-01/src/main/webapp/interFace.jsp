<%@ page contentType="text/html;charset=gb2312"%>
<html>
<head>
    <!-- �Ե����ݽ����ж� -->
    <script language="javascript">
        function formcheck(){
            if(form1.num1.value==""||form1.num2.value=="")
            {
                window.alert("����Ϊ�գ�");
                return false;
            }
            else if(Math.round(form1.num1.value)!=form1.num1.value||Math.round(form1.num2.value)!=form1.num2.value){
                window.alert("ֻ���������֣�");
                return false;
            }
            else if(form1.flag.options(3).value=="/"&&form1.num2.value==0){
                window.alert("0������Ϊ������");
                return false;
            }
        }
    </script>
</head>
<body>
<%
        //��������
        String flag=request.getParameter("flag");
        String num1=request.getParameter("num1");
        String num2=request.getParameter("num2");
        int mynum1=0,mynum2=0, result=0;
//Ϊ�˷�ֹ�����쳣�����յ���ֵΪnull������������д���
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

<!-- JSP�������Ľ��� -->
<h1>JSP������</h1>
<hr>
<form name="form1">
    ���������֣�<input type="text" name="num1" value="<%=mynum1 %>"><br>
    <select name="flag">
        <option value="+" selected>+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select><br>
    ���������֣�<input type="text" name="num2" value="<%=mynum2 %>"><br>
    <input type="submit" value="����" ��nclick="return formcheck();">
</form>
<hr>
<h3>����Ľ��Ϊ</h3><br>
<%=result %>
<hr>
</body>
</html>