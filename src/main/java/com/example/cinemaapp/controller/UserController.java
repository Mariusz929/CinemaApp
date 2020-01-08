package com.example.cinemaapp.controller;

import com.example.cinemaapp.model.User;
import com.example.cinemaapp.repository.UserRepository;
import com.example.cinemaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/admin/users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("adminMessage", "Content Available Only for Users with Admin Role");
        return "admin/users";
    }

    @RequestMapping(path = "/regular/profile", method = RequestMethod.GET)
    public String ReadProfile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("user", userService.getUserById(user.getId()));
        model.addAttribute("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        return "regular/profile";
    }

    @RequestMapping(value = "/regular/editProfile/{id}", method = RequestMethod.GET)
    public String profileedit(@PathVariable("id") Long id, ModelMap model) {
        model.put("edituser", userService.getUserById(id));
        return "/regular/editProfile";

    }

    @RequestMapping(value = "regular/editProfile", method = RequestMethod.POST)
    public String saveProfile(@ModelAttribute("edituser") User edituser, BindingResult result, ModelMap model) {
        model.addAttribute("successMessage", "Profile  Data Edited Successfully");
        if (result.hasErrors()) {
            return "/error";
        }
        edituser.setPassword(bCryptPasswordEncoder.encode(edituser.getPassword()));
        userRepository.save(edituser);
        return "regular/editProfile";
    }

    @RequestMapping(value = "/admin/editUser/{id}", method = RequestMethod.GET)
    public String useredit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("adminMessage", "Content Available Only for Users with Admin Role");
        model.put("edituser", userService.getUserById(id));
        return "/admin/editUser";

    }

    @RequestMapping(value = "admin/editUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("edituser") User edituser, BindingResult result, ModelMap model) {
        model.addAttribute("successMessage", "User  Data Edited Successfully");
        model.addAttribute("adminMessage", "Content Available Only for Users with Admin Role");
        if (result.hasErrors()) {
            return "/error";
        }
        edituser.setPassword(bCryptPasswordEncoder.encode(edituser.getPassword()));
        userRepository.save(edituser);
        return "admin/editUser";
    }
}

