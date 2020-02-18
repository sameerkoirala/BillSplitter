package com.test.BillSpliter.controller;

import com.test.BillSpliter.Services.UserServices;
import com.test.BillSpliter.beans.User;
import com.test.BillSpliter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserServices userServices;


    @PostMapping("/registeruser")
    public String registerUser(@ModelAttribute("newuser")User user)
    {
       userServices.addUser(user);
        return "Login";
    }

}
