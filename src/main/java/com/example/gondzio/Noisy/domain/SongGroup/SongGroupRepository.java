package com.example.gondzio.Noisy.domain.SongGroup;

import com.example.gondzio.Noisy.domain.Song.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SongGroupRepository {

    Optional<SongGroup> findById(Integer id);
    List<SongGroup> findAll();
    Page<SongGroup> findAll(Pageable pageable);
    SongGroup save(SongGroup song);

}
