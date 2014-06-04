/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.dao;

import com.budthapa.common.DBConnection;
import com.budthapa.model.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author budthapa
 */
public class LoginDAO {

    private String username;
    private String password;

    public LoginDAO() {
        this.password = "";
        this.username = "";
    }

    //check the form value with the database value
    public boolean authenticate(String username, String password) {
        this.username = username;
        this.password = password;

        //this value comes from the form
//        System.out.println(username);
//        System.out.println(password);
        selectLoginDetail();
        //check if username or password are null or not
        if (username != null && password != null) {
        //check if the form value and the database value matches
            if (username.equals(selectLoginDetail().getUsername()) && password.equals(selectLoginDetail().getPassword())) {

                System.out.println("Username or password match");
                return true;
            } else {
                System.out.println("Username or password mismatch");
                return false; //return false if null
            }
        }
        return false; //return false if null
    }
    
    
    public  String sessionName(String username){
        username=selectLoginDetail().getUsername();
        return username;
    }

    public Login selectLoginDetail() {
        try {
            String sql = "select * from login";
            PreparedStatement ps = DBConnection.getConnect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Login login = new Login();
                //this value comes from the database
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
//                System.out.println(login.getUsername());
//                System.out.println(login.getPassword());
                return login;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
