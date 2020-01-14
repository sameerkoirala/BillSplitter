package com.test.BillSpliter.controller;

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
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;

    private  ArrayList<User> userList ;
    @PostMapping("/createGroup")
    public  String createGroup(@RequestParam Map<String,String> allParams){

        String groupName = allParams.get("gName");
        GroupMember dbsearchResult = (groupRepository.searchGroup(groupName));
        GroupMember group = new GroupMember();
        List<GroupMember> groupList = new ArrayList<GroupMember>();
        if(dbsearchResult == null) {

            userList = new ArrayList<User>();
            userList = userRepository.getAllUser();
            quickSort(userList, 0, userList.size() - 1);

            groupList = groupRepository.getAllMembers();

            Boolean result = false;
            int i = 0;
            int groupID = 0;
            for (Map.Entry<String, String> s : allParams.entrySet()) {
                if(i != 0) {
                    for (User u : userList) {
                        if (s.getValue().equalsIgnoreCase(u.getPhoneNumber())) {
                            if(i == 1)
                            {
                                group.setUserID(u.getId());
                                if(groupList.size() != 0)
                                {
                                   groupID = groupList.get(0).getGroupID() + 1;
                                }
                                group.setGroupID(groupID);
                                groupRepository.save(group);
                            }
                            else
                            {
                                group.setUserID(u.getId());
                                group.setGroupID(groupID);
                                groupRepository.save(group);
                            }
                        }

                    }
                }
                else
                {
                    group.setGroupName(s.getValue());
                }
                i++;
            }


        }
        else
        {
            System.out.println("group ALready exist");
        }

        System.out.println("this is " + allParams);

        return "/home";
    }

    @PostMapping("/addmember")
    public String addmember(@RequestParam("name") String name, @RequestParam (required = false)  String number)
    {
       userList = new ArrayList<User>();
      //  userList = userRepository.searchUser(name);


        if(userList.size() != 0 && number != "")
        for (User u: userList) {
            if(Integer.parseInt(u.getPhoneNumber()) == Integer.parseInt(number))
            {

            }

        }
        return "/home";
    }

    public void quickSort(ArrayList<User> list, int left, int right)
    {
        if(left <right)
        {
            int pivotIndex = partition( list, left,  right);
            quickSort(list,left,pivotIndex-1);
            quickSort(list,pivotIndex +1, right);
        }
    }


    public int partition(ArrayList<User> list, int left, int right)
    {
        int mid = (left+right)/2 ;
        int pivot = Integer.parseInt(list.get(mid).getPhoneNumber());
        swap(list, mid, right);

        while(left < right)
        {
            while(left <right && Integer.parseInt(list.get(left).getPhoneNumber()) <= pivot)
            {
                left++ ;
            }

            if(left < right)
            {
                swap(list,left,right);
                right --;
            }

            while(right > left && Integer.parseInt( list.get(right).getPhoneNumber()) >= pivot)
            {
                right --;
            }

            if(right > left)
            {
                swap(list,left,right);
                left ++;
            }
        }
        return left;
    }

    public void swap(ArrayList<User>list,int a , int b)
    {
        User temp = list.get(a);
        list.set(a,list.get(b));
        list.set(b,temp);
    }
}
