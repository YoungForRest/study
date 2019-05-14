package com.youngTH.entity;

import java.util.List;

/**
 * Created by YoungTH on 2018/11/30.
 */
public class User {
    private String id;
    private String userName;
    private Integer age;
    private Father father;
    private List<Friend> friends;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", father=" + father +
                ", friends=" + friends +
                '}';
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public User() {

    }

    public User(String id, String userName, Integer age, Father father) {

        this.id = id;
        this.userName = userName;
        this.age = age;
        this.father = father;
    }
}
