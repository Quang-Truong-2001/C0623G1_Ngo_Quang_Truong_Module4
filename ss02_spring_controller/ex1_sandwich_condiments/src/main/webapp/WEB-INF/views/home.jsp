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
<h1>Sandwich Condiments</h1>
<form action="/save">
    <input type="checkbox" id="condiments1" name="condiment" value="Lettuce">
    <lable for="condiments1">Lettuce</lable>
    <input type="checkbox" id="condiments2" name="condiment" value="Tomato">
    <lable for="condiments2">Tomato</lable>
    <input type="checkbox" id="condiments3" name="condiment" value="Mustard">
    <lable for="condiments3">Mustard</lable>
    <input type="checkbox" id="condiments4" name="condiment" value="Sprouts">
    <lable for="condiments4">Sprouts</lable>
    <br>
    <input type="submit" value="submit">
</form>
</body>
</html>
