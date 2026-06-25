package com.example.playlist_api.dto.Response;

import com.example.playlist_api.entity.Playlist;
import java.util.List;

public class PlaylistResponse {
    private int id;
    private String name;
    private int clientId;
    private List<SongResponse> songs;

    public PlaylistResponse(int id, String name, int clientId, List<SongResponse> songs) {
        this.id = id;
        this.name = name;
        this.clientId = clientId;
        this.songs = songs;
    }

    public static PlaylistResponse from(Playlist playlist) {
        List<SongResponse> songs = playlist.getSongs().stream().map(s -> new SongResponse(s.getId(), s.getTitle(), s.getArtistName())).toList();
        return new PlaylistResponse(playlist.getId(), playlist.getName(), playlist.getClient().getId(), songs);
    }

    public int getId() { 
        return id; }
    public String getName() { 
        return name; }
    public int getClientId() { 
        return clientId; }
    public List<SongResponse> getSongs() { 
        return songs; }
}