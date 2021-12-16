<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="./navbar.jsp"%>
<%@ include file="./links.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3" style="color:white;">${title }</h1>
				<form action="http://localhost:8080/mvccrudapp/handleaddproduct" method="post">
				<input type="hidden" value="${product.pid }" name="pid"  />
					<div class="form-group">
						<label for="name" style="color:black;">Product Name</label> <input type="text"
							class="form-control" id="name" name="name"
							placeholder="Enter product name" value="${product.name }">
					</div>
					<div class="form-group">
						<label for="name" style="color:black;">Product Description</label>
						<textarea class="form-control" id="name" id="description"
							name=productDesc rows="5" placeholder="Enter product description">${product.productDesc}</textarea>
					</div>
					<div class="form-group">
						<label for="name" style="color:black;">Product Price</label> <input type="number"
							class="form-control" id="price" name="price"
							value="${product.price }" placeholder="Enter product price"
							required="required">
					</div>
					<div class="container text-center">
						<!-- in href we can use this also href="${pageContext.request.contextPath}/" -->
						<a href="http://localhost:8080/mvccrudapp/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-outline-primary">Update</button>
						 
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>