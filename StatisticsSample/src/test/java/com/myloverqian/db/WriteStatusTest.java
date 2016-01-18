package com.myloverqian.db;

import com.myloverqian.bean.Template;
import org.junit.Test;

import java.util.List;


/**
 * Created by dzw on 2016/1/18.
 */
public class WriteStatusTest {

    @Test
    public void testSectionStatus() throws Exception {
        WriteStatus status = new WriteStatus();
        List<Template> sectionTemplate = status.sectionStatus();
        System.out.println(sectionTemplate.toString());
    }

    @Test
    public void testPatientStatus() throws Exception {
        WriteStatus status = new WriteStatus();
        List<Template> patientTemplate = status.patientStatus();
        System.out.println(patientTemplate.toString());
    }
}