package com.small.servlet;

import com.small.vo.Book;

import javax.servlet.ServletException;
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
@WebServlet(name = "AddServlet",urlPatterns = "/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        HashMap<String,Book> books = (HashMap<String, Book>)session.getAttribute("books");

        //获得提交内容
        String bookno = req.getParameter("bookno");
        String bookname = req.getParameter("bookname");
        String strBookprice = req.getParameter("bookprice");
        String strBooknumber = req.getParameter("booknumber");

        //存入购物车
        Book book = new Book();
        book.setBookno(bookno);
        book.setBookname(bookname);
        float price = Float.parseFloat(strBookprice);
        book.setBookprice(price);
        int booknumber = Integer.parseInt(strBooknumber);
        book.setBooknumber(booknumber);

        books.put(bookno,book);

        //总金额

        double money = (Double) session.getAttribute("money");
        money = money + price*booknumber;
        session.setAttribute("money",money);
        resp.sendRedirect("/servlet06/showCart.jsp");

    }
}


