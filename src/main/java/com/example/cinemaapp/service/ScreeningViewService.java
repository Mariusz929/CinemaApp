package com.example.cinemaapp.service;

import java.util.List;
import com.example.cinemaapp.model.ScreeningView;

public interface ScreeningViewService {
    public ScreeningView findScreeningViewById(int id);
    public List<ScreeningView> getAllScreeningViews();
    public ScreeningView getScreeningViewById(int id);
}