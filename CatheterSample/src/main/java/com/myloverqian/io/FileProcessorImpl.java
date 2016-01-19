package com.myloverqian.io;

import com.myloverqian.db.DgSysDb;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dzw on 2016/1/19.
 */
public class FileProcessorImpl implements FileProcessor {
    @Override
    public void processorByLine(String filePath, LineProcessor lineProcessor) {
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "GBk");
            br = new BufferedReader(inputStreamReader);
            DgSysDb dgSysDb = new DgSysDb();
            List<String> tableName = dgSysDb.getTableName();
            String line = "";
            while ((line = br.readLine()) != null) {
                boolean flag = false;
                for (String s : tableName) {
                    if (line.contains(s)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    lineProcessor.needToDo(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStreamReader);
            IOUtils.closeQuietly(br);
        }
    }

    @Override
    public void processorByLine(File file, LineProcessor lineProcessor) {
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(file), "GBk");
            br = new BufferedReader(inputStreamReader);
            DgSysDb dgSysDb = new DgSysDb();
            List<String> tableName = dgSysDb.getTableName();
            String line = "";
            while ((line = br.readLine()) != null) {
                boolean flag = false;
                for (String s : tableName) {
                    if (line.contains(s)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    lineProcessor.needToDo(line.trim());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(inputStreamReader);
            IOUtils.closeQuietly(br);
        }
    }
}
