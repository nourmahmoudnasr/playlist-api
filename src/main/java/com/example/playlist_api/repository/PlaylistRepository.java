package com.example.playlist_api.repository;

import java.util.List;
import com.example.playlist_api.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;




public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

    List<Playlist> findAllByClientId(int clientId);
}