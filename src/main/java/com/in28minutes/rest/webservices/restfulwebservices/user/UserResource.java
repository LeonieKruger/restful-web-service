package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    //retrieve all users - GET /users

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    //retrieve user by id - GET /users/{id}
    @GetMapping("/users/{id}")
    public User retrievUser(@PathVariable int id){
        return service.findOne(id);
    }

    //CREATED
    //input - get details from user
    //output - return created URI
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        User saved =service.save(user);

    }

}
