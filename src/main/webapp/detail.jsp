<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 9/11/24
  Time: 07:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/update" method="post">
    <label>Id</label>
    <input type="text" name="id" value="${user.id}" readonly> <br>
    <label>Fullname</label>
    <input type="text" name="fullname" value="${user.fullname}"> <br>
    <label>Password</label>
    <input type="text" name="password" value="${user.password}"> <br>
    <label>Email</label>
    <input type="text" name="email" value="${user.email}"> <br>
    <label>Admin</label>
    <input type="radio" name="admin" value="true" ${user.admin == 'true' ? 'checked':''}> Quan Ly
    <input type="radio" name="admin" value="false" ${user.admin == 'false' ? 'checked':''}>Nhan Vien
    <br>
    <button type="submit">Update</button>
</form>
</body>
</html>
