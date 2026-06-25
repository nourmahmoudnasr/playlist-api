package com.example.playlist_api.repository;

import com.example.playlist_api.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    List<Playlist> findAllByClientId(int clientId);
}