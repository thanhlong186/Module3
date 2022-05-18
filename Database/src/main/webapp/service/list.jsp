<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 20/02/2022
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Service List</title>
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
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

<h1>Service list</h1>
<p>
    <a class="btn btn-success" href="/services?action=create">Create new Service</a>
</p>

<table border="1" id="service" class="table table-striped table-bordered" style="width:100%">
    <thead>
    <tr>
    <td scope="col">Service Id</td>
    <td scope="col">Service Code</td>
    <td scope="col">Service Name</td>
    <td scope="col">Service Area</td>
    <td scope="col">Service Cost</td>
    <td scope="col">Service Max People</td>
    <td scope="col">Rent Type Id</td>
    <td scope="col">Service Type Id</td>
    <td scope="col">standard Room</td>
    <td scope="col">Description Ohter Convenience</td>
    <td scope="col">Pool area</td>
    <td scope="col">Number of Floor</td>
    </tr>
    </thead>

    <tbody>
<%--    // items phải giống name bên p/t list.jsp--%>
<c:forEach var="service" items="${services}">

    <tr>
    <td >${service.serviceId}</td>
    <td >${service.code}</td>
    <td >${service.serviceName}</td>
    <td >${service.serviceArea}</td>
    <td >${service.serviceCost}</td>
    <td >${service.serviceMaxPeople}</td>
    <td >${service.rentTypeName}</td>
    <td >${service.serviceTypeName}</td>
    <td >${service.standardRoom}</td>
    <td >${service.descriptionOtherConvenience}</td>
    <td >${service.poolArea}</td>
    <td >${service.numberOfFloor}</td>
    <td>
    </tbody>
    </tr>
    </c:forEach>
    </tbody>
</table>

<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.bundle.js"></script>

<script>
    $(document).ready(function() {
        $('#service').DataTable();
    } );
</script>

</body>
</html>
