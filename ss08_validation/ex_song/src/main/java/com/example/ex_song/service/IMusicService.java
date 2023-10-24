package com.example.ex_song.service;

import com.example.ex_song.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> showList();
    void create(Music music);

    void update(Music music);

    Music findById(Integer id);
}
