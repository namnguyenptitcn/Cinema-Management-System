/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
/**
 *
 * @author NamNguyen
 */
public class Room implements Serializable {
    private int id;
    private String name;
    private String status;
    private int number_of_seat;
    private String acreage;
    
    public Room(){
        super();
    }

    public Room(int id, String name, String status, int number_of_seat, String acreage) {
        super();
        this.id = id;
        this.name = name;
        this.status = status;
        this.number_of_seat = number_of_seat;
        this.acreage = acreage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNumber_of_seat(int number_of_seat) {
        this.number_of_seat = number_of_seat;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getNumber_of_seat() {
        return number_of_seat;
    }

    public String getAcreage() {
        return acreage;
    }
    
}
