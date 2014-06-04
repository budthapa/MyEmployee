<%-- 
    Document   : changeUsernamePassword
    Created on : Mar 12, 2014, 12:14:44 PM
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
        %>
        <jsp:include page="settingsDashboard.jsp"></jsp:include>
        <jsp:include page="leftNav.jsp"></jsp:include>
        <% out.println("<hr />");%>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
