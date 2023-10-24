package com.example.ex_song.repository;

import com.example.ex_song.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music, Integer> {

}
