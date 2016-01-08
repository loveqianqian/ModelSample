package com.myloverqian.util;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhiwei on 2015/12/27.
 */
public class Separate3 {

    public String methodSelf(int count, String path) throws IOException {
        File file = new File(path);
        File[] list = file.listFiles();
        Pattern pattern = Pattern.compile("//d{10}");
        Matcher matcher = null;
        StringBuffer sb = new StringBuffer();
        for (File tf : list) {
            FileInputStream fis = new FileInputStream(tf);
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    sb.append(line);
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
        return sb.toString();
    }
}
