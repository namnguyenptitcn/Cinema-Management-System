/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Ticket;
import model.statShowTime;
//import model.statTicket;

/**
 *
 * @author NamNguyen
 */
public class statDAO extends DAO {

    public statDAO() {
        super();
    }

     public ArrayList<Ticket> statTicket() {
        PreparedStatement pst;
                ArrayList<Ticket> result = new ArrayList<Ticket>();

        String query = "select * from Ticket";
        try {
            pst = getConnection().prepareStatement(query);
//            pst.setInt(1, id);
//            pst.setInt(1, stt);
//            pst.setInt(1, date);
//            pst.setInt(1, ticket_sold);
//            pst.setInt(1, total_revenue);
           
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               Ticket r= new Ticket();
                r.setId(rs.getInt("id"));
                r.setStt(rs.getInt("stt"));
                r.setDate(rs.getString("date"));
                r.setTicket_sold(rs.getInt("ticketsold"));
                r.setTotal_revenue(rs.getString("totalrevenue"));
                r.setIdFilm(rs.getInt("idFilm"));
                r.setPrice(rs.getFloat("price"));
                r.setFilmLenght(rs.getString("filmLenght"));
                result.add(r);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return result ;
    }

    
    
}
