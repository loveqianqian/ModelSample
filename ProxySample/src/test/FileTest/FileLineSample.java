package test.FileTest;

import java.io.*;
import java.util.regex.Pattern;

/**
 * Created by zhiwei on 2015/12/5.
 */
public class FileLineSample {
    private static String filePath = "G://androidStudioProjects/java.txt";
    private String result = "";

    public static void main(String[] args) {
        File file = new File(filePath);
        int lineNum = 0;
        int fullLineNum = 0;
        BufferedReader reader = null;
//        Pattern pattern = Pattern.compile("\\n");
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = reader.readLine()) != null) {
//                if (pattern.matcher(line).matches()) {
//                    lineNum++;
//                } else {
//                    fullLineNum++;
//                }
                if ("".equals(line)) {
                    lineNum++;
                } else {
                    fullLineNum++;
                }
                System.out.println("line:" + line);
            }
            System.out.println("equal lineNum:" + lineNum + "\n" + "full line num:" + fullLineNum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
