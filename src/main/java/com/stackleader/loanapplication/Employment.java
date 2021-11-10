/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stackleader.loanapplication;
import java.util.Date;

/**
 *
 * @author intern
 */
public class Employment {
    Date startDate;
    Date endDate;
    String employerName;
    long employerPhone;

    public Employment() {
        this.startDate = new Date(2019,10,10);
        this.endDate = new Date(2021,10,1);
        this.employerName= "Stack Leader";
        this.employerPhone = 7049315330L;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    
    
    
}
