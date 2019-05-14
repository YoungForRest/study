package com.youngTH.entity;

/**
 * Created by YoungTH on 2018/11/30.
 */
public class Friend {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Friend(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Friend() {

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
