package com.example.cinemaapp.controller;

import com.example.cinemaapp.model.Screening;
import com.example.cinemaapp.model.User;
import com.example.cinemaapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
public class ScreeningController {

    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private ScreeningViewService screeningViewService;
    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private AuditoriumService auditoriumService;

    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @RequestMapping(path = "/repertoir", method = RequestMethod.GET)
    public String listEventsGuest(Model model) {
        model.addAttribute("screenings", screeningViewService.getAllScreeningViews());
        return "repertoir";
    }

    @RequestMapping(path = "/regular/repertoir", method = RequestMethod.GET)
    public String listEventsRegular(Model model) {
        model.addAttribute("screenings", screeningViewService.getAllScreeningViews());
        return "/regular/repertoir";
    }

    @RequestMapping(value = "/admin/addScreening", method = RequestMethod.GET)
    public ModelAndView addScreening() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        int movieid=1;
        int auditoriumid=1;
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.addObject("allMovies", movieService.getAllMovies());
        modelAndView.addObject("allAuditoriums", auditoriumService.getAllAuditoriums());
        modelAndView.addObject("lastSelectedMovie", movieid);
        modelAndView.addObject("lastSelectedAuditorium", auditoriumid);
        modelAndView.addObject("successMessage", "");
        Screening screening = new Screening();
        modelAndView.addObject("screening", screening);
        modelAndView.setViewName("/admin/addScreening");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addScreening", method = RequestMethod.POST)
    public ModelAndView createNewScreening(Screening screening, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        screeningService.saveScreening(screening);
        modelAndView.addObject("allMovies", movieService.getAllMovies());
        modelAndView.addObject("allAuditoriums", auditoriumService.getAllAuditoriums());
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.addObject("successMessage", "Event has been added successfully");
        //modelAndView.addObject("screening", new Screening());
        modelAndView.setViewName("/admin/addScreening");
        return modelAndView;
    }
}
