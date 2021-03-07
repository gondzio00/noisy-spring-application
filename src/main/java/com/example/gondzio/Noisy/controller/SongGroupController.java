package com.example.gondzio.Noisy.controller;

import com.example.gondzio.Noisy.domain.Song.dto.SongRead;
import com.example.gondzio.Noisy.domain.SongGroup.SongGroup;
import com.example.gondzio.Noisy.domain.SongGroup.SongGroupRepository;
import com.example.gondzio.Noisy.domain.SongGroup.dto.SongGroupRead;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/songGroup")
public class SongGroupController {

    SongGroupRepository songGroupRepository;

    SongGroupController(SongGroupRepository songGroupRepository) {
        this.songGroupRepository = songGroupRepository;
    }

    @GetMapping
    ResponseEntity getAllSongGroups(Pageable page) {

        Page<SongGroupRead> returnPage = songGroupRepository.findAll(page)
                .map(SongGroupRead::fromSongGroup);

        return ResponseEntity.ok(returnPage);
    }

    @GetMapping("/{id}")
    ResponseEntity getSongGroup(@PathVariable int id) {
        Optional<SongGroup> songGroup = songGroupRepository.findById(id);

        if(songGroup.isPresent()) {
            return ResponseEntity.ok(songGroup);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity saveSongGroup(@Valid @RequestBody SongGroup songGroup) {
        songGroupRepository.save(songGroup);
        return ResponseEntity.noContent().build();
    }

}
