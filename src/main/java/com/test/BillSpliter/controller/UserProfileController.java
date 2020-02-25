package com.test.BillSpliter.controller;

import com.test.BillSpliter.Services.BillingServices;
import com.test.BillSpliter.Services.GroupServices;
import com.test.BillSpliter.Services.UserServices;
import com.test.BillSpliter.beans.BillingDetails;
import com.test.BillSpliter.beans.GroupMember;
import com.test.BillSpliter.beans.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Callable;

@Controller
public class UserProfileController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private GroupServices groupServices;
    @Autowired
    private BillingServices billingServices;


    @GetMapping({"/","/home"})
    public Callable<String> userProfile(Model model, HttpSession session)
    {
        return ()->{
            String username = session.getAttribute("userName").toString();
            int id = userServices.getUserByUsername(username).getId();
            model.addAttribute("name",userServices.getUserByUsername(username).getFullName());
            model.addAttribute("groupName",groupServices.getGroupNameList(id));

            if(session.getAttribute("groupName") != null) {
                String groupName = session.getAttribute("groupName").toString();
                ArrayList<String> nameList = new ArrayList<String>();
                nameList = userServices.userNameList(groupName);
                model.addAttribute("nameLists",nameList);
                model.addAttribute("gName",groupName);
                ArrayList<BillingDetails> list = billingServices.getBillingDetails(groupName);
                if(list !=null) {
                    model.addAttribute("billingDetailsList",list);

                }
            }
            Map<String,ArrayList<Person>> getdata = (Map<String,ArrayList<Person>>) model.asMap().get("data");
            if (getdata != null)
            {
                model.addAttribute("data",getdata);
            }

            return "index";
        };


    }

    @GetMapping({"/groupDetails"})
    public ModelAndView userGroupDetails(@RequestParam("groupName") String groupName, HttpSession session)
    {
        session.setAttribute("groupName",groupName);
        return new ModelAndView("redirect:/home");
    }


}
