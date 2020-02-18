package com.test.BillSpliter.controller;

import com.test.BillSpliter.Services.GroupServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.Map;


@Controller
public class CreateGroupController {

    @Autowired
    private GroupServices groupServices;

    @PostMapping("/createGroup")
    public  ModelAndView createGroup(@RequestParam Map<String,String> allParams){

        groupServices.createGroup(allParams);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/addmember")
    public ModelAndView addmember(@RequestParam("name") String name, @RequestParam (required = false)  String number, @RequestParam() String groupName)
    {
        groupServices.addMemberToGroup(number,groupName,name);
        return new ModelAndView("redirect:/home");
    }


}
