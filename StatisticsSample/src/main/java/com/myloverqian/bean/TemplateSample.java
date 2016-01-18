package com.myloverqian.bean;

/**
 * Created by dzw on 2016/1/18.
 */
public class TemplateSample {
    private String depatName;
    private String count;

    @Override
    public String toString() {
        return "depatName:" + getDepatName() + " count:" + count;
    }

    public String getDepatName() {
        return depatName;
    }

    public void setDepatName(String depatName) {
        this.depatName = depatName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
