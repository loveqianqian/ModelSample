package test;

import com.myloverqian.model.LifeOff;

/**
 * Created by zhiwei on 2015/12/7.
 */
public class ThrreadSample4ManyThread {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            LifeOff lifeOff = new LifeOff(10);
            lifeOff.run();
        }
        System.out.println("let's begin");
    }
}
