package com.small.servlet;

import com.small.dao.BookDao;
import com.small.vo.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author small
 */
@WebServlet(name = "InitServlet",urlPatterns = "/init")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        BookDao bookDao = new BookDao();
        HashMap<String, Book> allbook = null;
        try {
            allbook = bookDao.getAllBook();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        req.getSession().setAttribute("allbook",allbook);
        resp.sendRedirect("/servlet06/showAllBook.jsp");
    }

}
