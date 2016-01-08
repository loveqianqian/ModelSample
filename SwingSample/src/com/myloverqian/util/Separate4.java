package com.myloverqian.util;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhiwei on 2015/12/27.
 */
public class Separate4 {

    public String methodSelf(int count, String path) throws IOException {
        File file = new File(path);
        File[] list = file.listFiles();
        Set<String> charge = new HashSet<String>();
        Set<String> error = new HashSet<String>();
        Map<String, String> map = new HashMap<String, String>();
        Set<String> msgs = new HashSet<String>();
        StringBuffer sbResult = new StringBuffer();
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
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals("02")) {
                sbResult.append(entry.getKey() + "\n");
                charge.add(entry.getKey());
            }
        }
        sbResult.append(charge.size() + "\n");

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

        for (String tempUser : users) {
            sbResult.append(tempUser + "\n");
        }

        for (String msg : msgs) {
            sbResult.append(msg + "\n");
        }
        return sbResult.toString();
    }
}

