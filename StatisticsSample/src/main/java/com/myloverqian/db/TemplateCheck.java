package com.myloverqian.db;

import com.myloverqian.bean.Template;
import com.myloverqian.bean.TemplateSample;
import com.myloverqian.util.DBUtils;
import com.myloverqian.util.SqlConstant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzw on 2016/1/15.
 */
public class TemplateCheck extends DBUtils {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    /**
     * 基本模板情况
     * check_status,check_status,count(*)
     *
     * @return
     */
    public List<Template> getTemplateSample() {
        List<Template> templateList = new ArrayList<Template>();
        String sql = SqlConstant.TEMPLATED_STATUS_CHECK_SAMPLE;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Template template = new Template();
                template.setId(resultSet.getString("CHECK_STATUS"));
                template.setStatus(resultSet.getString("MY_CHECK_STATUS"));
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
     * 科室模板制作审核情况
     * dept_name,check_status,count(*)
     */
    public List<Template> getTemplateCheck() {
        List<Template> templateList = new ArrayList<Template>();
        String sql = SqlConstant.TEMPLATED_STATUS_CHECK;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Template template = new Template();
                template.setId(resultSet.getString("DEPT_NAME"));
                template.setStatus(resultSet.getString("CHECK_STATUS"));
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
     * 科室模板制作情况
     * dept_name,count(*)
     */
    public List<TemplateSample> getTemplateManufacture() {
        List<TemplateSample> templateList = new ArrayList<TemplateSample>();
        String sql = SqlConstant.TEMPLATED_STATUS_MANUFACTURE;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TemplateSample template = new TemplateSample();
                template.setDepatName(resultSet.getString("DEPT_NAME"));
                template.setCount(resultSet.getString("MY_COUNT"));
                templateList.add(template);
            }
            closeConnection(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return templateList;
    }

}
