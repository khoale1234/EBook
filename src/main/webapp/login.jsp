<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<%@include file="all_components/allCSS.jsp" %>
</head>
<body style="background-color: #f0f1f2;">
<%@include file="all_components/navbar.jsp" %>
<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-3">
					<h2 class="text-center mt-2">Login</h2>
					<c:if test="${not empty sucMsg }">
						<h5 class="text-center text-success">${sucMsg }</h5>
						<c:remove var="sucMsg" scope="session"/>
					</c:if>
					<div class="card-body p-4">
						<form action="login" method="post">
							<div class="form-group mt-4">
								<label for="exampleInputEmail">Email Address:</label><input
									type="email" class="form-control" id="exampleInputEmail"
									aria-describeby="emailHelp" placeholder="Enter Email" required name="email">
							</div>
							<div class="form-group mt-4">
								<label for="exampleInputPassword">Password:</label><input
									type="password" class="form-control" id="exampleInputPassword"
									placeholder="Enter Password" required name="password">
							</div>
							<div class="form-check mt-4" >
								<input type="checkbox" class="form-check-input"
									id="exampleCheck" name="check"><label for="example-check"
									class="form-check-label">Remember me</label>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Login</button><br>
								<a href="register.jsp">Create Account</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>