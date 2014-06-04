<%-- 
    Document   : success
    Created on : Mar 6, 2014, 9:12:25 PM
    Author     : bud
--%>

<%@page import="java.util.List"%>
<%@page import="com.budthapa.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
        <link rel="stylesheet" href="mainStyle.css" type="text/css" >
    </head>
    <jsp:include page="header.jsp"></jsp:include>
        <body>
            <div class="header">
                <h1>New employee was successfully created</h1>
            </div>
        <%
            //get employee details from the servlet and display
//                Employee empDetails = (Employee) request.getAttribute("employee");
                List<Employee> add =(List<Employee>)request.getAttribute("addEmployee");
//            List<Employee> add = (List<Employee>)addEmployee;
            for (Employee emp : add) {
        %>

        <h3>Employee Details</h3>
        <table border="1px" cellpadding="3px" cellspacing="3px">
            <tr>
                <td>Employee Id</td>
                <td>Employee Name</td>
                <td>Department</td>
                <td>Post</td>
                <td>Salary</td>
                <td>Gender</td>
                <td>Age</td>
                <td>Join Date</td>
                <td>Email</td>
            </tr>

            <tr>
                <td>
                    <%
                        out.println(emp.getEmpId());
                    %>
                </td>
                <td>
                    <%
                        out.println(emp.getEmpName());
                    %>
                </td>
                <td>
                    <%
                        out.println(emp.getDepartment());
                    %>
                </td> 
                <td>
                    <%
                        out.println(emp.getPost());
                    %>
                </td>
                <td>
                    <%
                        out.println(emp.getSalary());
                    %>
                </td>
                <td>
                    <%
                        out.println(emp.getGender());
                    %>
                </td>
                <td>
                    <%
                        out.println(emp.getAge());
                    %>
                </td>
                <td>
                    <%
                        out.println(emp.getJoinDate());
                    %>
                </td>
                <td>
                    <%
                        out.println(emp.getEmail());
                    %>
                </td>
            </tr>
        </table>
        <%
            }
        %>
    </body>
</html>