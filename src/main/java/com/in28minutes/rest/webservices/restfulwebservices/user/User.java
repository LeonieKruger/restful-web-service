package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {
private int id;
private String name;
private Date birthDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public User() {

    }


    public User(int id, String name, Date date) {
        this.id = id;
        this.name=name;
        this.birthDate=date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}