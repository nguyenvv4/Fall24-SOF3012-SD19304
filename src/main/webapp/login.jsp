<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 21/11/24
  Time: 07:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <label>email</label>
    <input type="text" name="email"> <br>
    <label>pass</label>
    <input type="text" name="pass"> <br>
    <button type="submit">Login</button>
</form>
<h1>${error}</h1>
</body>
</html>
