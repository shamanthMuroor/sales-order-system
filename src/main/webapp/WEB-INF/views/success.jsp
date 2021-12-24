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
		<div class="row">
			<div class="col-md-12">
				<h1>Success</h1>
				<a href="http://localhost:8080/salesordersystem/" class="btn btn-outline-danger">Go Home</a>
			</div>
		</div>
	</div>
	<div class="col-md-12" style="text-align: center; margin-top: 60px;">&copy;</div>

</body>
</html>