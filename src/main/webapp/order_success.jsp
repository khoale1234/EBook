<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_components/allCSS.jsp" %>
</head>
<body style="background-color: #f0f1f2">
<%@include file="all_components/navbar.jsp" %>
<div class="container text-center mt-5">
	<i class="fas fa check-circle fa-5x text-success"></i>
	<h1>Thank for your order</h1>
	<h5>Your product will be delivered in 7 days</h5>
	<a href="index.jsp" class="btn btn-primary mt-3">Home</a>
	<a href="order.jsp" class="btn btn-danger mt-3">View Order</a>
</div>
</body>
</html>