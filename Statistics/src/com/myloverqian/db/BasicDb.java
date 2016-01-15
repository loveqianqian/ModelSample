package com.myloverqian.db;

import java.sql.*;

/**
 * Created by dzw on 2016/1/15.
 */
public class BasicDb {
    private static String url = "jdbc:oracle:thin:@192.168.200.36:meddoc";
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String username = "meddoc";
    private static String password = "meddoc";

    static Connection conn = null;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        return null;
    }

    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
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

}
