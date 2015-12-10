package test;

import com.myloverqian.model.LifeOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhiwei on 2015/12/7.
 */
public class FixedThreadPoolSample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LifeOff(10));
        }
        executorService.shutdown();
    }
}
