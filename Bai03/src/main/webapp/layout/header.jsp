<%--
  Created by IntelliJ IDEA.
  User: Tan Nghi
  Date: 9/19/2025
  Time: 5:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Quản Lý Tin Tức</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layout/style.css">
    </head>
    <body>
        <header>
            <h1>HỆ THỐNG QUẢN TRỊ TIN TỨC</h1>
        </header>
        <nav>
            <a href="${pageContext.request.contextPath}/danh-sach-tin-tuc">Xem Tin Tức</a>
            <a href="${pageContext.request.contextPath}/them-tin-tuc">Thêm Tin Mới</a>
            <a href="${pageContext.request.contextPath}/quan-ly">Quản Lý (Xóa)</a>
        </nav>
        <div class="container">