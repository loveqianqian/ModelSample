package com.myloverqian;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * <p>ProjectName:ModelSample</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/3
 */
public class FileStreamUtils {
    private static String filePath = "G:\\IdeaProjects\\ModelSample\\StreamSample\\resources\\1.jpg";
    private static String newFilePath = "G:\\IdeaProjects\\ModelSample\\StreamSample\\resources\\2.jpg";

    public static void main(String[] args) {
        File file = new File(filePath);
        File newFile = new File(newFilePath);
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            in = new FileInputStream(file);
            out = new FileOutputStream(newFile);
            byte[] bytes = new byte[1024 * 5];
            int length = 0;
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
