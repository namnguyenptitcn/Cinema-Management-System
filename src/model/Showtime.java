/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import model.Film;
import model.Room;
import model.Time;

/**
 *
 * @author NamNguyen
 */
public class Showtime implements Serializable{
    private int id;
    private Film film;
    private Room room;
    private Time time;

    public Showtime(){
        super();
    }
    
    public Showtime(int id, Film film, Room room, Time time) {
        this.id = id;
        this.film = film;
        this.room = room;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    public Room getRoom() {
        return room;
    }

    public Time getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    
}
