<%-- 
    Document   : changeUsernamePassword
    Created on : Mar 10, 2014, 11:13:02 PM
    Author     : budthapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="mainStyle.css" type="text/css" >

<jsp:include page="header.jsp"></jsp:include>
<% out.println("<hr />"); %>
    <div class="mainContent">
        <h3>Change Username</h3>
        <form action="SettingsController" method="post">
            <table>
                <tr>
                    <td>New Password</td>
                    <td><input type="password" name="newPassword" maxlength="15" onchange="onSubmit()"/></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><input type="submit" value="Change Now"/></td>
                </tr>
            </table>
        </form>
         <%
        String newPass = (String) request.getAttribute("newPassword");
        if (newPass!=null) {
            out.println("<h3>Password changed successfully</h3>");
        }
    %>
    </div>
<jsp:include page="leftNav.jsp"></jsp:include>
<% out.println("<hr />"); %>
<jsp:include page="footer.jsp"></jsp:include>
