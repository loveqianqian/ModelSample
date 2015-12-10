package com.myloverqian.model;

/**
 * Created by zhiwei on 2015/12/7.
 */
public class LifeOff implements Runnable {
    private int count;
    private int task = 0;

    public LifeOff(int count) {
        this.count = count;
    }

    private String status() {
        return "#" + task++ + "(" + (count > 0 ? count : "over") + ")";
    }

    @Override
    public void run() {
        while (count-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
