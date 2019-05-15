package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
