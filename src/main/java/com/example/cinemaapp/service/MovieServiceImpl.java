package com.example.cinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.repository.MovieRepository;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findMovieById(int id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie findMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(int id) {
        return movieRepository.findOne((long) id);
    }

}
