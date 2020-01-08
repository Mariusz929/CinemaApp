package com.example.cinemaapp.controller;

import com.example.cinemaapp.model.*;
import com.example.cinemaapp.dto.ReservationDTO;
import com.example.cinemaapp.repository.*;
import com.example.cinemaapp.service.EmailService;
import com.example.cinemaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ReservationController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private final UserService userService;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatReservedRepository seatReservedRepository;
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationViewRepository reservationViewRepository;

    public ReservationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/addReservation/{id}", method = RequestMethod.GET)
    public String addReservation(@PathVariable("id") int id, ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setScreeningid(id);
        if (auth.getName().equals("anonymousUser")) {
            reservationDTO.setUserreservedemail("");
        }else reservationDTO.setUserreservedemail(auth.getName());
        model.put("reservationDTO", reservationDTO);
        int auditoriumid = screeningRepository.findById(id).getAuditoriumid();
        model.addAttribute("rows", seatRepository.countRows(auditoriumid));
        model.addAttribute("seats", seatRepository.findAllByAuditoriumid(auditoriumid));
        List<Integer> lista = new ArrayList<>();
        seatReservedRepository.findAllByScreeningid(id).forEach((temp) -> lista.add(temp.getSeatid()));
        model.addAttribute("alreadyReserved", lista);
        return "addReservation";

    }

    @RequestMapping(value = "/addReservation", method = RequestMethod.POST)
    public String saveReservation(@ModelAttribute("reservationDTO") ReservationDTO reservationDTO, @Valid SimpleMailMessage message, Reservation reservation, BindingResult result, ModelMap model) {
        model.addAttribute("successMessage", "Success");
        if (result.hasErrors()) {
            return "/error";
        }
        int auditoriumid = screeningRepository.findById(reservationDTO.getScreeningid()).getAuditoriumid();
        model.addAttribute("rows", seatRepository.countRows(auditoriumid));
        model.addAttribute("seats", seatRepository.findAllByAuditoriumid(auditoriumid));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getName().equals("anonymousUser")) {
            User user = userService.findUserByEmail(auth.getName());
            reservation.setUserreservedid(user.getId());
        } else reservation.setUserreservedid(null);
        reservation.setScreeningid(reservationDTO.getScreeningid());
        reservation.setPaid(false);
        reservation.setActive(true);
        reservationRepository.save(reservation);
        for(int i=0; i<reservationDTO.getPlace().size(); i++){
            SeatReserved seatReserved = new SeatReserved();
            seatReserved.setSeatid(reservationDTO.getPlace().get(i));
            seatReserved.setReservationid(reservation.getId());
            seatReserved.setScreeningid(reservation.getScreeningid());
            seatReservedRepository.save(seatReserved);
        }
        emailService.sendMessage(reservationDTO.getUserreservedemail(), "New Reservation no. " + reservation.getId(), "We registered your reservation!\nReservation ID: " + reservation.getId() + "\nNumbers of seats reserved: " + reservationDTO.getPlace().size() + "\nPlease buy and pick up your tickets 15 minutes before the screening starts.");
        model.addAttribute("places", reservationDTO.getPlace().size());
        model.addAttribute("test", reservationDTO.getPlace().toString());
        List<Integer> lista = new ArrayList<>();
        seatReservedRepository.findAllByScreeningid(reservation.getScreeningid()).forEach((temp) -> lista.add(temp.getSeatid()));
        model.addAttribute("alreadyReserved", lista);
        return "addReservation";
    }

    @RequestMapping(value = "/regular/myRes", method = RequestMethod.GET)
    public String myRes(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("activeReservations",  reservationViewRepository.findActive(user.getId()));
        model.addAttribute("inactiveReservations",  reservationViewRepository.findInactive(user.getId()));
        model.addAttribute("user", userService.getUserById(user.getId()));
        model.addAttribute("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        return "regular/myRes";
    }

    @RequestMapping(value = "/regular/cancelRes/{id}", method = RequestMethod.GET)
    public String cancelRes(@PathVariable("id") int id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        reservationRepository.cancelReservation(id);
        myRes(model);
        return "regular/myRes";
    }
}