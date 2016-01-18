package com.myloverqian.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by dzw on 2016/1/15.
 */
public class DBUtils {
    private static String url = null;
    private static String driver = null;
    private static String username = null;
    private static String password = null;

    static Connection conn = null;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(System.getProperty(Constant.USER_DIR) + Constant.LAST_OF_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (properties != null) {
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        }
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet)
            throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        System.out.println(property);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        System.out.println(driver);
    }

}
