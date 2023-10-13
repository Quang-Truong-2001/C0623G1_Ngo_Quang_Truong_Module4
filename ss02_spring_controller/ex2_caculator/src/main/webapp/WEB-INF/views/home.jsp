<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13/10/2023
  Time: 1:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Caculator</h1>
<form action="/caculator">
    <input type="number" id="condiments1" name="numberOne" >
    <lable for="condiments1"></lable>
    <select name="operator">
        <option value="Addition">Addition</option>
        <option value="Subtraction">Subtraction</option>
        <option value="Multiplication">Multiplication</option>
        <option value="Division">Division</option>
    </select>
    <input type="number" id="condiments2" name="numberTwo" >
    <lable for="condiments2"></lable>
    <br>
    <br>
    <input type="submit" value="Caculator">
</form>
<lable>Kết quả</lable>
<input type="text" value="${result}">
</body>
</html>
