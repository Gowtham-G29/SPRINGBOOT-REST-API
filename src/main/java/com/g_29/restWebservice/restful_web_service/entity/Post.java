package com.g_29.restWebservice.restful_web_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity(name = "post")
public class Post {

    @Id
    @GeneratedValue
    private int id;

    private String descriptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post(){

    }

    public Post(int id, String descriptions) {
        this.id = id;
        this.descriptions = descriptions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", descriptions='" + descriptions + '\'' +
                '}';
    }
}
