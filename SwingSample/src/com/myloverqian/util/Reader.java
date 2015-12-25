package com.myloverqian.util;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhiwei on 2015/12/23.
 */
public class Reader {

    @Test
    public void test1() throws Exception {
        File file = new File("/home/luoxiaoming/Downloads/logs");
        File[] list = file.listFiles();
        int count = 0;
        for (File tf : list) {
            FileInputStream fis = new FileInputStream(tf);
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            String[] arrs = null;
            while ((line = br.readLine()) != null) {
                if (line.contains("检查报告数据")) {
                    String msg = line.substring(line.indexOf("检查报告数据：") + "检查报告数据：".length());
                    if (line.contains("呈\"剑鞘\"状") || line.contains("度\"S\"形")) {
                        System.out.println(msg);
                        msg = msg.replace("呈\"剑鞘\"状", "呈(剑鞘)状");
                        msg = msg.replace("度\"S\"形", "度(S)形");
                    }
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = JSONObject.fromObject(msg);
                    } catch (Exception e) {
                        continue;
                    }
                    System.out.println(jsonObject);
//                    ClientFactoryBean bean = ClientFactoryBean.getFactoryBeanInstance();
//                    Client client = bean.getClient("hehe", "http://localhost:8080/GatherService/GatherService?wsdl");
//                    Object[] args = client.invoke("getPacsCDA",msg );
                    System.out.println(msg);
//                    System.out.println(args[0]);
                    count++;
                }

            }
            System.out.println("总数:" + count);
        }
    }

    @Test
    public void test3() throws Exception {
        File file = new File("/home/luoxiaoming/Downloads/temps");
        File[] list = file.listFiles();
        int count = 0;
        Set<String> reqs = new HashSet<String>();
        for (File tf : list) {
            FileInputStream fis = new FileInputStream(tf);
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.contains("\"OPERATOR\":\"7516\"") || line.contains("\"OPERATOR\":\"1179\"")) {
                    String req = line.substring(line.indexOf("\"REQNO\":\"") + "\"REQNO\":\"".length(), line.indexOf("\",\"CONFIRMTIME\""));
                    reqs.add(req);
                    count++;
                }

            }
        }
        for (String temp : reqs) {
            System.out.println(temp);
        }
        System.out.println(reqs.size());
    }

    @Test
    public void test4() throws Exception {
        File file = new File("/home/luoxiaoming/Downloads/temps");
        File[] list = file.listFiles();
        int count = 0;
//        Set<String> reqs = new HashSet<String>();
        Pattern pattern = Pattern.compile("//d{10}");
        Matcher matcher = null;
        for (File tf : list) {
            FileInputStream fis = new FileInputStream(tf);
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {

                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    //                    reqs.add(req);
                    System.out.println(line);
                    count++;
                }

            }
        }
    }

    @Test
    public void test5() throws Exception {
        File file = new File("/home/luoxiaoming/Downloads/t");
        File[] list = file.listFiles();
        int count = 0;
        Set<String> reqs = new HashSet<String>();
        for (File tf : list) {
            FileInputStream fis = new FileInputStream(tf);
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.contains("1512165944") && line.contains("GatherServiceImpl.java:1100")) {
//                    String req = line.substring(line.indexOf("\"REQNO\":\"")+"\"REQNO\":\"".length(),line.indexOf("\",\"CONFIRMTIME\""));
//                    reqs.add(req);
                    System.out.println(tf.getName());
                    System.out.println(line);
                    count++;
                }
            }
        }
        for (String temp : reqs) {
            System.out.println(temp);
        }
        System.out.println(reqs.size());
    }

    @Test
    public void test6() throws Exception {
        File file = new File("/home/luoxiaoming/Downloads/temps");
        File[] list = file.listFiles();
        int count = 0;
        Set<String> charge = new HashSet<String>();
        Set<String> error = new HashSet<String>();
        Map<String, String> map = new HashMap<String, String>();
        Set<String> msgs = new HashSet<String>();
        for (File tf : list) {
            FileInputStream fis = new FileInputStream(tf);
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.contains("GatherServiceImpl.java:1378")) {
//                    System.out.println(line);
                    String lis = line.substring(104, 114);
                    String res = line.substring(line.length() - 2);
                    String olRes = map.get(lis);
                    if (!"00".equals(olRes)) {
                        map.put(lis, res);
                    }
                    count++;
                }

            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals("02")) {
                System.out.println(entry.getKey());
                charge.add(entry.getKey());
            }
        }


        System.out.println(charge.size());

        Set<String> users = new HashSet<String>();
        for (File tf : list) {
            FileInputStream fis = new FileInputStream(tf);
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                for (String req : charge) {
                    if (line.contains(req) && line.contains("GatherServiceImpl.java:1298")) {
                        msgs.add(line.substring(111));
                        String user = line.substring(237, 241);
                        users.add(user);
                    }
                }
            }
        }

        for (String tempUser : users) {
            System.out.println(tempUser);
        }
        for (String msg :msgs){
            System.out.println(msg);
        }

    }


    @Test
    public void test61() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.200.1:1521/hisoracle","mid","manager");
        String sql="select s.billing_indicator,s.* from LAB_TEST_MASTER s where s.test_no = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = null;
        File file = new File("/home/luoxiaoming/Downloads/temps");
        File[] list = file.listFiles();
        int count = 0;
        Set<String> charge = new HashSet<String>();
        Set<String> error = new HashSet<String>();
        Map<String, String> map = new HashMap<String, String>();
        for (File tf : list) {
            FileInputStream fis = new FileInputStream(tf);
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.contains("GatherServiceImpl.java:1378")) {
//                    System.out.println(line);
                    String lis = line.substring(104, 114);
                    String res = line.substring(line.length() - 2);
                    String olRes = map.get(lis);
                    if (!"00".equals(olRes)) {
                        map.put(lis, res);
                    }
                    count++;
                }

            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals("02")) {
                pstmt.setString(1,entry.getKey());
                rs = pstmt.executeQuery();
                rs.next();
                if(rs.getString("billing_indicator")==null){
                    System.out.println(entry.getKey());
                    charge.add(entry.getKey());
                }
            }
        }
        System.out.println(charge.size());


    }

