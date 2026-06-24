package com.example.playlist_api.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "playlist_song",
        joinColumns = @JoinColumn(name = "playlist_id"),
        inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> songs = new ArrayList<>();

    public Playlist() {}

    public Playlist(String name, Client client) {
        this.name = name;
        this.client = client;
    }

    public int getId() { 
        return id; }

    public String getName() { 
        return name; }

    public Client getClient() { 
        return this.client; }

    public List<Song> getSongs() { 
        return songs; }

    public void setName(String name) { 
        this.name = name; }

    public void addSong(Song song) { 
        songs.add(song); }
}