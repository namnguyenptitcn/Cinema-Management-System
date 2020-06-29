/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Time;


/**
 *
 * @author NamNguyen
 */
public class TimeDAO extends DAO {
static Connection con;

   
    public TimeDAO() {
        super();
        con = DAO.getConnection();
        
    }

    public ArrayList<Time> loadTimeByDate(java.util.Date date) {

        ArrayList<Time> list = new ArrayList<>();
        
        String sql = "SELECT * FROM time WHERE showDate = ? ";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setDate(1, new Date(date.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Time(rs.getInt(1), rs.getDate(2), rs.getString(3)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void AddTime(Time time) {
        
        
        String sql = "insert into time values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);           
            ps.setInt(1,time.getId());
            ps.setDate(2, new Date(( time.getShowDate().getTime())));
            ps.setString(3, time.getStartTime());
            ps.executeUpdate();
        } catch (Exception e) {
           e.printStackTrace();
        }
    
    }
     public ArrayList<Time> loadAllTime() {
       PreparedStatement pst;
        ArrayList<Time> list = new ArrayList<>();
        String query = "select * from time ";
        try {
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Time(rs.getInt(1), rs.getDate(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; 
    }
     public void deleteTime(int idTime) {
        PreparedStatement pst;
        String query = "delete from time where id = ?";
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1, idTime);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public boolean checkTime(java.util.Date date, String time) {
        PreparedStatement pst;
        String query = "select * from time where showDate = ? and startTime = ?";
        try {
            pst = con.prepareStatement(query);
            pst.setDate(1, new Date(date.getTime()));
            pst.setString(2, time);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
