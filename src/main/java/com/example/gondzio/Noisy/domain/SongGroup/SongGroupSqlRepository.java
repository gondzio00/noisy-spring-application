package com.example.gondzio.Noisy.domain.SongGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SongGroupSqlRepository extends SongGroupRepository, JpaRepository<SongGroup, Integer> {
}
