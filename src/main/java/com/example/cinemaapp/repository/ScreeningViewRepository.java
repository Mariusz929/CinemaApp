package com.example.cinemaapp.repository;

import com.example.cinemaapp.model.ScreeningView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreeningViewRepository extends JpaRepository<ScreeningView, Long> {
    ScreeningView findById(int id);
    List<ScreeningView> findAllByMovieid(int movieid);
}