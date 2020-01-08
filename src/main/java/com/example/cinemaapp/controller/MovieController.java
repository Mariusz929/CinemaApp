package com.example.cinemaapp.controller;

import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.model.User;
import com.example.cinemaapp.service.MovieService;
import com.example.cinemaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String addReservation(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("movie", movieService.findMovieById(id));
        return "details";

    }

    @RequestMapping(value = "/admin/addMovie", method = RequestMethod.GET)
    public ModelAndView addMovie() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.addObject("successMessage", "");
        Movie movie = new Movie();
        modelAndView.addObject("movie", movie);
        modelAndView.setViewName("admin/addMovie");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addMovie", method = RequestMethod.POST)
    public ModelAndView createNewMovie(@Valid Movie movie, @RequestParam("file") MultipartFile file) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        byte[] image = file.getBytes();
        movie.setImage(image);
        movieService.saveMovie(movie);
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.addObject("successMessage", "Movie has been added successfully");
        modelAndView.addObject("movie", new Movie());
        modelAndView.setViewName("/admin/addMovie");
        return modelAndView;
    }
}