package com.test.BillSpliter.repository;

import com.test.BillSpliter.beans.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {


    @Query("select u from User u ")
    public ArrayList<User> getAllUser();

//    @Query("Select u from User u  where u.fullName like %:name% ")
//    public List<User> searchUser(@Param("name") String name);
    @Query("select u from User u where u.userName = :username")
    public User getUserByUserName(@Param("username")String username);

    @Query("select u from User u where u.id = :id")
    public User getUserById(@Param("id")int id);
}
