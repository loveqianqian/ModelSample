package com.myloverqian.observe;

import com.myloverqian.subject.Subject;

/**
 * Created by zhiwei on 2015/12/9.
 */
public class ConcreteObserve implements Observe {

    private String observeSataus;

    @Override
    public void update(Subject subject) {

        observeSataus = subject.getSubjectStatus();
    }
}
