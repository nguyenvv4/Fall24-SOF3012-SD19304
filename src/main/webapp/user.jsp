<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 4/11/24
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/add" method="post">
    <label>Fullname</label>
    <input type="text" name="fullname"> <br>
    <label>Password</label>
    <input type="text" name="password"> <br>
    <label>Email</label>
    <input type="text" name="email"> <br>
    <label>Admin</label>
    <input type="radio" name="admin" value="true"> Quan Ly
    <input type="radio" name="admin" value="false">Nhan Vien
    <br>
    <button type="submit">Add</button>
</form>
<table class="table table-striped">
    <thead>
    <tr>
        <td>id</td>
        <td>fullname</td>
        <td>password</td>
        <td>email</td>
        <td>admin</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.fullname}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.admin  == 'true' ? 'Quan ly': 'NhanVien'}</td>
            <td>
                <a href="/detail?id=${user.id}">detail</a>
                <a href="/delete?id=${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
