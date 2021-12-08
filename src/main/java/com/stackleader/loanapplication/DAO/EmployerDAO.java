/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stackleader.loanapplication.DAO;

import com.stackleader.loanapplication.model.Employment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class EmployerDAO {
   private static final Logger LOG = LoggerFactory.getLogger(BorrowersDAO.class);
    
    @Resource(lookup = "java:jboss/postgresql")
    DataSource dataSource;
    
    @Inject
    private BorrowersDAO borrowersDAO;

    public ArrayList<Employment> fetchByID(long id) throws SQLException {
        ArrayList<Employment> employers = new ArrayList<>();
        String sql = "SELECT id,startdate,enddate,employername,employerphone,borrowerid from employment where borrowerid = ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setObject(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    
                    Employment employment = new Employment();
                    employment.setEmployerName(rs.getString("employername"));
                    employment.setEmployerPhone(rs.getLong("employerphone"));
                    employment.setEndDate(rs.getDate("enddate").toLocalDate());
                    employment.setStartDate(rs.getDate("startdate").toLocalDate());

                    employers.add(employment);
                }
            }
        } catch (SQLException ex) {
          LOG.error(ex.getMessage(),ex);
        }
        return employers;
    }

    public Response postEmployer(Employment employ, long borrowerId) throws SQLException {

        String sql = "INSERT INTO employment(startdate,enddate,employername,employerphone,borrowerid) VALUES(?,?,?,?,?)"; //sDate!,eDate!,name!,phone!,borrowerid
        try (Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
            stmt.setDate(1, java.sql.Date.valueOf(employ.getStartDate())); //Start date
            stmt.setDate(2, java.sql.Date.valueOf(employ.getEndDate()));//end date
            stmt.setString(3, employ.getEmployerName());//name
            stmt.setLong(4, employ.getEmployerPhone());//phone
            stmt.setObject(5, borrowerId);//borrowerId
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys();) {
                    while (rs.next()) {
                    }
                }
            }else{
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        } catch (SQLException exception){
               LOG.error(exception.getMessage(), exception);
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(employ).build();
    }
}
