package com.example.gondzio.Noisy.domain.SongGroup;

import com.example.gondzio.Noisy.domain.Song.Song;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "song_group")
public class SongGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Song> songs = new HashSet<>();

    public SongGroup(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public int getId() {
        return id;
    }
}
