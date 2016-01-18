package com.myloverqian.db;

import com.myloverqian.bean.Template;
import com.myloverqian.util.SqlConstant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.myloverqian.util.DBUtils.closeConnection;
import static com.myloverqian.util.DBUtils.getConnection;

/**
 * Created by dzw on 2016/1/18.
 */
public class WriteStatus {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    /**
     * 科室书写情况
     * dept_name,creator_name,count(*)
     */
    public List<Template> sectionStatus() {
        List<Template> templateList = new ArrayList<Template>();
        String sql = SqlConstant.WRITE_STATUS_SECTION;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Template template = new Template();
                template.setId(resultSet.getString("DEPT_NAME"));
                template.setStatus(resultSet.getString("CREATOR_NAME"));
                template.setStatusCount(resultSet.getString("MY_COUNT"));
                templateList.add(template);
            }
            closeConnection(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return templateList;
    }

    /**
     * 患者书写情况
     * patient_name，dept_name,count(*)
     */
    public List<Template> patientStatus() {
        List<Template> templateList = new ArrayList<Template>();
        String sql = SqlConstant.WRITE_STATUS_PATIENT;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Template template = new Template();
                template.setId(resultSet.getString("PATIENT_NAME"));
                template.setStatus(resultSet.getString("DEPT_NAME"));
                template.setStatusCount(resultSet.getString("MY_COUNT"));
                templateList.add(template);
            }
            closeConnection(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return templateList;
    }

}
