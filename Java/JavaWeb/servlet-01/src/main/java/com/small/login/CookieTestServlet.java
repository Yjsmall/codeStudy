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
@WebServlet("/doLogin")
public class CookieTestServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Cookie userCookie = new Cookie("userName",
                request.getParameter("userName"));
        Cookie pwdCookie = new Cookie("pwd", request.getParameter("pwd"));
        if (null != request.getParameter("SaveCookie")
                && "yes".equals(request.getParameter("SaveCookie"))) {
            userCookie.setMaxAge(7*24 * 60 * 60);
            pwdCookie.setMaxAge(7*24 * 60 * 60);
        } else {
            userCookie.setMaxAge(0);
            pwdCookie.setMaxAge(0);
        }
        response.addCookie(userCookie);
        response.addCookie(pwdCookie);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head><title>login Servlet</title></head>");
        out.println("<body>");
        out.println("</body>");
        out.print("欢迎" + request.getParameter("userName") + "访问本网站!");
        out.println("</html>");
        out.flush();
        out.close();
    }

}

