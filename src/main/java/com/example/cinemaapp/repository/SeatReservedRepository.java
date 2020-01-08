package com.example.cinemaapp.repository;

import com.example.cinemaapp.model.SeatReserved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatReservedRepository extends JpaRepository<SeatReserved, Long> {
    SeatReserved findById (int id);
    List<SeatReserved> findAllByReservationid(int id);
    List<SeatReserved> findAllByScreeningid(int id);
}