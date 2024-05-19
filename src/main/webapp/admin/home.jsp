<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: home</title>
<%@include file="allCSS.jsp"%>
<style type="text/css">
	a{
		text-decoration: none;
		color: black;
	}
	a:hover{
		text-decoration: none;
			color: black;
	}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp"/>
	</c:if>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-3">
			<a href="book_add.jsp">
				<div class="card">
					<div class="card-body text-center">
						<div class="text-primary"><i class="fas fa-plus-square fa-3x"></i></div><br>
						<h4>Add Book</h4>
						------------
					</div>
				</div>
			</a>
			</div>
			<div class="col-md-3">
			<a href="all_books.jsp">
				<div class="card">
				<div class="card-body text-center">
				<div class="text-danger"><i class="fas fa-book-open fa-3x"></i></div><br>
					
					<h4>All Book</h4>
					------------
				</div>
			</div>
			</a>
			</div>
			<div class="col-md-3">
				<a href="orders.jsp">
					<div class="card">
					<div class="card-body text-center">
					<div class="text-warning"><i class="fas fa-box-open fa-3x"></i></div><br>
						
						<h4>Orders</h4>
						------------
					</div>
				</div>
				</a>
			</div>
			<div class="col-md-3">
			<a data-bs-toggle="modal" data-bs-target="#exampleModal">
			<div class="card">
				<div class="card-body text-center">
					<div class="text-primary"><i class="fas fa-sign-out-alt fa-3x"></i></div><br>
					<h4>Sign Out</h4>
					------------
				</div>
			</div>
			</a>
			</div>
			<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel"></h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			       	<div class="text-center">
			       		 <h4>Do you want logout</h4>
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				        <a href="../logout" type="button" class="btn btn-primary">Logout</a>
			       	</div>
			      </div>
			      </div>
			      <div class="modal-footer">
			        
			    </div>
			  </div>
			</div>
		</div>
	</div>
</body>
</html>