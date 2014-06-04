<%-- 
    Document   : showNavMainDashboard
    Created on : Mar 11, 2014, 6:28:50 PM
    Author     : budthapa
--%>

<%@page import="com.budthapa.model.Navigation"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Registration</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            out.println("<hr />");
            Navigation navigate=(Navigation)request.getAttribute("nav");
            %>
            
            <jsp:include page="employeeRegistration.jsp"></jsp:include>
            <%
            navigate.getMakePayment();
            
            %>
            <jsp:include page="leftNav.jsp"></jsp:include>
            <%
            out.println("<hr />");
            %>
            <jsp:include page="footer.jsp"></jsp:include>
            
    </body>
</html>
