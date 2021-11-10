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
public class CreditCardApplication extends BaseApplication {

    int requestedCreditLimit;
    String cardType;
    List<Borrower> borrowers = new ArrayList<Borrower>();

    public CreditCardApplication() {
        this.requestedCreditLimit = 5000;
        this.cardType = "VISA";
        
    }
//-------------test
    public void fillBorrowers(){
        for (int i = 0; i < 10; i++) {
            
            Borrower b = new Borrower();
            String s = Integer.toString(i);
            b.setFirstName(b.getFirstName()+ s);
            b.setLastName(b.getLastName() + s);
            b.fillEmploye();
            this.borrowers.add(b);
            
        }
        
        
    }
    
    
//-------------test
    
    
    
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

    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }
       
}
