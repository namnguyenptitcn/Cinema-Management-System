/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Employee;

/**
 *
 * @author NamNguyen
 */
public class EmployeeDao extends DAO{
    
    public EmployeeDao() {
	super();
	}
	
	public boolean checkLogin(Employee em) {
		boolean result = false;
		String sql = "SELECT name, position FROM employee WHERE username = ? AND password = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, em.getUsername());
			ps.setString(2, em.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				em.setName(rs.getString("name"));
				em.setPosition(rs.getString("position"));
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
