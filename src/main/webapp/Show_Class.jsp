<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/5/2023
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h1 style="text-align: center">Bảng Class</h1>
    <table class="table table-hover">
        <tr>
            <th>STT</th>
            <th>Tên sách</th>

        </tr>
        <c:forEach items="${Class1}" var="C" varStatus="ClassName">
            <tr>
                <td>${ClassName.count}</td>
                <td>${C.getName()}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
