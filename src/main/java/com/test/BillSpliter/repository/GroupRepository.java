package com.test.BillSpliter.repository;


import com.test.BillSpliter.beans.GroupMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<GroupMember,Integer> {


    @Query("Select g from GroupMember g order by g.groupID desc")
   public List<GroupMember> getAllMembers();
    @Query("Select g from GroupMember g where g.groupName = :gname")
    public GroupMember searchGroup(@Param("gname") String gname);
}
