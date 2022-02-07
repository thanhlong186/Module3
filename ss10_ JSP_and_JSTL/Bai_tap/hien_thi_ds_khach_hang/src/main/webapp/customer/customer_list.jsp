<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 07/02/2022
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách khách hàng</h2>
<table border ="1">
    <tr>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <%--    for(Customers customers : customesList(list)--%>
    <c:forEach var="customer" items="${list}">
        <tr>
                <%--                <td>${customers.ngaySinh}</td>--%>
            <td><c:out value="${customer.ten}"></c:out></td>
            <td><c:out value="${customer.ngaySinh}"></c:out></td>
            <td><c:out value="${customer.diaChi}"></c:out></td>
            <td><img  src="${customer.anh}" alt="" width="100px"></td>
                <%--                <td><c:out value="${customers.anh}"></c:out></td>--%>
        </tr>
    </c:forEach>
</table>

</body>
</html>
