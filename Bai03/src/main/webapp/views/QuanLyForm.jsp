<%--
  Created by IntelliJ IDEA.
  User: Tan Nghi
  Date: 9/19/2025
  Time: 5:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp"/>

<h2>Quản Lý Tin Tức</h2>
<table>
    <tr>
        <th>Mã Tin</th>
        <th>Tiêu đề</th>
        <th class="actions">Hành động</th>
    </tr>
    <c:forEach items="${listAllTT}" var="tt">
        <tr>
            <td>${tt.maTT}</td>
            <td>${tt.tieuDe}</td>
            <td class="actions">
                <a href="xoa-tin-tuc?maTT=${tt.maTT}" onclick="return confirm('Bạn có chắc chắn muốn xóa tin này?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../layout/footer.jsp"/>