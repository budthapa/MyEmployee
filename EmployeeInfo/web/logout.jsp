<%-- 
    Document   : logout
    Created on : Mar 28, 2014, 9:22:42 PM
    Author     : budthapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //http 1.1
    response.setHeader("Pragma", "no-cache"); //http 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%//            response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //http 1.1
//            response.setHeader("Pragma", "no-cache"); //http 1.0
//            response.setDateHeader("Expires", 0); //prevents caching at the proxy server
            if ((String) request.getSession(true).getAttribute("sessionName") != null) {

                session.invalidate();
                    response.sendRedirect(response.encodeRedirectURL("logout.jsp"));
            }
        %>

    </body>
</html>
