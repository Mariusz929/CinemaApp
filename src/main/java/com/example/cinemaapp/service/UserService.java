package com.example.cinemaapp.service;

import com.example.cinemaapp.model.User;
import java.util.List;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
    public List<User> getAllUsers();
    public User getUserById(long id);
}