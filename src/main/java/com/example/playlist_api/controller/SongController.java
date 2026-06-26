package com.example.playlist_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.playlist_api.dto.Request.CreateSongRequest;
import com.example.playlist_api.dto.Response.SongResponse;
import com.example.playlist_api.entity.Song;
import com.example.playlist_api.service.SongService;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public ResponseEntity<SongResponse> createSong(@RequestBody CreateSongRequest request) {
        Song song = songService.createSong(request.getTitle(), request.getArtistName());
        return ResponseEntity.status(HttpStatus.CREATED).body(new SongResponse(song.getId(), song.getTitle(), song.getArtistName()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongResponse> getSong(@PathVariable int id) {
        Song song = songService.getSongOrThrow(id);
        return ResponseEntity.ok(new SongResponse(song.getId(), song.getTitle(), song.getArtistName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable int id) {
        songService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }
}