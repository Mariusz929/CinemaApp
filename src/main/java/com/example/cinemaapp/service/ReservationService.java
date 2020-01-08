package com.example.cinemaapp.service;

import com.example.cinemaapp.model.Reservation;
import java.util.List;

public interface ReservationService {

        public Reservation findReservationById(int id);
        public  void saveReservation(Reservation reservation);
        public List<Reservation> getAllReservations();
        public Reservation getReservationById(int id);

}