package com.myloverqian.db;

import com.myloverqian.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzw on 2016/1/19.
 */
public class DgSysDb extends BasicDb {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    /**
     * 获取导管室，涉及得而tablename
     *
     * @return
     * @throws SQLException
     */
    public List<String> getTableName() throws SQLException {
        List<String> list = new ArrayList<>();
        String sql = "select distinct(t.tablename) as tablename " +
                "from dwp.dc_sendresultreport t " +
                "where t.sysname='dgSys'";
        connection = getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String tableName = resultSet.getString("tablename");
            list.add(tableName);
        }
        closeConnection(statement, resultSet);
        return list;
    }

}
