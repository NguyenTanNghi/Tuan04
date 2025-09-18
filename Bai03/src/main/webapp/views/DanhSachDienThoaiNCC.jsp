<%--
  Created by IntelliJ IDEA.
  User: Tan Nghi
  Date: 9/19/2025
  Time: 5:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Danh sách Điện thoại theo Nhà Cung Cấp</title>
  </head>
  <body>
    <h1>Xem Điện Thoại Theo Nhà Cung Cấp</h1>
    <form action="danh-sach-ncc" method="get">
      <label for="maNCC">Chọn nhà cung cấp:</label>
      <select name="maNCC" id="maNCC" onchange="this.form.submit()">
        <option value="">--Tất cả--</option>
        <c:forEach items="${listNCC}" var="ncc">
          <option value="${ncc.maNCC}" ${ncc.maNCC == selectedNCC ? 'selected' : ''}>
              ${ncc.tenNCC}
          </option>
        </c:forEach>
      </select>
    </form>
    <hr>
    <c:if test="${not empty listDT}">
      <h2>Danh sách điện thoại</h2>
      <table border="1">
        <tr>
          <th>Mã ĐT</th>
          <th>Tên Điện Thoại</th>
          <th>Năm SX</th>
          <th>Cấu Hình</th>
          <th>Hình Ảnh</th>
        </tr>
        <c:forEach items="${listDT}" var="dt">
          <tr>
            <td>${dt.maDT}</td>
            <td>${dt.tenDT}</td>
            <td>${dt.namSanXuat}</td>
            <td>${dt.cauHinh}</td>
            <td><img src="images/${dt.hinhAnh}" alt="${dt.tenDT}" width="100"></td>
          </tr>
        </c:forEach>
      </table>
    </c:if>
  </body>
</html>