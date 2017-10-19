package com.example.cloudnativejavaweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rss {

    @JsonProperty("channel")
    private Channel channel;

    public Rss() {
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
