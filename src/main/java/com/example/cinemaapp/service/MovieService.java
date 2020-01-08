package com.example.cinemaapp.service;

        import com.example.cinemaapp.model.Movie;
        import java.util.List;

public interface MovieService {
    public Movie findMovieById(int id);
    public Movie findMovieByTitle(String title);
    public  void saveMovie(Movie movie);
    public List<Movie> getAllMovies();
    public Movie getMovieById(int id);
}