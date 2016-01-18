package com.myloverqian.util;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiwei on 2016/1/18.
 */
public class ExcelUtils {
    private static HSSFWorkbook workbook = null;

    static {
        workbook = new HSSFWorkbook();
    }

    public static HSSFSheet createExcelFile(int i, String sheetName, boolean isCreate) {
        if (isCreate) {
            workbook = new HSSFWorkbook();
        }
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(i, sheetName);
        return sheet;
    }

    public static boolean addHSSFTableHead(HSSFSheet sheet, String... args) {
        boolean flag = true;
        try {
            HSSFRow row = sheet.createRow(0);
            for (int i = 0; i < args.length; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellValue(args[i]);
            }
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean addHSSFTableBody(HSSFSheet sheet, int rowNo, int cellNo, List<List<?>> dateArray) {
        boolean flag = true;
        try {
            for (int rowNum = 1; rowNum < rowNo + 1; rowNum++) {
                HSSFRow row = sheet.createRow(rowNum);
                List<?> subDateArray = dateArray.get(rowNum - 1);
                for (int cellNum = 0; cellNum < cellNo; cellNum++) {
                    HSSFCell cell = row.createCell(cellNum);
                    cell.setCellValue((String) subDateArray.get(cellNum));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean writeIntoFile(String path) {
        boolean flag = true;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream stream = FileUtils.openOutputStream(file);
            workbook.write(stream);
            if (stream != null) {
                stream.close();
            }
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    public static void main(String[] args) {
        String[] testArray = new String[]{"name", "sex", "age"};
        HSSFSheet sheet = createExcelFile(0, "test", true);
        addHSSFTableHead(sheet, testArray);
        List<List<?>> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<String> subList = new ArrayList<>();
            subList.add("david" + i);
            subList.add("man" + i);
            subList.add(String.valueOf(i));
            list.add(subList);
        }
        addHSSFTableBody(sheet, 2, 3, list);
        writeIntoFile("D:\\text.xls");
    }
}
