<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 18/02/2022
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-9">
            <form action="/customers?action=create" method="post" class="needs-validation" novalidate>
                <div class="form-group">
                    <label for="customer_code">Code</label>
                    <input type="text" class="form-control" id="customer_code" name="customer_code" required  pattern="(KH-)[0-9]{4}">
                    <div class="valid-feedback">Hợp lệk</div>
                    <div class="invalid-feedback">Vui lòng nhập voi dinh dang KH-XXXX</div>
                </div>
                <div class="form-group">
                    <label for="customer_name">Name</label>
                    <input type="text" class="form-control" id="customer_name" name="customer_name">
                </div>
                <div class="form-group">
                    <label for="customer_birthday">Birthday</label>
                    <input type="date" class="form-control" id="customer_birthday" name="customer_birthday">
                </div>
                <div class="form-group">
                    <label for="customer_gender">Gender</label>
                    <select class="form-control" id="customer_gender" name="customer_gender" required>
                        <option  value="">Chọn...</option>
                        <option value="true" >Nam</option>
                        <option value="false" >Nữ</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="customer_id_card">Id Card Customer</label>
                    <input type="text" class="form-control" id="customer_id_card" name="customer_id_card">
                </div>
                <div class="form-group">
                    <label for="customer_phone">Phone</label>
                    <input type="text" class="form-control" id="customer_phone" name="customer_phone">
                </div>
                <div class="form-group">
                    <label for="customer_email">Email</label>
                    <input type="text" class="form-control" id="customer_email" name="customer_email">
                </div>
                <div class="form-group">
                    <label for="customer_address">Address</label>
                    <input type="text" class="form-control" id="customer_address" name="customer_address">
                </div>
                <div class="form-group">
                    <label for="category">CustomerType</label>
                    <select class="form-control" id="category" name="customer_type_id">
                        <c:forEach var="type" items="${customerTypeList}">
                            <option value="${type.customerTypeId}">${type.customerTypeName}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>

<script>
    // Disable form submissions if there are invalid fields
    (function() {
        'use strict';
        window.addEventListener('load', function() {
            // Get the forms we want to add validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>
</body>
</html>
