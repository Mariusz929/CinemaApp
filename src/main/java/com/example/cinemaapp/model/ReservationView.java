package com.example.cinemaapp.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Immutable
@Table(name = "reservationview")
public class ReservationView {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "user_reserved_id")
    private Long userreservedid;

    @Column(name = "title")
    private String  movietitle;

    @Column(name = "email")
    private String useremail;

    @Column(name = "active")
    private boolean active;

    @Column(name = "screening_start_date")
    private Date screeningStartDate;

    @Column(name = "screening_start_hour")
    private Time screeningStartHour;

    @Column(name = "seats_quantity")
    private int seatsquantity;

    @Column(name = "name")
    private String auditoriumname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserreservedid(Long userreservedid) {
        this.userreservedid = userreservedid;
    }

    public long getUserreservedid() {
        return userreservedid;
    }

    public void setUserreservedid(long userreservedid) {
        this.userreservedid = userreservedid;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public int getSeatsquantity() {
        return seatsquantity;
    }

    public void setSeatsquantity(int seatsquantity) {
        this.seatsquantity = seatsquantity;
    }

    public String getAuditoriumname() {
        return auditoriumname;
    }

    public void setAuditoriumname(String auditoriumname) {
        this.auditoriumname = auditoriumname;
    }
}