package com.example.cinemaapp.service;

import com.example.cinemaapp.model.Auditorium;
import com.example.cinemaapp.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    @Autowired
    private final AuditoriumRepository auditoriumRepository;

    @Autowired
    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    @Override
    public Auditorium findAuditoriumByName(String name) {
        return auditoriumRepository.findByName(name);
    }

    @Override
    public void saveAuditorium(Auditorium auditorium) {
        auditoriumRepository.save(auditorium);
    }

    @Override
    public List<Auditorium> getAllAuditoriums() {
        return auditoriumRepository.findAll();
    }

    @Override
    public Auditorium getAuditoriumById(int id) {
        return auditoriumRepository.findOne((long) id);
    }

}

