<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file="./navbar.jsp"%>
	<%@include file="./links.jsp"%>
	<title>Sales Order System</title>
</head>
<body>
	<div class="container ">
		<div class="row">
			<div class="col-md-12">
				<h1 align="center">
					<a href="<%=request.getContextPath()%>/">Sales Order System</a>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 message">
				<c:if test="${qty != null}">
					<div class="alert alert-success alert-dismissable fade in">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>Success!</strong> ${sm}
					</div>

				</c:if>
				<c:if test="${em != null}">
					<div class="alert alert-danger alert-dismissable fade in">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>Error!</strong> ${em}
					</div>
				</c:if>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="card card-primary">
					<div class="card-heading">
						<h3 align="center">
							<i class="fa fa-user-plus"></i> Add Item
						</h3>
					</div>
					<div class="card-body">
						<form action="<%=request.getContextPath()%>/additem" method="post">
							<div class="form-group">
								<label for="itemId">Item ID: </label> 
									<input value="${item.itemId}" name="itemId" type="text" class="form-control" id="itemId"
									<c:if test="${item.itemId == null}">disabled="1"</c:if>" readonly>
							</div>	
							<div class="form-group">
								<label for="itemName">Item Name:</label> 
									<input value="${item.itemName}" name="itemName" type="text" class="form-control" id="itemName">
							</div>
							<div class="form-group">
								<label for="weight">Weight (kg):</label> 
									<input value="${item.weight}" name="weight" type="number" class="form-control" id="weight">
							</div>
							<div class="form-group">
								<label for="price">Price:</label> 
									<input value="${item.price}" name="price" type="number" class="form-control" id="price">
							</div>
	
							<c:if test="${item.itemId != null}">
								<button type="submit" class="btn btn-warning">
									<i class="fa fa-edit"></i> Update
								</button>
								<a href="<%=request.getContextPath()%>/item"
									class="btn btn-primary pull-right"><i
									class="fa fa-user-plus"></i> New</a>
							</c:if>
	
							<c:if test="${item.itemId == null}">
								<button type="submit" class="btn btn-success">
									<i class="fa fa-send"></i> Submit
								</button>
							</c:if>
						</form>
					</div>
				</div>
			</div>

			<div class="col-md-8">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th colspan="8" style="text-align: center;">
								<h2><i class="fa fa-users"></i>Item List</h2>
							</th>
						</tr>
						<tr>
							<th>Item ID</th>
							<th>Item Name</th>
							<th>Weight</th>
							<th>Price</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${items}">
							<tr>
								<td>${row.itemId}</td>
								<td>${row.itemName}</td>
								<td>${row.weight}</td>
								<td>${row.price}</td>
								<td><a href="<%= request.getContextPath()%>/edititem/${row.itemId}" 
									class="btn btn-warning"><i class="fa fa-edit"></i> Edit</a></td>
								<td><a
									onclick="return confirm('Are you want to delete this item?')"
									href="<%= request.getContextPath()%>/deleteitem/${row.itemId}"
									class="btn btn-danger"><i class="fa fa-trash"></i> Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>