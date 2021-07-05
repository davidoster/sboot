<%-- 
    Document   : register
    Created on : Jul 5, 2021, 11:19:56 AM
    Author     : George.Pasparakis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register a user</title>
    </head>
    <body>
        <h1>Fill in the form to register a user</h1>
       
        <f:form action="/users/register" method="POST" modelAttribute="user">
            <label for="username">User Name:</label>
            <f:input path="username" /><br>
            <label for="password">Password:</label>
            <f:input path="password" /><br>
            <input type="submit" value="Register a user">
        </f:form>
    </body>
</html>
