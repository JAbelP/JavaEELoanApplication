package com.stackleader.loanapplication;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author intern
 */
public class Borrower {
    
    @Id
    @GeneratedValue
    //@XmlTransient // This won't work? Check line 8 // TODO
    long id;
    String firstName;
    String lastName;
    int age;
    String address;
    String city;
    String state;
    int zip;
    int ssn;
    String relationship;
    List<Employment> employers = new ArrayList<Employment>();

    //putting in our own information
    public Borrower(String firstName, String lastName, int age, String address, String city, String state, int zip, int ssn, String relationship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.ssn = ssn;
        this.relationship = relationship;
    }

    
    
    
    //----------THIS IS FOR TESTING ONLY.
    
    
    public Borrower() {
        /*325 McGill Avenue, NW, Suite 507
            Concord, NC 28027
            1-704-931-5330
        */
        this.firstName = "Bob";
        this.lastName = "Smith";
        this.age = 25;
        this.address = "325 McGill Avenue, NW, Suite 507";
        this.city = "concord";
        this.state = "NC";
        this.zip = 28027;
        this.ssn = 123456789;
        this.relationship = "Relationship";
        fillEmploye();
    }
    
    public void fillEmploye(){
        
        for (int i = 0; i < 10; i++) {
            Employment e = new Employment();
            String s = Integer.toString(i);
            e.setEmployerName(e.getEmployerName() +  s);
            this.employers.add(e);
            
        }
    }
    
  
    
    
    //-----------------TESTING 
    
    
    
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

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

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
}
