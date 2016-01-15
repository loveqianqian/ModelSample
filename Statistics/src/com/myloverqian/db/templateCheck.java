package com.myloverqian.db;

import com.myloverqian.bean.Template;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzw on 2016/1/15.
 */
public class TemplateCheck extends BasicDb {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public List<Template> getTemplat() {
        List<Template> templateList = new ArrayList<Template>();

        String sql = "SELECT " +
                "T.CHECK_STATUS id, " +
                "(CASE T.CHECK_STATUS " +
                "   WHEN '0' THEN '未审核' " +
                "   WHEN '1'  THEN '有缺陷' " +
                "   WHEN '2' THEN '已确认' " +
                "   WHEN '3' THEN '已审核' " +
                "END)AS status ," +
                "COUNT(*) statusCount " +
                "FROM DOC_TEMPLET_T T " +
                "WHERE T.IS_VALID = '1' " +
                "AND T.IS_FOLDER <> '1' " +
                "GROUP BY T.CHECK_STATUS " +
                "ORDER BY t.check_status";
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("服务关闭");
        }
        return templateList;
    }
}
