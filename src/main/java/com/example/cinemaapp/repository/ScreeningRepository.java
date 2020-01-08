package com.example.cinemaapp.repository;

import com.example.cinemaapp.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    Screening findById(int id);
    List<Screening> findAllByMovieid(int movieid);
}
