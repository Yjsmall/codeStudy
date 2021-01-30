package com.small.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author small
 */
@WebServlet("/toLogin")
public class LoginCookieServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String cookieName="userName";
        String cookiePwd="pwd";
        String userName="";
        String pwd="";
        String isChceked="";

        Cookie[] cookies=request.getCookies();
        if(cookies!=null)
        {
            isChceked="checked";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    userName = cookie.getValue();
                }
                if (cookie.getName().equals(cookiePwd)) {
                    pwd = cookie.getValue();
                }
            }
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head><title>登录</title></head>");
        out.println("<body>");
        out.print("<div align='center'>");
        out.print("<form action='doLogin'"+"method='post'>");
        out.print("姓名:<input type='text'"+" name='userName' value='"+userName+"'><br/>");
        out.print("密码:<input type='password'"+" name='pwd' value='"+pwd+"'><br/>");
        out.print("保存用户名和密码<input type='checkbox'"+"name='SaveCookie' value='yes'"+isChceked+"><br/>");
        out.print("<input type='submit'"+"value='提交'");
        out.print("</div>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}

