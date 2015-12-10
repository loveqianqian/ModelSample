package test;

import com.myloverqian.model.ArrayBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhiwei on 2015/12/8.
 */
public class ArraySample {
    public static void main(String[] args) {
        ArrayBean bean = new ArrayBean("david", 1, 18, "nankai");
        ArrayBean bean1 = new ArrayBean("orial", 3, 19, "heping");
        ArrayBean bean2 = new ArrayBean("lion", 4, 29, "hexi");
        ArrayBean bean3 = new ArrayBean("zhiwei", 2, 19, "heping");
        List<ArrayBean> list = new ArrayList<ArrayBean>();
        list.add(bean);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        Collections.sort(list, new Comparator<ArrayBean>() {
            @Override
            public int compare(ArrayBean o1, ArrayBean o2) {
                int serialNo1 = o1.getSerialNum();
                int serialNo2 = o2.getSerialNum();
                return serialNo1 - serialNo2;
            }
        });
        for (ArrayBean arrayBean : list) {
            System.out.println(arrayBean.getName());
        }
    }
}
