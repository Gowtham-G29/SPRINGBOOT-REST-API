package com.g_29.restWebservice.restful_web_service.entity;

public class Helloworld {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Helloworld(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Hello world{" +
                "message='" + message + '\'' +
                '}';
    }
}
