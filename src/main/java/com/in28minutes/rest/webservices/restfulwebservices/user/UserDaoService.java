package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users=new ArrayList<>();

    private static int userCount = 3;
    static {
        users.add(new User(1,"Adam",new Date()));
        users.add(new User(2,"Eve",new Date()));
        users.add(new User(3,"Jan",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
       int newId=user.getId();
        if (user.getId()==0){
            newId=++userCount;
        }

        user.setId(newId);
        return user;
    }

    public User findOne(int id){
        for (User user:users){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }


}
