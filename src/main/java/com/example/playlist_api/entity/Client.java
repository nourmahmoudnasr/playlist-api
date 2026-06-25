package com.example.playlist_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    public Client() {}

    public Client(String username) {
        if (username == null || username.isBlank()) {
        throw new IllegalArgumentException("Client username cannot be blank");
    }
    this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

}