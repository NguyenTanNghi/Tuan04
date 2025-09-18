<%--
  Created by IntelliJ IDEA.
  User: Tan Nghi
  Date: 9/19/2025
  Time: 5:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
  <h1>Thêm Điện Thoại Mới</h1>
  <form action="them-dien-thoai" method="post" enctype="multipart/form-data" id="addPhoneForm">
    Mã ĐT: <input type="text" name="maDT" required><br>
    Tên ĐT: <input type="text" name="tenDT" required><br>
    Năm sản xuất: <input type="text" name="namSanXuat" required pattern="\d{4}"><br>
    Cấu hình: <textarea name="cauHinh" required maxlength="255"></textarea><br>
    Nhà cung cấp:
    <select name="maNCC" required>
      <c:forEach items="${listNCC}" var="ncc">
        <option value="${ncc.maNCC}">${ncc.tenNCC}</option>
      </c:forEach>
    </select><br>
    Hình ảnh: <input type="file" name="hinhAnh" accept=".png,.jpg,.jpeg" required><br>
    <button type="submit">Thêm</button>
  </form>
</body>