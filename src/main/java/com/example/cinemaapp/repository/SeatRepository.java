package com.example.cinemaapp.repository;

import com.example.cinemaapp.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    Seat findById (int id);
    List<Seat> findAllByRow(int row);
    List<Seat> findAllByAuditoriumid(int id);
    List<Seat> findAllByAuditoriumidAndRow(int id, int row);

    @Query(nativeQuery = true, value = "SELECT count(DISTINCT row) FROM seat WHERE seat.auditorium_id = ?1")
    Long countRows(int id);
}