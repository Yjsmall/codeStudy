package com.small.util;

import java.sql.*;

/**
 * @author small
 */
public class DBUtil {
        private static final String MY_URL = "jdbc:mysql://localhost:3306/Tables?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        private static final String USER_NAME = "root";
        private static final String USER_PWD = "12345678";

        private static Connection conn = null;


        static {
                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection(MY_URL, USER_NAME, USER_PWD);
                } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                }
        }

        public static Connection getConnection(){
                return conn;
        }


}


