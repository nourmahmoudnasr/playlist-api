package com.example.playlist_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    private String artistName;

    public Song() {}


    public Song(String title, String artistName) {
        this.title = title;
        this.artistName = artistName;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }
}
