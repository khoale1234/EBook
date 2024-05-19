<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_components/allCSS.jsp" %>
</head>
<body style="background-color: #f7f7f7">
<c:if test="${ empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
<%@include file="all_components/navbar.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-4 offset-md-4 mt-5">
			<div class="card">
				<div class="card-body ">
					<h3 class="text-center text-primary">Sell Book</h3>
					<c:if test="${not empty successMsg }">
						<h5 class="text-center text-success">${successMsg}</h5>
						<c:remove var="successMsg" scope="session"/>
					</c:if>
					<c:if test="${not empty failedMsg }">
						<h5 class="text-center text-danger">${failedMsg}</h5>
						<c:remove var="failedMsg" scope="session"/>
					</c:if>
					<form action="add_old_book" method="post" enctype="multipart/form-data">
							<input type="hidden" value="${userobj.email }"name="user">
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
								<label for="exampleFormControlFile">Upload Photo:</label> <input
									name="bookimg" type="file" class="form-control-file" id="exampleFormControlFile">
							</div>
							<div class="d-flex justify-content-center mt-4">
								<button type="submit" class="btn btn-primary">Sell</button>
							</div>
						</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>