<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./navbar.jsp"%>
<%@include file="./links.jsp"%>
</head>
<body>

	<div class="container mt-3 ">
		<div class="alert alert-secondary mt-3 text-center " role="alert">
			<h4>Add Products</h4>
		</div>
		<div class="row">

			<div class="col-md-6 offset-md-3 ">



				<form action="handleaddproduct" method="post">
					<div class="form-group">
						<label for="name" style="color: black;">Product Name</label> <input
							type="text" class="form-control" id="name" name="name"
							placeholder="Enter product name">
					</div>
					<div class="form-group">
						<label for="name" style="color: black;">Product
							Description</label>
						<textarea class="form-control" id="name" id="description"
							name=productDesc rows="5" placeholder="Enter product description"></textarea>
					</div>
					<div class="form-group">
						<label for="name" style="color: black;">Product Price</label> <input
							type="number" class="form-control" id="price" name="price"
							placeholder="Enter product price">
					</div>
					<div class="container text-center">
						<!-- in href we can use this also href="${pageContext.request.contextPath}/" -->
						<a href="http://localhost:8080/mvccrudapp/"
							class="btn btn-outline-danger btn-block">Back</a>
						<button type="submit" class="btn btn-outline-primary btn-block">Add</button>

						<h4 style="color: black;">${addmsg }</h4>
					</div>
				</form>
			</div>
		</div>

	</div>

</body>
</html>