package com.small.mysql;

import java.sql.*;

/**
 * @author small
 */
public class MysqlTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //mysql配置信息
        String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        String sql = "select * from Users";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet != null){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+ resultSet.getObject("name"));
            System.out.println("password="+resultSet.getObject("password"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birthday="+resultSet.getObject("birthday"));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
