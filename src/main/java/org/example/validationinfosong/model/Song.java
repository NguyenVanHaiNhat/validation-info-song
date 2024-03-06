package org.example.validationinfosong.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "song")
public class Song implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Max(800)
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]+", message = "Tên chứa kí tự đặc biệt!")
    private String songName;
    @NotEmpty
    @Max(300)
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]+", message = "Tên chứa kí tự đặc biệt!")
    private String artistPerformance;
    @NotEmpty
    @Max(300)
    @Pattern(regexp = "[^a-zA-Z0-9,]+")
    private String songCategory;

    public Song() {
    }

    public Song(Long id,@NotEmpty @Max(800) @Pattern(regexp = "[a-zA-Z][a-zA-Z ]+", message = "Tên chứa kí tự đặc biệt!")String songName,
                @NotEmpty @Max(300) @Pattern(regexp = "[a-zA-Z][a-zA-Z ]+", message = "Tên chứa kí tự đặc biệt!")String artistPerformance,
                @NotEmpty @Max(300) @Pattern(regexp = "[^a-zA-Z0-9,]+")String songCategory) {
        this.id = id;
        this.songName = songName;
        this.artistPerformance = artistPerformance;
        this.songCategory = songCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistPerformance() {
        return artistPerformance;
    }

    public void setArtistPerformance(String artistPerformance) {
        this.artistPerformance = artistPerformance;
    }

    public String getSongCategory() {
        return songCategory;
    }

    public void setSongCategory(String songCategory) {
        this.songCategory = songCategory;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Song.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
