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

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupMemberRepository groupMemberRepository;

    private ArrayList<User> userList;
    private ArrayList<String> groupNameList;

    public void createGroup(Map<String,String> formDetails) {

        String groupName = formDetails.get("gName");
        groupName = groupName.toLowerCase();
        //searching the groups table for the groupname
        GroupsList dbsearchResult = (groupRepository.searchGroup(groupName));

        GroupMember groupMember = new GroupMember();
        GroupsList groups = new GroupsList();

        List<GroupsList> groupList = new ArrayList<GroupsList>();

        if (dbsearchResult == null) {

            userList = new ArrayList<User>();
            userList = userRepository.getAllUser();
            quickSort(userList, 0, userList.size() - 1);

            groupList = groupRepository.getAllMembers();

            int i = 0;
            int groupID = 0;
            String profileName = formDetails.get("profileName");

            for (Map.Entry<String, String> s : formDetails.entrySet()) {
                if (i > 0 && i< formDetails.size()-2) { //running the loops only for the user names
                    for (User u : userList) {
                        if (s.getValue().equalsIgnoreCase(u.getPhoneNumber())) { //comparing the entered user phonenumber with db phonenumber
                            if (i == 1) {
                                groupMember.setUserID(u.getId());
                                if (groupList.size() != 0) {
                                    groupID = groupList.get(0).getGroupId() + 1;
                                }
                                groupMember.setGroupID(groupID);
                                groups.setGroupId(groupID);
                                groupMemberRepository.save(groupMember);
                                groupRepository.save(groups);
                                break;
                            } else {
                                groupMember.setUserID(u.getId());
                                groupMember.setGroupID(groupID);
                                groupMemberRepository.save(groupMember);
                                break;
                            }
                        }
                    }
                }
                else if(i == formDetails.size()-2)
                {
                    int profileUserId = userRepository.getUserId(profileName).getId();
                    groupMember.setUserID(profileUserId);
                    groupMember.setGroupID(groupID);
                    groupMemberRepository.save(groupMember);
                }
                else if(i == 0){
                    groups.setGroupName(s.getValue());
                }
                i++;
            }


        } else {
            System.out.println("group Already exist");
        }

        System.out.println("this is " + formDetails);
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
