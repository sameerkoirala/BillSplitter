package com.test.BillSpliter.controller;

import com.test.BillSpliter.Services.GroupCreationServices;
import com.test.BillSpliter.beans.GroupMember;
import com.test.BillSpliter.beans.User;
import com.test.BillSpliter.repository.GroupRepository;
import com.test.BillSpliter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class CreateGroupController {

    @Autowired
    private GroupCreationServices groupCreationServices;

    @PostMapping("/createGroup")
    public  String createGroup(@RequestParam Map<String,String> allParams){

        groupCreationServices.createGroup(allParams);
        return "index";
    }

//    @PostMapping("/addmember")
//    public String addmember(@RequestParam("name") String name, @RequestParam (required = false)  String number)
//    {
//       userList = new ArrayList<User>();
//      //  userList = userRepository.searchUser(name);
//
//
//        if(userList.size() != 0 && number != "")
//        for (User u: userList) {
//            if(Integer.parseInt(u.getPhoneNumber()) == Integer.parseInt(number))
//            {
//
//            }
//
//        }
//        return "/home";
//    }


}
