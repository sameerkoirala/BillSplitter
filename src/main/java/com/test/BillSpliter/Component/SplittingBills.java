package com.test.BillSpliter.Component;


import com.test.BillSpliter.Services.BillingServices;
import com.test.BillSpliter.beans.BillingDetails;
import com.test.BillSpliter.beans.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;


@Component
public class SplittingBills {


    private double splitedAmount;
    private Map<String, ArrayList<Person>> settlementList;
    private ArrayList<BillingDetails> billingDetailList;
    private DecimalFormat decimalFormat ;
    private BillingServices billingServices;


    @Autowired
    public SplittingBills(BillingServices billingServices) {
        this.billingServices = billingServices;
        billingDetailList = new ArrayList<BillingDetails>();
        decimalFormat = new DecimalFormat("#.00");
    }

    public Map<String, ArrayList<Person>> finalizedBilling(String groupName)
    {
        billingDetailList = billingServices.getBillingDetails(groupName);
        settlementList = new HashMap<String, ArrayList<Person>>();
        for(BillingDetails bd:billingDetailList)
        {
            splitting(bd);
        }

        ArrayList<String> keyList = new ArrayList<String>();
        for(String key:settlementList.keySet())
        {
           keyList.add(key);
        }
        for(String k: keyList) {
            String key1 = k;
            ArrayList<Person> value1 = settlementList.get(key1);
            if(value1 != null) {
                for (int j = 0; j < value1.size(); j++) {
                    if (settlementList.get(value1.get(j).getName()) != null) {
                        j = settlementCalculation(value1, settlementList.get(value1.get(j).getName()), value1.get(j).getAmount(), j, key1);
                    }
                }
            }
        }
        return settlementList;
    }

    public int settlementCalculation(ArrayList<Person> personList1, ArrayList<Person> personList2,double amount,int index,String key1)
    {
        int returnIndex = index;
        double amountToBeReduce  = personList1.get(index).getAmount();
        String key2 =personList1.get(index).getName();
        outterloop:
        for(int i =0 ; i< personList1.size();i++)
        {
            for(int j = 0 ; j<personList2.size();j++)
            {
                if(personList1.get(i).getName().equalsIgnoreCase(personList2.get(j).getName()))
                {
                    double subAmount =  Double.parseDouble(decimalFormat.format(personList2.get(j).getAmount() - amountToBeReduce)) ;
                    if(subAmount >0)
                    {
                        double calAmount = amountToBeReduce+ personList1.get(i).getAmount();
                        calAmount = Double.parseDouble(decimalFormat.format(calAmount));
                        personList1.get(i).setAmount(calAmount);
                        personList1.remove(index);
                        settlementList.put(key1,personList1);
                         personList2.get(j).setAmount(subAmount);
                         settlementList.put(key2,personList2);
                         returnIndex = index -1;
                         break outterloop;
                    }
                    else
                    {
                        double calAmount = personList2.get(j).getAmount() + personList1.get(i).getAmount();
                        calAmount = Double.parseDouble(decimalFormat.format(calAmount));
                        amountToBeReduce = subAmount * -1;
                        personList1.get(i).setAmount(calAmount);
                        personList1.get(index).setAmount(subAmount*(-1));
                        settlementList.put(key1,personList1);
                        personList2.remove(j);
                        if(personList2.size() == 0)
                        {
                            settlementList.remove(key2);
                            break outterloop;
                        }
                        else
                        {
                            settlementList.put(key2,personList2);
                        }
                    }

                }
            }
        }
        return returnIndex;
    }

    public void splitting(BillingDetails bd) {
        BillingDetails billingDetails = bd;
        String paidByName = billingDetails.getPaidBy();;
       String[] nameList = billingDetails.getSplitedOn().split(",");


        if (nameList.length != 0) {
            splitedAmount = billingDetails.getSpittedAmount();
            for (String s : nameList) {
                if (!(s).trim().equalsIgnoreCase(paidByName.trim())) {
                    double newAmount = 1;
                    if (settlementList.get(s.trim()) != null) {
                        newAmount = reduceAmount(paidByName, s, splitedAmount);
                    }
                    if (newAmount > 0) {
                        if (settlementList.size() == 0 || settlementList.get(paidByName) == null) {
                            ArrayList<Person> personList = new ArrayList<Person>();
                            personList.add(new Person(s, splitedAmount));
                            settlementList.put(paidByName, personList);
                        } else {
                            ArrayList<Person> pList = new ArrayList<Person>();

                            pList = settlementList.get(paidByName);
                            for (int i = 0; i < pList.size(); i++) {
                                if (pList.get(i).getName().equalsIgnoreCase(s)) {
                                    Person p = pList.get(i);
                                    p.setAmount(pList.get(i).getAmount() + splitedAmount);
                                    pList.set(i, p);
                                    settlementList.put(paidByName, pList);
                                    break;
                                } else if (i == pList.size() - 1) {
                                    pList.add(new Person(s, splitedAmount));
                                    settlementList.put(paidByName, pList);
                                    break;
                                }
                            }
                        }
                    } else if (newAmount < 0) {
                        ArrayList<Person> pList = new ArrayList<Person>();
                        if(settlementList.get(paidByName) != null) {pList = settlementList.get(paidByName);}
                        newAmount = newAmount * -1;
                        pList.add(new Person(s, newAmount));
                        settlementList.put(paidByName, pList);
                    }

                }
            }
        }
    }


    public double reduceAmount(String paidByName, String personName, double amount) {
        double result = 1;
        ArrayList<Person> people = new ArrayList<Person>();
        people = settlementList.get(personName);
        for (int i = 0; i < people.size(); i++) {

            if (people.get(i).getName().equalsIgnoreCase(paidByName.trim())) {
                double newAmount = people.get(i).getAmount() - amount;
                if (newAmount > 0) {
                    people.get(i).setAmount(newAmount);
                    people.set(i, people.get(i));
                    settlementList.put(personName, people);
                    result = 0;
                    break;
                } else {
                    people.remove(i);
                    settlementList.put(personName, people);
                    result = newAmount;
                }
            }

        }
        return result;
    }

    public ArrayList<BillingDetails> addBillingDetailsList(BillingDetails bd)
    {
        String[] splittedPeople = bd.getSplitedOn().split(",");
        double splitAmount = Double.parseDouble(decimalFormat.format((Double.parseDouble(bd.getAmount()))/splittedPeople.length));
        int id = (((billingServices.getAllBillingData()).size() == 0) ? 1 : billingServices.getAllBillingData().get(0).getTransId()+1) ;
        billingServices.addToBillingDetails(new BillingDetails(id,splitAmount,bd.getDescription(),bd.getAmount(),bd.getPaidBy(),bd.getSplitedOn(),bd.getDate(),bd.getGroupName()));
        return billingDetailList;
    }

    public ArrayList<BillingDetails> removeBillingDetailsList(int id,String groupName)
    {
       billingServices.removeBillingDetails(id);
       billingDetailList = billingServices.getBillingDetails(groupName);
        return billingDetailList;
    }
    public ArrayList<BillingDetails> getBillingDetailsList()
    {
        return billingDetailList;
    }
    public Map<String,ArrayList<Person>> getSettlementList(){return settlementList;}

}
