package com.test.BillSpliter.repository;



import com.test.BillSpliter.beans.GroupsList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<GroupsList,Integer> {



    //table groups related query
    @Query("Select g from GroupsList g where g.groupName = :gname")
    public GroupsList searchGroup(@Param("gname") String gname);

    @Query("Select g.groupName from GroupsList g where g.groupId = :gId")
    public  String groupListById(@Param("gId") int gId);

    @Query("Select g from GroupsList g order by g.groupId desc")
    public List<GroupsList> getAllMembers();
}
