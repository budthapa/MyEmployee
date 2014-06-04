<%-- 
    Document   : dashboard
    Created on : Mar 12, 2014, 5:59:48 PM
    Author     : budthapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="mainContent">
    <h2>Quick Interface</h2>
    <!--check the session name-->
    <% // out.println(request.getSession().getAttribute("sessionName")); %>

    <form action="EmployeeServlet" method="post">
        <table>
            <tr>
                <td><input type="submit" name="paymentReport" class="submit" value="Payment Report"/></td>
                <td><input type="submit" name="listEmployee" class="submit" value="View Employees"/></td>
            </tr>
        </table>
    </form>
    <br />
    <form action="SettingsController" method="post">
        <table>
            <tr>
                <td><input style="width: 400px;" type="submit" name="changeUsername" class="submit" value="Change Username"/></td>
            </tr>
            <tr>
                <td><input style="width: 400px;" type="submit" name="changePassword" class="submit" value="Change Password"/></td>
            </tr>
        </table>
    </form>

</div>