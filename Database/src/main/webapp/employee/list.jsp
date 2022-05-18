<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 18/02/2022
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
</head>
<body>
<h1>Employee List</h1>
<p>
    <a class="btn btn-success" href="/employees?action=create">Create New Employee</a>
</p>
<table border="1" id="employee" class="table table-striped table-bordered" style="width:100%">
    <thead>
    <tr>
    <th scope="col">Id</th>
    <th scope="col">Name</th>
    <th scope="col">Birthday</th>
    <th scope="col">Id Card</th>
    <th scope="col">Salary</th>
    <th scope="col">Phone</th>
    <th scope="col">Email</th>
    <th scope="col">Address</th>
    <th scope="col">Position Id</th>
    <th scope="col">Education Degree Id</th>
    <th scope="col">Division Id</th>
    </tr>
    </thead>
<tbody>
<c:forEach var="employee" items="${employees}">
    <tr>
        <td >${employee.employeeId}</td>
        <td >${employee.employeeName}</td>
        <td >${employee.employeeBirthday}</td>
        <td >${employee.employeeIdCard}</td>
        <td >${employee.employeeSalary}</td>
        <td >${employee.employeePhone}</td>
        <td >${employee.employeeEmail}</td>
        <td >${employee.employeeAddress}</td>
        <td >${employee.positionName}</td>
        <td >${employee.educationDegreeName}</td>
        <td >${employee.divisionName}</td>
        <td>
            <button class="btn btn-warning">Edit</button>
            <button onclick="deleteEmployee('${employee.employeeId}','${employee.employeeName}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
                Delete
            </button>
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
                Are you sure delete <span class="text-danger" id="name-customer"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button onclick="submitFormDelete()" type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>

<form hidden id="form-delete" method="post" action="/employee">
    <input type="text" name="action" value="delete">
    <input type="text" name="id" id="employeeId">
</form>

<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.bundle.js"></script>

<script>
    $(document).ready(function() {
        $('#employee').DataTable();
    } );
</script>
<script>
    function deleteEmployee(id, name) {
        document.getElementById("employeeId").value = id;
        document.getElementById("employeeName").innerText = name;
    }
    function submitFormDelete() {
        document.getElementById("form-delete").submit();
    }
</script>
</body>
</html>
