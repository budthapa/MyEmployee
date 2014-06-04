/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author budthapa
 */
public class DBConnection {

    public static Connection getConnect() {
        Connection connect=null;
        String username = "root";
        String password = "iMnotfine6";

        //getting the jdbc class file
        try {
//            java.sql.Driver driver=DriverManager.getDriver("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            DriverManager.deregisterDriver(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (InstantiationException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        //making a connection
        try {
            String conUrl="jdbc:mysql://localhost/talab";
            connect = DriverManager.getConnection(conUrl, username, password);
            return connect;
        } catch (SQLException e) {
            System.out.println("Cannot connect to database " + e.getMessage());
        }        
        return connect;
    }
}
