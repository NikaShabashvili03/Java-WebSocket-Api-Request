package com.messenger.api.models;

public class Message {

    private String from;
    private String text;
    private String createdAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Message(String from, String text, String createdAt) {
        this.from = from;
        this.text = text;
        this.createdAt = createdAt;
    }

    // getters and setters

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
