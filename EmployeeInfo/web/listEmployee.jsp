<%--
   Document   : listEmployee
   Created on : Mar 10, 2014, 6:27:34 PM
   Author     : budthapa
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.budthapa.model.Employee"%>
<%@page import="com.budthapa.dao.EmployeeDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="mainStyle.css" type="text/stylesheet" />

<div class="mainContent">
    <h2>Employee List</h2>
    <!--//check the session name-->

    <%  
        List<Employee> list = (List<Employee>)request.getAttribute("listData");        
        if(list == null ){
            list = new ArrayList();
        }
                
        //check the total number of content in the list
        float size = list.size(); 
        float noOfPage = size / 5;
        System.out.println("noOfPage"+noOfPage);
        //find the total number of anchor links needed
        double anchorPage=Math.ceil(noOfPage);
        System.out.println("anchorPage"+anchorPage);
        
        //display the page number
        for(int pageNo=1;pageNo<=anchorPage;pageNo++){
            out.print("<a href=''>"+pageNo+" "+"</a>");
            
        }
        
        //display number of list in the page
        int limit=4; //display 5 list per page
        for(int start=0;start<limit+start;start++){
            
        
    %>
    <form name="form" >
        <table border="1" cellpadding="3">
            <tr>
                <th>Employee Id</th>
                <th>Employee Name</th>
                <th>Department</th>
                <th>Post</th>
                <th>Salary</th>
                <th>Gender</th>
                <th>Age</th>
                <th>Join Date</th>
                <th>Email</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <%for (int i = 0; i < list.size(); i++) {%>

            <tr>
                <td>
                    <%
                        out.println(list.get(i).getEmpId());
                    %>
                </td>
                <td>
                    <%
                        out.println(list.get(i).getEmpName());
                    %>
                </td>
                <td>
                    <%
                        out.println(list.get(i).getDepartment());
                    %>
                </td>
                <td>
                    <%
                        out.println(list.get(i).getPost());
                    %>
                </td>
                <td>
                    <%
                        out.println(list.get(i).getSalary());
                    %>
                </td>
                <td>
                    <%
                        out.println(list.get(i).getGender());
                    %>
                </td>
                <td>
                    <%
                        out.println(list.get(i).getAge());
                    %>
                </td>
                <td>
                    <%
                        out.println(list.get(i).getJoinDate());
                    %>
                </td>
                <td>
                    <%
                        out.println(list.get(i).getEmail());
                    %>
                </td>
                <td>
                    <a href="EmployeeServlet?q=<%=list.get(i).getEmpId()%>" name="editEmployee">Edit</a>
                </td>
                <td>
                    <a href="" name="deleteEmployee" onclick="carryContactsID(<%=list.get(i).getEmpId()%>)">Delete</a>
                </td>
                <%
                    }
             }
                %>
            </tr>
        </table>
    </form>
</div>