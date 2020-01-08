package com.example.cinemaapp.repository;

        import com.example.cinemaapp.model.Movie;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findById (int id);
    Movie findByTitle(String title);
}