<%-- 
    Document   : getdata
    Created on : Mar 11, 2014, 1:00:03 PM
    Author     : budthapa
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.budthapa.common.DBConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Get Data from database</h1>
        <%
          String sql="select * from employee";
          try{
          PreparedStatement ps= DBConnection.getConnect().prepareStatement(sql);
          ResultSet rs=ps.executeQuery();
          while(rs.next()){
              List li=new ArrayList();
              li.add(rs);
              out.println(rs);
          }
          }catch(SQLException e){
              System.out.println(e);
          }
            
            
            
            
            
            
            
            %>
    </body>
</html>
