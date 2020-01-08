package com.example.cinemaapp.service;

import java.util.List;
import com.example.cinemaapp.model.Screening;

public interface ScreeningService {
        public Screening findScreeningById(int id);
        public  void saveScreening(Screening screening);
        public List<Screening> getAllScreenings();
        public Screening getScreeningById(int id);
}
