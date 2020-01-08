package com.example.cinemaapp.repository;

import com.example.cinemaapp.model.ReservationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationViewRepository extends JpaRepository<ReservationView, Long> {
    ReservationView findById(int id);
    List<ReservationView> findAllByUserreservedid(Long userId);

    @Query(nativeQuery = true, value = "SELECT * FROM reservationview WHERE reservationview.user_reserved_id = ?1 && reservationview.active=1")
    List<ReservationView> findActive(long id);

    @Query(nativeQuery = true, value = "SELECT * FROM reservationview WHERE reservationview.user_reserved_id = ?1 && reservationview.active=0")
    List<ReservationView> findInactive(long id);

    @Query(nativeQuery = true, value = "SELECT DISTINCT title from reservationview ORDER BY title")
    List<String> getDistTitles();

    @Query(nativeQuery = true, value = "SELECT count(*) from reservationview GROUP BY title ORDER BY title")
    List<Long> countByTitle();

    @Query(nativeQuery = true, value = "SELECT DISTINCT name from reservationview ORDER BY name")
    List<String> getDistAuditNames();

    @Query(nativeQuery = true, value = "SELECT count(*) from reservationview GROUP BY name ORDER BY name")
    List<Long> countByAudit();
        }