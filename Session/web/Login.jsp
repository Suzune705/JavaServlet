<%-- 
    Document   : Login
    Created on : Oct 3, 2025, 4:11:30 PM
    Author     : hieuchu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="Login" method="get">
            <div> 
                <label> Account : </label>
                <input type="text" name="account" placeholder="@gamail.com"> 
            </div>
            <br> 
            <div>
                <label> Password : </label>
                <input type="text" name="password">
            </div>     
            
            <button type="submit"> login</button>
        </form>
    </body>
</html>
