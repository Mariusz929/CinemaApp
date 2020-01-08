package com.example.cinemaapp.repository;

import com.example.cinemaapp.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findById(int id);

    List<Reservation> findAllByScreeningid(int screeningId);

    List<Reservation> findAllByUserreservedid(long userId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM reservation WHERE reservation.id = ?1")
    void cancelReservation(int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE reservation WHERE reservation.id = ?1")
    void setInactive(int id);

}