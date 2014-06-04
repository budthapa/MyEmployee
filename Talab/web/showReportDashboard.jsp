<%-- 
    Document   : showReportDashboard
    Created on : Mar 12, 2014, 11:24:46 AM
    Author     : budthapa
--%>

<%@page import="com.budthapa.model.Navigation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report Dashboard</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            out.println("<hr />");
        Navigation navigate=(Navigation)request.getAttribute("nav");
        %>
        <jsp:include page="reportDashboard.jsp"></jsp:include>
        <%    
        navigate.getRecords();
        %>
        <jsp:include page="leftNav.jsp"></jsp:include>
        <% out.println("<hr />");%>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
