<%-- 
    Document   : leftNav
    Created on : Mar 7, 2014, 8:07:47 PM
    Author     : bud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="mainStyle.css" type="text/css" >
<div class="leftNav">
    <form action="GoWhere" method="get">
        <input type="submit" class="submit" value="Home" name="dashboard" />
        <input type="submit" class="submit" value="Make Payment" name="makePayment" />
        <input type="submit" class="submit" value="Add Employee" name="addEmployee" />
        <input type="submit" class="submit" value="Report" name="report" />
        <input type="submit" class="submit" value="Settings" name="settings" />
        <input type="submit" class="submit" value="Exit" name="logout" />
        
    </form>
</div>