package test.FileTest;

import java.io.File;

/**
 * Created by zhiwei on 2015/12/5.
 */
public class OneFileSample {
    public static void main(String[] args) {
        String filePath="G://androidStudioProjects";
        File file=new File(filePath);
        int fileNum=0;
        if (!file.exists()){
            System.out.println("this don't had a file any more");
        }else{
            File[] files = file.listFiles();
            System.out.println(files.length);
            for (File fileBean : files) {
                System.out.println(fileBean.getName());
            }
        }
    }
}
