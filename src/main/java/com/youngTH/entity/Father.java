package com.youngTH.entity;

/**
 * Created by YoungTH on 2018/11/30.
 */
public class Father {
    private String id;
    private String fatherName;
    private Integer age;

    @Override
    public String toString() {
        return "Father{" +
                "id='" + id + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Father(String id, String fatherName, Integer age) {

        this.id = id;
        this.fatherName = fatherName;
        this.age = age;
    }

    public Father() {

    }
}
