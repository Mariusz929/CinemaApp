package com.example.cinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cinemaapp.model.SeatReserved;
import com.example.cinemaapp.repository.SeatReservedRepository;
import java.util.List;

@Service
public class SeatReservedServiceImpl implements SeatReservedService {

    @Autowired
    private final SeatReservedRepository seatReservedRepository;

    @Autowired
    public SeatReservedServiceImpl(SeatReservedRepository seatReservedRepository) {
        this.seatReservedRepository = seatReservedRepository;
    }

    @Override
    public SeatReserved findSeatReservedById(int id) {
        return seatReservedRepository.findById(id);
    }

    @Override
    public void saveSeatReserved(SeatReserved seatReserved) {
        seatReservedRepository.save(seatReserved);
    }

    @Override
    public List<SeatReserved> getAllSeatsReserved() {
        return seatReservedRepository.findAll();
    }

    @Override
    public SeatReserved getSeatReservedById(int id) {
        return seatReservedRepository.findOne((long) id);
    }

}