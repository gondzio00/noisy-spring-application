package com.example.gondzio.Noisy.controller;

import com.example.gondzio.Noisy.domain.Song.Song;
import com.example.gondzio.Noisy.domain.Song.SongRepository;
import com.example.gondzio.Noisy.domain.Song.dto.SongRead;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/song")
public class SongController {

    private String defaultPath = "/src/main/resources/files/";

    SongRepository songRepository;

    SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping
    ResponseEntity getAllSongs(Pageable page) {

        Page<SongRead> returnPage = songRepository.findAll(page)
                .map(SongRead::fromSong);

        return ResponseEntity.ok(returnPage);

    }

    @GetMapping("/{id}")
    ResponseEntity getSong(@PathVariable int id) {
        Optional<Song> song = songRepository.findById(id);

        if (song.isPresent()) {
            return ResponseEntity.ok(SongRead.fromSong(song.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity saveSong(@Valid @RequestBody Song song) {
        songRepository.save(song);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Object> downloadSongFile(@PathVariable int id) throws FileNotFoundException {

        Optional<Song> song = songRepository.findById(id);

        if (!song.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        File file = new File(this.fileSongPath() + "/" + song.get().getPath());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
                MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity<String> fileSongUpload(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile = new File(this.fileSongPath() + "/" + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();

        return ResponseEntity.ok("Successfull");
    }

    private String fileSongPath() {
        Path resourceDirectory = Paths.get("src","main","resources", "files");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();

        return absolutePath;
    }
}
