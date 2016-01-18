package com.myloverqian.bean;

import java.io.Serializable;

/**
 * Created by dzw on 2016/1/15.
 */
public class Template implements Serializable {

    private String id;
    private String status;
    private String statusCount;

    @Override
    public String toString() {
        return "id:" + id + "\n" + "status:" + status + "\n" + "statusCount:" + statusCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCount() {
        return statusCount;
    }

    public void setStatusCount(String statusCount) {
        this.statusCount = statusCount;
    }
}
