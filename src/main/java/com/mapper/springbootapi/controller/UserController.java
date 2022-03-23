package com.mapper.springbootapi.controller;

import com.mapper.springbootapi.domain.User;
import com.mapper.springbootapi.service.DbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private DbUser dbUser;

    @Autowired
    public UserController(DbUser dbUser) {
        this.dbUser = dbUser;
    }

    @GetMapping("/register")
    public String enroll(Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }

    @PostMapping("/enroll")
    public String getRegister(User user) {
        dbUser.addUser(user);
        return "/register";
    }


}
