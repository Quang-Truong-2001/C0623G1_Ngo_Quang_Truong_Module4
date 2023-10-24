package com.example.ex_song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MusicDTO implements Validator {
    private Integer id;


    private String song;


    private String musician;


    private String category;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDTO musicDTO = (MusicDTO) target;
        if (!musicDTO.getSong().matches("^[a-zA-Z0-9]*$")) {
            errors.rejectValue("song", "", "khong chua cac ky tu dac biet");
        }
        if (musicDTO.getSong().length() > 5) {
            errors.rejectValue("song", "", "khong vuot qua 800 ky tu");
        }
        if (musicDTO.getSong().equals("")) {
            errors.rejectValue("song", "", "khong duoc de trong");
        }


        if (!musicDTO.getMusician().matches("^[a-zA-Z0-9]*$")) {
            errors.rejectValue("musician", "", "khong chua cac ky tu dac biet");
        }
        if (musicDTO.getMusician().length() > 500) {
            errors.rejectValue("musician", "", "khong vuot qua 500 ky tu");
        }
        if (musicDTO.getMusician().equals("")) {
            errors.rejectValue("musician", "", "khong duoc de trong");
        }

        if (!musicDTO.getCategory().matches("^[a-zA-Z0-9||/,]*$")) {
            errors.rejectValue("category", "", "khong chua cac ky tu dac biet");
        }
        if (musicDTO.getCategory().length() > 1000) {
            errors.rejectValue("category", "", "khong vuot qua 1000 ky tu");
        }
        if (musicDTO.getCategory().equals("")) {
            errors.rejectValue("category", "", "khong duoc de trong");
        }

    }

    public MusicDTO(Integer id, String song, String musician, String category) {
        this.id = id;
        this.song = song;
        this.musician = musician;
        this.category = category;
    }

    public MusicDTO(String song, String musician, String category) {
        this.song = song;
        this.musician = musician;
        this.category = category;
    }

    public MusicDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
