package com.myloverqian.implement.achieve;

import com.myloverqian.implement.MoveAble;

import java.util.Random;

/**
 * Created by zhiwei on 2015/12/3.
 */
public class Car implements MoveAble {
    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
