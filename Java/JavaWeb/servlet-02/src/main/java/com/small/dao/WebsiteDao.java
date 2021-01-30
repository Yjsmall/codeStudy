package com.small.dao;

import com.small.model.Website;
import com.small.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author small
 */
public class WebsiteDao {
    public List<Website> query() throws SQLException{
        List<Website> websites = new ArrayList<>();

        Connection connection = DBUtil.getConnection();

        String sql;
        sql = "SELECT id,name,url FROM websites";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        Website website;

        while (rs.next()){
            website = new Website();
            website.setId(rs.getInt("id"));
            website.setName(rs.getString("name"));
            website.setName(rs.getString("url"));

            websites.add(website);

        }
        rs.close();
        statement.close();
        connection.close();

        return websites;
    }

    public static void main(String[] args) throws SQLException {
        List<Website> query = new WebsiteDao().query();
        System.out.println(Arrays.toString(query.toArray()));
    }
}
