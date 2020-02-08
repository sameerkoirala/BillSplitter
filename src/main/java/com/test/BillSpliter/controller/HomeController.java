package com.test.BillSpliter.controller;

import com.test.BillSpliter.beans.Login;
import com.test.BillSpliter.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/signup")
    public String goSignup()
    {
        return "signup";
    }

    @GetMapping("/Login")
    public String goLogin(){return "Login";}


}
