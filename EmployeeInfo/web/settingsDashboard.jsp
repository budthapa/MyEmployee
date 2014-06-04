<%-- 
    Document   : settingsDashboard
    Created on : Mar 12, 2014, 12:36:36 PM
    Author     : budthapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="mainStyle.css" type="text/css" >
<div class="mainContent">
    <h2>Settings</h2>
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