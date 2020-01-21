package com.test.BillSpliter.beans;

import org.springframework.context.annotation.Bean;

import java.util.List;


public class CalculationDetails {

    private String itemName;
    private String description;
    private int amount;
    private String paidBy;
    private List splitedOn;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public List getSplitedOn() {
        return splitedOn;
    }

    public void setSplitedOn(List splitedOn) {
        this.splitedOn = splitedOn;
    }

}
