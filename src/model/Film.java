/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author NamNguyen
 */
public class Film implements Serializable{
    private int id;
    private String name;
    private String type;
    private String des;
    private Date air_date;
    private String projection_time;
    private String director;
    
    public Film(){
        super();
    }

   

    public Film(int id, String name, String type, String des, Date air_date, String projection_time, String director) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.des = des;
        this.air_date = air_date;
        this.projection_time = projection_time;
        this.director = director;
    }

    public void setProjection_time(String projection_time) {
        this.projection_time = projection_time;
    }

    public String getProjection_time() {
        return projection_time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDes() {
        return des;
    }

    public Date getAir_date() {
        return air_date;
    }

    public String getDirector() {
        return director;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setAir_date(Date air_date) {
        this.air_date = air_date;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    
}
