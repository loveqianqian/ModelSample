package com.myloverqian.db;

import com.myloverqian.bean.Template;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static com.myloverqian.util.DBUtils.closeConnection;
import static com.myloverqian.util.DBUtils.getConnection;

/**
 * Created by dzw on 2016/1/18.
 */
public class CommonDb {

    public static void commonDbTemplated(Connection connection, Statement statement, ResultSet resultSet, String sql, List<Template> templateList)
            throws Exception {
        connection = getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Template template = new Template();
            template.setId(resultSet.getString(0));
            template.setStatus(resultSet.getString(1));
            template.setStatusCount(resultSet.getString(2));
            templateList.add(template);
        }
        closeConnection(connection, statement, resultSet);
    }
}
