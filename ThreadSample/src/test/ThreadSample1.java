package test;


import com.myloverqian.model.LifeOff;

/**
 * Created by zhiwei on 2015/12/7.
 */
public class ThreadSample1 {
    public static void main(String[] args) {
        LifeOff launch=new LifeOff(10);
        launch.run();
    }
}
