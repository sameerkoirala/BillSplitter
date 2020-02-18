package com.test.BillSpliter.Services;

import com.test.BillSpliter.beans.GroupMember;
import com.test.BillSpliter.beans.GroupsList;
import com.test.BillSpliter.beans.User;
import com.test.BillSpliter.repository.GroupMemberRepository;
import com.test.BillSpliter.repository.GroupRepository;
import com.test.BillSpliter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class GroupServices {


    private GroupRepository groupRepository;
    private GroupMemberRepository groupMemberRepository;
    private  UserServices userServices;
    private ArrayList<String> groupNameList;

    @Autowired
    private GroupServices(UserServices userServices,GroupRepository groupRepository, GroupMemberRepository groupMemberRepository)
    {
        this.groupRepository = groupRepository;
        this.groupMemberRepository = groupMemberRepository;
        this.userServices = userServices;

    }

    public void createGroup(Map<String,String> formDetails) {

        String groupName = formDetails.get("gName");
        groupName = groupName.toLowerCase();
        //searching the groups table for the groupname
        GroupsList dbsearchResult = (groupRepository.searchGroup(groupName));

        GroupMember groupMember = new GroupMember();
        GroupsList groups = new GroupsList();

        List<GroupsList> groupList = new ArrayList<GroupsList>();

        if (dbsearchResult == null) {

//            userList = userRepository.getAllUser();
//            quickSort(userList, 0, userList.size() - 1);

            groupList = groupRepository.getAllMembers();

            int i = 0;
            int groupID = 0;
            String profileName = formDetails.get("profileName");

            for (Map.Entry<String, String> s : formDetails.entrySet()) {
                if (i > 0 && i< formDetails.size()-2) { //running the loops only for the user names

                        if(i ==1)
                        {
                            if (groupList.size() != 0) {
                                groupID = groupList.get(0).getGroupId() + 1;
                            }
                            groupMember.setGroupID(groupID);
                            groups.setGroupId(groupID);
                            groupRepository.save(groups);
                        }
                         User user= userServices.getUserByPhoneNumber(s.getValue());
                         if (user != null) {
                             groupMember.setUserID(user.getId());
                             groupMemberRepository.save(groupMember);
                         }
                         else
                         {
                             User newUser = new User();
                             newUser.setFullName(s.getValue()+" (GuestUser)");
                             newUser.setPhoneNumber(s.getValue());
                             userServices.addUser(newUser);

                             User newUserId= userServices.getUserByPhoneNumber(s.getValue());
                             groupMember.setUserID(newUserId.getId());
                             groupMemberRepository.save(groupMember);
                         }
                }
                else if(i == formDetails.size()-2)
                {
                    int profileUserId = userServices.getUserByName(profileName).getId();
                    groupMember.setUserID(profileUserId);
                    groupMemberRepository.save(groupMember);
                }
                else if(i == 0){
                    groups.setGroupName(s.getValue());
                }
                i++;
            }


        }
        else {
            System.out.println("group Already exist");
        }

    }

    public ArrayList<String> getGroupNameList(int userId)
    {
        groupNameList = new ArrayList<String>();
        ArrayList<Integer> groupId = groupMemberRepository.groupId(userId);
        if(groupId.size() != 0 ) {
            for (Integer id : groupId) {
                groupNameList.add(groupRepository.groupListById(id));
            }
        }
        return groupNameList;
    }

    public void addMemberToGroup(String phoneNumber, String groupName, String name)
    {
        User user= userServices.getUserByPhoneNumber(phoneNumber);
        int groupId =groupRepository.searchGroup(groupName).getGroupId();
        GroupMember groupMem= new GroupMember();
        groupMem.setGroupID(groupId);

        if(user != null)
        {
            groupMem.setUserID(user.getId());
            groupMemberRepository.save(groupMem);
        }
        else
        {
            User newUser = new User();
            newUser.setFullName(name);
            newUser.setPhoneNumber(phoneNumber);
            userServices.addUser(newUser);

            User newUserId= userServices.getUserByPhoneNumber(phoneNumber);
            groupMem.setUserID(newUserId.getId());
            groupMemberRepository.save(groupMem);
        }

    }
}
