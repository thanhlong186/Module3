<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 25/01/2022
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
  .discount {
    height:250px; width:250px;
    margin:0;
    padding:10px;
    border:1px #CCC solid;
  }
  .discount input {
    padding:5px; margin:5px
  }
</style>
<body>
<form action="product" method="post">
  <div class="discount ">
    <h2>Product Discount Calculator</h2>
    <input type="text" name="productDescription" size="30"  placeholder="Product Description" />
    <input type="number" name="listPrice" size="30"  placeholder="List Price" value="0"/>
    <input type="number" name="discountPercent" size="30"  placeholder="Discount Percent" value="0"/>
    <input type="submit" value="calculate Discount"/>
  </div>
<%--  <label>Product Description : </label>--%>
<%--  <input type="text" name="productDescription"><br>--%>

<%--  <label>List Price : </label><br/>--%>
<%--  <input type="text" name="listPrice" value="0"><br>--%>

<%--  <label>Discount Percent : </label><br/>--%>
<%--  <input type="text" name="discountPercent" value="0"><br>--%>

<%--  <input type="submit" value="input">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
