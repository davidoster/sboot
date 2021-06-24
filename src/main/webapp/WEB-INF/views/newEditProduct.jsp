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
        <title>${title}</title>
    </head>
    <body>
        <h1>${h1}</h1>
        <f:form action="${action}" method="POST" modelAttribute="product">
            Name: <f:input path="name"  />
            Description: <f:input path="description"  />
            Price: <f:input path="price"  />
            Image: <f:input path="image"  />
            <f:hidden path="id" readonly="true" />
            <input type="submit" value="${submit}" />
        </f:form>
    </body>
</html>
