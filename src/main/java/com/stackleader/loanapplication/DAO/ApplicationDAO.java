/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stackleader.loanapplication.DAO;

import com.stackleader.loanapplication.model.BaseApplication;
import com.stackleader.loanapplication.model.Borrower;
import com.stackleader.loanapplication.model.CreditCardApplication;
import com.stackleader.loanapplication.model.MorageApplication;
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
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ApplicationDAO {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationDAO.class);
    @Inject
    BorrowersDAO bdao;
    @Inject
    EmployerDAO edao;

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
                        ba.setLendType(rs.getString("lendtype"));
                        ba.setCardType(rs.getString("cardtype"));
                        ba.setRequestedCreditLimit(rs.getInt("creditlimit"));
                        ArrayList<Borrower> borrowers = bdao.fetchByID(id);
                        ba.setBorrowers(bdao.fetchByID(id));

                    }
                    if (lendType.equals("morage")){
                        ba = new MorageApplication();
                        ba.setId(id);
                        ba.setLendType(rs.getString("lendtype"));
                        ba.setRequestedCreditLimit(rs.getInt("creditlimit"));
                        ArrayList<Borrower> borrowers = bdao.fetchByID(id);
                        ba.setBorrowers(bdao.fetchByID(id));

                    }
                    
                }
            }
        } catch (SQLException ex) {
            LOG.error(ex.getMessage(), ex);
        }
        return ba;
    }

    public ArrayList<BaseApplication> fullList() throws SQLException {
        String sql = "SELECT id,creditlimit,cardtype,lendtype from applications";
        ArrayList<BaseApplication> baseAppList = new ArrayList<BaseApplication>();
        BaseApplication ba = null;

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    ba = new BaseApplication();
                    ba.setId(rs.getInt("id"));
                    ArrayList<Borrower> borrowers = bdao.fetchByID(ba.getId());
                    ba.setBorrowers(borrowers);
                    baseAppList.add(ba);

                }
            }
        }

        return baseAppList;

    }

    public Response postApplication(BaseApplication baseApplication) throws SQLException {
        long id = 0;
        Response response = null;

        String sql = "INSERT INTO applications(creditlimit,cardtype,lendtype)VALUES(?,?,?)";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setObject(1, baseApplication.getRequestedCreditLimit());
            stmt.setObject(2, baseApplication.getCardType());
            stmt.setObject(3, baseApplication.getLendType());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys();) {
                    while (rs.next()) {
                        id = rs.getLong(1);
                    }
                    baseApplication.setId(Math.toIntExact(id));
                }
            }
            else 
            {
                return Response.status(Response.Status.BAD_REQUEST).entity("not valid").build();
            }

        } catch (SQLException ex){
            LOG.error(ex.getMessage(), ex);
        }
        
        return Response.ok().entity(baseApplication).build();
        
    }
}
