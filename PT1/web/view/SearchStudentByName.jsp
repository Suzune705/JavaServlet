<%-- 
    Document   : SearchStudentByName
    Created on : Sep 30, 2025, 2:05:27 PM
    Author     : hieuchu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Student" %>
<%@page import= "java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            li{
                border: 1px solid black ;
                width: 200px;                
            }
        </style>
    </head>
    <body>
        <h1> Found Student </h1>
        <%@include file="ListOfStudent.jsp" %>
        <%
        Student s = (Student) request.getAttribute("studentName");
                 if (s != null) {
        %>
        <ul>
            <li>ID: <%= s.getStudentID() %></li>
            <li>Name: <%= s.getStudentName() %></li>
            <li>Age: <%= s.getStudentAge() %></li>
            <li>Gender: <%= s.getStudentGender() %></li>
            <li>Address: <%= s.getStudentAddress() %></li>
            <li>Score: <%= s.getStudentScore() %></li>
        </ul>
        <%
            } else {
        %>
        <p> Student is not exist </p>
        <%
            }
        %>

        <form action = "SearchStudentByName" method = "post">
            <label>Enter student name : </label>
            <input type="text" name="studentName">
            <button type="submit"> Search </button>
        </form>
    </body>
</html>
