package com.myloverqian.subject;

import com.myloverqian.observe.Observe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiwei on 2015/12/9.
 */
public class Subject {

    private String subjectStatus;

    private List<Observe> observes = new ArrayList<>();

    public void attach(Observe observe) {
        observes.add(observe);
    }

    public void detach(Observe observe) {
        observes.remove(observe);
    }


    protected void notifyObserves() {
        for (Observe observe : observes) {
            observe.update(this);
        }
    }

    public String getSubjectStatus() {
        return subjectStatus;
    }

    public void setSubjectStatus(String subjectStatus) {
        this.subjectStatus = subjectStatus;
    }
}
