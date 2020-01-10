package com.test.BillSpliter.repository;

import com.test.BillSpliter.beans.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group,Integer> {


}
