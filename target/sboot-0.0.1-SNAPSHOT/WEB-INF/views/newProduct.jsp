<%-- 
    Document   : newproduct
    Created on : Jun 22, 2021, 9:24:23 PM
    Author     : George.Pasparakis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"        prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Product</title>
    </head>
    <body>
        <h1>Insert a New Product</h1>
        <f:form action="/products/new" method="POST" modelAttribute="product">
            Name: <f:input path="name"  />
            Description: <f:input path="description"  />
            Price: <f:input path="price"  />
            Image: <f:input path="image"  />
            <input type="submit" value="New Product" />
        </f:form>
    </body>
</html>
