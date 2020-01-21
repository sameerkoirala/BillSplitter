package com.test.BillSpliter.Services;

import com.test.BillSpliter.beans.GroupMember;
import com.test.BillSpliter.beans.User;
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

    private ArrayList<String> groupNameList;
    private ArrayList<GroupMember> groupListOfUser ;
    private ArrayList<String> nameList ;


    public User getUserByUsername(String username)
    {
        return userRepository.getUserByUserName(username);

    }
    public ArrayList<String> userGroupList(int userId)
    {
        groupNameList = new ArrayList<String>();
        groupListOfUser = new ArrayList<GroupMember>();
        nameList = new ArrayList<String>();
        int groupId = groupRepository.groupId(userId);
        groupListOfUser = groupRepository.groupListById(groupId);
        for (GroupMember g:groupListOfUser) {

            nameList.add(userRepository.getUserById(g.getUserID()).getFullName());
            groupNameList.add(g.getGroupName());
        }
        return nameList;
    }
    public ArrayList<String> getGroupNameList()
    {
        return groupNameList;
    }



}
