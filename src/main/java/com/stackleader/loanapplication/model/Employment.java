/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stackleader.loanapplication.model;
import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

/**
 *
 * @author intern
 */
public class Employment {
    
    @Id
    @GeneratedValue
    long id;
    
    @Past(message = "Invalid Start Date")
    LocalDate startDate;
    
    @PastOrPresent(message = "invalid End date")
    LocalDate endDate;
    
    @Size(min = 3)
    @NotEmpty(message = "Missing Employer name")
    String employerName;
    
    @Min(value=1000000000, message = "Not a valid Phone number ") @Max(value = 999999999, message = "not a valid Phone number")
    long employerPhone;

    public Employment() {
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

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
    
}
