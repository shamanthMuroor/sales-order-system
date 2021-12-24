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
			<div class="col-md-12">
				<h1 align="center">
					<a href="<%=request.getContextPath()%>/">Sales Order System</a>
				</h1>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<div class="card card-primary">
					<div class="card-heading">
						<h3 align="center">
							<i class="fa fa-user-plus"></i> Payment Section
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
						        <td>${orderDetailsModel.getQty() * amt}</td>
						    </tr>
						</table><br><br>
						<form action="<%=request.getContextPath()%>/transaction/${orderDetailsModel.getPayMode()}" method="post">
							<c:if test="${orderDetailsModel.getPayMode() == 'cheque'}">
								<input name="orderId" type="text" id="orderId" value="${orderDetailsModel.getOrderId()}" hidden>
								<div class="form-group">
									<label for="chequeNo">Cheque Number: </label> 
									<input name="chequeNo" type="text" class="form-control" id="chequeNo" required>
								</div>
								<div class="form-group">
									<label for="bankID">bankID: </label> 
									<input name="bankID" type="text" class="form-control" id="bankID">
								</div>
								<div class="form-group">
									<label for="amount">Amount to be Paid: </label> 
									<input name="amount" type="text" class="form-control" id="amount" value="${orderDetailsModel.getQty() * amt}" readonly>
								</div>
							</c:if>
							<button type="submit" class="btn btn-info">
								<i class="fa fa-send"></i> Pay
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>		
	</div>
</body>
</html>