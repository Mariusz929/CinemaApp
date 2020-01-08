package com.example.cinemaapp.controller;


import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.model.User;
import com.example.cinemaapp.service.EmailService;
import com.example.cinemaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;
    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView guestContact() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "");
        modelAndView.setViewName("contact");
        return modelAndView;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public ModelAndView guestMessageSend(@Valid SimpleMailMessage message) {
        ModelAndView modelAndView = new ModelAndView();
        emailService.sendMessage("mycinemaapp@gmail.com", "Question from: " + message.getSubject(), message.getText());
        modelAndView.addObject("successMessage", "Email has been sent successfully");
        modelAndView.setViewName("/contact");
        return modelAndView;
    }

    @RequestMapping(value = "/regular/contact", method = RequestMethod.GET)
    public ModelAndView regularContact() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "");
        modelAndView.setViewName("regular/contact");
        return modelAndView;
    }

    @RequestMapping(value = "/regular/contact", method = RequestMethod.POST)
    public ModelAndView regularMessageSend(@Valid SimpleMailMessage message) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        emailService.sendMessage("mycinemaapp@gmail.com", "Question from: " + user.getEmail(), message.getText());
        modelAndView.addObject("successMessage", "Email has been sent successfully");
        modelAndView.setViewName("/regular/contact");
        return modelAndView;
    }
}
