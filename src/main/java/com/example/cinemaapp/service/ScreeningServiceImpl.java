package com.example.cinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cinemaapp.model.Screening;
import com.example.cinemaapp.repository.ScreeningRepository;
import java.util.List;

@Service("screeningService")
public class ScreeningServiceImpl implements ScreeningService {

    @Autowired
    private final ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @Override
    public Screening findScreeningById(int id) {
        return screeningRepository.findById(id);
    }

    @Override
    public void saveScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    @Override
    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }

    @Override
    public Screening getScreeningById(int id) {
        return screeningRepository.findOne((long) id);
    }

}
