package com.example.cinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cinemaapp.model.ScreeningView;
import com.example.cinemaapp.repository.ScreeningViewRepository;
import java.util.List;

@Service
public class ScreeningViewServiceImpl implements ScreeningViewService {

    @Autowired
    private final ScreeningViewRepository screeningViewRepository;

    @Autowired
    public ScreeningViewServiceImpl(ScreeningViewRepository screeningViewRepository) {
        this.screeningViewRepository = screeningViewRepository;
    }

    @Override
    public ScreeningView findScreeningViewById(int id) {
        return screeningViewRepository.findById(id);
    }

    @Override
    public List<ScreeningView> getAllScreeningViews() {
        return screeningViewRepository.findAll();
    }

    @Override
    public ScreeningView getScreeningViewById(int id) {
        return screeningViewRepository.findOne((long) id);
    }

}
