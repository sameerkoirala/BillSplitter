package com.test.BillSpliter.repository;

import com.test.BillSpliter.beans.BillingDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;


@Repository
public interface BillingRepository extends CrudRepository<BillingDetails,Integer> {

    @Transactional
    @Modifying
    @Query("Delete from BillingDetails b  where b.transId =:id  ")
    public void remove(@Param("id")int id);

    @Query("Select b from BillingDetails b where b.groupName = :groupName order by b.transId desc " )
    public ArrayList<BillingDetails> getBillingDetails(@Param("groupName") String groupName);

    @Query("Select b from BillingDetails b order by b.transId desc " )
    public ArrayList<BillingDetails> getAllBillingData();
}
