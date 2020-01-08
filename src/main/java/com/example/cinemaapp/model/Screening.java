package com.example.cinemaapp.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Screening {
    private int id;
    private int movieid;
    private int auditoriumid;
    private Date screeningStartDate;
    private Time screeningStartHour;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "movie_id")
    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    @Basic
    @Column(name = "auditorium_id")
    public int getAuditoriumid() {
        return auditoriumid;
    }

    public void setAuditoriumid(int auditoriumid) {
        this.auditoriumid = auditoriumid;
    }

    @Basic
    @Column(name = "screening_start_hour")
    public Time getScreeningStartHour() {
        return screeningStartHour;
    }

    public void setScreeningStartHour(Time screeningStartHour) {
        this.screeningStartHour = screeningStartHour;
    }

    @Basic
    @Column(name = "screening_start_date")
    public Date getScreeningStartDate() {
        return screeningStartDate;
    }

    public void setScreeningStartDate(Date screeningStartDate) {
        this.screeningStartDate = screeningStartDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Screening screening = (Screening) o;

        if (id != screening.id) return false;
        if (screeningStartDate != null ? !screeningStartDate.equals(screening.screeningStartDate) : screening.screeningStartDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (screeningStartDate != null ? screeningStartDate.hashCode() : 0);
        return result;
    }
}
