package com.myloverqian.util;

/**
 * Created by zhiwei on 2016/1/18.
 */
public class SqlConstant {
	/** 
	* 患者书写情况
	* patient_name，dept_name,count(*)
	*/
    public static final String WRITE_STATUS_PATIENT =
            "SELECT d.patient_name,D.DEPT_NAME,COUNT(*) AS MY_COUNT FROM emr_doc_t d " +
                    "WHERE d.doc_id IN (" +
                    "   SELECT t.doc_id " +
                    "   FROM doc_status_t t " +
                    "   WHERE t.doc_status IN ('0','1')) " +
                    "GROUP BY d.patient_name,D.DEPT_NAME " +
                    "ORDER BY D.DEPT_NAME";
	
	/** 
	* 科室书写情况
	* dept_name,creator_name,count(*)
	*/
    public static final String WRITE_STATUS_SECTION =
            "SELECT d.dept_name,d.creator_name,COUNT(*) AS MY_COUNT " +
                    "FROM emr_doc_t d " +
                    "WHERE d.doc_id IN (" +
                    "   SELECT t.doc_id " +
                    "   FROM doc_status_t t " +
                    "   WHERE t.doc_status IN ('0','1')) " +
                    "GROUP BY d.dept_name,d.creator_name " +
                    "ORDER BY D.DEPT_NAME";

	/** 
	* 科室模板制作情况
	* dept_name,count(*)
	*/				
    public static final String TEMPLATED_STATUS_MANUFACTURE =
            " SELECT T.DEPT_NAME,COUNT(*) AS MY_COUNT " +
                    "FROM DOC_TEMPLET_T T " +
                    "WHERE T.IS_VALID = '1' " +
                    "AND T.IS_FOLDER <> '1' " +
                    "AND t.check_status='3' " +
                    "GROUP BY T.DEPT_NAME " +
                    "ORDER BY T.DEPT_NAME";
	
	/** 
	* 科室模板制作审核情况
	* dept_name,check_status,count(*)
	*/
    public static final String TEMPLATED_STATUS_CHECK=
            "SELECT T.DEPT_NAME," +
                    "   (CASE T.CHECK_STATUS " +
                    "   WHEN '0' THEN '未审核' " +
                    "   WHEN '1' THEN '有缺陷' " +
                    "   WHEN '2' THEN  '已确认' " +
                    "   WHEN '3' THEN '已审核' " +
                    "   END" +
                    "   )AS CHECK_STATUS," +
                    "COUNT(*) AS MY_COUNT " +
                    "FROM DOC_TEMPLET_T T " +
                    "WHERE T.IS_VALID = '1' " +
                    "AND T.IS_FOLDER <> '1'  " +
                    "GROUP BY T.CHECK_STATUS,T.DEPT_NAME " +
                    "ORDER BY T.DEPT_NAME,t.check_status";
    
	/** 
	* 基本模板情况
	* check_status,check_status,count(*)
	*/
    public static final String TEMPLATED_STATUS_CHECK_SAMPLE=
            "SELECT T.CHECK_STATUS," +
                    "   (CASE T.CHECK_STATUS " +
                    "   WHEN '0' THEN '未审核' " +
                    "   WHEN '1' THEN '有缺陷' " +
                    "   WHEN '2' THEN '已确认' " +
                    "   WHEN '3' THEN '已审核' " +
                    "   END)AS MY_CHECK_STATUS," +
                    "COUNT(*) as MY_COUNT " +
                    "FROM DOC_TEMPLET_T T " +
                    "WHERE T.IS_VALID = '1'" +
                    "AND T.IS_FOLDER <> '1'" +
                    "GROUP BY T.CHECK_STATUS " +
                    "ORDER BY t.check_status";
}
