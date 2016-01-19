package com.myloverqian.io;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dzw on 2016/1/19.
 */
public class FileProcessorImplTest {

    @Test
    public void testProcessorByLine() throws Exception {
        final StringBuffer sb = new StringBuffer();
        FileProcessorImpl fileProcessor = new FileProcessorImpl();
        fileProcessor.processorByLine("C:\\Users\\admin\\Desktop\\log\\gatherService.log.1", new LineProcessor() {
            @Override
            public void needToDo(String oneLine) {
                sb.append(oneLine);
            }
        });
        System.out.println(sb.toString());
    }
}