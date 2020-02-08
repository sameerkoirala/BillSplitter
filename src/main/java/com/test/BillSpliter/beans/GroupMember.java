package com.test.BillSpliter.beans;



import javax.persistence.*;
import java.io.Serializable;

@Entity @IdClass(GroupMemberIDClasses.class)
public class GroupMember implements Serializable {

    @Id
    private int groupID;

    @Id
    private int userID;

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
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

