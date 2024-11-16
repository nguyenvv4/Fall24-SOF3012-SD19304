<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 16/11/24
  Time: 07:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/san-pham/update?id=${sanPham.id}" method="post">
    <label>ma san pham</label>
    <input type="text" name="maSanPham" value="${sanPham.maSanPham}"> <br>
    <label>ten san pham</label>
    <input type="text" name="tenSanPham" value="${sanPham.tenSanPham}"> <br>
    <label>tran thai</label>
    <input type="radio" name="trangThai" value="Active" ${sanPham.trangThai == 'Active'? 'checked':''}>Active
    <input type="radio" name="trangThai" value="InActive" ${sanPham.trangThai == 'InActive'? 'checked':''}>InActive<br>
    <label>Danh muc</label>
    <select name="danhMuc" id="">
        <c:forEach items="${listDm}" var="d">
            <option value="${d.id}"
                ${sanPham.danhMuc.tenDanhMuc == d.tenDanhMuc ? 'selected':''}
            >${d.tenDanhMuc}</option>
        </c:forEach>
    </select>
    <br>
    <button type="submit">Add</button>
</form>
</body>
</html>
