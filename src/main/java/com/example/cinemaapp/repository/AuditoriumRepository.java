package com.example.cinemaapp.repository;

import com.example.cinemaapp.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
    Auditorium findByName(String name);
}