package test.GenericsTest;

import com.myloverqian.implement.GenericsBean.AutoBean;
import com.myloverqian.implement.GenericsBean.Sample;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhiwei on 2015/12/4.
 */
public class GenericsSample1 {
    public static void main(String[] args) {
        AutoBean bean = new AutoBean();
        String itemName = "";
        try {
            itemName = java.net.URLEncoder.encode("test for me", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        bean.setItemName(itemName);
        Sample<AutoBean> sample = new Sample<AutoBean>();
        sample.setSample(bean);
        AutoBean auto = sample.getSample();
        String orgItemName = "";
        try {
            orgItemName = java.net.URLDecoder.decode(auto.getItemName(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(orgItemName);
    }
}
