package com.example.playlist_api.dto.Response;

public class SongResponse {
    private int id;
    private String title;
    private String artistName;

    public SongResponse(int id, String title, String artistName) {
        this.id = id;
        this.title = title;
        this.artistName = artistName;
    }

    public int getId() { 
        return id; 
    }

    public String getTitle() { 
        return title; }
    public String getArtistName() { 
        return artistName; }
}