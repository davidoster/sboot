<%-- 
    Document   : products
    Created on : Jun 22, 2021, 9:22:09 PM
    Author     : George.Pasparakis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.25/datatables.min.css"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.25/datatables.min.js"></script>
    </head>
    <body>
        <h1>List of Products</h1>
        <table id="products_table" class="display" style="width:100%">
            <thead>
                <tr>
                    <th>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Description</td>
                    <td>Price</td>
                    <td>Image</td>
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${products}" var="product">  

                    <tr>
                        <td><c:out value="${product.id}"/></td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td>${product.image}</td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
    <script>
        $(document).ready(function() {
        $('#products_table').DataTable();
        } );
    </script>
</body>
</html>
