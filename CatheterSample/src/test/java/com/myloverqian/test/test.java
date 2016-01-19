package com.myloverqian.test;

import org.junit.Test;

import java.io.File;

/**
 * Created by dzw on 2016/1/19.
 */
public class test {
    @Test
    public void myTest(){
        File file=new File("D:\\logService\\gatherService.log.26");
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
    }

}
