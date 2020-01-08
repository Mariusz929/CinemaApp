package com.example.cinemaapp.service;

import com.example.cinemaapp.model.Auditorium;

import java.util.List;

public interface AuditoriumService {
    public Auditorium findAuditoriumByName(String name);
    public  void saveAuditorium(Auditorium auditorium);
    public List<Auditorium> getAllAuditoriums();
    public Auditorium getAuditoriumById(int id);
}