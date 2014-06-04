/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.controller;

import com.budthapa.dao.SettingsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author budthapa
 */
public class SettingsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //check for session
            if (request.getSession().getAttribute("sessionName") == null) {
                response.sendRedirect("index.jsp");
            } else {

                //setting for changing username and password
                String changeUsername = request.getParameter("changeUsername");
                String changePassword = request.getParameter("changePassword");

                List<String> settings = new ArrayList();
                settings.add(changeUsername);
                settings.add(changePassword);

                if (settings.contains("Change Username")) {
                    request.getRequestDispatcher("changeUsername.jsp").forward(request, response);
                } else if (settings.contains("Change Password")) {
                    request.getRequestDispatcher("changePassword.jsp").forward(request, response);
                }

                List<String> settingsList = new ArrayList();
                settingsList.add(request.getParameter("newUsername"));
                settingsList.add(request.getParameter("newPassword"));

                SettingsDAO set = new SettingsDAO();
                String newUsername = request.getParameter("newUsername");
                String newPassword = request.getParameter("newPassword");
                if (settingsList.equals("newPassword")) {
                    //getting a new username from changeUsername form
                    //passing the newUsername for update
                    set.updateUsername(newUsername);
                    request.setAttribute("newUsername", newUsername);
                    request.getRequestDispatcher("changeUsername.jsp").forward(request, response);
                } else if (settingsList.equals("newPassword")) {
                    //getting a new password from the changePassword form
                    set.updatePassword(newPassword);
                    request.setAttribute("newPassword", newPassword);
                    request.getRequestDispatcher("changePassword.jsp").forward(request, response);
                }

            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
