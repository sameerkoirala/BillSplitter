package com.test.BillSpliter.Services;

import com.test.BillSpliter.beans.BillingDetails;
import com.test.BillSpliter.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillingServices {

    private BillingRepository billingRepository;
    @Autowired
    public BillingServices(BillingRepository billingRepository)
    {
        this.billingRepository = billingRepository;
    }

    public void addToBillingDetails(BillingDetails billingDetails)
    {
        billingRepository.save(billingDetails);
    }

    public ArrayList<BillingDetails> getBillingDetails(String groupName)
    {
        ArrayList<BillingDetails> bdList = new ArrayList<BillingDetails>();
        bdList = billingRepository.getBillingDetails(groupName);
        return bdList;
    }

    public void removeBillingDetails(int id)
    {
        billingRepository.remove(id);
    }

    public ArrayList<BillingDetails> getAllBillingData()
    {
        return  billingRepository.getAllBillingData();
    }

}
