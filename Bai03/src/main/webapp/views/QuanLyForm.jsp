<%--
  Created by IntelliJ IDEA.
  User: Tan Nghi
  Date: 9/19/2025
  Time: 5:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Quản Lý Sản Phẩm</title>
        <script>
            function confirmDelete(maDT) {
                if (confirm("Bạn có chắc chắn muốn xóa điện thoại có mã " + maDT + "?")) {
                    window.location.href = 'xoa-dien-thoai?maDT=' + maDT;
                }
            }
        </script>
    </head>
    <body>
        <h1>Quản lý Điện thoại</h1>
        <table border="1">
            <tr>
                <th>Mã ĐT</th>
                <th>Tên Điện Thoại</th>
                <th>Năm SX</th>
                <th>Hành động</th>
            </tr>
            <c:forEach items="${listAllDT}" var="dt">
                <tr>
                    <td>${dt.maDT}</td>
                    <td>${dt.tenDT}</td>
                    <td>${dt.namSanXuat}</td>
                    <td>
                        <a href="#" onclick="confirmDelete('${dt.maDT}')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>