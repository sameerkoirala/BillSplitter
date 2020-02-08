package com.test.BillSpliter.controller;

import com.test.BillSpliter.Component.SplittingBills;
import com.test.BillSpliter.beans.BillingDetails;
import com.test.BillSpliter.beans.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class BillingController {


    private SplittingBills splittingBills;

    @Autowired
    public BillingController(SplittingBills splittingBills){
        this.splittingBills = splittingBills;

    }
    @PostMapping("/billDetails")
    public ModelAndView getBillingDetails(@ModelAttribute("newBillingDetails")BillingDetails bd,RedirectAttributes redirectAttributes)
    {
         ArrayList<BillingDetails> billingDetailsList = splittingBills.addBillingDetailsList(bd);
            redirectAttributes.addFlashAttribute("billdetails",billingDetailsList);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/remove")
    public ModelAndView deleteList(@RequestParam("id")int ID,RedirectAttributes redirectAttributes, HttpSession session)
    {
        ArrayList<BillingDetails> bdLists = splittingBills.removeBillingDetailsList(ID, session.getAttribute("groupName").toString());
        redirectAttributes.addFlashAttribute("billdetails",bdLists);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/calculate")
    public ModelAndView finalizedBill(RedirectAttributes redirectAttributes, HttpSession session)
    {
        ArrayList<BillingDetails> billingDetailsList = splittingBills.getBillingDetailsList();
        redirectAttributes.addFlashAttribute("billdetails",billingDetailsList);
        Map<String,ArrayList<Person>> calData = splittingBills.finalizedBilling(session.getAttribute("groupName").toString());
        redirectAttributes.addFlashAttribute("data",calData);
        return new ModelAndView("redirect:/home");
    }
}
