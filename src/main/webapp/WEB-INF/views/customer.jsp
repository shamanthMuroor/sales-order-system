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
	<div class="container">
		<!-- <div class="row">
			<div class="col-md-12">
				<h1 align="center">
					<a href="<%=request.getContextPath()%>/">Sales Order System</a>
				</h1>
			</div>
		</div> -->
		<div class="row mt-3">
			<div class="col-md-4">
				<div class="card card-primary p-2">
					<div class="card-heading p-2">
						<h3 align="center">
							<i class="fa fa-user-plus"></i> Register Customer
						</h3>
					</div>
					<div class="card-body">
						<form action="http://localhost:8080/salesordersystem/addcustomer" method="post">
							<div class="form-group">
								<label for="cid">Customer ID: </label> <input
									value="${customer.cid}" name="cid" type="text"
									class="form-control" id="cid"
									<c:if test="${customer.cid == null}">disabled="1"</c:if> readonly>
							</div>
	
							<div class="form-group">
								<label for="cusname">Name:</label> <input
									value="${customer.cusname}" name="cusname" type="text"
									class="form-control" id="cusname">
							</div>
	
							<div class="form-group">
								<label for="contact">Contact:</label> <input
									value="${customer.contact}" name="contact" type="text"
									class="form-control" id="contact">
							</div>
	
							<div class="form-group">
								<label for="deliveryAddress">Delivery Address:</label> <input
									value="${customer.deliveryAddress}" name="deliveryAddress"
									type="text" class="form-control" id="deliveryAddress">
							</div>
	
							<div class="form-group text-right">
								<c:if test="${customer.cid != null}">
									<button type="submit" class="btn btn-warning">
										<i class="fa fa-edit"></i> Update
									</button>
									<a href="http://localhost:8080/salesordersystem/customer"
										class="btn btn-primary pull-right"><i
										class="fa fa-user-plus"></i> New</a>
								</c:if>
		
								<c:if test="${customer.cid == null}">
									<button type="submit" class="btn btn-success">
										<i class="fa fa-user-plus"></i> Register
									</button>
								</c:if>
							</div>
						</form>
					</div>
				</div>
			</div>

			<div class="col-md-8">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th colspan="6" style="text-align: center;">
								<h2><i class="fa fa-users"></i>  Customer List</h2>
							</th>
						</tr>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Contact</th>
							<th>Delivery Address</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${customers}">
							<tr>
								<td>${row.cid}</td>
								<td>${row.cusname}</td>
								<td>${row.contact}</td>
								<td>${row.deliveryAddress}</td>
								<td><a href="http://localhost:8080/salesordersystem/editcustomer/${row.cid}" 
									class="btn btn-warning"><i class="fa fa-edit"></i> Edit</a></td>
								<td><a
									onclick="return confirm('Are you want to delete this item?')"
									href="http://localhost:8080/salesordersystem/deletecustomer/${row.cid}"
									class="btn btn-danger"><i class="fa fa-trash"></i> Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
<!-- 		<div class="row">
			<c:forEach var="row" items="${customers}">
				<c:forEach var="innerrow" items="${row.itemmodel}">
					<c:if test="${innerrow != null}">
						<h1>${innerrow.itemId}</h1>
					</c:if>
				</c:forEach>
			</c:forEach>
		</div>  -->
		
	</div>
</body>
</html>