package com.test.BillSpliter.Services;

import com.test.BillSpliter.beans.GroupMember;
import com.test.BillSpliter.beans.User;
import com.test.BillSpliter.repository.GroupMemberRepository;
import com.test.BillSpliter.repository.GroupRepository;
import com.test.BillSpliter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;


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


    public void addUser(User user)
    {
        User isUserExist = userRepository.getUserByPhoneNumber(user.getPhoneNumber());
        if(isUserExist == null)
        {
            userRepository.save(user);
        }
        else
        {
            User u = userRepository.findById(isUserExist.getId()).orElse(new User());
            u.setFullName(user.getFullName());
            u.setUserName(user.getUserName());
            u.setPassword(user.getPassword());
            userRepository.save(u);
        }
    }

    public User getUserByPhoneNumber(String phoneNumber)
    {
      User user = userRepository.getUserByPhoneNumber(phoneNumber);
      return user;
    }

    public User getUserByName(String name)
    {
        User user = userRepository.getUserByName(name);
        return user;
    }

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
