<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/10/2023
  Time: 2:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Chuyển đổi tiền đô</h2>
    <form action="/convert">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">USD</label>
            <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="usd">
        </div>
        <button type="submit" class="btn btn-primary">Chuyển</button>
    </form>
    <form>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">VND</label>
            <input type="number" class="form-control" id="exampleInputPassword1" value="${vnd}">
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
