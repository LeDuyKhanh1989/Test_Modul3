<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/6/2023
  Time: 10:21 AM
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

<form class="d-flex"
      STYLE="width: 700px; height: 150px; background-color: cornsilk; border: cadetblue; border-radius: 10px;margin: auto; text-align: center">
    <H1 style="text-align: center"> bạn có chắc muốn xóa không? </H1> <br>
    <a style="margin-left: 10px;  margin-top: 100px; width: 100px" class="btn btn-info" href="My_Servlet?action=deleteConfirm&&id=${id}">Có</a>
    <a style="margin-left: 10px; margin-top: 100px; width: 100px" class="btn btn-info" href="/My_Servlet">Không</a>
</form>

</body>
</html>
