package com.example.playlist_api.service;
import java.util.NoSuchElementException;
import com.example.playlist_api.entity.Song;
import org.springframework.stereotype.Service;
import com.example.playlist_api.repository.SongRepository;


@Service
public class  SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song getSongOrThrow(int id) {
        return songRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Song not found"));
    }

    public Song createSong(String title, String artistName) {

        Song song = new Song(title, artistName);
        return songRepository.save(song);
        
    }

    public void deleteSong(int id) {
        Song song = getSongOrThrow(id);
        songRepository.delete(song);
    }


    }

  
