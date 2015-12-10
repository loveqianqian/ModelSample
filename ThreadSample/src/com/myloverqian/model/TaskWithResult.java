package com.myloverqian.model;

import java.util.concurrent.Callable;

/**
 * Created by zhiwei on 2015/12/7.
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        return "result of TaskWith Result" + id;
    }
}
