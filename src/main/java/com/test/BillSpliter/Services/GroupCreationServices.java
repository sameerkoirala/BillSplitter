package com.test.BillSpliter.Services;

import com.test.BillSpliter.beans.GroupMember;
import com.test.BillSpliter.beans.User;
import com.test.BillSpliter.repository.GroupRepository;
import com.test.BillSpliter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class GroupCreationServices {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;

    private ArrayList<User> userList;

    public void createGroup(Map<String,String> formDetails) {

        String groupName = formDetails.get("gName");
        groupName = groupName.toLowerCase();
        GroupMember dbsearchResult = (groupRepository.searchGroup(groupName));
        GroupMember group = new GroupMember();
        List<GroupMember> groupList = new ArrayList<GroupMember>();
        if (dbsearchResult == null) {

            userList = new ArrayList<User>();
            userList = userRepository.getAllUser();
            quickSort(userList, 0, userList.size() - 1);

            groupList = groupRepository.getAllMembers();


            int i = 0;
            int groupID = 0;
            int profileUserId = 0;
            String profileName = formDetails.get("profileName");

            for (Map.Entry<String, String> s : formDetails.entrySet()) {
                if (i > 0 && i< formDetails.size()-2) {
                    for (User u : userList) {
                        if (s.getValue().equalsIgnoreCase(u.getPhoneNumber())) {
                            if (i == 1) {
                                group.setUserID(u.getId());
                                if (groupList.size() != 0) {
                                    groupID = groupList.get(0).getGroupID() + 1;
                                }
                                group.setGroupID(groupID);
                                groupRepository.save(group);
                                break;
                            } else {
                                group.setUserID(u.getId());
                                group.setGroupID(groupID);
                                groupRepository.save(group);
                                break;
                            }
                        }
                        else if(u.getFullName().equalsIgnoreCase(profileName)){
                            profileUserId = u.getId();
                        }

                    }
                }
                else if(i == formDetails.size()-2)
                {
                    group.setUserID(profileUserId);
                    group.setGroupID(groupID);
                    groupRepository.save(group);
                }
                else if(i == 0){
                    group.setGroupName(s.getValue());
                }
                i++;
            }


        } else {
            System.out.println("group Already exist");
        }

        System.out.println("this is " + formDetails);
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
