package com.small.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author small
 */
@WebServlet(name = "helloServlet",urlPatterns = "/servlet")
public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("连接成功Tomcat");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.getOutputStream().write(("<h1>hello servlet</h1>").getBytes());
        res.getOutputStream().close();

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Tomcat关闭成功");

    }
}
