package com.stackleader.loanapplication.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Abel P
 */
public class Borrower {
    
    @Id
    @GeneratedValue
    long id;
    
    @NotEmpty(message = "You must have a first name")
    @Size(min = 1,message = "First name must be at least 1 character")
    String firstName;
    
    @NotEmpty(message = "You must have a Last name")
    @Size(min = 1,message = "Last name must be ")
    String lastName;
    
    @Min(value=18,message="You must be at least 18 years old")
    int age;
    
    @NotEmpty(message = "You must have an adress")
    @Size(min = 1,message = "Address must have more then one character")
    String address;
    
    @Size(min = 1, message = "City must be more then one Character")
    @NotEmpty(message = "You must have a city")
    String city;
    
    @NotEmpty(message = "You must have a state")
    @Size(min = 1, message = "State must be more then one character")
    String state;
    
    @Min(value=10000, message = "Not a valid Zip code (under)") @Max(value = 99999, message = "not a valid Zip code (to high)")
    int zip;
    
    @Min(value=100000000, message = "Not a valid SSN number ") @Max(value = 999999999, message = "not a valid SSN number")
    int ssn;
    
    
    @NotEmpty(message = "You must put in a relationship")
    String relationship;
    
    @Min(value = 0,message = "NOT ASSOCIATED WITH AN APPLICATION.")
    long appID;
    
    List<Employment> employers = new ArrayList<Employment>();

    //putting in our own information
    public Borrower(String firstName, String lastName, int age, String address, String city, String state, int zip, int ssn, String relationship, long appID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.ssn = ssn;
        this.relationship = relationship;
        this.appID = appID;
    }

    
    
    

    
    
    public Borrower() {
    }
    
    
    
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Trying to make this transent
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    //Transient

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public List<Employment> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employment> employers) {
        this.employers = employers;
    }

    public long getAppID() {
        return appID;
    }

    public void setAppID(long appID) {
        this.appID = appID;
    }
    
    
}
