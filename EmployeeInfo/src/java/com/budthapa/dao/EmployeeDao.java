 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.dao;

import com.budthapa.common.DBConnection;
import com.budthapa.model.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author budthapa
 */
public class EmployeeDao {

    public void add(Employee employee) {
//        DBConnection.getConnect();
        String insertData = "insert into employee values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DBConnection.getConnect().prepareStatement(insertData);
            ps.setInt(1, employee.getEmpId());
            ps.setString(2, employee.getEmpName());
            ps.setString(3, employee.getDepartment());
            ps.setString(4, employee.getPost());
            ps.setFloat(5, employee.getSalary());
            ps.setString(6, employee.getGender());
            ps.setFloat(7, employee.getAge());
            ps.setInt(8, employee.getJoinDate());
            ps.setString(9, employee.getEmail());
            ps.executeUpdate();
            System.out.println("insert successful");
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error --->" + e);
        }

    }

    public List<Employee> selectData() {
        //query to get data from database
        String fromDatabase = "select * from employee";
        //creating a new arraylist to store retreived data from database
        List<Employee> empList = new ArrayList();
        try {
            PreparedStatement ps = DBConnection.getConnect().prepareStatement(fromDatabase);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee em = new Employee();
                em.setEmpId(rs.getInt("empid"));
                em.setEmpName(rs.getString("empname"));
                em.setDepartment(rs.getString("department"));
                em.setPost(rs.getString("post"));
                em.setSalary(rs.getFloat("salary"));
                em.setGender(rs.getString("gender"));
                em.setAge(rs.getInt("age"));
                em.setJoinDate(rs.getInt("joindate"));
                em.setEmail(rs.getString("email"));
                empList.add(em);
            }
            ps.close();
            return empList;
        } catch (SQLException e) {
            System.out.println("Error ---->" + e);
        }
        return null;
    }

    public List<Employee> selectDataToEdit(int id) {
        String sql = "select * from employee where empid=?";
        List<Employee> list=new ArrayList<Employee>();
        try {
            PreparedStatement ps = DBConnection.getConnect().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpId(rs.getInt("empId"));
                emp.setEmpName(rs.getString("empname"));
                emp.setDepartment(rs.getString("department"));
                emp.setPost(rs.getString("post"));
                emp.setSalary(rs.getFloat("salary"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getInt("age"));
                emp.setJoinDate(rs.getInt("joindate"));
                emp.setEmail(rs.getString("email"));
                list.add(emp);
             return list;   
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    //update data that is edited in editEmployee.jsp
    public void updateData(Employee emp) {
        try {
//            String sql="update employee set empName=?, department=?, post=?, salary=?, gender=?, age=?, joindate=? where empId=?";
            String update="update employee set empname=?, department=?, post=?, salary=?, gender=?, age=?, joindate=?, email=? where empId=?";
            PreparedStatement ps=DBConnection.getConnect().prepareStatement(update);
            ps.setString(1, emp.getEmpName());
            ps.setString(2, emp.getDepartment());
            ps.setString(3, emp.getPost());
            ps.setFloat(4, emp.getSalary());
            ps.setString(5, emp.getGender());
            ps.setInt(6, emp.getAge());
            ps.setInt(7, emp.getJoinDate());
            ps.setString(8, emp.getEmail());
            ps.setInt(9, emp.getEmpId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}
