/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stackleader.loanapplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author intern
 */


//create a list to look through each application, using dummy data.


//http://localhost:8080/loan-application
@Path("/cc/applications")
//http://localhost:8080/loan-application/cc/applications
public class LoanApi {
    
    //create a credit card application here for a list of borrowers(?).    
 
    @Produces(MediaType.APPLICATION_JSON)//needs to be a json file
    @GET
    public BaseApplication jsonMessage(){
           //TODO make it looks through the users for the final point "application ID"
           //you prob need a database.
           
           //Test Data
           CreditCardApplication cca = new CreditCardApplication();
           cca.fillBorrowers();
           //Test Data
           
           return cca;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseApplication trialApplication(@PathParam("id") long id){
        BaseApplication trialApp = new CreditCardApplication();
        BaseApplication trialApp2 = new CreditCardApplication();
        
        return trialApp;
    }
    
    @GET
    @Path("/Example")
    @Produces(MediaType.APPLICATION_JSON)
    public List  trialApplicationList(){
        
        List<BaseApplication> gg = new ArrayList<>();
        BaseApplication trialApp = new CreditCardApplication();
        BaseApplication trialApp2 = new CreditCardApplication();
        gg.add(trialApp);
        gg.add(trialApp2);
        return gg;
    }
    
}
