package com.myloverqian.control;

import com.myloverqian.io.*;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * Created by dzw on 2016/1/19.
 */
public class FilterFile {

    public void createResult(String fileName) throws IOException {
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
                    fileProcessor.processorByLine(f, new LineProcessor() {
                        @Override
                        public void needToDo(String oneLine) {
                            result.append(oneLine);
                            result.append("\n");
                        }
                    });
                    writeOut.writeOut(f.getAbsolutePath() + ".filter", result.toString());
                }
            }
        }
    }

    public static void main(String[] args) {
        FilterFile filterFile = new FilterFile();
        try {
            filterFile.createResult("D:\\logService");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
}
