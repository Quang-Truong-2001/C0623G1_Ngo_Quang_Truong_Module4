<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13/10/2023
  Time: 1:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách các gia vị bạn đã chọn</h1>
    <c:forEach items="${result}" var="condiment" >
        <h3>${condiment}</h3>
    </c:forEach>

</body>
</html>
