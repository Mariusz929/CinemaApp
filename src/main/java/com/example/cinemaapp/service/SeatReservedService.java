package com.example.cinemaapp.service;

import com.example.cinemaapp.model.SeatReserved;
import java.util.List;

public interface SeatReservedService {
    public SeatReserved findSeatReservedById(int id);
    public  void saveSeatReserved(SeatReserved movie);
    public SeatReserved getSeatReservedById(int id);
    public List<SeatReserved> getAllSeatsReserved(); //???
}