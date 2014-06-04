/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.common;

import com.budthapa.dao.LoginDAO;

/**
 *
 * @author budthapa
 */
public class SessionCheck {

    public boolean checkSession() {
        LoginDAO ld = new LoginDAO();
        String u = ld.selectLoginDetail().getUsername();
        if (u != null) {
            System.out.println("checked session name " + u);
            return true;
        }
        return false;
    }
}
