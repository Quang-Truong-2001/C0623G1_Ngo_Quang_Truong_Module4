package com.example.ex_song.service.impl;

import com.example.ex_song.model.Music;
import com.example.ex_song.repository.IMusicRepository;
import com.example.ex_song.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements IMusicService {

    @Autowired
    private IMusicRepository repository;
    @Override
    public List<Music> showList() {
        return repository.findAll();
    }

    @Override
    public void create(Music music) {
        repository.save(music);
    }

    @Override
    public void update(Music music) {
        repository.save(music);
    }

    @Override
    public Music findById(Integer id) {
        return repository.findById(id).get();
    }
}
