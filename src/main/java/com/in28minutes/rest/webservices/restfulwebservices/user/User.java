package com.in28minutes.rest.webservices.restfulwebservices.user;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Entity
public class User {
    private int id;

    @Size(min=2, message="Name should have at least two characters")
    private String name;

    @Past
    private Date birthDate;

    @Id
    @GeneratedValue
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
    
//    @OneToMany(targetEntity=Post.class, mappedBy="user")
//    private List<Post> posts;
//
//	public List<Post> getPosts() {
//		return posts;
//	}
//
//	public void setPosts(List<Post> posts) {
//		this.posts = posts;
//	}


}
