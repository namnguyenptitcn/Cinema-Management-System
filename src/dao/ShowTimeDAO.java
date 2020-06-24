/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Showtime;

/**
 *
 * @author NamNguyen
 */
public class ShowTimeDAO extends DAO {

    public ShowTimeDAO() {
        super();
    }
    public void AddShowTime(Showtime showtime) {
        PreparedStatement pst;
        String query = "insert into showTime values(?,?,?,?)";
        try {
            pst = getConnection().prepareStatement(query);
            pst.setInt(1, showtime.getId());
            pst.setInt(2, showtime.getFilm().getId());
            pst.setInt(3, showtime.getRoom().getId());
            pst.setInt(4, showtime.getTime().getId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public boolean checkShowTime(int idShowtime, int idFilm, int idRoom, int idTime) {
        PreparedStatement pst;
        String query = "select * from showtime where id = ?, idFilm = ?, idRoom = ?, idTime = ?";
        try {
            pst = getConnection().prepareStatement(query);
            pst.setInt(1, idShowtime);
            pst.setInt(1, idFilm);
            pst.setInt(1, idRoom);
            pst.setInt(1, idTime);
           
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return false;
    }

    
    
}
