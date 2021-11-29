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
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getEmployerPhone() {
        return employerPhone;
    }

    public void setEmployerPhone(long employerPhone) {
        this.employerPhone = employerPhone;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    
    
    
}
