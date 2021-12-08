/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stackleader.loanapplication.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 *
 * @author intern
 */
public class BaseApplication {
    @Id
    @GeneratedValue
    private long id;
    
    @Max(value = 10000, message = "Value must be under or at 100000") @Positive(message = "Value must be positive")
    private int requestedCreditLimit;
    
    @NotEmpty(message = "you must enter a card type")
    @Size(min = 1,message = "You must enter a valid credit card name")
    private String cardType;
    
    @NotEmpty(message = "you must specify a lend type")
    private String lendType;

    @Valid
    private List<Borrower> borrowers = new ArrayList<Borrower>();



    public String getLendType() {
        return lendType;
    }

    public void setLendType(String lendType) {
        this.lendType = lendType;
    }
    
    
    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRequestedCreditLimit() {
        return requestedCreditLimit;
    }

    public void setRequestedCreditLimit(int requestedCreditLimit) {
        this.requestedCreditLimit = requestedCreditLimit;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    
    
    
}
