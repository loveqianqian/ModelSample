package com.myloverqian.util;

import com.myloverqian.bean.Template;
import com.myloverqian.bean.TemplateSample;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.List;

/**
 * Created by dzw on 2016/1/18.
 */
public class AnalyzeUtils {

    private static StringBuffer result = new StringBuffer();

    /**
     * 未审核
     * 有缺陷
     * 已确认
     * 已审核
     *
     * @param templateSample
     * @return
     */
    public static void createPartOne(List<Template> templateSample) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        for (Template template : templateSample) {
            if (template.getId().equals("0")) {
                String statusCount1 = template.getStatusCount();
                count1 = Integer.parseInt(statusCount1);
            }
            if (template.getId().equals("1")) {
                String statusCount2 = template.getStatusCount();
                count2 = Integer.parseInt(statusCount2);
            }
            if (template.getId().equals("2")) {
                String statusCount3 = template.getStatusCount();
                count3 = Integer.parseInt(statusCount3);
            }
            if (template.getId().equals("3")) {
                String statusCount4 = template.getStatusCount();
                count4 = Integer.parseInt(statusCount4);
            }
        }
        result.append(Constant.FIRST_ONE);
        result.append(DateUtils.getCurrentTimeChinese());
        result.append(Constant.FIRST_TWO);
        result.append(count1 + count2 + count3 + count4 + "");
        result.append(Constant.FIRST_THREE);
        result.append(count4 + "");
        result.append(Constant.FIRST_FOUR);
        result.append(count2 + "");
        result.append(Constant.FIRST_FIVE);
        result.append(count1 + "");
        result.append(Constant.FIRST_SIX);
        result.append(count3 + "");
        result.append(Constant.FIRST_SEVEN);
    }

    public static void createPartTwo(List<Template> list) {
        int countCCU = 0;
        int countCICU = 0;
        int countRICU = 0;
        int countXiongNei1ke = 0;
        int countXiongNei2Ke = 0;
        int countXiongNei3Ke = 0;
        int countXiongNei4Ke = 0;
        int countXiongNei5Ke = 0;
        int countNeiFenMi = 0;
        int countXinNei8ke = 0;
        int countXinNei6ke = 0;
        int countXinNei7ke = 0;
        int countXinNei3ke = 0;
        int countXinNei4ke = 0;
        int countXinNei5ke = 0;
        int countXinNei1ke = 0;
        int countXinWaiKe = 0;
        int countXiongWai1ke = 0;
        int countZongHeBingFang = 0;
        for (Template template : list) {
            if (template.getStatus().contains("已审核")) {
                if (template.getId().contains("CCU")) {
                    countCCU += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("CICU")) {
                    countCICU += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("RICU")) {
                    countRICU += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("呼吸与危重症1科")) {
                    countXiongNei1ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("呼吸与危重症2科") || template.getId().contains("胸内二科")) {
                    countXiongNei2Ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("呼吸与危重症3科")) {
                    countXiongNei3Ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("呼吸与危重症4科")) {
                    countXiongNei4Ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("呼吸与危重症5科")) {
                    countXiongNei5Ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("内分泌科")) {
                    countNeiFenMi += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("心内八科")) {
                    countXinNei8ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("心内六科")) {
                    countXinNei6ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("心内七科")) {
                    countXinNei7ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("心内三科")) {
                    countXinNei3ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("心内四科")) {
                    countXinNei4ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("心内五科")) {
                    countXinNei5ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("心内一科")) {
                    countXinNei1ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("心外科")) {
                    countXinWaiKe += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("胸外一科")) {
                    countXiongWai1ke += Integer.parseInt(template.getStatusCount());
                }
                if (template.getId().contains("综合病房")) {
                    countZongHeBingFang += Integer.parseInt(template.getStatusCount());
                }
            }
        }
        result.append("\n");
        result.append("其中通过审核的模版中：");
        result.append("胸外科" + countXiongWai1ke + "份");
        result.append("，心外科" + countXinWaiKe + "份");
        result.append(",CCU" + countCCU + "份");
        result.append(",CICU" + countCICU + "份");
        result.append(",RICU" + countRICU + "份");
        result.append(",胸内1科" + countXiongNei1ke + "份");
        result.append(",胸内2科" + countXiongNei2Ke + "份");
        result.append(",胸内3科" + countXiongNei3Ke + "份");
        result.append(",胸内4科" + countXiongNei4Ke + "份");
        result.append(",胸内5科" + countXiongNei5Ke + "份");
        result.append(",内分泌科" + countNeiFenMi + "份");
        result.append("，心内3科" + countXinNei3ke + "份");
        result.append(",心内6科" + countXinNei6ke + "份");
        result.append(",心内8科" + countXinNei8ke + "份");
        result.append(",心内7科" + countXinNei7ke + "份");
        result.append(",心内4科" + countXinNei4ke + "份");
        result.append(",心内5科" + countXinNei5ke + "份");
        result.append(",心内1科" + countXinNei1ke + "份");
        result.append(",综合病房" + countZongHeBingFang + "份");
    }

    public static void createPartThree(List<Template> list) {
        int allCount = 0;
        int patientCount = 0;
        int CCU = 0;
        int CICU = 0;
        int RICU = 0;
        int xiongnei1 = 0;
        int xiongnei2 = 0;
        int xiongnei3 = 0;
        int xiongnei5 = 0;
        int xiongnei4 = 0;
        int xiongneiputong = 0;
        int neifenmi = 0;
        int xinnei8 = 0;
        int xinnei6 = 0;
        int xinnei1 = 0;
        int xinnei2 = 0;
        int xinnei3 = 0;
        int xinnei4 = 0;
        int xinnei5 = 0;
        int xinnei7 = 0;
        int xinwai2 = 0;
        int xiongwai1 = 0;
        for (Template template : list) {
            int count = Integer.parseInt(template.getStatusCount());
            patientCount++;
            allCount += count;
            if (template.getStatus().contains("CCU")) {
                CCU += count;
            }
            if (template.getStatus().contains("CICU")) {
                CICU += count;
            }
            if (template.getStatus().contains("RICU")) {
                RICU += count;
            }
            if (template.getStatus().contains("呼吸与危重症1科")) {
                xiongnei1 += count;
            }
            if (template.getStatus().contains("呼吸与危重症2科")) {
                xiongnei2 += count;
            }
            if (template.getStatus().contains("呼吸与危重症3科")) {
                xiongnei3 += count;
            }
            if (template.getStatus().contains("呼吸与危重症4科")) {
                xiongnei4 += count;
            }
            if (template.getStatus().contains("呼吸与危重症5科")) {
                xiongnei5 += count;
            }
            if (template.getStatus().contains("内分泌科")) {
                neifenmi += count;
            }
            if (template.getStatus().contains("心内八科")) {
                xinnei8 += count;
            }
            if (template.getStatus().contains("心内七科")) {
                xinnei7 += count;
            }
            if (template.getStatus().contains("心内六科")) {
                xinnei6 += count;
            }
            if (template.getStatus().contains("心内五科")) {
                xinnei5 += count;
            }
            if (template.getStatus().contains("心内四科")) {
                xinnei4 += count;
            }
            if (template.getStatus().contains("心内三科")) {
                xinnei3 += count;
            }
            if (template.getStatus().contains("心内二科")) {
                xinnei2 += count;
            }
            if (template.getStatus().contains("心内一科")) {
                xinnei1 += count;
            }
            if (template.getStatus().contains("心外科")) {
                xinwai2 += count;
            }
            if (template.getStatus().contains("胸外一科")) {
                xiongwai1 += count;
            }
            if (template.getStatus().contains("呼吸科普通病区")) {
                xiongneiputong += count;
            }
        }
        result.append("\n");
        result.append("使用新病历系统书写病历共计");
        result.append(patientCount+"");
        result.append("个病人，书写");
        result.append(allCount);
        result.append("份病历,其中：");
        result.append("胸外科"+xiongwai1+"人");
        result.append("，胸内一科"+xiongnei1+"人");
        result.append("，胸内二科"+xiongnei2+"人");
        result.append("，胸内三科"+xiongnei3+"人");
        result.append("，胸内四科"+xiongnei4+"人");
        result.append("，胸内五科"+xiongnei5+"人");
        result.append(",CCU"+CCU+"人");
        result.append(",CICU"+CICU+"人");
        result.append(",RICU"+RICU+"人");
        result.append("，内分泌"+neifenmi+"人");
        result.append(",心外科"+xinwai2+"人");
        result.append(",心内8科"+xinnei8+"人");
        result.append(",心内6科"+xinnei6+"人");
        result.append(",心内1科"+xinnei1+"人");
        result.append(",心内2科"+xinnei2+"人");
        result.append(",心内3科"+xinnei3+"人");
        result.append(",心内4科"+xinnei4+"人");
        result.append(",心内5科"+xinnei5+"人");
        result.append(",心内7科"+xinnei7+"人");
        result.append(",呼吸普通科"+xiongneiputong+"人");
    }
    public static void outPutIntoFile(String path) throws IOException {
        File file=new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = FileUtils.openOutputStream(file);
        byte[] content=result.toString().getBytes();
        fileOutputStream.write(content);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
