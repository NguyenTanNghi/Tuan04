<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
	<head>
		<title>Phone Shop</title>
		<link rel="stylesheet"
			  href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.min.css" />
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

			.card {
				border-radius: 15px;
				box-shadow: 0 10px 20px rgba(0,0,0,0.2);
				transition: transform 0.3s ease, box-shadow 0.3s ease;
			}
			.card:hover {
				transform: translateY(-10px) scale(1.05);
				box-shadow: 0 15px 30px rgba(0,0,0,0.3);
			}

			.card img {
				border-radius: 10px;
				width: 100%;
				height: auto;
				transition: transform 0.4s ease, box-shadow 0.4s ease;
			}

			.card img:hover {
				transform: scale(1.1);
				box-shadow: 0 10px 20px rgba(0,0,0,0.3);
			}

			.buy-btn {
				background: linear-gradient(135deg, #ff7e5f, #feb47b);
				color: white;
				padding: 8px 20px;
				border-radius: 12px;
				text-decoration: none;
				font-weight: bold;
				transition: transform 0.3s ease, box-shadow 0.3s ease;
				display: inline-block;
			}
			.buy-btn:hover {
				transform: scale(1.1);
				box-shadow: 0 5px 15px rgba(0,0,0,0.3);
			}

			h3 {
				text-align: center;
				color: #333;
				margin-bottom: 30px;
			}
		</style>
	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-md navbar-dark">
				<div class="container-fluid">
					<div class="navbar-brand">
						<a href="<%=request.getContextPath()%>">Phone Shop</a>
					</div>
				</div>
			</nav>
		</header>

		<div class="container">
			<h3>List of Phones</h3>
			<div class="row g-4">
				<c:forEach var="phone" items="${phones}">
					<div class="col-sm-6 col-md-4 col-lg-3">
						<div class="card">
							<img src="${pageContext.request.contextPath}/images/${phone.image}" alt="${phone.name}" class="card-img-top">
							<div class="card-body text-center">
								<h5 class="card-title">${phone.name}</h5>
								<p class="card-text">$${phone.price}</p>
								<a href="${pageContext.request.contextPath}/cart?action=buy&id=${phone.id}" class="buy-btn">Buy</a>
							</div>
						</div>


					</div>
				</c:forEach>
			</div>
		</div>
	</body>
</html>
