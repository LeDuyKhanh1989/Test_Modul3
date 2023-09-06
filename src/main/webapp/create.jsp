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
    <title>Tạo sinh viên mới</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<a style="margin-left: 100px; margin-top: 100px" class="btn btn-info" href="/My_Servlet">Quay lại</a>
<div class="container">
  <h1 style="text-align: center">Thêm sinh viên</h1>
  <form style="width: 500px; margin: auto"
        action="/My_Servlet?action=createPost" method="post">
    <div class="mb-3">
      <label for="name" class="form-label">Nhập tên sinh viên</label>
      <input type="text" class="form-control"
             id="name" name="name" required>
    </div>
    <div class="mb-3">
      <label for="email" class="form-label">Nhập vào email</label>
      <input type="text" class="form-control"
             id="email" name="email" required>
    </div>
    <div class="mb-3">
      <label for="dateOfBirth" class="form-label">Nhập vào ngày sinh</label>
      <input type="text" class="form-control"
             id="dateOfBirth" name="dateOfBirth" required>
    </div>
    <div class="mb-3">
      <label for="address" class="form-label">Nhập vào địa chỉ</label>
      <input type="text" class="form-control"
             id="address" name="address" required>
    </div>
    <div class="mb-3">
      <label for="phoneNumber" class="form-label">Nhập vào số điện thoại</label>
      <input type="text" class="form-control"
             id="phoneNumber" name="phoneNumber" required>
    </div>
    <div>
    <label class="form-label">Lựa chọn tên lớp</label>
    <select class="form-select" name="id_Class" >
      <c:forEach items="${classList}" var="c">
        <option value="${c.getId()}"><c:out value="${c.getName()}"/></option>
      </c:forEach>
    </select>
    </div>

    <button class="btn btn-primary" type="submit">Tạo mới</button>
    <button class="btn btn-secondary" type="reset">Đặt lại</button>
  </form>
</div>
</body>
</html>
