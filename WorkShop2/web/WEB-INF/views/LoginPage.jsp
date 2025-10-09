<%-- 
    Document   : LoginPage
    Created on : Oct 7, 2025, 2:01:10 PM
    Author     : hieuchu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .content{
                max-width: 300px;
                padding: 20px;
            }
            .content label{
                display: inline-block;
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <div class="content">
            <h1> Login Account </h1>
            <form action="Login" method="post">  
                <div class="Account">
                <label>Account</label>
                <input type="text" name="account">
                </div>
                <div class="Password">
                <label>Password</label>
                <input type="text" name="password">           
                </div>
                <div class="Button">
                    <button type="submit">Login</button>
                </div>                   
            </form>
        </div>
    </body>
</html>
