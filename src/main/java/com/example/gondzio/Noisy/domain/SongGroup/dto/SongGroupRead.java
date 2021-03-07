package com.example.gondzio.Noisy.domain.SongGroup.dto;

import com.example.gondzio.Noisy.domain.SongGroup.SongGroup;

public class SongGroupRead {

    public int id;

    public String name;

    public static SongGroupRead fromSongGroup(SongGroup songGroup) {
        return new SongGroupRead(songGroup.getId(), songGroup.getName());
    }

    public SongGroupRead(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}