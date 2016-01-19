package com.myloverqian.db;

import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dzw on 2016/1/19.
 */
public class DgSysDbTest {

    @Test
    public void testGetTableName() throws Exception {
        DgSysDb dgSysDb = new DgSysDb();
        List<String> list = new ArrayList<>();
        try {
            list = dgSysDb.getTableName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}