package test;

import com.myloverqian.model.LifeOff;

/**
 * Created by zhiwei on 2015/12/7.
 */
public class LifeOffUseMethod2 {
    public static void main(String[] args) {
        Thread thread=new Thread(new LifeOff(10));
        thread.start();
        System.out.println("thread have start");
    }
}
