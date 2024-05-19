<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: add books</title>
<%@include file="allCSS.jsp"%>
</head>
<body style="background-color: #f0f2f2">
	<%@include file="navbar.jsp"%>
		<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp"/>
	</c:if>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<h3 class="text-center mt-2">Book Add</h3>
					<c:if test="${not empty successMsg }">
						<h5 class="text-center text-success">${successMsg}</h5>
						<c:remove var="successMsg" scope="session"/>
					</c:if>
					<c:if test="${not empty failedMsg }">
						<h5 class="text-center text-danger">${failedMsg}</h5>
						<c:remove var="failedMsg" scope="session"/>
					</c:if>
					<div class="card-body">
						<form action="../booka" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label for="exampleInputBookName">Book Name:</label><input
									type="text" class="form-control" id="exampleInputBookName"
									placeholder="Enter Book Name" required name="bname">
							</div>
							<div class="form-group mt-4">
								<label for="exampleInputAuthorName">Author Name:</label><input
									type="text" class="form-control" id="exampleInputAuthorName"
									placeholder="Enter Author Name" required name="Aname">
							</div>
							<div class="form-group mt-4">
								<label for="exampleInputPrice">Price:</label><input type="text"
									class="form-control" id="exampleInputPrice"
									aria-describeby="emailHelp" placeholder="Enter Price" required
									name="bprice">
							</div>
							<div class="form-group mt-4">
								<label for="inputState">Book Categories:</label><select
									id="inputState" name="btype" class="form-control">
									<option selected>--select--</option>
									<option value="Old Book">Old Book</option>
									<option value="New Book">New book</option>
								</select>
							</div>
							<div class="form-group mt-4">
								<label for="inputState">Book Status:</label><select
									id="inputState" name="bstatus" class="form-control">
									<option selected>--select--</option>
									<option value="Active">Active
									<option value="Inactive">Inactive
								</select>
							</div>
							<div class="form-group">
								<label for="exampleFormControlFile">Upload Photo:</label> <input
									name="bookimg" type="file" class="form-control-file" id="exampleFormControlFile">
							</div>
							<div class="d-flex justify-content-center">
								<button type="submit" class="btn btn-primary">Add</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>