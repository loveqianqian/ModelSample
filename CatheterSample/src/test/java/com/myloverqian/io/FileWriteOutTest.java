package com.myloverqian.io;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

/**
 * Created by dzw on 2016/1/19.
 */
public class FileWriteOutTest {

    @Test
    public void testWriteOut() throws Exception {
        final String s = "=2016-01-19 09:49:01,826 INFO  [http-8080-7] util.AnalyzingJsonString (GatherServiceImpl\"DEPTID\":\"02010102\",\"DEPTNAME\":\"����ƶ���\",\"PERFORMDEPTID\":\"\",\"PERFORMDEPTNAME\":\"\",\"REQUIREDATE#DATE\":\"2016-01-20 08:00:00\",\"OPERATORID\":\"��ǿ\",\"OPERATORNAME\":\"\",\"ASSISTANTID\":\"\",\"ASSISTANTNAME\":\"\",\"ANESTHETISTID\":\"\",";
        String filePath = "C:\\Users\\admin\\Desktop\\log\\gatherService.log.1.filter";
        FileWriteOut out = new FileWriteOut();
        out.writeOut(filePath, s);
    }
}