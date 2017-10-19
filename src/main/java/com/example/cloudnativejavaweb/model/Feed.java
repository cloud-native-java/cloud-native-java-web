package com.example.cloudnativejavaweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feed {

    @JsonProperty("rss")
    private Rss rss;

    public Feed() {
    }

    public Rss getRss() {
        return rss;
    }

    public void setRss(Rss rss) {
        this.rss = rss;
    }

}
