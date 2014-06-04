<%-- 
    Document   : reportDashboard
    Created on : Mar 12, 2014, 11:36:01 AM
    Author     : budthapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="mainStyle.css" type="text/css" >
<div class="mainContent">
    <h2>Generate Reports</h2>
    <form action="EmployeeServlet" method="post">
        <table>
            <tr>
                <td><input type="submit" name="paymentReport" class="submit" value="Payment Report"/></td>
                <td><input type="submit" name="listEmployee" class="submit" value="View Employees"/></td>
            </tr>
        </table>
    </form>
</div>