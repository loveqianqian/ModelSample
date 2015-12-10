package test.EnumTest;

import com.myloverqian.implement.EnumBean.Sample;

/**
 * Created by zhiwei on 2015/12/4.
 */
public class EnumSample2 {
    public static void main(String[] args) {
        for (Sample sample : Sample.values()) {
            System.out.println(sample + ",ordinal" + sample.ordinal());
        }
    }
}
