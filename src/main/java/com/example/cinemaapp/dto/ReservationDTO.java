package com.example.cinemaapp.dto;

import java.util.List;

public class ReservationDTO {

    private int reservationid;
    private int screeningid;
    private Long userreservedid;
    private boolean paid;
    private boolean active;
    private int seatreservedid;
    private int seatid;
    private List<Integer> place;
    private String userreservedemail;

    public int getReservationid() {
        return reservationid;
    }
    public void setReservationid(int id) {
        this.reservationid = id;
    }

    public int getScreeningid() {
        return screeningid;
    }
    public void setScreeningid(int screeningid) {
        this.screeningid = screeningid;
    }

    public Long getUserreservedid() {
        return userreservedid;
    }
    public void setUserreservedid(Long userreservedid) {
        this.userreservedid = userreservedid;
    }


    public boolean getPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }


    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public int getSeatreservedid() {
        return seatreservedid;
    }
    public void setSeatreservedid(int seatreservedid) {
        this.seatreservedid = seatreservedid;
    }

    public int getSeatid() {
        return seatid;
    }
    public void setSeatid(int seatid) {
        this.seatid = seatid;
    }

    public String getUserreservedemail() {
        return userreservedemail;
    }

    public void setUserreservedemail(String userreservedemail) {
        this.userreservedemail = userreservedemail;
    }

    public List<Integer> getPlace() {
        return place;
    }
    public void setPlace(List<Integer> place) {
        this.place = place;
    }
}
