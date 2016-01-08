package com.myloverqian.util;

import net.sf.json.JSONObject;

import java.io.*;

/**
 * Created by zhiwei on 2015/12/26.
 */
public class Separate1 {

    public String methodSelf(int count, String path) throws IOException {
        File file = new File(path);
        File[] list = file.listFiles();
        StringBuffer sb = new StringBuffer();
        for (File tf : list) {
            FileInputStream fis = new FileInputStream(tf);
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.contains("检查报告数据")) {
                    String msg = line.substring(line.indexOf("检查报告数据：") + "检查报告数据：".length());
                    if (line.contains("呈\"剑鞘\"状") || line.contains("度\"S\"形")) {
                        sb.append(msg + "\n");
                        msg = msg.replace("呈\"剑鞘\"状", "呈(剑鞘)状");
                        msg = msg.replace("度\"S\"形", "度(S)形");
                    }
//                    JSONObject jsonObject = JSONObject.fromObject(msg);
//                    sb.append(jsonObject + "\n");
                    sb.append(msg + "\n");
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
            sb.append(count + "\n");
        }
        return sb.toString();
    }

}