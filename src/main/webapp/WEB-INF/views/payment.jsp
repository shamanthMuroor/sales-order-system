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
		<div class="row mt-3">
			<div class="col">
				<div class="card card-primary p-2">
					<div class="card-heading pt-2">
						<h3 align="center">
							<i class="fa fa-shopping-cart"></i> Payment Section
						</h3>
					</div>
					<div class="card-body">
						<c:if test="${orderDetailsModel.getPayMode() == 'cod'}">
							<% String redirectURL="http://localhost:8080/salesordersystem/orderdetails";   response.sendRedirect(redirectURL); %>
						</c:if>
						
						<table>
						    <tr>
						        <th class="small text-muted pr-2" scope="row">Order ID:</th>
						        <td>${orderDetailsModel.getOrderId()}</td>
						    </tr>
						    <tr>
						        <th class="small text-muted pr-2" scope="row">Customer Name:</th>
						        <td>${orderDetailsModel.getCusname()}</td>
						    </tr>
						    <tr>
						        <th class="small text-muted pr-2" scope="row">Item Name:</th>
						        <td>${orderDetailsModel.getItemName()}</td>
						    </tr>
						    <tr>
						        <th class="small text-muted pr-2" scope="row">Quantity:</th>
						        <td>${orderDetailsModel.getQty()}</td>
						    </tr>
						    <tr>
						        <th class="small text-muted pr-2" scope="row">Amount to be Paid:</th>
						        <td>&#x20B9;${orderDetailsModel.getAmount()}</td>
						    </tr>
						</table><br><hr><br>
						<form action="http://localhost:8080/salesordersystem/transaction" method="post">
							<c:if test="${orderDetailsModel.getPayMode() == 'cheque'}">
								<h3 align="center">Cheque</h3><br><br>
								<input name="orderId" type="text" id="orderId" value="${orderDetailsModel.getOrderId()}" hidden>
								<div class="form-group">
									<label for="chequeNo">Cheque Number: </label> 
									<input name="chequeNo" type="text" class="form-control" id="chequeNo" required>
								</div>
								<div class="form-group">
									<label for="bankID">Bank ID: </label> 
									<input name="bankID" type="text" class="form-control" id="bankID">
								</div>
							</c:if>
							<c:if test="${orderDetailsModel.getPayMode() == 'wiretransfer'}">
								<h3 align="center">Wire Transfer</h3><br><br>
								<input name="orderId" type="text" id="orderId" value="${orderDetailsModel.getOrderId()}" hidden>
								<div class="form-group">
									<label for="bankID">Bank ID: </label> 
									<input name="bankID" type="text" class="form-control" id="bankID">
								</div>
								<div class="form-group">
									<label for="bankName">Bank Name: </label> 
									<input name="bankName" type="text" class="form-control" id="bankName" required>
								</div>
							</c:if>
							<c:if test="${orderDetailsModel.getPayMode() == 'credit'}">
								<h3 align="center">
									<i class="fa fa-credit-card" aria-hidden="true"></i>  Credit Card
								</h3><br><br>
								<input name="orderId" type="text" id="orderId" value="${orderDetailsModel.getOrderId()}" hidden>
								<div class="form-group">
									<label for="cardNumber">Credit Card Number: </label> 
									<input name="cardNumber" type="text" class="form-control" id="cardNumber">
								</div>
								<div class="form-group">
									<label for="cardType">Card Type: </label> 
									<input name="cardType" type="text" class="form-control" id="cardType" required>
								</div>
								<div class="form-group">
									<label for="expireDate">Expire Date: </label> 
									<input name="expireDate" type="text" class="form-control" id="expireDate" required>
								</div>
							</c:if>
							<div class="form-group">
								<label for="amount">Amount to be Paid: </label> 
								<input name="amount" type="number" step="0.01" class="form-control" id="amount" value="${orderDetailsModel.getAmount()}" readonly>
							</div>
							<div class="form-group text-center">
								<button type="submit" class="btn btn-info">
									<i class="fa fa-shopping-cart"></i> Pay
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>		
	</div>
</body>
</html>