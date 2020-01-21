package com.test.BillSpliter.controller;

import com.test.BillSpliter.Services.UserServices;
import com.test.BillSpliter.beans.GroupMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

@Controller
public class UserProfileController {

    @Autowired
    private UserServices userServices;

    @GetMapping({"/","/home"})
    public String userProfile(@SessionAttribute("userName") String username, Model model)
    {
        int id = userServices.getUserByUsername(username).getId();
        model.addAttribute("name",userServices.getUserByUsername(username).getFullName());
        ArrayList<String> nameList = new ArrayList<String>();
        nameList = userServices.userGroupList(id);
        model.addAttribute("nameLists",nameList);
       model.addAttribute("groupName",userServices.getGroupNameList());
        return "index";

    }

    @GetMapping({"/groupDetails"})
    public String userGroupDetails(@RequestParam("groupName") String groupName)
    {
        System.out.println("Group Name is :"+groupName);
        return "index";
    }
}
