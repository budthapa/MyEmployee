<%-- 
    Document   : payment
    Created on : Mar 12, 2014, 6:17:23 PM
    Author     : budthapa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="mainStyle.css" type="text/css" >
<div class="mainContent">
    <h2>Payment Terminal</h2>

    <form action="EmployeeServlet" method="post">
        <table>
            <tr>
                <td>Employee Id</td>
                <td><input type="text" name="empId" maxlength="15" disabled=""/></td>
            </tr>
            <tr>
                <td>Employee Name</td>
                <td><input type="text" name="empName" maxlength="45"/></td>
            </tr>
            <tr>
                <td>Department</td>
                <td><input type="text" name="department" maxlength="30"/></td>
            </tr>
            <tr>
                <td>Month</td>
                <td><input type="text" name="month" maxlength="30"/></td>
            </tr>
            <tr>
                <td>Basic Salary</td>
                <td><input type="text" name="salary" maxlength="8"/></td>
            </tr>
            <tr>
                <td>Allowance</td>
                <td><input type="text" name="allowance" maxlength="8"/></td>
            </tr>
            <tr>
                <td>Deduct</td>
                <td><input type="text" name="deduct" maxlength="8"/></td>
            </tr>
            <tr>
                <td>Net Payment</td>
                <td><input type="text" name="netpayment" maxlength="8"/></td>
            </tr>
            
            <tr>
                <td>Remarks</td>
                <td><input type="text" name="remarks"/></td>
            </tr>
            <tr>
                <td style="text-align: center;"><input type="reset" value="Reset Form"/></td>
                <td style="text-align: center;"><input type="submit" value="Make Payment" name="makePayment"/></td>
            </tr>
        </table>
    </form>
</div>