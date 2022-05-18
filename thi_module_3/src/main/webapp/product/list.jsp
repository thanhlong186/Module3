<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 23/02/2022
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" type="text/css" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
</head>
<body>
<style>
    h1,p {
        text-align: center;
    }
    form {
        display: inline-block;
    }
</style>

    <h1>Product list</h1>
<p>
    <a class="btn btn-success" href="/products?action=create">Create new Product</a>
</p>

<form action="/products?action=search" method="post" align="center">
    <button type="submit">Search</button>
    <input type="text" name="name"  placeholder="name customer">
</form>
<table border="1"  id="product" class="table table-striped table-bordered" style="width:100%">

    <thead>
    <tr>
        <th scope="col"> Id</th>
        <th scope="col"> Name</th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
        <th scope="col">Color</th>
        <th scope="col">Category</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <%--        </td>${customer.customerName}</td>--%>
        <tr>
            <td >${product.productId}</td>
            <td >${product.productName}</td>
            <td >${product.price}</td>
            <td >${product.quantity}</td>
            <td >${product.color}</td>
            <td >${product.categoryName}</td>

            <td>
                <button class="btn btn-warning"><a href="/products?action=edit&id=${Product.productId}">Edit</a></button>
                <button onclick="deleteCustomer('${product.productId}','${product.productName}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure delete <span class="text-danger" id="customer_name"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button onclick="submitFormDelete()" type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>

<form hidden id="form-delete" method="post" action="/products">
    <input type="text" name="action" value="delete">
    <input type="text" name="id" id="customer_id">
</form>
<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.bundle.js"></script>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>

<script>
    $(document).ready(function() {
        $('#product').DataTable();
    } );
</script>
<script>
    function deleteCustomer(id, name) {
        document.getElementById("id_product").value = id;
        document.getElementById("name_product").innerText = name;
    }

    function submitFormDelete() {
        document.getElementById("form-delete").submit();
    }
</script>
</body>
</html>
