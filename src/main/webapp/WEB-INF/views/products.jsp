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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/css/style.css" >
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.25/datatables.min.js"></script>
    </head>
    <body>
        <h1>List of Products</h1>
        <a href="/products/new" class="btn btn-primary">New Product</a>
        <table id="products_table" class="display" style="width:100%">
        <thead>
            <td>ID</td>
            <td>Name</td>
            <td>Description</td>
            <td>Price</td>
            <td>Image</td>
            <td>Actions</td>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="product">  
                <tr>
                    <td><c:out value="${product.id}"/></td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td><img src="${product.image}" class="img-responsive" alt="${product.name}"></td>
                    <td><a href="/products/edit/${product.id}" class="btn btn-info">Edit</a>&nbsp;<a href="/products/delete/${product.id}" class="btn btn-danger">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/products/new" class="btn btn-primary">New Product</a>
    <script>
        $(document).ready(function () {
            $('#products_table').DataTable();
        });
    </script>
</body>
</html>
