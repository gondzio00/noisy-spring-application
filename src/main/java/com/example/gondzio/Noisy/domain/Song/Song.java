package com.example.gondzio.Noisy.domain.Song;

import com.example.gondzio.Noisy.domain.SongGroup.SongGroup;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.net.URL;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "can't be null or empty")
    private String name;

    @NotBlank(message = "can't be null or empty")
    private String path;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private SongGroup songGroup;

    public Song() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public SongGroup getSongGroup() {
        return songGroup;
    }

    public void setSongGroup(SongGroup songGroup) {
        this.songGroup = songGroup;
    }

}
