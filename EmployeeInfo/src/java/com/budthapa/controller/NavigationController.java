/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.controller;

import com.budthapa.dao.EmployeeDao;
import com.budthapa.model.Navigation;
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
public class NavigationController extends HttpServlet {

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
            if (request.getSession().getAttribute("sessionName") == null) {
                response.sendRedirect("index.jsp");
                System.out.println("Session on Navigation page" + request.getSession().getAttribute("sessionName"));
            } else {
                //------------------------------Navigation Starts here-----------------------------------------//    
                //open a specific page in main dashboard when user clicks
                //on link provided in left navigation
                Navigation navigation = new Navigation();

                navigation.setAddEmployee(request.getParameter("addEmployee"));
                navigation.setMakePayment(request.getParameter("makePayment"));
                navigation.setRecords(request.getParameter("report"));
                navigation.setSettings(request.getParameter("settings"));

                //set attribute value to be used by show Pages
                request.setAttribute("nav", navigation);

                //making the list of array to hold navigation buttons
                List<String> navList = new ArrayList();
                navList.add(request.getParameter("dashboard"));
                navList.add(request.getParameter("makePayment"));
                navList.add(request.getParameter("addEmployee"));
                navList.add(request.getParameter("report"));
                navList.add(request.getParameter("settings"));
                navList.add(request.getParameter("logout"));

                //check if these buttons name contains the value of button
                //if true forward to the specific page
                if (navList.contains("Home")) {
                    request.getRequestDispatcher("showDashboard.jsp").forward(request, response);
                } else if (navList.contains("Make Payment")) {
                    request.getRequestDispatcher("showPayment.jsp").forward(request, response);
                } else if (navList.contains("Add Employee")) {
                    request.getRequestDispatcher("showEmployeeRegistration.jsp").forward(request, response);
                } else if (navList.contains("Report")) {
                    request.getRequestDispatcher("showReportDashboard.jsp").forward(request, response);
                } else if (navList.contains("Settings")) {
                    request.getRequestDispatcher("showSettings.jsp").forward(request, response);
                } else if (navList.contains("Exit")) {
                        
                        
//                  request.getSession(true).invalidate();
//                    request.setAttribute("logout", request.getSession().getAttribute("sessionName")); //set session attribute
//                    response.sendRedirect(response.encodeRedirectURL("logout.jsp"));
                    response.sendRedirect("logout.jsp");

                }
                //------------------------------Navigation ends here-----------------------------------------//    

                
                //----------------------------Edit Employee starts here-----------------------------------//
                EmployeeDao empUpdate = new EmployeeDao();
//            empUpdate.update();

                request.setAttribute("update", empUpdate);
                if (request.getParameter("editEmployee") != null) {
                    request.getRequestDispatcher("showEditEmployee.jsp").forward(request, response);
                }

                //----------------------------Edit Employee ends here-----------------------------------//
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
