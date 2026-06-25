package com.example.playlist_api.dto.Request;

public class CreateClientRequest {

    private String username;

    public CreateClientRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}