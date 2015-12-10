package com.myloverqian.implement.achieve;

import com.myloverqian.implement.MoveAble;

/**
 * Created by zhiwei on 2015/12/3.
 */
public class CarLogProxy implements MoveAble {

    private MoveAble moveAble;

    public CarLogProxy(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    @Override
    public void move() {
        System.out.println("start move ! come on");
        moveAble.move();
        System.out.println("stop move ! ohh~~");
    }
}
