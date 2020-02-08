package com.test.BillSpliter.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class BillingDetails {

    @Id
    private int transId;
    private double spittedAmount;
    private String description;
    private String amount;
    private String paidBy;
    private String splitedOn ;
    private String date;
    private String groupName;


    public BillingDetails(){}

    public BillingDetails(int transId, double spittedAmount, String description, String amount, String paidBy, String splitedOn,String date,String groupName) {
        this.spittedAmount = spittedAmount;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitedOn = splitedOn;
        this.date = date;
        this.transId = transId;
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSpittedAmount() {
        return spittedAmount;
    }

    public void setSpittedAmount(double itemName) {
        this.spittedAmount = spittedAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public String getSplitedOn() {
        return splitedOn;
    }

    public void setSplitedOn(String splitedOn) {
        this.splitedOn = splitedOn;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

}
