package com.small.servlet;

import com.small.vo.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author small
 */
@WebServlet(name = "removeServlet",urlPatterns = "/removeServlet")
public class RemoveServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String bookno = req.getParameter("bookno");

        HttpSession session = req.getSession();
        HashMap books = (HashMap) session.getAttribute("books");
        if (books != null){
            Book book = (Book) books.get(bookno);

            //总钱数减少
            double money = (double)session.getAttribute("money");
            money = money - ((double) (book.getBookprice()) * book.getBooknumber());
            session.setAttribute("money",money);

            //移除相应图书
            books.remove(bookno);
            resp.sendRedirect("/servlet06/showCart.jsp");
        }
    }
}
