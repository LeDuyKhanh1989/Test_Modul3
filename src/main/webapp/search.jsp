<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/5/2023
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Student</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h1 style="text-align: center">Tìm kiếm sinh viên</h1>

    <form class="d-flex">
        <a class="btn btn-primary" href="/My_Servlet?action=goback">Trở lại</a>
    </form>

    <table class="table table-hover">
        <tr>
            <th>STT</th>
            <th>Tên </th>
            <th>Email</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Số điện thoại</th>
            <th>Tên lớp</th>
            <th colspan="2"></th>
        </tr>
        <c:forEach items="${studentList}" var="S" varStatus="aa">
            <tr>
                <td>${aa.count}</td>
                <td>${S.getName()}</td>
                <td>${S.getEmail()}</td>
                <td>${S.getDateOfBirth()}</td>
                <td>${S.getAddress()}</td>
                <td>${S.getPhoneNumber()}</td>
                <td>${S.getClassName().getName()}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
