package com.example.test.model;

import java.io.Serializable;

public class Contact implements Serializable {

    private String name;
    private String tel;
    private String age;
    private String place;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private String link;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Contact(String name, String tel, String age, String place, String link) {
        this.name = name;
        this.tel = tel;
        this.age = age;
        this.place = place;
        this.link = link;
    }
}
