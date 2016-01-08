package com.myloverqian.util;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhiwei on 2015/12/26.
 */
public class Separate2 {

    public String methodSelf(int count, String path) throws IOException {
        File file = new File(path);
        File[] list = file.listFiles();
        Set<String> reqs = new HashSet<String>();
        StringBuffer sb = new StringBuffer();
        for (File tf : list) {
            FileInputStream fis = new FileInputStream(tf);
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.contains("\"OPERATOR\":\"7516\"") || line.contains("\"OPERATOR\":\"1179\"")) {
                    String req = line.substring(line.indexOf("\"REQNO\":\"") + "\"REQNO\":\"".length(),
                            line.indexOf("\",\"CONFIRMTIME\""));
                    reqs.add(req);
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
        for (String temp : reqs) {
            sb.append(temp);
        }
        return sb.toString();
    }
}
