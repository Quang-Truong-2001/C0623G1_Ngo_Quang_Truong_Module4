<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17/10/2023
  Time: 10:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Setting</h2>
    <form:form modelAttribute="email" action="/update" method="post">
        <table>
            <tr>
                <td>Languages</td>
                <td>
                    <form:select path="language">
                        <form:option value="English" label="English"/>
                        <form:option value="Vietnamese" label="Vietnamese"/>
                        <form:option value="Japanese" label="Japanese"/>
                        <form:option value="Chinese" label="Chinese"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Page Size</td>
                <td>
                    <span>
                        show
                    </span>
                    <span>
                        <form:select path="pageSize">
                            <form:option value="5" label="5"/>
                            <form:option value="10" label="10"/>
                            <form:option value="15" label="15"/>
                            <form:option value="25" label="25"/>
                            <form:option value="50" label="50"/>
                            <form:option value="100" label="100"/>
                        </form:select>
                    </span>
                    <span>
                        emails per page
                    </span>
                </td>
            </tr>
            <tr>
                <td>Spams filter</td>
                <td>
                    <form:checkbox path="spam" label="enable spams filter"/>
                </td>

            </tr>
            <tr>
                <td>Signature</td>
                <td>
                    <form:textarea path="signature"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button class="btn btn-primary" type="submit">Update</button>
                </td>
                <td>
                    <a class="btn btn-warning" role="button" href="/">Cancel</a>
                </td>
            </tr>
        </table>

    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
