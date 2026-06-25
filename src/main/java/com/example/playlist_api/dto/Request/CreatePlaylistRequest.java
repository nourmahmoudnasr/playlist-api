package com.example.playlist_api.dto.Request;

public class CreatePlaylistRequest {

    private int clientId;
    private String name;

    public CreatePlaylistRequest() {
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}