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
        if (title == null || title.isBlank()) {
        throw new IllegalArgumentException("Song title cannot be blank");
    }
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return id == song.id;
}

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
}
}
