<%-- 
    Document   : header
    Created on : Mar 6, 2014, 9:49:43 PM
    Author     : bud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    .header{
        background-color: cadetblue;
        padding: 1px 0px 1px 10px;
        border-radius: 4px;
        text-align: center;

    }
    .header h1{
        font-size: 30px;
    }
</style>
<div class="header">
    <h1>Talab</h1>
    <h2>Simple Payroll Solution</h2>
    <%
        //check the session name
        String sessionName = (String) (request.getSession().getAttribute("sessionName"));

        if (sessionName == null) {
            response.sendRedirect("index.jsp");
        } else {
            out.println("Welcome : " + request.getSession().getAttribute("sessionName"));
        }
  %>    
</div>