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
public class Client implements Serializable{
    private int id;
    private String name;
    private String address;
    private String email;
    private String tel;
    private String note;

    
    public Client(){
        super();
    }
    public Client(int id, String name, String address, String email, String tel, String note) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getNote() {
        return note;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}

