/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stackleader.loanapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;

/**
 *
 * @author Abel
 */


@ApplicationScoped
public class EmployerDAO {
    @Resource(lookup = "java:jboss/postgresql")
    DataSource dataSource;
    
    
    public ArrayList<Employment> fetchByID(long id) throws SQLException{
        ArrayList<Employment> employers = new ArrayList<>();
        String sql = "SELECT id,startdate,enddate,employername,employerphone,borrowerid from employer where borrowerid = ?";
          try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setObject(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    Employment employment = new Employment();
                    employment.setEmployerName(rs.getString("employername"));
                    employment.setEmployerPhone(rs.getLong("employerphone"));
                    employment.setEndDate(rs.getDate("enddate"));
                    employment.setStartDate(rs.getDate("startdate"));
                    
                    
                    
                    employers.add(employment);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employers; 
    }
}
