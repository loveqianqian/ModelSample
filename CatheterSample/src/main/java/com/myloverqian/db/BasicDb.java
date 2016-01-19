package com.myloverqian.db;

import com.myloverqian.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by dzw on 2016/1/19.
 */
public class BasicDb {
    Connection connection = null;


    public Connection getConnection() throws SQLException {
        return connection = DBUtils.getConnection();
    }

    public void closeConnection(Statement statement, ResultSet resultSet) throws SQLException {
        DBUtils.closeConnection(connection, statement, resultSet);
    }

}
