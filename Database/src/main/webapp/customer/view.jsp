<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 21/02/2022
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Customer</title>
    <link rel="stylesheet" type="text/css" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
</head>
<body>
<p>
    <a class="btn btn-success" href="/customers">Back to customer list</a>
</p>
    <div class="container-fluid">
        <div class="row">
            <div class="col-3">
            </div>
            <div class="col-9">
                <form method="post">
                    <div class="form-group">
                        <label for="customer-id">Id Customer</label>
                        <input value="${customer.customerID}" type="text" class="form-control" id="customer-id" name="customer_id">
                    </div>
                    <div class="form-group">
                        <label for="customer-code">Code Customer</label>
                        <input value="${customer.customerCode}" type="text" class="form-control" id="customer-code" name="customer_code" >
                    </div>
                    <div class="form-group">
                        <label for="customer-name">Name Customer</label>
                        <input value="${customer.customerName}" type="text" class="form-control" id="customer-name" name="customer_name">
                    </div>
                    <div class="form-group">
                        <label for="customer-birthday">Birthday</label>
                        <input value="${customer.customerBirthday}" type="date" class="form-control" id="customer-birthday" name="customer_birthday">
                    </div>
                    <div class="form-group">
                        <label for="customer_gender">Gender</label>
                        <select class="form-control" id="customer_gender" name="customer_gender" required>
                            <option value="true" ${requestScope["customer"].getCustomerGender()?"selected":''}>Nam</option>
                            <option value="false" ${!requestScope["customer"].getCustomerGender()?"selected":''} >Nữ</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="customer-id-card">Id Card Customer</label>
                        <input value="${customer.customerIdCard}" type="text" class="form-control" id="customer-id-card" name="customer_id_card">
                    </div>
                    <div class="form-group">
                        <label for="customer-phone">Phone</label>
                        <input value="${customer.customerPhone}" type="text" class="form-control" id="customer-phone" name="customer_phone">
                    </div>
                    <div class="form-group">
                        <label for="customer-email">Email</label>
                        <input value="${customer.customerEmail}" type="text" class="form-control" id="customer-email" name="customer_email">
                    </div>
                    <div class="form-group">
                        <label for="customer-address">Address</label>
                        <input value="${customer.customerAddress}" type="text" class="form-control" id="customer-address" name="customer_address">
                    </div>

                    <div class="form-group">
                        <label for="category">CustomerType</label>
                        <select class="form-control" id="category" name="customer_type_id">
                            <c:forEach var="type" items="${customerTypeList}">
                                <option value="${type.customerTypeId}">${type.customerTypeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>
        </div>
    </div>
<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.bundle.js"></script>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>
</body>
</html>
