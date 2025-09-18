<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
        <title>Shopping Cart</title>
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.min.css"/>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background: linear-gradient(135deg, #f6d365, #fda085, #a1c4fd, #c2e9fb);
                background-size: 400% 400%;
                animation: gradientBG 15s ease infinite;
                min-height: 100vh;
                margin: 0;
                padding: 0;
            }

            @keyframes gradientBG {
                0% {background-position: 0% 50%;}
                50% {background-position: 100% 50%;}
                100% {background-position: 0% 50%;}
            }

            .navbar {
                background-color: #ff6f61 !important;
            }

            .navbar-brand a {
                color: white;
                font-weight: bold;
                font-size: 24px;
                text-decoration: none;
                transition: transform 0.3s ease;
            }

            .navbar-brand a:hover {
                transform: scale(1.1);
            }

            .container {
                padding: 50px 15px;
            }

            h3 {
                text-align: center;
                margin-bottom: 30px;
                color: #333;
            }

            table {
                border-radius: 15px;
                overflow: hidden;
                box-shadow: 0 10px 25px rgba(0,0,0,0.2);
                background-color: #fff;
                transition: transform 0.3s ease, box-shadow 0.3s ease;
            }

            table:hover {
                transform: translateY(-5px);
                box-shadow: 0 15px 30px rgba(0,0,0,0.3);
            }

            th {
                background-color: #ff7e5f;
                color: white;
                text-align: center;
            }

            td {
                text-align: center;
                vertical-align: middle;
            }

            img {
                width: 100px;
                height: 100px;
                object-fit: contain;
                border-radius: 10px;
                transition: transform 0.3s ease, box-shadow 0.3s ease;
            }

            img:hover {
                transform: scale(1.1);
                box-shadow: 0 5px 15px rgba(0,0,0,0.3);
            }

            .btn-action {
                background: linear-gradient(135deg, #ff7e5f, #feb47b);
                color: white;
                padding: 6px 15px;
                border-radius: 8px;
                text-decoration: none;
                font-weight: bold;
                transition: transform 0.3s ease, box-shadow 0.3s ease;
            }

            .btn-action:hover {
                transform: scale(1.1);
                box-shadow: 0 5px 15px rgba(0,0,0,0.3);
            }

            .total-row {
                font-weight: bold;
                background-color: #ffe4c4;
            }

            .continue-shopping {
                display: block;
                width: fit-content;
                margin: 20px auto;
                text-decoration: none;
                background: linear-gradient(135deg, #a1c4fd, #c2e9fb);
                color: #333;
                padding: 10px 20px;
                border-radius: 12px;
                font-weight: bold;
                transition: transform 0.3s ease, box-shadow 0.3s ease;
            }

            .continue-shopping:hover {
                transform: scale(1.05);
                box-shadow: 0 5px 15px rgba(0,0,0,0.2);
            }
        </style>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark">
                <div class="container-fluid">
                    <div class="navbar-brand">
                        <a href="<%=request.getContextPath()%>">Sample Shopping</a>
                    </div>
                </div>
            </nav>
        </header>

        <div class="container">
            <h3>Shopping Cart</h3>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Option</th>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Photo</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Sub Total</th>
                    </tr>
                </thead>
                <c:set var="total" value="0"/>
                <c:forEach var="item" items="${sessionScope.cart}">
                    <c:set var="total" value="${total + item.phone.price * item.quantity}"/>
                    <tr>
                        <td>
                            <a href="${pageContext.request.contextPath }/cart?action=remove&id=${item.phone.id}"
                               onclick="return confirm('Are you sure?')" class="btn-action">Remove</a>
                        </td>
                        <td>${item.phone.id}</td>
                        <td>${item.phone.name}</td>
                        <td>
                            <img src="${pageContext.request.contextPath }/images/${item.phone.image}" alt="${item.phone.name}">
                        </td>
                        <td>$${item.phone.price}</td>
                        <td>${item.quantity}</td>
                        <td>$${item.phone.price * item.quantity}</td>
                    </tr>
                </c:forEach>
                <tr class="total-row">
                    <td colspan="6">Total</td>
                    <td>$${total}</td>
                </tr>
            </table>

            <a href="${pageContext.request.contextPath }/phones" class="continue-shopping">Continue Shopping</a>
        </div>
    </body>
</html>
