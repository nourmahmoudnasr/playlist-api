package com.example.playlist_api.dto.Response;

public class ClientResponse {
    private int id;
    private String username;

    public ClientResponse(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() { 
        return id; }

    public String getUsername() { 
        return username; }

}