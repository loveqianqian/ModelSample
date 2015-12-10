package com.myloverqian.implement.achieve;

import com.myloverqian.implement.MoveAble;

/**
 * Created by zhiwei on 2015/12/3.
 */
public class CarTimeProxy implements MoveAble {

    private MoveAble moveAble;

    public CarTimeProxy(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        moveAble.move();
        long endTime = System.currentTimeMillis();
        System.out.println("time:" + (endTime - startTime));
    }
}
