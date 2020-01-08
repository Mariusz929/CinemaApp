package com.example.cinemaapp.controller;

import com.example.cinemaapp.model.Screening;
import com.example.cinemaapp.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ScreeningRestController {

    @Autowired
    private ScreeningService screeningService;

    @RequestMapping(value="screenings", method = RequestMethod.GET)
    public List<Screening> getAllBooks(){
        return screeningService.getAllScreenings();
    }

    @RequestMapping(value = "screenings/{id}", method = RequestMethod.GET)
    public Screening getBookById(@PathVariable("id") int id){
        return screeningService.getScreeningById(id);
    }
}
