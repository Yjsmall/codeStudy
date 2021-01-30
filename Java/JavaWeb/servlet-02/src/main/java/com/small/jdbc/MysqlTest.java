package com.small.jdbc;

import java.sql.*;

/**
 * @author small
 */
public class MysqlTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String myUrl = "jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String userName = "root";
        String userPwd = "12345678";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(myUrl, userName, userPwd);

        Statement statement = connection.createStatement();
        String sql = "SELECT bookno,bookname,bookprice from books";
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()){
            // 通过字段检索
            String id  = rs.getString("bookno");
            String name = rs.getString("bookname");
            String url = rs.getString("bookprice");

            // 输出数据
            System.out.print("ID: " + id);
            System.out.print(", 站点名称: " + name);
            System.out.print(", 站点 URL: " + url);
            System.out.print("\n");
        }
        // 完成后关闭
        rs.close();
        statement.close();
        connection.close();

    }
}
