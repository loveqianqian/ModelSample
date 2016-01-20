package com.myloverqian.control;

import com.myloverqian.io.FileProcessor;
import com.myloverqian.io.FileProcessorImpl;
import com.myloverqian.io.FileWriteOut;
import com.myloverqian.io.LineProcessor;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * Created by dzw on 2016/1/19.
 */
public class FilterFileReversion {

    private void createResult(String fileName) throws IOException {
        File newFile = new File("D:\\gatherLogs");
        if (!newFile.exists()) {
            newFile.createNewFile();
        }
        FileProcessor fileProcessor = new FileProcessorImpl();
        FileWriteOut writeOut = new FileWriteOut();
        File file = new File(fileName);
        if (file.exists()) {
            File[] files = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.getName().contains("gatherService.log")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });
            for (File f : files) {
                if (f.isFile()) {
                    final StringBuffer result = new StringBuffer();
                    fileProcessor.processorByLineReversion(f, new LineProcessor() {
                        @Override
                        public void needToDo(String oneLine) {
                            appendResult(result, oneLine);
                        }
                    });
                    writeOut.writeOut(f.getAbsolutePath() + ".filter", result.toString());
                }
            }
        }
    }

    public boolean appendResult(StringBuffer result, String oneLine) {
        String lineNumStr = "";
        int lineNum = 0;
        boolean flag = false;
        if (oneLine.contains("(GatherServiceImpl.java:")) {
            String result1 = oneLine.split("\\(GatherServiceImpl.java\\:")[1];
            lineNumStr = result1.split("\\)")[0];
            lineNum = Integer.parseInt(lineNumStr);
            if (lineNum > 1859 && lineNum < 1879) {
                flag = true;
                result.append(oneLine);
                result.append("\n");
                return flag;
            }
            if (lineNum > 2197 && lineNum < 2262) {
                flag = true;
                result.append(oneLine);
                result.append("\n");
                return flag;
            }
            if (lineNum > 2270 && lineNum < 2325) {
                flag = true;
                result.append(oneLine);
                result.append("\n");
                return flag;
            }
            if (lineNum > 2334 && lineNum < 2387) {
                flag = true;
                result.append(oneLine);
                result.append("\n");
                return flag;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        FilterFileReversion filterFile = new FilterFileReversion();
        try {
            filterFile.createResult("D:\\logService");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
}