//    @Test
//    public void test62() throws Exception {
//        ClientFactoryBean bean = ClientFactoryBean.getFactoryBeanInstance();
//        Client client = bean.getClient("hehe", "http://192.168.200.23:8080/GatherService/GatherService?wsdl");
//        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.200.1:1521/hisoracle","mid","manager");
//        String sql="select s.billing_indicator,s.* from LAB_TEST_MASTER s where s.test_no = ? AND (s.requested_date_time>sysdate-2) AND (patient_id,visit_id) not IN (SELECT patient_id,visit_id FROM pats_in_hospital)";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        ResultSet rs = null;
//        File file = new File("/home/luoxiaoming/Downloads/temps");
//        File[] list = file.listFiles();
//        int count = 0;
//        Set<String> charge = new HashSet<String>();
//        Set<String> error = new HashSet<String>();
//        double sum = 0;
//        Map<String, String> map = new HashMap<String, String>();
//        List<List<Object>> datas = new ArrayList<List<Object>>();
//        for (File tf : list) {
//            FileInputStream fis = new FileInputStream(tf);
//            InputStreamReader isr = new InputStreamReader(fis, "GBK");
//            BufferedReader br = new BufferedReader(isr);
//            String line = "";
//            while ((line = br.readLine()) != null) {
//                if (line.contains("GatherServiceImpl.java:1378")) {
////                    System.out.println(line);
//                    String lis = line.substring(104, 114);
//                    String res = line.substring(line.length() - 2);
//                    String olRes = map.get(lis);
//                    if (!"00".equals(olRes)) {
//                        map.put(lis, res);
//                    }
//                    count++;
//                }
//            }
//        }
//
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            if (entry.getValue().equals("02")) {
//                pstmt.setString(1,entry.getKey());
//                rs = pstmt.executeQuery();
//                if(rs.next()){
//                    if(rs.getString("billing_indicator")==null){
//                        List<Object> data  = new ArrayList<Object>();
//                        data.add(rs.getString("test_no"));
//                        data.add(rs.getString("patient_id"));
//                        data.add(rs.getString("visit_id"));
//                        data.add(rs.getString("charges"));
//                        data.add(rs.getString("specimen"));
//                        data.add(rs.getString("name"));
//                        System.out.println(entry.getKey());
//                        sum = sum+ Double.valueOf(rs.getDouble("charges"));
//                        charge.add(entry.getKey());
//                        datas.add(data);
//                    }
//                }
//            }
//        }
//        System.out.println(charge.size());
//        System.out.println(sum);
//        for (List list1 : datas){
//            for (Object o : list1){
//                System.out.print(o+"\t");
//            }
//            System.out.println();
//        }
////        Set<String> msgs = new HashSet<String>();
////        for (File tf : list) {
////            FileInputStream fis = new FileInputStream(tf);
////            InputStreamReader isr = new InputStreamReader(fis, "GBK");
////            BufferedReader br = new BufferedReader(isr);
////            String line = "";
////            while ((line = br.readLine()) != null) {
////                for (String req : charge) {
////                    if (line.contains(req) && line.contains("GatherServiceImpl.java:1298")) {
////                        msgs.add(line.substring(111));
////                    }
////                }
////            }
////        }
////        for (String msg :msgs){
////            JSONObject object = JSONObject.fromObject(msg);
////            JSONArray dataList = object.getJSONArray("dataList");
////            for (int i = 0 ; i <dataList.size();i++){
////                JSONObject t = dataList.getJSONObject(i);
////                t.put("OPERATOR","1171");
////            }
//////            System.out.println(object);
////            Object[] args = client.invoke("getLisExamConfiir",object.toString());
////            String res = (String)args[0];
////            if(res.endsWith("-02")){
////                System.out.println(msg);
////            }
////            System.out.println(res);
////        }
//
//    }


//    @Test
//    public void test8() throws Exception{
//        ClientFactoryBean bean = ClientFactoryBean.getFactoryBeanInstance();
//        Client client = bean.getClient("hehe", "http://192.168.200.23:8080/GatherService/GatherService?wsdl");
//        Object[] args = client.invoke("getLisExamConfiir","{\"tableName\":\"DC_INSPCONFIRM\",\"dataList\":[{\"ADVICENO\":\"\",\"REQNO\":\"1512164361\",\"CONFIRMTIME\":\"2015-12-17 08:51:59\",\"OPERATOR\":\"1171\",\"VISHOSPTYPE\":\"\",\"STATUES\":\"2\",\"PATIENTNO\":\"T44796\",\"PATIENTSN\":\"1\",\"ITEM_NO\":\"1\",\"ITEM_CODE\":\"JY053\",\"WORKING_ID\":\"100\",\"ITEM_FLAG\":\"Y\"}],\"totalSize\":\"1\"}" );
//        System.out.println(args[0].toString());
//    }

    @Test
    public void test111() {
        System.out.println("=2015-12-18 01:55:24,441 INFO  [http-8080-5] impl.GatherServiceImpl (GatherServiceImpl.java:1298)     - 检验确认数据：".length());
    }
}
