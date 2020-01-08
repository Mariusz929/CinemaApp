package com.example.cinemaapp.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Immutable
@Table(name = "screeningview")
public class ScreeningView {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "movie_id")
    private int movieid;

    @Column(name = "title")
    private String  title;

    @Column(name = "director")
    private String director;

    @Column(name = "genre")
    private String genre;

    @Column(name = "duration_min")
    private int durationMin;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "screening_start_date")
    private Date screeningStartDate;

    @Column(name = "screening_start_hour")
    private Time screeningStartHour;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getScreeningStartDate() {
        return screeningStartDate;
    }

    public void setScreeningStartDate(Date screeningStartDate) {
        this.screeningStartDate = screeningStartDate;
    }

    public Time getScreeningStartHour() {
        return screeningStartHour;
    }

    public void setScreeningStartHour(Time screeningStartHour) {
        this.screeningStartHour = screeningStartHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
