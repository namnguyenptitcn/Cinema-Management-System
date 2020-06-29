/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author NamNguyen
 */
public class Film implements Serializable{
    private int id;
    private String name;
    private String description;
    private Date airDate;
    private String manufacturer;
    private String national;
    private String type;
    private String directors;
    private String duration;
    
    public Film(){
        super();
    }

    public Film(int id, String name, String description, Date airDate, String manufacturer, String national, String type, String directors, String duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.airDate = airDate;
        this.manufacturer = manufacturer;
        this.national = national;
        this.type = type;
        this.directors = directors;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getAirDate() {
        return airDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getNational() {
        return national;
    }

    public String getType() {
        return type;
    }

    public String getDirectors() {
        return directors;
    }

    public String getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAirDate(Date airDate) {
        this.airDate = airDate;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    
   

    
}
