package com.example.cinemaapp.model;

import javax.persistence.*;

@Entity
public class Reservation {
    private int id;
    private int screeningid;
    private Long userreservedid;
    private boolean paid;
    private boolean active;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "screening_id")
    public int getScreeningid() {
        return screeningid;
    }

    public void setScreeningid(int screeningid) {
        this.screeningid = screeningid;
    }

    @Basic
    @Column(name = "user_reserved_id")
    public Long getUserreservedid() {
        return userreservedid;
    }

    public void setUserreservedid(Long userreservedid) {
        this.userreservedid = userreservedid;
    }

    @Basic
    @Column(name = "paid")
    public boolean getPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Basic
    @Column(name = "active")
    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
