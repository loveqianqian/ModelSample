package test.FileTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;

/**
 * Created by zhiwei on 2015/12/5.
 */
public class AllFileSample {
    private String fileName = "G://androidStudioProjects";
    private static int lineNum = 0;
    private static String reg = ".java";
    private static String reg2 = ".xml";

    public File getFile() {
        File file = new File(fileName);
        return file;
    }

    public int eachFile(File f, int fileNum) {
        for (File file : f.listFiles()) {
            if (file.isDirectory()) {
                fileNum = eachFile(file, fileNum);
            } else {
                fileNum++;
            }
        }
        return fileNum;
    }

    public boolean matcherFileName(String fileName) {
        return fileName.contains(reg) || fileName.contains(reg2);
    }

    public void eachFileNum(File f) {
        for (File file : f.listFiles()) {
            if (file.isDirectory()) {
                eachFileNum(file);
            } else {
                if (matcherFileName(file.getName())) {
                    lineNum = countLineNum(file, lineNum);
                }
            }
        }
    }

    public int countLineNum(File f, int lineNum) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String result = "";
            while ((result = reader.readLine()) != null) {
                if (!result.equals("")) {
                    lineNum++;
                }
            }
            return lineNum;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lineNum;
    }

    public static String formatNum() {
        int bits = lineNum % 10;
        int ten = lineNum / 10 % 10;
        int hundred = lineNum / 100 % 10;
        int thousand = lineNum / 1000 % 10;
        int tenThousand = lineNum / 10000 % 10;
        int million = lineNum / 100000 % 10;
        return "line number:" + million + "" + tenThousand + "" + thousand + "," + hundred + "" + ten + ""
                + bits;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        AllFileSample sample = new AllFileSample();
        File file = sample.getFile();
        if (!file.exists()) {
            System.out.println("this don't exists");
            return;
        }
        sample.eachFileNum(file);
        long endTime = System.currentTimeMillis();
        System.out.println("use time:" + (endTime - startTime) + " minSeconds");
        System.out.println("match file specification .java and .xml");
        System.out.println(formatNum());
    }
}
