package com.test.BillSpliter.beans;



import javax.persistence.*;
import java.io.Serializable;

@Entity @IdClass(GroupMemberIDClasses.class)
public class GroupMember implements Serializable {

    @Id
    private int groupID;

    @Id
    private int userID;

    @Column(length = 20)
    private String groupName;



    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }




}
class GroupMemberIDClasses implements Serializable {
    int groupID;
    int userID;
}

