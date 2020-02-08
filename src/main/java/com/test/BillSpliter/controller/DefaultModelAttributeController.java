package com.test.BillSpliter.controller;


import com.test.BillSpliter.beans.BillingDetails;
import com.test.BillSpliter.beans.Login;
import com.test.BillSpliter.beans.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DefaultModelAttributeController {

    @ModelAttribute("newuser")
    public User getDefaultUser()
    {
        return  new User();
    }

    @ModelAttribute("login")
    public Login getDefaultLogin()
    {
        return  new Login();
    }

    @ModelAttribute("newBillingDetails")
    public BillingDetails getDefaultBillingDetails(){return new BillingDetails();}
}
