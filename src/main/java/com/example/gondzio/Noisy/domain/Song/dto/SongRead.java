package com.example.gondzio.Noisy.domain.Song.dto;

import com.example.gondzio.Noisy.domain.Song.Song;
import com.example.gondzio.Noisy.domain.SongGroup.dto.SongGroupRead;

import java.net.URL;

public class SongRead {

    public int id;
    public String name;
    public String path;

    public SongGroupRead songGroup;

    public SongRead(int id, String name, String path, SongGroupRead songGroup) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.songGroup = songGroup;
    }

    public static SongRead fromSong(Song song) {
        int id = song.getId();
        String name = song.getName();
        String path = song.getPath();

        SongGroupRead songGroup = SongGroupRead.fromSongGroup(song.getSongGroup());

        return new SongRead(id, name, path, songGroup);
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

    public SongGroupRead getSongGroup() {
        return songGroup;
    }

    public void setSongGroup(SongGroupRead songGroup) {
        this.songGroup = songGroup;
    }
}
