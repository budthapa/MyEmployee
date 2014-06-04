<%-- 
    Document   : editEmployee
    Created on : Mar 12, 2014, 10:01:19 PM
    Author     : budthapa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.budthapa.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="mainContent">
    <h2>Update Employee Information</h2>
    <%
        Object editList = request.getAttribute("editData"); //getting the object from editemployee
        
        List<Employee> ed=(List<Employee>)editList;  //converting the object to list
        
        //using for each loop to display the data
        for(Employee emp:ed){
            
        
        //this code is working fine 
//        for(int i=0;i<ed.size();i++){
//            out.println("vay o ki");
//                    out.println(ed.get(i).getDepartment());
//        }
    %>
    <form action="EmployeeServlet" method="post">
        <table>
            <tr>
                <td>Employee Id</td>
                <td><input type="text" name="empId" maxlength="15" value="<%= emp.getEmpId() %>" /></td>
            </tr>
            <tr>
                <td>Employee Name</td>
                <td><input type="text" name="empName" maxlength="45" value="<%= emp.getEmpName() %>"/></td>
            </tr>
            <tr>
                <td>Department</td>
                <td><input type="text" name="department" maxlength="30" value="<%= emp.getDepartment() %>"/></td>
            </tr>
            <tr>
                <td>Post</td>
                <td><input type="text" name="post" maxlength="30" value="<%= emp.getPost() %>"/></td>
            </tr>
            <tr>
                <td>Salary</td>
                <td><input type="text" name="salary" maxlength="8" value="<%= emp.getSalary() %>"/></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><input type="radio" name="gender" value="Male"/>Male
                    <input type="radio" name="gender" value="Female"/>Female</td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" name="age" maxlength="3" value="<%= emp.getAge() %>"/></td>
            </tr>
            <tr>
                <td>Join Date</td>
                <td><input type="text" name="joinDate" value="<%= emp.getJoinDate() %>"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email" value="<%=emp.getEmail() %>"/></td>
            </tr>
            <tr>
                <td style="text-align: center;"><input type="submit" value="Update Information" name="updateInformation"/></td>
            </tr>
        </table>
    </form>
    <%
         //end of for each loop
        }
    %>
</div>