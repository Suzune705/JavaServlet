<%-- 
    Document   : ListOfStudent
    Created on : Sep 30, 2025, 1:05:38 PM
    Author     : hieuchu
--%>

<%@page import="model.Student" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    List<Student> list = (List<Student>)request.getAttribute("highestScoreStudent");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            td, th , tr {
                border: 1px solid black ;
            }
        </style>            
    </head>
    <body>
        <h1> List Of Highest Score Student </h1>
        <table>
            <tr>
                <th> ID </th>
                <th> Name </th>
                <th> Age </th>
                <th> Gender </th>
                <th> Address </th>
                <th> Score </th>                
            </tr>
            <%
                for(Student s : list){                
            %>
            <tr>
                <td> <%= s.getStudentID() %></td>
                <td> <%= s.getStudentName() %></td>
                <td> <%= s.getStudentAge() %></td>
                <td> <%= s.getStudentGender() %></td>
                <td> <%= s.getStudentAddress() %></td>
                <td> <%= s.getStudentScore() %></td>
            </tr>
            <%
            }
            %>

        </table>
    </body>
</html>
