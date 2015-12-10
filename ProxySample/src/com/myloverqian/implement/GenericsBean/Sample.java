package com.myloverqian.implement.GenericsBean;

/**
 * Created by zhiwei on 2015/12/4.
 */
public class Sample<T> {
    private  T sample;

    public T getSample() {
        return sample;
    }

    public void setSample(T sample) {
        this.sample = sample;
    }
}
