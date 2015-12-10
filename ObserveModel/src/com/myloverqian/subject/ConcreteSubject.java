package com.myloverqian.subject;

/**
 * Created by zhiwei on 2015/12/9.
 */
public class ConcreteSubject extends Subject {
    @Override
    public String getSubjectStatus() {
        return super.getSubjectStatus();
    }

    @Override
    public void setSubjectStatus(String subjectStatus) {
        super.setSubjectStatus(subjectStatus);
        this.notifyObserves();
    }
}
