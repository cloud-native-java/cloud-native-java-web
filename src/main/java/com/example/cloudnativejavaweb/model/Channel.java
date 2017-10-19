package com.example.cloudnativejavaweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Channel {

    @JsonProperty("item")
    private List<Post> item;

    public Channel() {
    }

    public List<Post> getItem() {
        return item;
    }

    public void setItem(List<Post> item) {
        this.item = item;
    }
}
