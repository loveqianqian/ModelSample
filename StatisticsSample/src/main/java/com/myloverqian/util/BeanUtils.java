package com.myloverqian.util;

import com.myloverqian.bean.Template;
import com.myloverqian.bean.TemplateSample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzw on 2016/1/18.
 */
public class BeanUtils {

    public static List<List<?>> putIntoList(List<Template> argArray) {
        List<List<?>> list = new ArrayList<>();
        for (int i = 0; i < argArray.size(); i++) {
            List<String> subList = new ArrayList<>();
            String id = argArray.get(i).getId();
            String status = argArray.get(i).getStatus();
            String statusCount = argArray.get(i).getStatusCount();
            subList.add(id);
            subList.add(status);
            subList.add(statusCount);
            list.add(subList);
        }
        return list;
    }

    public static List<List<?>> putIntoListSample(List<TemplateSample> argArray) {
        List<List<?>> list = new ArrayList<>();
        for (int i = 0; i < argArray.size(); i++) {
            List<String> subList = new ArrayList<>();
            String count = argArray.get(i).getCount();
            String depatName = argArray.get(i).getDepatName();
            subList.add(count);
            subList.add(depatName);
            list.add(subList);
        }
        return list;
    }
}
