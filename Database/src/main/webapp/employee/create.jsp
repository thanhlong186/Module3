<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 22/02/2022
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-9">
            <form action="/employees?action=create" method="post">
                <div class="form-group">
                        <label for="employee-name">Name</label>
                    <input type="text" class="form-control" id="employee-name" name="employee_name">
                </div>
                <div class="form-group">
                    <label for="employee-birthday">Birthday</label>
                    <input type="date" class="form-control" id="employee-birthday" name="employee_birthday">
                </div>
                <div class="form-group">
                    <label for="employee-id-card">Id Card</label>
                    <input type="text" class="form-control" id="employee-id-card" name="employee_id_card">
                </div>
                <div class="form-group">
                    <label for="employee-salary">Salary</label>
                    <input type="text" class="form-control" id="employee-salary" name="employee_salary">
                </div>
                <div class="form-group">
                    <label for="employee-phone">Phone</label>
                    <input type="text" class="form-control" id="employee-phone" name="employee_phone">
                </div>
                <div class="form-group">
                    <label for="employee-email">Email</label>
                    <input type="text" class="form-control" id="employee-email" name="employee_email">
                </div>
                <div class="form-group">
                    <label for="employee-address">Address</label>
                    <input type="text" class="form-control" id="employee-address" name="employee_address">
                </div>
                <div class="form-group">
                    <label for="position-id">Position Id</label>
                    <select class="form-control" id="position-id" name="position_id">
                        <c:forEach var="type" items="${positionList}">
                            <option value="${type.positionId}">${type.positionName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="education-degree-id">Education Degree Id</label>
                    <select class="form-control" id="education-degree-id" name="education_degree_id">
                        <c:forEach var="type" items="${educationDegreeList}">
                            <option value="${type.educationDegreeId}">${type.educationDegreeName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="division-id">Division Id</label>
                    <select class="form-control" id="division-id" name="division_id">
                        <c:forEach var="type" items="${divisionList}">
                            <option value="${type.divisionId}">${type.divisionName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="user-name">Username</label>
                    <input type="text" class="form-control" id="user-name" name="username">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
