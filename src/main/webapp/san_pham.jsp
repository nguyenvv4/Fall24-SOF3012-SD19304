<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 10/11/24
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/san-pham/add" method="post">
    <label>ma san pham</label>
    <input type="text" name="maSanPham"> <br>
    <label>ten san pham</label>
    <input type="text" name="tenSanPham"> <br>
    <label>tran thai</label>
    <input type="radio" name="trangThai" value="Active">Active
    <input type="radio" name="trangThai" value="InActive">InActive<br>
    <label>Danh muc</label>
    <select name="danhMuc" id="">
        <c:forEach items="${listDm}" var="d">
            <option value="${d.id}">${d.tenDanhMuc}</option>
        </c:forEach>
    </select>
    <br>
    <button type="submit">Add</button>
</form>
<table class="table table-striped">
    <thead>
    <tr>
        <td>id</td>
        <td>ma san pham</td>
        <td>ten san pham</td>
        <td>trang thai</td>
        <td>id danh muc</td>
        <td>ten danh muc</td>
        <td>ngay tao</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sp" items="${list}">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.maSanPham}</td>
            <td>${sp.tenSanPham}</td>
            <td>${sp.trangThai}</td>
            <td>${sp.danhMuc.id}</td>
            <td>${sp.danhMuc.tenDanhMuc}</td>
            <td>${sp.ngayTao}</td>
             <td>
                 <a href="/san-pham/chi-tiet?id=${sp.id}">Chi tiet</a>
                 <a href="/san-pham/delete?id=${sp.id}">delete</a>
             </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
