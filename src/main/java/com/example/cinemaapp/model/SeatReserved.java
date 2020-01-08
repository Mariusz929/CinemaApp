package com.example.cinemaapp.model;

import javax.persistence.*;

@Entity
@Table(name = "seat_reserved")
public class SeatReserved {
    private int id;
    private int seatid;
    private int reservationid;
    private int screeningid;

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
    @Column(name = "seat_id")
    public int getSeatid() {
        return seatid;
    }

    public void setSeatid(int seatid) {
        this.seatid = seatid;
    }

    @Basic
    @Column(name = "reservation_id")
    public int getReservationid() {
        return reservationid;
    }

    public void setReservationid(int reservationid) {
        this.reservationid = reservationid;
    }

    @Basic
    @Column(name = "screening_id")
    public int getScreeningid() {
        return screeningid;
    }

    public void setScreeningid(int screeningid) {
        this.screeningid = screeningid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeatReserved that = (SeatReserved) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
