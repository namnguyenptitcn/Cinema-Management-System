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
        String query = "select ID, Name, the_loai, Projection_time, Air_date, Director, Describe from Film order by Name";
        ArrayList<Film> lstFilm = new ArrayList<>();
        Film film;
        try {
            pst = getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                film = new Film();
                film.setId(rs.getInt("ID"));
                film.setName(rs.getString("Name"));
                film.setType(rs.getString("Type"));

                film.setProjection_time(rs.getString("Projection_time"));
                film.setAir_date(rs.getDate("Air_date"));

                film.setDirector(rs.getString("Director"));

                film.setDes(rs.getString("Describe"));
                lstFilm.add(film);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstFilm;
    }
}
