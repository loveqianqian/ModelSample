package com.myloverqian.db;

import com.myloverqian.bean.Template;
import org.junit.Test;

import java.util.List;

/**
 * Created by dzw on 2016/1/15.
 */
public class templateCheckTest {

    @Test
    public void testGetTemplate() throws Exception {
        TemplateCheck tc = new TemplateCheck();
        List<Template> templateList = tc.getTemplat();
        System.out.println(templateList.get(0).toString());
    }
}