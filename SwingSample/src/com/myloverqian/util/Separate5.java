package com.myloverqian.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhiwei on 2015/12/27.
 */
public class Separate5 {

    private static String url = "jdbc:oracle:thin:@192.168.200.1:1521/hisoracle";
    private static String username = "mid";
    private static String password = "manager";


    public String methodSelf(int count, String path) throws Exception {
        StringBuffer sb = new StringBuffer();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            String sql = "select s.billing_indicator,s.* from LAB_TEST_MASTER s where s.test_no = ?";
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        File file = new File(path);
        File[] list = file.listFiles();
        count = 0;
        Set<String> charge = new HashSet<String>();
        Map<String, String> map = new HashMap<String, String>();
        for (File tf : list) {
            FileInputStream fis = new FileInputStream(tf);
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.contains("GatherServiceImpl.java:1378")) {
                    String lis = line.substring(104, 114);
                    String res = line.substring(line.length() - 2);
                    String olRes = map.get(lis);
                    if (!"00".equals(olRes)) {
                        map.put(lis, res);
                    }
                    count++;
                }
            }
            if (fis != null) {
                fis.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (br != null) {
                br.close();
            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals("02")) {
                try {
                    pstmt.setString(1, entry.getKey());
                    rs = pstmt.executeQuery();
                    rs.next();
                    if (rs.getString("billing_indicator") == null) {
                        sb.append(entry.getKey() + "\n");
                        charge.add(entry.getKey());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        sb.append(charge.size() + "\n");
        return sb.toString();
    }
}
