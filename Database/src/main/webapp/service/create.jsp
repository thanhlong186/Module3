<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 22/02/2022
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Service</title>
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-9">
            <form action="/services?action=create" method="post">
                <div class="form-group">
                    <label for="service_code">Code</label>
                    <input type="text" class="form-control" id="service_code" name="service_code">
                </div>
                <div class="form-group">
                    <label for="service_name">Name</label>
                    <input type="text" class="form-control" id="service_name" name="service_name">
                </div>
                <div class="form-group">
                    <label for="service_area">Area</label>
                    <input type="text" class="form-control" id="service_area" name="service_area">
                </div>
                <div class="form-group">
                    <label for="service_cost">Cost</label>
                    <input type="text" class="form-control" id="service_cost" name="service_cost">
                </div>
                <div class="form-group">
                    <label for="service_max_people">Max People</label>
                    <input type="text" class="form-control" id="service_max_people" name="service_max_people">
                </div>
                <div class="form-group">
                    <label for="rent_type_id">Rent Type Id</label>
                    <select class="form-control" id="rent_type_id" name="rent_type_id">
                        <c:forEach var="type" items="${rentTypeList}">
                            <option value="${type.rentTypeId}">${type.rentTypeName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="service_type_id">Service Type Id</label>
                    <select class="form-control" id="service_type_id" name="service_type_id">
                        <c:forEach var="type" items="${serviceTypeList}">
                            <option value="${type.serviceTypeId}">${type.serviceTypeName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="standard_room">Standard Room</label>
                    <input type="text" class="form-control" id="standard_room" name="standard_room">
                </div>
                <div class="form-group">
                    <label for="description_other_convenience">description Other Convenience</label>
                    <input type="text" class="form-control" id="description_other_convenience" name="description_other_convenience">
                </div>
                <div class="form-group">
                    <label for="pool_area">Pool Area</label>
                    <input type="text" class="form-control" id="pool_area" name="pool_area">
                </div>
                <div class="form-group">
                    <label for="number_of_floor">Number of Floor</label>
                    <input type="text" class="form-control" id="number_of_floor" name="number_of_floor">
                </div>


                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
