package com.myloverqian;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>ProjectName:ModelSample</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/3
 */
public class FileStreamUtils3 {
    public static void main(String[] args) throws IOException {
        String filePath = "G:\\IdeaProjects\\ModelSample\\StreamSample\\resources\\test.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        String result = "这是一个test";
        String result2 = "hah come on";
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(result.getBytes(), 0, result.getBytes().length);
            out.flush();
            out.write(result2.getBytes(), 0, result2.getBytes().length);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
