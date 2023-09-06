<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/5/2023
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa sinh viên</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<a style="margin-left: 100px; margin-top: 100px" class="btn btn-info" href="/My_Servlet">Quay lại</a>
<div class="container">
  <h1 style="text-align: center">Sửa sinh viên</h1>
  <form style="width: 500px; margin: auto"
        action="/My_Servlet?action=updatePost&id=${student.getId()}" method="post">
    <div class="mb-3">
      <label class="form-label">Nhập tên sinh viên</label>
      <input type="text" class="form-control" name="name" value="${student.getName()}" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Nhập vào email</label>
      <input type="text" class="form-control" name="email" value="${student.getEmail()}" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Nhập vào ngày sinh</label>
      <input type="text" class="form-control" name="dateOfBirth" value="${student.getDateOfBirth()}" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Nhập vào địa chỉ</label>
      <input type="text" class="form-control" name="address" value="${student.getAddress()}" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Nhập vào số điện thoại</label>
      <input type="text" class="form-control" name="phoneNumber" value="${student.getPhoneNumber()}" required>
    </div>
    <div>
    <label class="form-label">Lựa chọn tên lớp</label>
    <select class="form-select" name="id_Class" >
      <c:forEach items="${classList}" var="c">
        <option value="${c.getId()}"><c:out value="${c.getName()}"/></option>
      </c:forEach>
    </select>
    </div>

    <button class="btn btn-primary" type="submit">Cập nhật</button>
    <button class="btn btn-secondary" type="reset">Đặt lại</button>
  </form>
</div>
</body>
</html>
