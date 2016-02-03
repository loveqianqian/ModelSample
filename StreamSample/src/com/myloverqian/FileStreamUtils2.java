package com.myloverqian;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * <p>ProjectName:ModelSample</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/3
 */
public class FileStreamUtils2 {
    private static String filePath = "G:\\IdeaProjects\\ModelSample\\StreamSample\\resources\\1.jpg";
    private static String newFilePath = "G:\\IdeaProjects\\ModelSample\\StreamSample\\resources\\2.jpg";
    private static String filePath1 = "G:\\IdeaProjects\\ModelSample\\StreamSample\\resources\\1.txt";
    private static String newFilePath1 = "G:\\IdeaProjects\\ModelSample\\StreamSample\\resources\\2.txt";
    private static List<byte[]> list = new ArrayList<>();
    private static FileOutputStream out = null;
    private static FileInputStream in = null;

    public static void saveFile() throws IOException {
        Map<Integer, byte[]> map = new HashMap<>();
//        File file = new File(filePath1);
//        File newFile = new File(newFilePath1);
        File file = new File(filePath);
        File newFile = new File(newFilePath);
        if (!newFile.exists()) {
            newFile.createNewFile();
        }
        out = new FileOutputStream(newFile);
        in = new FileInputStream(file);
        byte[] bytes = new byte[1024 * 5];
        int num = 0;
        while (in.read(bytes) != -1) {
//            list.add(bytes);
            map.put(num, bytes);
            num++;
        }
        in.close();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//            out.write(list.get(i), 0, list.get(i).length);
//        }
        for (int i = 0; i < num; i++) {
            byte[] date = map.get(i);
            out.write(date, 0, date.length);
        }
        out.flush();
        out.close();
    }

    public static void main(String[] args) {
        try {
            saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
