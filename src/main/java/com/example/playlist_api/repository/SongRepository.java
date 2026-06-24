package com.example.playlist_api.repository;

import com.example.playlist_api.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {
}