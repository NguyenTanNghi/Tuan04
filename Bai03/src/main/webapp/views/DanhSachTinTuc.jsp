<%--
  Created by IntelliJ IDEA.
  User: Tan Nghi
  Date: 9/19/2025
  Time: 5:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp"/>

<h2>Xem tin tức theo danh mục</h2>
<form action="danh-sach-tin-tuc" method="get">
    <select name="maDM" onchange="this.form.submit()">
        <option value="">-- Chọn danh mục --</option>
        <c:forEach items="${listDM}" var="dm">
            <option value="${dm.maDM}" ${dm.maDM == selectedDM ? 'selected' : ''}>
                    ${dm.tenDanhMuc}
            </option>
        </c:forEach>
    </select>
</form>

<c:if test="${not empty listTT}">
    <table>
        <tr>
            <th>Mã Tin</th>
            <th>Tiêu đề</th>
            <th>Nội dung</th>
            <th>Liên kết</th>
        </tr>
        <c:forEach items="${listTT}" var="tt">
            <tr>
                <td>${tt.maTT}</td>
                <td>${tt.tieuDe}</td>
                <td>${tt.noiDungTT}</td>
                <td><a href="${tt.lienKet}" target="_blank">Xem chi tiết</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<jsp:include page="../layout/footer.jsp"/>