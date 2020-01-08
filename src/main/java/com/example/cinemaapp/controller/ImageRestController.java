package com.example.cinemaapp.controller;

import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImageRestController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/image/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] helloWorld (@PathVariable("movieId") int movieId)  {
        Movie movie = movieService.findMovieById(movieId);
        return movie.getImage();
    }
}
