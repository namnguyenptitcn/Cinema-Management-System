/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Room;

/**
 *
 * @author NamNguyen
 */
public class RoomDAO extends DAO{
    public RoomDAO() {
        super();
        }
    public ArrayList<Room> loadAllRoom() {
        PreparedStatement pst;
        String query = "select id, name, numberOfSeat, acreage from room order by name";
        ArrayList<Room> lstRooms = new ArrayList<>();
        Room room;
        try {
            pst = getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                room = new Room();
                room.setId(rs.getInt("ID"));
                room.setName(rs.getString("Name"));
                room.setNumber_of_seat(rs.getInt("numberOfSeat"));
                room.setAcreage(rs.getString("acreage"));
                
                
                lstRooms.add(room);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return lstRooms;
    }

}
