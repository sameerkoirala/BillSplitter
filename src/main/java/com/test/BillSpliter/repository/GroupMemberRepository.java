package com.test.BillSpliter.repository;


import com.test.BillSpliter.beans.GroupMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface GroupMemberRepository extends CrudRepository<GroupMember,Integer> {
    @Query("Select g.groupID from GroupMember g where g.userID = :userId")
    public ArrayList<Integer>  groupId(@Param("userId") int userId);

    @Query("Select g.userID from GroupMember g where g.groupID = :gId")
    public  ArrayList<Integer> UserIdList(@Param("gId") int gId);
}
