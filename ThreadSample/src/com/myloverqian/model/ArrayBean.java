package com.myloverqian.model;

import java.util.Collections;

/**
 * Created by zhiwei on 2015/12/8.
 */
public class ArrayBean {
    private String name;
    private int serialNum;
    private int age;
    private String address;

    public ArrayBean(String name, int serialNum, int age, String address) {
        this.name = name;
        this.serialNum = serialNum;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "ArrayBean{" +
                "name='" + name + '\'' +
                ", serialNum=" + serialNum +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
