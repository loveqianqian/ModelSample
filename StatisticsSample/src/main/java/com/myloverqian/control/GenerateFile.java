package com.myloverqian.control;


import com.myloverqian.bean.Template;
import com.myloverqian.bean.TemplateSample;
import com.myloverqian.db.TemplateCheck;
import com.myloverqian.db.WriteStatus;
import com.myloverqian.util.*;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.io.File;
import java.util.List;

/**
 * Created by dzw on 2016/1/15.
 */
public class GenerateFile {

    private static String path = "";

    public GenerateFile() {
    }

    public GenerateFile(String path) {
        this.path = path;
    }

    public boolean generateMethod() {
        boolean flag = true;
        try {
            if (MyStringUtils.isEmpty(path)) {
                path = Constant.DEFAULT_FILE_PATH;
            }
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            generateTemplateSample();
            generateTemplateManufacture();
            generateTemplateCheck();
            generateWritePatient();
            generateWriteWode();
            AnalyzeUtils.outPutIntoFile(path + "\\" + Constant.CONSOLE);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    public void generateTemplateSample() {
        TemplateCheck check = new TemplateCheck();
        List<Template> templateSample = check.getTemplateSample();
        List<List<?>> list = BeanUtils.putIntoList(templateSample);
        HSSFSheet sheet = ExcelUtils.createExcelFile(0, DateUtils.getCurrentTime(), true);
        ExcelUtils.addHSSFTableHead(sheet, Constant.FIRST_EXCEL_TABLE_HEAD);
        ExcelUtils.addHSSFTableBody(sheet, list.size(), list.get(0).size(), list);
        ExcelUtils.writeIntoFile(path + "\\" + Constant.FIRST_EXCEL_NAME + ".xls");
        AnalyzeUtils.createPartOne(templateSample);
    }

    public void generateTemplateManufacture() {
        TemplateCheck check = new TemplateCheck();
        List<TemplateSample> templateSample = check.getTemplateManufacture();
        List<List<?>> list = BeanUtils.putIntoListSample(templateSample);
        HSSFSheet sheet = ExcelUtils.createExcelFile(0, DateUtils.getCurrentTime() + "制作情况", true);
        ExcelUtils.addHSSFTableHead(sheet, Constant.SECOND_EXCEL_TABLE_HEAD_MANUFACTURE);
        ExcelUtils.addHSSFTableBody(sheet, list.size(), list.get(0).size(), list);
        ExcelUtils.writeIntoFile(path + "\\" + Constant.SECOND_EXCEL_NAME + ".xls");
    }

    public void generateTemplateCheck() {
        TemplateCheck check = new TemplateCheck();
        List<Template> templateSample = check.getTemplateCheck();
        List<List<?>> list = BeanUtils.putIntoList(templateSample);
        HSSFSheet sheet = ExcelUtils.createExcelFile(1, DateUtils.getCurrentTime() + "审核情况", false);
        ExcelUtils.addHSSFTableHead(sheet, Constant.SECOND_EXCEL_TABLE_HEAD_CHECK);
        ExcelUtils.addHSSFTableBody(sheet, list.size(), list.get(0).size(), list);
        ExcelUtils.writeIntoFile(path + "\\" + Constant.SECOND_EXCEL_NAME + ".xls");
        AnalyzeUtils.createPartTwo(templateSample);
    }

    public void generateWritePatient() {
        WriteStatus status = new WriteStatus();
        List<Template> templateSample = status.patientStatus();
        List<List<?>> list = BeanUtils.putIntoList(templateSample);
        HSSFSheet sheet = ExcelUtils.createExcelFile(0, DateUtils.getCurrentTime() + "病人情况", true);
        ExcelUtils.addHSSFTableHead(sheet, Constant.THIRD_EXCEL_TABLE_HEAD_PATINET);
        ExcelUtils.addHSSFTableBody(sheet, list.size(), list.get(0).size(), list);
        ExcelUtils.writeIntoFile(path + "\\" + Constant.THIRD_EXCEL_NAME + ".xls");
        AnalyzeUtils.createPartThree(templateSample);
    }

    public void generateWriteWode() {
        WriteStatus status = new WriteStatus();
        List<Template> templateSample = status.sectionStatus();
        List<List<?>> list = BeanUtils.putIntoList(templateSample);
        HSSFSheet sheet = ExcelUtils.createExcelFile(1, DateUtils.getCurrentTime() + "科室情况", false);
        ExcelUtils.addHSSFTableHead(sheet, Constant.THIRD_EXCEL_TABLE_HEAD_WODE);
        ExcelUtils.addHSSFTableBody(sheet, list.size(), list.get(0).size(), list);
        ExcelUtils.writeIntoFile(path + "\\" + Constant.THIRD_EXCEL_NAME + ".xls");
    }

    public static void main(String[] args) {
        GenerateFile file = new GenerateFile();
        file.generateMethod();
    }

}
