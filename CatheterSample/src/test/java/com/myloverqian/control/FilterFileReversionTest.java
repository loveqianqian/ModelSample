package com.myloverqian.control;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dzw on 2016/1/20.
 */
public class FilterFileReversionTest {

    @Test
    public void testAppendResult() throws Exception {
        String oneLine =
                "=2016-01-19 09:57:20,465 DEBUG [http-8080-3] impl.GatherServiceImpl " +
                        "(GatherServiceImpl.java:2206)     - update DC_ORDERS set FIRST_ADD_NUM='',FIRST_ADD_FLAG=''," +
                        "PACKAGE_SPEC='',COSTS='0',REQNO='',CLINIC_TYPE='2',REPORTDATE=  TO_DATE(substr('2016-01-19 09:57:38" +
                        "',0,19),'yyyy-mm-dd HH24:mi:ss'),SOURCEID='T47059-2-165-2',PATIENTNO='T47059',PATIENTSN='2',ORDE" +
                        "R_NO='165',ORDER_SUB_NO='2',REPEAT_INDICATOR='1',ORDER_CLASS='A',ORDER_TEXT='注射用门冬氨酸钾镁*',ORD" +
                        "ER_CODE='1503040011',DOSAGE='8',DOSAGE_UNITS='g',ADMINISTRATION='静滴',DURATION='',DURATION_UNITS" +
                        "='',START_DATE_TIME=  TO_DATE(substr('2016-01-19 06:57:18',0,19),'yyyy-mm-dd HH24:mi:ss'),STOP_D" +
                        "ATE_TIME=  TO_DATE(substr('',0,19),'yyyy-mm-dd HH24:mi:ss'),FREQUENCY='1/日',FREQ_COUNTER='1',FREQ" +
                        "_INTERVAL='1',FREQ_INTERVAL_UNIT='日',FREQ_DETAIL='',PERFORM_SCHEDULE='8:00',PERFORM_RESULT='',OR" +
                        "DERING_DEPT='02010202',DOCTOR='李培军',STOP_DOCTOR='',NURSE='刘若男',ORDER_STATUS='2',STOP_ORDER_D" +
                        "ATE_TIME=  TO_DATE(substr('',0,19),'yyyy-mm-dd HH24:mi:ss'),ENTER_DATE_TIME=  TO_DATE(substr('20" +
                        "16-01-19 07:48:38',0,19),'yyyy-mm-dd HH24:mi:ss'),BILLING_ATTR='0',LAST_ACCTING_DATE_TIME=  TO_DA" +
                        "TE(substr('',0,19),'yyyy-mm-dd HH24:mi:ss'),LAST_PERFORM_DATE_TIME=  TO_DATE(substr('2016-01-20 16" +
                        ":00:00',0,19),'yyyy-mm-dd HH24:mi:ss'),CURRENT_PRESC_NO='',STOP_NURSE='',BABY_NO='0',DRUG_BILLING_" +
                        "ATTR='',PERFORMED_BY='240203',DISPENSARY_CODE='',NWARN='',LAST_PERFORM_POINT='',PZWH='' where sour" +
                        "ceId='T47059-2-165-2'";
        FilterFileReversion reversion = new FilterFileReversion();
        System.out.println(reversion.appendResult(new StringBuffer(), oneLine));
    }
}