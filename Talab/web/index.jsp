<%-- 
    Document   : index
    Created on : Mar 6, 2014, 8:20:13 PM
    Author     : bud
--%>

<%@page import="com.budthapa.model.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Talab : Simple Payroll Solution</title>
        <link rel="stylesheet" type="text/css" href="mainStyle.css" />
        <script type="text/javascript">
            function validate() {
                var username = document.getElementById("username").value;
                var password = document.getElementById("password").value;
                if (username === "" || username === null) {
                    alert("Username is empty.");
                } else if (password === "" || password === null) {
                    alert("Password is empty.");
                }

                var loginForm = document.getElementsByName("loginForm");
                if (loginForm !== null) {
                    loginForm.action = "/Dashboard";
                    loginForm.submit();
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="login">
                <form method="post" id="loginForm" action="Dashboard" name="loginForm">
                    <table>
                        <tr>
                            <td>Username </td><td><input type="text" name="username" id="username" /></td>
                        </tr>
                        <tr>
                            <td>Password </td><td><input type="password" name="password" id="password" /></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="rememberMe" />Remember me</td>
                            <td style="text-align: center;"><input type="submit" value="Go Inside" name="submit" onclick="validate()"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td style="text-align: center;"><a href="resetPassword">Forgot Password?</a></td>
                        </tr>
                    </table>
                </form>
            <% //  Login log=new Login();

                //            if(request.getAttribute("login")==null){
                //                out.println("Username or Password mismatch");    
                //            }
                if ((String) request.getSession(true).getAttribute("sessionName") != null) {

//                        response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //http 1.1
//                        response.setHeader("Pragma", "no-cache"); //http 1.0
//                        response.setDateHeader("Expires", 0); //prevents caching at the proxy server
//                        
                    session.invalidate();
//                        response.sendRedirect("index.jsp");
                }
            %>

            <%

            %>
        </div>
    </body>
</html>

