<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    	<%@ include file="./links.jsp"%>
		<%@ include file="./navbar.jsp"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@page isELIgnored="false"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales Order System</title>
    </head>
    <body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1 align="center">
					<a href="<%= request.getContextPath()%>/">Sales Order System</a>
				</h1>
			</div>
		</div>
		
		<form action="payment" method="post">
		<div class="row">
			<div class="col">
				<div class="card card-primary p-3" style="height: 100%">
					<div class="card-header">
						<i class="fa fa-product-hunt"></i> Order Details
					</div>
					<div class="card-body">
						<div class="form-group">
							<label for="Customer Name">Customer Name:</label> 
							<select name="cusname" class="form-control">
								<c:forEach var="row" items="${customers}">
									<option value="${row.cusname}">${row.cusname}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="Item Name">Item Name:</label> 
							<select name="itemName" class="form-control">
								<c:forEach var="row" items="${items}">
									<option value="${row.itemName}">${row.itemName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="createDate">Order Date:</label> 
							<input name="createDate" type="date" class="form-control" id="createDate">
						</div>
						<div class="form-group">
							<label for="qty">Quantity:</label> 
								<input name="orderQty" type="text" class="form-control" id="qty" placeholder="Enter Quantity">
						</div>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card card-primary p-3" style="height: 100%">
					<div class="card-header"><i class="fa fa-sellsy"></i> Payment Details</div>
					<div class="card-body">
						<div class="form-group">
							<label for="payMode">Payment Method:</label>
							<select name="payMode" class="form-control" id="payMode">
								<option value="cod">Cash on delivery</option>
								<option value="cheque">Cheque</option>
								<option value="wiretransfer">WireTransfer</option>
								<option value="credit">Credit Card</option>
							</select>
						</div>
						<div class="form-group">
							<label for="payStatus">Payment status:</label> 
							<select name="payStatus" class="form-control" id="payStatus">
								<option value="yes">Completed</option>
								<option value="no">Not Completed</option>
							</select>
						</div>
						<div class="form-group">
							<label for="total">Total:</label> 
							<input readonly name="total" type="text" class="form-control" id="total" value="1">
						</div>
						<div class="form-group">
							<button  class="btn btn-success">
								<i class="fa fa-cart-plus"></i> Payment
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		</form>


	</div>
	<div class="col-md-12" style="text-align: center; margin-top: 60px;">&copy;</div>

</body>
</html>