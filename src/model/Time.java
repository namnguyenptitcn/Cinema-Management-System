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
public class Time implements Serializable{
    private int id;
    private Date showDate;
    private String startTime;

    public Time(){
        super();
    }
    
    
    public Time(int id, Date showDate, String startTime) {
        this.id = id;
        this.showDate = showDate;
        this.startTime = startTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public Date getShowDate() {
        return showDate;
    }

    public String getStartTime() {
        return startTime;
    }
    
}
