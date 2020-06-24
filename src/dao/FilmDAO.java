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
import model.Film;

/**
 *
 * @author NamNguyen
 */
public class FilmDAO extends DAO {

    public FilmDAO() {
        super();
    }

    public ArrayList<Film> loadAllPhim() {
        PreparedStatement pst;
        String query = "select id, name, airDate, duration from film order by name";
        ArrayList<Film> lstFilm = new ArrayList<>();
        Film film;
        try {
            pst = getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                film = new Film();
                film.setId(rs.getInt("ID"));
                film.setName(rs.getString("Name"));
                film.setAirDate(rs.getDate("airDate"));
                film.setDuration(rs.getString("Duration"));
                
                
                lstFilm.add(film);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return lstFilm;
    }
}
