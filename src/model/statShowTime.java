/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author van hieu
 */
public class statShowTime {
    private String id;
    private String name;
    private int ticket;
    private int income;

    public statShowTime() {
    }

    public String getId() {
        return id;
    }

    public statShowTime(String id, String name, int ticket, int icome) {
        this.id = id;
        this.name = name;
        this.ticket = ticket;
        this.income = icome;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getTicket() {
        return ticket;
    }

    public int getIncome() {
        return income;
    }
    
            
            
}
