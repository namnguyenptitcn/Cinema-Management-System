/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;

public class Ticket {
    private int id;
    private int stt;
    private String date;
    private int ticket_sold;
    private String total_revenue;
    private float price;
    private String filmLenght;
    private int idFilm;
    public Ticket(int id, int stt, String date, int ticket_sold, String total_revenue, float price, String filmLenght, int idFilm) {
        this.id = id;
        this.stt = stt;
        this.date = date;
        this.ticket_sold = ticket_sold;
        this.total_revenue = total_revenue;
        this.idFilm = idFilm;
        this.price = price;
        this.filmLenght = filmLenght;
    }

    public Ticket() {
    }

    public void setFilmLenght(String filmLenght) {
        this.filmLenght = filmLenght;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTicket_sold(int ticket_sold) {
        this.ticket_sold = ticket_sold;
    }

    public void setTotal_revenue(String total_revenue) {
        this.total_revenue = total_revenue;
    }

    public int getId() {
        return id;
    }

    public int getStt() {
        return stt;
    }

    public String getDate() {
        return date;
    }

    public int getTicket_sold() {
        return ticket_sold;
    }

    public String getTotal_revenue() {
        return total_revenue;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public String getFilmLenght() {
        return filmLenght;
    }

    public float getPrice() {
        return price;
    }


    
}
