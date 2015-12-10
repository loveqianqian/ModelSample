package test.PatternTest;

import java.util.regex.Pattern;

/**
 * Created by zhiwei on 2015/12/5.
 */
public class PatternSample {
    private static String reg = "^*.txt$";

    public static void main(String[] args) {
        String result = "java.txt";
        Pattern pattern = Pattern.compile(reg);
        boolean flag = pattern.matcher(result).matches();
        System.out.println(flag ? "1" : "0");
    }
}
