<%--
  Created by IntelliJ IDEA.
  User: Tan Nghi
  Date: 9/19/2025
  Time: 5:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp"/>

<h2>Thêm Tin Tức Mới</h2>
<form action="them-tin-tuc" method="post">
    Mã TT: <input type="text" name="maTT" required><br>
    Tiêu đề: <input type="text" name="tieuDe" required><br>
    Liên kết: <input type="text" name="lienKet" required pattern="http://.*" title="Phải bắt đầu bằng http://"><br>
    Nội dung: <textarea name="noiDungTT" required pattern=".{1,255}"
                        title="Nội dung không quá 255 ký tự"></textarea><br>
    Danh mục:
    <select name="maDM" required>
        <option value="">-- Chọn danh mục --</option>
        <c:forEach items="${listDM}" var="dm">
            <option value="${dm.maDM}">${dm.tenDanhMuc}</option>
        </c:forEach>
    </select><br>
    <button type="submit">Thêm Tin</button>
</form>

<jsp:include page="../layout/footer.jsp"/>