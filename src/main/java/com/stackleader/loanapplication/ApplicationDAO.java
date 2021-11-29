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
 * @author Abel this is to get the data to create users
 */
@ApplicationScoped
public class ApplicationDAO {
    @Inject
    BorrowersDAO bdao;
    
    @Resource(lookup = "java:jboss/postgresql")
    DataSource dataSource;

    public BaseApplication fetchByUUID(long id) throws SQLException {
        String sql = "SELECT id,creditlimit,cardtype,lendtype from applications where id = (?)";
        BaseApplication ba = null;
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setObject(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    String lendType = rs.getString("lendtype");
                    if (lendType.equals("Credit Card")) {
                        ba = new CreditCardApplication();
                        ba.setId(id);
                        ba.setCardType(rs.getString("cardtype"));
                        ba.setRequestedCreditLimit(rs.getInt("creditlimit"));
                        ArrayList<Borrower> borrowers = bdao.fetchByID(id);
                        ba.setBorrowers(bdao.fetchByID(id));
                        
                    }
                    /*
                        if (lendType == "morage")
                        {
                            Code For Morage to be inserted here.
                        }
                        
                     */

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ba;
    }

}
