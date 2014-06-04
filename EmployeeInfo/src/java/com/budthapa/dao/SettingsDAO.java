/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.budthapa.dao;

import com.budthapa.common.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author budthapa
 */
public class SettingsDAO {
    public void updateUsername(String newUsername){
        String sql="update login set username= ?";
        try {
            PreparedStatement ps=DBConnection.getConnect().prepareStatement(sql);
            ps.setString(1,newUsername);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(SettingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void updatePassword(String newPassword){
        String sql="update login set password=?";
        try{
            PreparedStatement ps=DBConnection.getConnect().prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            Logger.getLogger(SettingsDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
