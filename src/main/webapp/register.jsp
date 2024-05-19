<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<%@include file="all_components/allCSS.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_components/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-3">
					<h2 class="text-center mt-2">Register</h2>
					<c:if test="${not empty successMsg }">
						<p class="text-center text-success">${successMsg}</p>
					</c:if>
					<c:if test="${not empty failedMsg }">
						<p class="text-center text-danger">${failedMsg}</p>
					</c:if>
					<div class="card-body p-4">
						<form action="RegisterServlet" method="post">
							<div class="form-group mt-4">
								<label for="exampleInputName">Full Name:</label><input
									type="text" class="form-control" id="exampleInputName"
									placeholder="Enter Full Name" required name="fname">
							</div>
							<div class="form-group mt-4">
								<label for="exampleInputPhone">Phone:</label><input
									type="text" class="form-control" id="exampleInputPhone"
									placeholder="Enter Phone number" required name="fphone">
							</div>
							<div class="form-group mt-4">
								<label for="exampleInputEmail">Email Address:</label><input
									type="email" class="form-control" id="exampleInputEmail"
									aria-describeby="emailHelp" placeholder="Enter Email" required name="femail">
							</div>
							<div class="form-group mt-4">
								<label for="exampleInputPassword">Password:</label><input
									type="password" class="form-control" id="exampleInputPassword"
									placeholder="Enter Password" required name="fpassword">
							</div>
							<div class="form-check mt-4" >
								<input type="checkbox" class="form-check-input"
									id="exampleCheck" name="fcheck"><label for="example-check"
									class="form-check-label">agree Terms & Conditions</label>
							</div>
							<div class="d-flex justify-content-center">
								<button type="submit" class="btn btn-primary">Sign in</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_components/footer.jsp" %>
</body>
</html>