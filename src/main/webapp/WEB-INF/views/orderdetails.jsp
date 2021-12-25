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
	<div class="row">
		
	</div>
	<div class="row mt-2">
		<div class="col">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>
							<a href="http://localhost:8080/salesordersystem/" class="btn btn-outline-danger">
								<i class="fa fa-chevron-circle-left" aria-hidden="true"></i>  Back
							</a>
						</th>
						<th colspan="8" style="text-align: center;">
							<h2>
								Order details
							</h2>
						</th>
					</tr>
					<tr>
						<th>Order ID</th>
						<th>Customer Name</th>
						<th>Item Name</th>
						<th>Quantity</th>
						<th>Order Created</th>
						<th>Payment Mode</th>
						<th>Payment Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="row" items="${orderDetails}">
						<tr>
							<td>${row.orderId}</td>
							<td>${row.cusname}</td>
							<td>${row.itemName}</td>
							<td>${row.qty}</td>
							<td>${row.createDate}</td>
							<td>${row.payMode}</td>
							<td>${row.payStatus}</td>
							<td>
								<a
								onclick="return confirm('Are you want to delete this item?')"
								href="http://localhost:8080/salesordersystem/deleteorderdetails/${row.orderId}"
								class="btn btn-danger"><i class="fa fa-trash"></i> Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>
</body>
</html>


<!--  							<td>
								<a
								href="<%= request.getContextPath()%>/editorderdetails/${row.orderId} 
								class="btn btn-warning"><i class="fa fa-edit"></i> Edit</a>
							</td>
href="<%= request.getContextPath()%>/editorderdetails/${row.cid}" 


-->
