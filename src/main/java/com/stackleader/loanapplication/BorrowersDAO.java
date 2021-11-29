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
import javax.inject.Inject;
import javax.sql.DataSource;

/**
 *
 * @author intern
 */
@ApplicationScoped
public class BorrowersDAO {
    @Resource(lookup = "java:jboss/postgresql")
    DataSource dataSource;
    
    @Inject
    EmployerDAO edao;
    
    
    public ArrayList<Borrower> fetchByID(long id) throws SQLException{
        ArrayList<Borrower> borrowers= new ArrayList<Borrower>();
        String sql = "SELECT id,firstname,lastname,age,address,city,stat,zip,ssn,relation,appid from borrowers where appid = ?";
          try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setObject(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    Borrower borrower = new Borrower();
                    borrower.setId(rs.getInt("id"));
                    borrower.setAge(rs.getInt("age"));
                    borrower.setAddress(rs.getString("address"));
                    borrower.setFirstName(rs.getString("firstname"));
                    borrower.setLastName(rs.getString("lastname"));
                    borrower.setState(rs.getString("stat"));
                    borrower.setCity(rs.getString("city"));
                    borrower.setSsn(rs.getInt("ssn"));
                    borrower.setZip(rs.getInt("zip"));
                    borrower.setEmployers(edao.fetchByID(rs.getInt("id")));
                    borrowers.add(borrower);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return borrowers; 
        
        
        
        
        
    }
    
    
}
