package com.small.dao;

import com.small.beans.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author small
 */
public class UserDao {

    public ArrayList<User> query() throws Exception{
        ArrayList<User> users = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String name = "root";
        String pwd = "12345678";
        Class.forName("com.mysql.cj.Driver");
        Connection conn = DriverManager.getConnection(url, name, pwd);
        String sql = "SELECT * FROM tables";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()){
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            users.add(user);
        }
        rs.close();
        stat.close();
        conn.close();
        return users;
    }

    public static void main(String[] args) throws Exception {
        UserDao userDao = new UserDao();
        ArrayList<User> users = userDao.query();
        System.out.print(users.toString());
    }
}
