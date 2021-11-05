/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stackleader.loanapplication;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author intern
 */
public class CreditCardApplication {
    int requestedCreditLimit;
    String cardType;
    List<Borrower> employers = new ArrayList<Borrower>();

    public CreditCardApplication(int requestedCreditLimit, String cardType) {
        this.requestedCreditLimit = requestedCreditLimit;
        this.cardType = cardType;
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

    public List<Borrower> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Borrower> employers) {
        this.employers = employers;
    }
    
    
    
     
}
