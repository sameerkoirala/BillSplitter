package com.test.BillSpliter.Services;

import com.test.BillSpliter.beans.GroupMember;
import com.test.BillSpliter.beans.User;
import com.test.BillSpliter.repository.GroupMemberRepository;
import com.test.BillSpliter.repository.GroupRepository;
import com.test.BillSpliter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;


@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupMemberRepository groupMemberRepository;


    private ArrayList<Integer> userIdList ;
    private ArrayList<String> nameList ;


    public User getUserByUsername(String username)
    {
        return userRepository.getUserByUserName(username);

    }
    public ArrayList<String> userNameList(String groupName)
    {

        userIdList = new ArrayList<Integer>();
        nameList = new ArrayList<String>();
            userIdList = groupMemberRepository.UserIdList(groupRepository.searchGroup(groupName).getGroupId());
            for (Integer id : userIdList) {

                nameList.add(userRepository.getUserById(id).getFullName());
            }

        return nameList;
    }





}
