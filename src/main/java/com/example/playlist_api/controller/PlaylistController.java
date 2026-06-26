package com.example.playlist_api.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.playlist_api.service.PlaylistService;
import org.springframework.web.bind.annotation.*;
import com.example.playlist_api.dto.Request.CreatePlaylistRequest;
import com.example.playlist_api.dto.Request.RenamePlaylistRequest;
import com.example.playlist_api.dto.Response.PlaylistResponse;
import com.example.playlist_api.entity.Playlist;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<PlaylistResponse> createPlaylist(@RequestBody CreatePlaylistRequest request) {
        Playlist playlist = playlistService.createPlaylist(request.getClientId(), request.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(PlaylistResponse.from(playlist));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistResponse> getPlaylist(@PathVariable int id) {
        Playlist playlist = playlistService.getPlaylistOrThrow(id);
        return ResponseEntity.ok(PlaylistResponse.from(playlist));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<PlaylistResponse>> getClientPlaylists(@PathVariable int clientId) {
        List<PlaylistResponse> response = playlistService.fetchClientPlaylists(clientId).stream().map(PlaylistResponse::from).toList(); //converted each playlist into playlistResponse
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> renamePlaylist(@PathVariable int id, @RequestBody RenamePlaylistRequest request) {
        playlistService.updatePlaylistName(id, request.getName());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable int id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{playlistId}/songs/{songId}") //post as new object created in the playlist_song table
    public ResponseEntity<Void> addSongToPlaylist(@PathVariable int playlistId, @PathVariable int songId) {
        playlistService.addSongToPlaylist(playlistId, songId);
        return ResponseEntity.noContent().build(); //although new object is created, no content returned so no need to wrap it
    }

    @DeleteMapping("/{playlistId}/songs/{songId}")
    public ResponseEntity<Void> removeSongFromPlaylist(@PathVariable int playlistId, @PathVariable int songId) {
        playlistService.removeSongFromPlaylist(playlistId, songId);
        return ResponseEntity.noContent().build();
    }
}