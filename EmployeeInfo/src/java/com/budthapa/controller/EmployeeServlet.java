package com.budthapa.controller;

import com.budthapa.dao.EmployeeDao;
import com.budthapa.model.Employee;
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
 * @author bud
 */
public class EmployeeServlet extends HttpServlet {

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
            String sessionName = (String) request.getSession(true).getAttribute("sessionName");
            if (sessionName == null) {
                response.sendRedirect("index.jsp");
            } else if (request.getParameter("addEmployee") != null && request.getParameter("addEmployee").contains("Register")) {
                //rest of the code below
                //creating a object of the model employee class and set the values
                Employee emp = new Employee();
//                emp.setEmpId(Integer.parseInt(request.getParameter("empId"))); //auto generated
//                System.out.println(request.getParameter("empId"));
                emp.setEmpName(request.getParameter("empName"));
                emp.setDepartment(request.getParameter("department"));
                emp.setPost(request.getParameter("post"));
                emp.setSalary(Float.parseFloat(request.getParameter("salary")));
                emp.setGender(request.getParameter("gender"));
                emp.setAge(Integer.parseInt(request.getParameter("age")));
                emp.setJoinDate(Integer.parseInt(request.getParameter("joinDate")));
                emp.setEmail(request.getParameter("email"));

                EmployeeDao ed = new EmployeeDao();
                ed.add(emp);
                request.setAttribute("addEmployee", emp);
                request.getRequestDispatcher("success.jsp").forward(request, response);
            }

            //-------------------------display employee data starts here--------------------------
            //  getting the data from the database to view
            //calling the method that inserts data into the database
            String listEmployee = request.getParameter("listEmployee");
            System.out.println("emp servlet :" + listEmployee);
            if (listEmployee != null && listEmployee.contains("View Employees")) {
                List<Employee> list = new ArrayList();
                EmployeeDao ed = new EmployeeDao();
                list = ed.selectData();
                if (list != null) {
                    request.setAttribute("listData", list);
                    request.getRequestDispatcher("showListEmployee.jsp").forward(request, response);
                }
            }

            //-------------------------to edit the employee data starts here--------------------------
            //get value from listEmployee.jsp to edit, send it to the editEmployee.jsp
            //get parameter id from the url       
            String q = request.getParameter("q");
            if (q != null) {
                int id = Integer.parseInt(q);
                String queryString = request.getQueryString();
                if (queryString != null && id > 0) {
                    System.out.println("url q " + id);
                    List<Employee> getEmployeeList = new ArrayList();

                    EmployeeDao empEdit = new EmployeeDao();
                    getEmployeeList = empEdit.selectDataToEdit(id);

                    //check if some data is available, working fine
                    for (Employee employeeList : getEmployeeList) {
                        System.out.println("Name -->" + employeeList.getEmpName());
                    }

                    request.setAttribute("editData", getEmployeeList);
                    request.getRequestDispatcher("showEditEmployee.jsp").forward(request, response);
                }

                //-------------------------to edit the employee data ends here--------------------------//
                //-------------------------insert the updated value starts here --------------------------//
            } else if (request.getParameter("updateInformation") != null && request.getParameter("updateInformation").contains("Update Information")) {
                Employee emp = new Employee();
                emp.setEmpId(Integer.parseInt(request.getParameter("empId")));
                emp.setEmpName(request.getParameter("empName"));
                emp.setDepartment(request.getParameter("department"));
                emp.setPost(request.getParameter("post"));
                emp.setSalary(Float.parseFloat(request.getParameter("salary")));
                emp.setGender(request.getParameter("gender"));
                emp.setAge(Integer.parseInt(request.getParameter("age")));
                emp.setJoinDate(Integer.parseInt(request.getParameter("joinDate")));
                emp.setEmail(request.getParameter("email"));

                EmployeeDao ed = new EmployeeDao();
                ed.updateData(emp);
                System.out.println("Records Updated successfully");

                response.sendRedirect("editSuccess.jsp");

            }   //-------------------------display employee data ends here--------------------------
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
