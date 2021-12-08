/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stackleader.loanapplication;

import com.stackleader.loanapplication.DAO.ApplicationDAO;
import com.stackleader.loanapplication.DAO.BorrowersDAO;
import com.stackleader.loanapplication.DAO.EmployerDAO;
import com.stackleader.loanapplication.model.BaseApplication;
import com.stackleader.loanapplication.model.Borrower;
import com.stackleader.loanapplication.model.Employment;
import java.sql.SQLException;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cc/applications") 
public class LoanApi {
    //@Resource(lookup = "java:/postgresql")
    //private  DataSource dataSource;
//    @Resource(lookup = "java:/postgresql")
//    private  DataSource dataSource;

    //create a credit card application here for a list of borrowers(?).    
    @Inject
    ApplicationDAO applicationDAO;
    @Inject
    BorrowersDAO borrowerDAO;
    @Inject
    EmployerDAO employerDAO; 

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)//needs to be a json file
    public Response jsonMessage() throws SQLException {

        return Response.ok(applicationDAO.fullList()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response trialApplication(@PathParam("id") long id) throws SQLException {
        BaseApplication app = applicationDAO.fetchByUUID(id);
        return Response.ok(app).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postApplication (@Valid BaseApplication application) throws SQLException{
        
        Response response = applicationDAO.postApplication(application);
        for(Borrower borrower : application.getBorrowers() ){
            borrowerDAO.postBorrower(borrower, application.getId());
            for (Employment employers: borrower.getEmployers()){
                employerDAO.postEmployer(employers, borrower.getId());
            }
        }
        
        return response;
        
        
    }
}
