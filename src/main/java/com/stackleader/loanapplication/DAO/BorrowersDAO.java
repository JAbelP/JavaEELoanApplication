/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stackleader.loanapplication.DAO;

import com.stackleader.loanapplication.model.Borrower;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author intern
 */
@ApplicationScoped
@Transactional
public class BorrowersDAO {
    @Resource(lookup = "java:jboss/postgresql")
    DataSource dataSource;
    @Inject
    EmployerDAO edao;
    private static final Logger LOG = LoggerFactory.getLogger(BorrowersDAO.class);
    
    
    public ArrayList<Borrower> fetchByID(long id) throws SQLException{
        ArrayList<Borrower> borrowers= new ArrayList<Borrower>();
        String sql = "SELECT firstname,lastname,age,address,city,stat,zip,ssn,relation,appid,id from borrowers where appid = ?";
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
                    borrower.setRelationship("relation");
                    borrower.setEmployers(edao.fetchByID(borrower.getId()));
                    borrowers.add(borrower);
                    
                }
                
            }
            return borrowers; 
        } catch (SQLException ex) {
            LOG.error(ex.getMessage(),ex);
        }
          throw new NotFoundException();
    }
    
    public Response postBorrower(Borrower borrower, long appID) throws SQLException{
        
        String sql = "INSERT INTO borrowers(firstname,lastname,age,address,city,stat,zip,ssn,relation,appid)VALUES(?,?,?,?,?,?,?,?,?,?)";
        try(Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
            stmt.setString(1, borrower.getFirstName());
            stmt.setString(2, borrower.getLastName());
            stmt.setInt(3, borrower.getAge());
            stmt.setString(4, borrower.getAddress());
            stmt.setString(5, borrower.getCity());
            stmt.setString(6, borrower.getState());
            stmt.setInt(7, borrower.getZip());
            stmt.setInt(8, borrower.getSsn());
            stmt.setString(9, borrower.getRelationship());
            stmt.setLong(10, appID);
            int rows = stmt.executeUpdate();
            if(rows > 0){
                try (ResultSet rs = stmt.getGeneratedKeys();){
                    while (rs.next()){
                        
                    }
                }
            }else
            {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        } catch (SQLException e){
            LOG.error(e.getMessage(),e);
        }
        return Response.status(Response.Status.CREATED).entity(borrower).build();
}
}
