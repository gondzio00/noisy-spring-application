package com.example.gondzio.Noisy.domain.Song;

import com.example.gondzio.Noisy.domain.SongGroup.SongGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SongRepository {

    Optional<Song> findById(Integer id);
    List<Song> findAll();
    Page<Song> findAll(Pageable pageable);
    Song save(Song song);

}
