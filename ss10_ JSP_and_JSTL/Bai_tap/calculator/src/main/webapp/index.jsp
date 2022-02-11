<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 09/02/2022
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Calculator</title>
  </head>
  <body>
  <h2>Simple Caculator</h2>

  <form action="/calculate" method="post" >
    <fieldset>
      <legend>Caculator</legend>
      <td>
      <th><label>First operand:</label></th>
      <th><input type="text" name="first_operand"></th>
      </td><br/>
      <td>
      <th><label>Operator:</label></th>
      <th><select name ="operator">
        <option value="+">Addition</option>
        <option value="-">Subtraction</option>
        <option value="*">Multiplication</option>
        <option value="/">Division</option>
      </select></th>
      </td><br/>
      <td>
        <label>Second Operand:</label>
      <th><input type="text" name="second_operand"></th>
      </td><br/>
      <th><input type="submit" id="submit" value="Caculate"/></th>
    </fieldset>
  </form>
  </body>
</html>
