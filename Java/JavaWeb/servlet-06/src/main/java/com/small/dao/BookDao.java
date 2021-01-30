package com.small.dao;

import com.small.vo.Book;

import java.sql.*;
import java.util.HashMap;

/**
 * @author small
 */
public class BookDao {
    public BookDao(){}
    private Connection conn = null;
    private ResultSet rs = null;

    public HashMap<String,Book> getAllBook() throws Exception {
        HashMap<String, Book> hm = new HashMap<String, Book>(20);

        this.initConnection();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM books";

        rs = stmt.executeQuery(sql);

        while (rs.next()){
            Book book = new Book();
            book.setBookno(rs.getString("bookno"));
            book.setBookname(rs.getString("bookname"));
            book.setBookprice(rs.getFloat("bookprice"));
            hm.put(book.getBookno(),book);
        }
        this.closeConnection();
        return hm;
    }

    public void initConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String myUrl = "jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String userName = "root";
        String userPwd = "12345678";
        conn = DriverManager.getConnection(myUrl,userName,userPwd);
    }
    
    public void closeConnection() throws Exception {
        conn.close();
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "conn=" + conn +
                '}';
    }

    public static void main(String[] args) throws Exception {
        BookDao bookDao = new BookDao();
        HashMap<String, Book> allBook = bookDao.getAllBook();
        System.out.println(allBook.toString());
    }
}
