package com.example.playlist_api.dto;

public class CreateSongRequest {

    private String title;
    private String artistName;

    public CreateSongRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}