package test;

import com.myloverqian.model.TaskWithResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zhiwei on 2015/12/7.
 */
public class CallAbleSample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
                System.out.println(e);
            } finally {
                executorService.shutdown();
            }
        }
    }
}
