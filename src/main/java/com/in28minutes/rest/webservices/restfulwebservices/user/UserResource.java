package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = service.findOne(id);
        if (user==null){
            throw new UserNotFoundException("id-"+id);
        }
        return user;
    }

    //CREATED
    //input - get details from user
    //output - return created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser =service.save(user);

        URI location=ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
       return ResponseEntity.created(location).build();
    }

}