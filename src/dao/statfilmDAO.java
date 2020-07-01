/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.statfilm;

/**
 *
 * @author van hieu
 */
public class statfilmDAO extends DAO{
    public statfilmDAO(){
        super();
    }
    public  ArrayList<statfilm> searchfilm(Date startDate,Date endDate){
        ArrayList<statfilm> result=new ArrayList<statfilm>();
        String sql="SELECT a.id ,a.name,sum(ticket) AS ve ,sum(income) as income  "
                + "  WHERE a.date>? AND a.date<?"
                + "     FROM statfilm a"
                + "GROUP BY id ";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        try{
            PreparedStatement ps=getConnection().prepareStatement(sql);
            ps.setString(1, sdf.format(endDate));
            ps.setString(2, sdf.format(startDate));
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                statfilm r=new statfilm();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setTicket(rs.getInt("ve"));
                r.setIncome(rs.getInt("income"));
                result.add(r);
                
                
                
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(statfilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
        
    }
    
    
    
}
