<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 21/02/2022
  Time: 08:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>

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

<h1>Customer list</h1>
<p>
    <a class="btn btn-success" href="/customers?action=create">Create new Customer</a>
</p>

<form action="/customers?action=search" method="post" align="center">
    <button type="submit">Search</button>
    <input type="text" name="name"  placeholder="name customer">
</form>
<table border="1"  id="customer" class="table table-striped table-bordered" style="width:100%">

    <thead>
    <tr>
        <th scope="col"> Id</th>
        <th scope="col"> Code</th>
        <th scope="col"> Name</th>
        <th scope="col">Birthday</th>
        <th scope="col">Gender</th>
        <th scope="col">IdCard</th>
        <th scope="col">Phone</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Customer Type Id</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
<%--        </td>${customer.customerName}</td>--%>
        <tr>
            <td ><a href="/customers?action=view&customerID=${customer.customerID}">${customer.customerID}</a></td>
            <td >${customer.customerCode}</td>
            <td >${customer.customerName}</td>
            <td >${customer.customerBirthday}</td>
            <td >${customer.customerGender ? 'Nam':'Nữ'}</td>
            <td >${customer.customerIdCard}</td>
            <td >${customer.customerPhone}</td>
            <td >${customer.customerEmail}</td>
            <td >${customer.customerAddress}</td>
            <td >${customer.customerTypeName}</td>
            <td>
                <button class="btn btn-warning"><a href="/customers?action=edit&id=${customer.customerID}">Edit</a></button>
                <button onclick="deleteCustomer('${customer.customerID}','${customer.customerName}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</button>
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

<form hidden id="form-delete" method="post" action="/customers">
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
        $('#customer').DataTable();
    } );
</script>

<script>
    function deleteCustomer(id, name) {
        document.getElementById("customer_id").value = id;
        document.getElementById("customer_name").innerText = name;
    }

    function submitFormDelete() {
        document.getElementById("form-delete").submit();
    }
</script>
</body>
</html>
