package com.test.BillSpliter.controller;

import com.test.BillSpliter.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String goHome()
    {
        return "index";
    }
    @GetMapping("/signup")
    public String goSignup()
    {
        return "signup";
    }
    @ModelAttribute("newuser")
    public User getDefaultUser()
    {
        return  new User();
    }
}
