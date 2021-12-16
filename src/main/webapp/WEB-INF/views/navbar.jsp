<html>
<head>
<%@ include file="./links.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a href="http://localhost:8080/salesordersystem/">
			<img alt="" 
			src="https://cdn.worldvectorlogo.com/logos/google-marketing-platform.svg"
			height="80px" width="150px" class="img-responsive mr-3"> 
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/salesordersystem/">Home <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/salesordersystem/item">Add Item</a></li>
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/salesordersystem/customer">Register Customer</a></li>
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/salesordersystem/orderdetails">Order Details</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>