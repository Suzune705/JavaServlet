<%-- 
    Document   : ManagerDashBoard
    Created on : Oct 7, 2025, 2:01:27 PM
    Author     : hieuchu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List" %> 
<%@page import="model.Employee" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            tr, th , td {
                border: 1px solid black ;
                padding: 10px ;
            }
            .form label, form input {
                display: block;
                margin: 10px;
            }
            .function{
                display: flex;
                justify-content: space-around;
                align-items: flex-start;
                margin-top: 30px;
            }
        </style>
    </head>
    <body>
        <h1> Show Employees</h1>
        <table>
            <tr>
                <th> ID </th>
                <th> Name </th>
                <th> Phone </th>
                <th> Age </th> 
            </tr>   
            <c:forEach var="e" items="${empList}" >
                <tr>
                    <td> ${e.employeeID}</td>
                    <td> ${e.name}</td>
                    <td> ${e.phone}</td>
                    <td> ${e.age}</td>
                </tr>
            </c:forEach>
        </table>

        <div class="function">

            <div class="content3">
                <h1> Add Employee </h1>
                <c:if test="${not empty error}">
                    <div style="color:red;">${error}</div>
                </c:if>
                <form action="AddEmployee" method="post">
                    <labeL> Enter employee_id </label>
                    <input type="text" name="employee_id">
                    <label> Enter name </label>
                    <input type="text" name="name">
                    <labeL> Enter phone </label>
                    <input type="text" name="phone">
                    <labeL> Enter age </label>
                    <input type="text" name="age">
                    <button type="submit"> add employee </button>
                </form>
            </div>

            <div class="content3">
                <h1> Update Employee </h1>
                <form action="UpdateEmployee" method="post">
                    <labeL> Enter employee_id </label>
                    <input type="text" name="employee_id">
                    <label> Enter name </label>
                    <input type="text" name="name">
                    <labeL> Enter phone </label>
                    <input type="text" name="phone">
                    <labeL> Enter age </label>
                    <input type="text" name="age">
                    <button type="submit"> update employee </button>
                </form>
            </div>
            <div class="content3">
                <h1> Delete Employee </h1>
                <c:if test="${not empty error2}">
                    <div style="color:red;">${error2}</div>
                </c:if>
                <form action="DeleteEmployee" method="post">
                    <labeL> Enter employee_id </label>
                    <input type="text" name="employee_id">                    
                    <button type="submit"> delete employee </button>
                </form>
            </div>
            <div class="content3">
                <h1> Search Employee </h1>
                <input readonly value="${emp.employeeID}" style="padding: 10px"> <br>              
                <input readonly value="${emp.name}" style="padding: 10px"> <br>              
                <input readonly value="${emp.phone}" style="padding: 10px"> <br>              
                <input readonly value="${emp.age}" style="padding: 10px"> <br>             
                <form action="SearchEmployee" method="post">
                    <div>
                        <labeL> Enter employee_id </label>
                        <input type="text" name="employee_id"> 
                    </div>
                    <div>
                        <labeL> Enter name </label>
                        <input type="text" name="name"> 
                    </div>
                    <button type="submit"> search employee </button>
                </form>
            </div>
        </div>
    </body>
</html>
