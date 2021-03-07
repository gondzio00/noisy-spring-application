package com.example.gondzio.Noisy.domain.Song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface SongSqlRepository extends SongRepository, JpaRepository<Song, Integer> {
}
